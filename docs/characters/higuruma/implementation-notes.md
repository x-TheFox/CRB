# Hiromi Higuruma — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.higuruma`
- **Data Attachments (NeoForge 1.21.1)**:
  - `CourtroomTrialAttachment`: Tracks active courtroom session, courtroom UUID, defendant UUID, prosecutor UUID, trial phase, crime charge string, and verdict outcome.
  - `ConfiscationAttachment`: Tracks duration of sealed techniques and inventory slots affected.
- **Networking & Payloads**:
  - `ClientboundCourtroomPacket`: Opens trial screen on client, syncing camera to courtroom podium.
  - `ServerboundCourtroomPleaPacket`: Sends player plea (Silence / Confession / Defense) to server.
- **Trial State Machine**:
  - `PREPARING` -> `ACCUSATION` -> `DEFENSE_WINDOW` -> `VERDICT_EVALUATION` -> `SENTENCING` -> `CLEANUP`.
- **Gametests**:
  - `HigurumaGametests#testCourtroomNonViolenceEnforced`: Asserts attacks inside trial trigger event cancellation.
  - `HigurumaGametests#testConfiscationSealsTechnique`: Asserts defendant cannot cast abilities when sentenced.
  - `HigurumaGametests#testExecutionerSwordKillsCondemnedOnly`: Asserts sword instakills target while dealing standard damage to non-condemned.
