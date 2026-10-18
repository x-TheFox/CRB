# Kinji Hakari — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.hakari`
- **Data Attachments (NeoForge 1.21.1)**:
  - `JackpotStateAttachment`: Tracks active state boolean, countdown ticks (`5020`), probability boost multipliers, and consecutive jackpot streak count.
  - `DomainGachaAttachment`: Tracks current Riichi drama stage, visual indicators (color), and slot numbers.
- **Networking & Payloads**:
  - `ClientboundJackpotMusicPacket`: Plays and synchronizes *Admiring You* / *Tuka Donka* stream across all nearby players.
  - `ClientboundRiichiCutscenePacket`: Renders UI manga panel sequence on client.
- **Server-Authoritative Immortality**:
  - `LivingDamageEvent.Pre`: If `JackpotStateAttachment.isActive()`, damage is intercepted, health set to maximum, and `event.setCanceled(true)`.
  - `LivingDeathEvent`: If player would die due to absolute damage while in Jackpot, player is revived on the spot with full HP.
- **Gametests**:
  - `HakariGametests#testJackpotPreventsLethalDamage`: Verifies player survives 1000 void/explosion damage in Jackpot.
  - `HakariGametests#testThemeMusicSyncsAcrossClients`: Verifies music packet broadcasts within 48 blocks.
  - `HakariGametests#testDomainCooldownResetsOnJackpotEnd`: Asserts burnout is 0 upon mode expiration.
