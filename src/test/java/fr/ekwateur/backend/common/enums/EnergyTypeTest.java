package fr.ekwateur.backend.common.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnergyTypeTest {

    @Test
    void testEnergyType_should_return_values() throws Exception {
        EnergyType[] energyTypes = EnergyType.values();

        assertEquals(2, energyTypes.length);
        assertEquals(EnergyType.GAS, energyTypes[0]);
        assertEquals(EnergyType.ELECTRICITY, energyTypes[1]);
    }

    @Test
    void testEnergyType_should_return_string() throws Exception {
        assertEquals("GAS", EnergyType.GAS.toString());
        assertEquals("ELECTRICITY", EnergyType.ELECTRICITY.toString());
    }

    @Test
    void testEnergyType_should_return_ordinal() throws Exception {
        assertEquals(0, EnergyType.GAS.ordinal());
        assertEquals(1, EnergyType.ELECTRICITY.ordinal());
    }
}
