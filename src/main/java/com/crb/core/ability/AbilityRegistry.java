package com.crb.core.ability;

import com.crb.content.characters.absorption.SupernovaDetonationAbility;
import com.crb.content.characters.finger_bearer.MugetsuBeamAbility;
import com.crb.content.characters.gojo.HollowPurpleAbility;
import com.crb.content.characters.gojo.LapseBlueAbility;
import com.crb.content.characters.hakari.IdleDeathGambleAbility;
import com.crb.content.characters.higuruma.DeadlySentencingAbility;
import com.crb.content.characters.higuruma.ExecutionerSwordAbility;
import com.crb.content.characters.inumaki.CursedSpeechCommandAbility;
import com.crb.content.characters.jogo.CoffinOfTheIronMountainAbility;
import com.crb.content.characters.jogo.DisasterFlamesAbility;
import com.crb.content.characters.jogo.MaximumMeteorAbility;
import com.crb.content.characters.kashimo.MythicalBeastAmberAbility;
import com.crb.content.characters.kashimo.SureHitLightningDischargeAbility;
import com.crb.content.characters.mahito.IdleTransfigurationAbility;
import com.crb.content.characters.mahito.SelfEmbodimentOfPerfectionAbility;
import com.crb.content.characters.megumi.ChimeraShadowGardenAbility;
import com.crb.content.characters.megumi.MahoragaRitualAbility;
import com.crb.content.characters.megumi.TenShadowsSummonAbility;
import com.crb.content.characters.minor.HarutaMiracleSaveAbility;
import com.crb.content.characters.sukuna.*;
import com.crb.content.characters.todo.BoogieWoogieSwapAbility;
import com.crb.content.characters.todo.SimpleDomainAbility;
import com.crb.content.characters.toji_maki.InvertedSpearNullifyAbility;
import com.crb.content.characters.toji_maki.SoulSplitKatanaAbility;
import com.crb.content.characters.yuji.BlackFlashChainAbility;
import com.crb.content.characters.yuji.BloodManipulationPiercingBloodAbility;
import com.crb.content.characters.yuji.DivergentFistAbility;
import net.minecraft.resources.ResourceLocation;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AbilityRegistry {
    private static final Map<ResourceLocation, Ability> REGISTRY = new ConcurrentHashMap<>();

    public static void register(Ability ability) {
        REGISTRY.put(ability.getId(), ability);
    }

    public static Optional<Ability> get(ResourceLocation id) {
        return Optional.ofNullable(REGISTRY.get(id));
    }

    public static Collection<Ability> getAll() {
        return Collections.unmodifiableCollection(REGISTRY.values());
    }

    public static Set<ResourceLocation> getAllIds() {
        return Collections.unmodifiableSet(REGISTRY.keySet());
    }

    public static void init() {
        // Gojo Satoru
        register(new LapseBlueAbility());
        register(new HollowPurpleAbility());

        // Sukuna Ryomen
        register(new DismantleAbility());
        register(new CleaveAbility());
        register(new FireArrowAbility());
        register(new WorldCuttingSlashAbility());
        register(new MalevolentShrineAbility());

        // Yuji Itadori
        register(new DivergentFistAbility());
        register(new BlackFlashChainAbility());
        register(new BloodManipulationPiercingBloodAbility());

        // Megumi Fushiguro
        register(new TenShadowsSummonAbility());
        register(new MahoragaRitualAbility());
        register(new ChimeraShadowGardenAbility());

        // Jogo
        register(new DisasterFlamesAbility());
        register(new MaximumMeteorAbility());
        register(new CoffinOfTheIronMountainAbility());

        // Mahito
        register(new IdleTransfigurationAbility());
        register(new SelfEmbodimentOfPerfectionAbility());

        // Hajime Kashimo
        register(new SureHitLightningDischargeAbility());
        register(new MythicalBeastAmberAbility());

        // Hiromi Higuruma
        register(new DeadlySentencingAbility());
        register(new ExecutionerSwordAbility());

        // Aoi Todo
        register(new BoogieWoogieSwapAbility());
        register(new SimpleDomainAbility());

        // Kinji Hakari
        register(new IdleDeathGambleAbility());

        // Toji Fushiguro / Maki Zenin
        register(new InvertedSpearNullifyAbility());
        register(new SoulSplitKatanaAbility());

        // Toge Inumaki
        register(new CursedSpeechCommandAbility());

        // Finger Bearer
        register(new MugetsuBeamAbility());

        // Curse Absorption (Geto / Kenjaku)
        register(new SupernovaDetonationAbility());

        // Minor CTs
        register(new HarutaMiracleSaveAbility());
    }
}
