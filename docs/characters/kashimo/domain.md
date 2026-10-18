# Hajime Kashimo — Domain Expansion: Unforgiving Tempest (嵐の領域)

## 1. Domain Overview & Canon Status
- **Canon Context**: Kashimo in canon did not reveal an innate domain expansion (relying instead on Hollow Wicker Basket to neutralize others' domains, Chapter 187).
- **JJA Adaptation**: JJA granted Kashimo a custom domain expansion: "Unforgiving Tempest" (`kashimo_domain1.mcfunction`, `storm_domain.mcfunction`, tag `form6`).
- **Java Mod Policy**: Fully implemented in CRB to honor JJA parity, with an optional toggle in YACL config for strict canon purists.

## 2. Domain Mechanics & Specifications
- **Barrier Type**: Enclosed 66-block spherical domain barrier with stormy dark-slate exterior and swirling vortex clouds.
- **Interior Environment**:
  - Sky turns into an unending supercell thunderstorm with turbulent wind and static ozone fog.
  - Flooded floor with 0.5-block deep water layer conducting electricity across the entire surface.
- **Sure-Hit Effect (必中効果)**:
  - **Electrostatic Saturation**: All targets within the domain are automatically inflicted with maximum negative charge stacks upon entering.
  - **Omnidirectional Lightning Cascade**: Every 10 ticks (0.5 seconds), a guaranteed-hit lightning strike hammers every enemy entity inside the domain, dealing 12 true electrical damage per strike.
  - **Simple Domain / HWB Counter**: If the opponent deploys Hollow Wicker Basket or Simple Domain, the sure-hit cascade is blocked, but the electrified water pool continues to deal minor contact shock.
