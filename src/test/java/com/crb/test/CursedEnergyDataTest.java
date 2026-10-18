package com.crb.test;

import com.crb.core.cursedenergy.Clan;
import com.crb.core.cursedenergy.CursedEnergyData;
import com.crb.core.cursedenergy.SorcererGrade;
import com.crb.core.cursedenergy.Trait;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CursedEnergyDataTest {
    private CursedEnergyData data;

    @BeforeEach
    public void setup() {
        data = new CursedEnergyData();
    }

    @Test
    @DisplayName("Grade 4 initial configuration matches expected baseline")
    public void testInitialBaseline() {
        assertEquals(SorcererGrade.GRADE_4, data.getGrade());
        assertEquals(100.0, data.getMaxCE());
        assertEquals(100.0, data.getCurrentCE());
        assertEquals(1.0, data.getRegenRate());
        assertFalse(data.isZeroCE());
    }

    @Test
    @DisplayName("Grade advancement scales max CE and regeneration rate")
    public void testGradeAdvancement() {
        data.setGrade(SorcererGrade.SPECIAL_GRADE);
        assertEquals(3500.0, data.getMaxCE());
        assertEquals(5.0, data.getRegenRate());
    }

    @Test
    @DisplayName("Consuming CE adheres to cost and prevents overdraw")
    public void testConsumeCE() {
        data.setCurrentCE(80.0);
        assertTrue(data.consume(50.0));
        assertEquals(30.0, data.getCurrentCE(), 0.001);

        assertFalse(data.consume(50.0));
        assertEquals(30.0, data.getCurrentCE(), 0.001);
    }

    @Test
    @DisplayName("Six Eyes reduces CE cost to near-zero")
    public void testSixEyesEfficiency() {
        data.setTrait(Trait.SIX_EYES);
        data.setClan(Clan.GOJO);
        data.setCurrentCE(10.0);

        // A 500 CE Hollow Purple should cost only 0.5 CE with Six Eyes (0.001x)
        assertTrue(data.consume(500.0));
        assertEquals(9.5, data.getCurrentCE(), 0.001);
    }

    @Test
    @DisplayName("Heavenly Restriction permanently zeroes CE pool and prevents consumption")
    public void testHeavenlyRestriction() {
        data.setTrait(Trait.HEAVENLY_RESTRICTION);
        data.tickRegen(20);

        assertTrue(data.isZeroCE());
        assertEquals(0.0, data.getCurrentCE());
        assertEquals(0.0, data.getMaxCE());
        assertFalse(data.consume(1.0));
    }

    @Test
    @DisplayName("Burnout state disables ability casting until timer expires")
    public void testDomainBurnoutLifecycle() {
        data.applyBurnout(100);
        assertTrue(data.isDomainBurnout());
        assertEquals(100, data.getBurnoutTicksRemaining());

        data.tickRegen(50);
        assertTrue(data.isDomainBurnout());
        assertEquals(50, data.getBurnoutTicksRemaining());

        data.tickRegen(60);
        assertFalse(data.isDomainBurnout());
        assertEquals(0, data.getBurnoutTicksRemaining());
    }
}
