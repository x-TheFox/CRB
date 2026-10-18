package com.crb.core.domain;

import com.crb.core.cursedenergy.CursedEnergyData;
import com.crb.core.init.ModRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DomainManager {
    private static final Map<UUID, DomainInstance> ACTIVE_DOMAINS = new ConcurrentHashMap<>();

    public static void registerDomain(DomainInstance domain) {
        ACTIVE_DOMAINS.put(domain.getDomainId(), domain);
        checkForClashes(domain);
    }

    public static void tick(ServerLevel level) {
        Iterator<Map.Entry<UUID, DomainInstance>> it = ACTIVE_DOMAINS.entrySet().iterator();
        while (it.hasNext()) {
            DomainInstance domain = it.next().getValue();
            domain.tick(level);

            if (domain.isDissolved()) {
                // Apply CT burnout to caster
                ServerPlayer caster = level.getServer().getPlayerList().getPlayer(domain.getCasterId());
                if (caster != null) {
                    CursedEnergyData data = caster.getData(ModRegistries.CURSED_ENERGY);
                    data.applyBurnout(600); // 30 seconds of burnout
                    caster.setData(ModRegistries.CURSED_ENERGY, data);
                }
                it.remove();
            }
        }
    }

    private static void checkForClashes(DomainInstance newDomain) {
        for (DomainInstance existing : ACTIVE_DOMAINS.values()) {
            if (existing.getDomainId().equals(newDomain.getDomainId())) continue;

            double distance = existing.getCenter().distanceTo(newDomain.getCenter());
            if (distance < (existing.getRadius() + newDomain.getRadius())) {
                // Domains overlap: establish clash
                existing.setClashingTargetId(newDomain.getDomainId());
                newDomain.setClashingTargetId(existing.getDomainId());

                // Evaluate refinement difference
                double diff = newDomain.getRefinementRating() - existing.getRefinementRating();
                if (Math.abs(diff) > 50.0) {
                    if (diff > 0) {
                        existing.setDissolved(true); // Existing domain shattered
                    } else {
                        newDomain.setDissolved(true); // New domain shattered
                    }
                }
            }
        }
    }

    public static boolean isEntityInsideAnyDomain(Entity entity) {
        for (DomainInstance domain : ACTIVE_DOMAINS.values()) {
            if (domain.isInside(entity.position()) && !domain.isDissolved()) {
                return true;
            }
        }
        return false;
    }

    public static List<DomainInstance> getActiveDomains() {
        return new ArrayList<>(ACTIVE_DOMAINS.values());
    }

    public static void clearAll() {
        ACTIVE_DOMAINS.clear();
    }
}
