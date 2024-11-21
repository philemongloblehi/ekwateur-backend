package fr.ekwateur.backend.common.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTypeTest {

    @Test
    void testCustomerType_should_return_values() throws Exception {
        CustomerType[] customerTypes = CustomerType.values();

        assertEquals(2, customerTypes.length);
        assertEquals(CustomerType.PARTICULAR, customerTypes[0]);
        assertEquals(CustomerType.PROFESSIONAL, customerTypes[1]);
    }

    @Test
    void testCustomerType_should_return_string() throws Exception {
        assertEquals("PARTICULAR", CustomerType.PARTICULAR.toString());
        assertEquals("PROFESSIONAL", CustomerType.PROFESSIONAL.toString());
    }

    @Test
    void testCustomerType_should_return_ordinal() throws Exception {
        assertEquals(0, CustomerType.PARTICULAR.ordinal());
        assertEquals(1, CustomerType.PROFESSIONAL.ordinal());
    }
}
