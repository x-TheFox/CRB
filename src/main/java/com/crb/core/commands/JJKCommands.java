package com.crb.core.commands;

import com.crb.core.ability.Ability;
import com.crb.core.ability.AbilityRegistry;
import com.crb.core.cursedenergy.Clan;
import com.crb.core.cursedenergy.CursedEnergyData;
import com.crb.core.cursedenergy.SorcererGrade;
import com.crb.core.cursedenergy.Trait;
import com.crb.core.domain.DomainManager;
import com.crb.core.init.ModRegistries;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

public class JJKCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("jjk")
                .requires(source -> source.hasPermission(2))
                .then(Commands.literal("energy")
                        .then(Commands.literal("set")
                                .then(Commands.argument("amount", DoubleArgumentType.doubleArg(0))
                                        .executes(ctx -> {
                                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                                            double amount = DoubleArgumentType.getDouble(ctx, "amount");
                                            CursedEnergyData data = player.getData(ModRegistries.CURSED_ENERGY);
                                            data.setCurrentCE(amount);
                                            player.setData(ModRegistries.CURSED_ENERGY, data);
                                            ctx.getSource().sendSuccess(() -> Component.literal("Set cursed energy to " + amount), true);
                                            return 1;
                                        })
                                )
                        )
                )
                .then(Commands.literal("grade")
                        .then(Commands.literal("set")
                                .then(Commands.argument("gradeName", StringArgumentType.string())
                                        .executes(ctx -> {
                                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                                            String gradeName = StringArgumentType.getString(ctx, "gradeName").toUpperCase();
                                            try {
                                                SorcererGrade grade = SorcererGrade.valueOf(gradeName);
                                                CursedEnergyData data = player.getData(ModRegistries.CURSED_ENERGY);
                                                data.setGrade(grade);
                                                player.setData(ModRegistries.CURSED_ENERGY, data);
                                                ctx.getSource().sendSuccess(() -> Component.literal("Set grade to " + grade.getDisplayName()), true);
                                                return 1;
                                            } catch (IllegalArgumentException e) {
                                                ctx.getSource().sendFailure(Component.literal("Unknown grade: " + gradeName));
                                                return 0;
                                            }
                                        })
                                )
                        )
                )
                .then(Commands.literal("trait")
                        .then(Commands.literal("set")
                                .then(Commands.argument("traitName", StringArgumentType.string())
                                        .executes(ctx -> {
                                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                                            String traitName = StringArgumentType.getString(ctx, "traitName").toUpperCase();
                                            try {
                                                Trait trait = Trait.valueOf(traitName);
                                                CursedEnergyData data = player.getData(ModRegistries.CURSED_ENERGY);
                                                data.setTrait(trait);
                                                player.setData(ModRegistries.CURSED_ENERGY, data);
                                                ctx.getSource().sendSuccess(() -> Component.literal("Set trait to " + trait.name()), true);
                                                return 1;
                                            } catch (IllegalArgumentException e) {
                                                ctx.getSource().sendFailure(Component.literal("Unknown trait: " + traitName));
                                                return 0;
                                            }
                                        })
                                )
                        )
                )
                .then(Commands.literal("clan")
                        .then(Commands.literal("set")
                                .then(Commands.argument("clanName", StringArgumentType.string())
                                        .executes(ctx -> {
                                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                                            String clanName = StringArgumentType.getString(ctx, "clanName").toUpperCase();
                                            try {
                                                Clan clan = Clan.valueOf(clanName);
                                                CursedEnergyData data = player.getData(ModRegistries.CURSED_ENERGY);
                                                data.setClan(clan);
                                                player.setData(ModRegistries.CURSED_ENERGY, data);
                                                ctx.getSource().sendSuccess(() -> Component.literal("Set clan to " + clan.getDisplayName()), true);
                                                return 1;
                                            } catch (IllegalArgumentException e) {
                                                ctx.getSource().sendFailure(Component.literal("Unknown clan: " + clanName));
                                                return 0;
                                            }
                                        })
                                )
                        )
                )
                .then(Commands.literal("burnout")
                        .then(Commands.literal("clear")
                                .executes(ctx -> {
                                    ServerPlayer player = ctx.getSource().getPlayerOrException();
                                    CursedEnergyData data = player.getData(ModRegistries.CURSED_ENERGY);
                                    data.clearBurnout();
                                    player.setData(ModRegistries.CURSED_ENERGY, data);
                                    ctx.getSource().sendSuccess(() -> Component.literal("Cleared technique burnout!"), true);
                                    return 1;
                                })
                        )
                        .then(Commands.literal("apply")
                                .then(Commands.argument("ticks", IntegerArgumentType.integer(1))
                                        .executes(ctx -> {
                                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                                            int ticks = IntegerArgumentType.getInteger(ctx, "ticks");
                                            CursedEnergyData data = player.getData(ModRegistries.CURSED_ENERGY);
                                            data.applyBurnout(ticks);
                                            player.setData(ModRegistries.CURSED_ENERGY, data);
                                            ctx.getSource().sendSuccess(() -> Component.literal("Applied burnout for " + ticks + " ticks"), true);
                                            return 1;
                                        })
                                )
                        )
                )
                .then(Commands.literal("domain")
                        .then(Commands.literal("clear")
                                .executes(ctx -> {
                                    DomainManager.clearAll();
                                    ctx.getSource().sendSuccess(() -> Component.literal("Dissolved all active domain barriers"), true);
                                    return 1;
                                })
                        )
                )
                .then(Commands.literal("ability")
                        .then(Commands.literal("list")
                                .executes(ctx -> {
                                    ctx.getSource().sendSuccess(() -> Component.literal("§6§lRegistered Jujutsu Abilities (" + AbilityRegistry.getAll().size() + "):"), false);
                                    for (Ability ability : AbilityRegistry.getAll()) {
                                        ctx.getSource().sendSuccess(() -> Component.literal("§7- §e" + ability.getId() + " §8[§b" + ability.getName() + "§8] CE: " + ability.getCeCost()), false);
                                    }
                                    return 1;
                                })
                        )
                        .then(Commands.literal("cast")
                                .then(Commands.argument("abilityId", StringArgumentType.string())
                                        .executes(ctx -> {
                                            ServerPlayer player = ctx.getSource().getPlayerOrException();
                                            String idStr = StringArgumentType.getString(ctx, "abilityId");
                                            ResourceLocation loc = ResourceLocation.tryParse(idStr.contains(":") ? idStr : "crb:" + idStr);
                                            if (loc == null) {
                                                ctx.getSource().sendFailure(Component.literal("Invalid ability ID: " + idStr));
                                                return 0;
                                            }
                                            var opt = AbilityRegistry.get(loc);
                                            if (opt.isEmpty()) {
                                                ctx.getSource().sendFailure(Component.literal("Ability not found: " + loc));
                                                return 0;
                                            }
                                            Ability ability = opt.get();
                                            CursedEnergyData ceData = player.getData(ModRegistries.CURSED_ENERGY);
                                            if (!ability.canCast(player, ceData)) {
                                                ctx.getSource().sendFailure(Component.literal("Cannot cast: Insufficient CE or in Technique Burnout!"));
                                                return 0;
                                            }
                                            ceData.consume(ability.getCeCost());
                                            player.setData(ModRegistries.CURSED_ENERGY, ceData);
                                            Vec3 look = player.getLookAngle();
                                            Vec3 target = player.position().add(look.scale(ability.getMaxRange()));
                                            ability.execute(player, new Ability.AbilityContext(target, 0, 0, player.isShiftKeyDown()));
                                            ctx.getSource().sendSuccess(() -> Component.literal("Executed: " + ability.getName()), true);
                                            return 1;
                                        })
                                )
                        )
                )
        );
    }
}
