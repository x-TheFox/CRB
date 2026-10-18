package com.crb.test;

import com.crb.CursedRealityBoundless;
import com.crb.core.ability.Ability;
import com.crb.core.ability.AbilityCategory;
import com.crb.core.ability.AbilityRegistry;
import net.minecraft.resources.ResourceLocation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AbilityRegistryTest {

    @BeforeAll
    public static void setupRegistry() {
        AbilityRegistry.init();
    }

    @Test
    @DisplayName("AbilityRegistry registers full JJA roster abilities")
    public void testRegistryCount() {
        assertFalse(AbilityRegistry.getAll().isEmpty(), "Ability registry should not be empty");
        assertTrue(AbilityRegistry.getAll().size() >= 25, "Registry should contain all JJA character wave abilities");
    }

    @Test
    @DisplayName("Signature Gojo abilities are registered and properly typed")
    public void testGojoAbilities() {
        Optional<Ability> purple = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "hollow_purple"));
        assertTrue(purple.isPresent(), "Hollow Purple must be registered");
        assertEquals(AbilityCategory.OFFENSIVE, purple.get().getCategory());
        assertTrue(purple.get().getCeCost() > 0);

        Optional<Ability> blue = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "lapse_blue"));
        assertTrue(blue.isPresent(), "Lapse Blue must be registered");
        assertEquals(AbilityCategory.OFFENSIVE, blue.get().getCategory());
    }

    @Test
    @DisplayName("Signature Sukuna abilities are registered with Malevolent Shrine domain")
    public void testSukunaAbilities() {
        Optional<Ability> shrine = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "malevolent_shrine"));
        assertTrue(shrine.isPresent(), "Malevolent Shrine must be registered");
        assertEquals(AbilityCategory.DOMAIN_EXPANSION, shrine.get().getCategory());

        Optional<Ability> wcs = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "world_cutting_slash"));
        assertTrue(wcs.isPresent(), "World Cutting Slash must be registered");

        Optional<Ability> fireArrow = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "fire_arrow"));
        assertTrue(fireArrow.isPresent(), "Fire Arrow (Kamutoke/Furnace) must be registered");
    }

    @Test
    @DisplayName("Domain expansions from Jogo, Mahito, Megumi are registered")
    public void testDomainExpansions() {
        Optional<Ability> ironMountain = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "coffin_iron_mountain"));
        assertTrue(ironMountain.isPresent());
        assertEquals(AbilityCategory.DOMAIN_EXPANSION, ironMountain.get().getCategory());

        Optional<Ability> perfection = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "self_embodiment_perfection"));
        assertTrue(perfection.isPresent());
        assertEquals(AbilityCategory.DOMAIN_EXPANSION, perfection.get().getCategory());

        Optional<Ability> garden = AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "chimera_shadow_garden"));
        assertTrue(garden.isPresent());
        assertEquals(AbilityCategory.DOMAIN_EXPANSION, garden.get().getCategory());
    }

    @Test
    @DisplayName("Unique CTs (Hakari, Higuruma, Todo, Kashimo) are registered")
    public void testUniqueTechniques() {
        assertTrue(AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "idle_death_gamble")).isPresent());
        assertTrue(AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "deadly_sentencing")).isPresent());
        assertTrue(AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "boogie_woogie")).isPresent());
        assertTrue(AbilityRegistry.get(ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "mythical_beast_amber")).isPresent());
    }
}
