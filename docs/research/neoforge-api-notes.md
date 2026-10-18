# NeoForge 1.21.1 API Notes & Implementation Cartography

**Document ID**: CRB-API-MAP-001  
**Target Mod Loader**: NeoForge 21.1.x (Minecraft 1.21.1)  
**Java Version**: Java 21 LTS  

---

## 1. NeoForge 1.21.1 Native Architectural Changes

### 1.1 Data Attachments (Replacing Legacy Capabilities)
In 1.21.1, the old `Capability` system is removed. State persistence is handled through `Data Attachments`:
- **Registry**: `DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);`
- **Definition Example**:
  ```java
  public static final Supplier<AttachmentType<CursedEnergyData>> CURSED_ENERGY = ATTACHMENT_TYPES.register(
      "cursed_energy",
      () -> AttachmentType.builder(CursedEnergyData::new)
          .serialize(CursedEnergyData.CODEC)
          .copyOnDeath()
          .build()
  );
  ```
- **Accessing Attachments**:
  ```java
  CursedEnergyData data = player.getData(CURSED_ENERGY);
  data.consume(50);
  player.setData(CURSED_ENERGY, data); // Triggers dirty tracking
  ```

### 1.2 Payload Networking (`CustomPacketPayload`)
Network communication uses type-safe records implementing `CustomPacketPayload`:
- **Definition Example**:
  ```java
  public record AbilityCastPayload(ResourceLocation abilityId, int chargeTicks) implements CustomPacketPayload {
      public static final Type<AbilityCastPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "ability_cast"));
      public static final StreamCodec<ByteBuf, AbilityCastPayload> STREAM_CODEC = StreamCodec.composite(
          ResourceLocation.STREAM_CODEC, AbilityCastPayload::abilityId,
          ByteBufCodecs.VAR_INT, AbilityCastPayload::chargeTicks,
          AbilityCastPayload::new
      );

      @Override
      public Type<? extends CustomPacketPayload> type() {
          return TYPE;
      }
  }
  ```
- **Registration**:
  ```java
  @SubscribeEvent
  public static void registerPayloads(RegisterPayloadHandlersEvent event) {
      PayloadRegistrar registrar = event.registrar("1.0.0");
      registrar.playToServer(
          AbilityCastPayload.TYPE,
          AbilityCastPayload.STREAM_CODEC,
          AbilityCastPayload::handleOnServer
      );
  }
  ```

---

## 2. Adopted Libraries Integration Notes

### 2.1 Veil 4.5.2 (Post-Processing & Volumetric Shaders)
- **Shader Manifest**: Defined in `assets/crb/veil/pipelines/`.
- **Post-Processing Passes**:
  - `infinity_refraction`: Dual-pass screen-space refractive distortion using normal maps.
  - `domain_barrier`: Stencil-buffer spherical dome shader separating exterior from interior rendering.
  - `world_cutting_slash`: 1-tick monochrome screen tear with horizontal displacement.

### 2.2 GeckoLib 4.9.3 (Entity & Armor Rendering)
- Entities implement `GeoEntity` and cache an `AnimatableInstanceCache`.
- Models located at `assets/crb/geo/entity/`.
- Animations located at `assets/crb/animations/entity/`.
- `PlayState` callbacks drive bone transforms, particle spawning, and custom sound playback on specific animation frames.

### 2.3 Player Animation Library 1.1.6
- Provides `ModifierLayer<IAnimation>` registered to the player renderer.
- Plays Bedrock `.animation.json` files on the player model:
  - First-person arm animation layer (casting Blue, Divergent Fist windup).
  - Third-person full body martial arts animations.

### 2.4 Free Camera API 2.1.1
- Detaches player camera for scripted cutscenes:
  ```java
  FreeCameraAPI.startCinematicCamera(
      new CameraPathBuilder()
          .addPoint(startPos, startRot, 0)
          .addPoint(endPos, endRot, 40, EasingCurve.IN_OUT_CIRC)
          .build()
  );
  ```

### 2.5 SmartBrainLib 1.16.11 (AI Brains)
- Custom bosses implement `SmartBrainOwner<T>`.
- Behavior trees compose `FirstApplicableBehaviour`, `ParallelBehaviour`, and custom memory sensors (`NearestTargetSensor`, `CursedEnergySensor`).

### 2.6 Yet Another Config Lib / YACL 3.8.2
- `CRBConfig.java` defines configurable parameters:
  - Particle density (Low, Medium, High, Cinematic).
  - Screen shake intensity multiplier (0.0 to 2.0).
  - Canon Purist Mode (Disables non-canon domain expansions for Kashimo, Inumaki, etc.).
