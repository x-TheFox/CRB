package com.crb.test;

import com.crb.CursedRealityBoundless;
import com.crb.core.domain.BarrierType;
import com.crb.core.domain.DomainInstance;
import com.crb.core.domain.DomainManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DomainEngineTest {

    @BeforeEach
    public void setup() {
        DomainManager.clearAll();
    }

    @Test
    @DisplayName("DomainInstance inside check accurately evaluates spherical radius")
    public void testDomainInsideBounds() {
        Vec3 center = new Vec3(0, 64, 0);
        DomainInstance domain = new DomainInstance(
                UUID.randomUUID(),
                ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "infinite_void"),
                BarrierType.CLOSED_SPHERE,
                center,
                25.0,
                600,
                100.0
        );

        assertTrue(domain.isInside(new Vec3(10, 64, 10)), "Point inside radius must return true");
        assertTrue(domain.isInside(new Vec3(0, 89, 0)), "Boundary point must return true");
        assertFalse(domain.isInside(new Vec3(30, 64, 0)), "Point outside radius must return false");
        assertEquals(BarrierType.CLOSED_SPHERE, domain.getBarrierType());
    }

    @Test
    @DisplayName("Open barrier domain spans up to 200m without closed wall obstruction")
    public void testOpenBarrierProperties() {
        Vec3 center = new Vec3(100, 70, 100);
        DomainInstance shrine = new DomainInstance(
                UUID.randomUUID(),
                ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "malevolent_shrine"),
                BarrierType.OPEN_BARRIER,
                center,
                200.0,
                1200,
                100.0
        );

        assertEquals(BarrierType.OPEN_BARRIER, shrine.getBarrierType());
        assertTrue(shrine.isInside(new Vec3(250, 70, 100)));
        assertFalse(shrine.isInside(new Vec3(350, 70, 100)));
    }

    @Test
    @DisplayName("Domain clash shatters weaker barrier when refinement difference exceeds threshold")
    public void testDomainClashRefinementShatter() {
        Vec3 center = new Vec3(0, 64, 0);

        // Superior domain (Refinement 100)
        DomainInstance sukuna = new DomainInstance(
                UUID.randomUUID(),
                ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "malevolent_shrine"),
                BarrierType.OPEN_BARRIER,
                center,
                200.0,
                1200,
                100.0
        );

        // Inferior domain (Refinement 40, diff = 60 > 50)
        DomainInstance fingerBearer = new DomainInstance(
                UUID.randomUUID(),
                ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "incomplete_domain"),
                BarrierType.CLOSED_SPHERE,
                center.add(5, 0, 5),
                20.0,
                600,
                40.0
        );

        DomainManager.registerDomain(sukuna);
        DomainManager.registerDomain(fingerBearer);

        // Inferior domain should be immediately shattered
        assertTrue(fingerBearer.isDissolved(), "Weaker domain must shatter due to overwhelming refinement delta");
        assertFalse(sukuna.isDissolved(), "Superior domain must remain active");
    }

    @Test
    @DisplayName("Evenly matched domains enter mutual clash without immediate dissolution")
    public void testEvenlyMatchedDomainClash() {
        Vec3 center = new Vec3(0, 64, 0);

        DomainInstance domainA = new DomainInstance(
                UUID.randomUUID(),
                ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "infinite_void"),
                BarrierType.CLOSED_SPHERE,
                center,
                25.0,
                600,
                100.0
        );

        DomainInstance domainB = new DomainInstance(
                UUID.randomUUID(),
                ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "malevolent_shrine"),
                BarrierType.OPEN_BARRIER,
                center.add(10, 0, 0),
                200.0,
                600,
                100.0
        );

        DomainManager.registerDomain(domainA);
        DomainManager.registerDomain(domainB);

        assertFalse(domainA.isDissolved(), "Equally refined domain A must survive clash");
        assertFalse(domainB.isDissolved(), "Equally refined domain B must survive clash");
        assertEquals(domainB.getDomainId(), domainA.getClashingTargetId(), "Domain A must record target clash ID");
        assertEquals(domainA.getDomainId(), domainB.getClashingTargetId(), "Domain B must record target clash ID");
    }
}
