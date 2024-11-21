package fr.ekwateur.backend.common.external;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerReferenceGeneratorImplTest {

    @Test
    public void testCustomerReferenceGenerator() throws Exception {
        CustomerReferenceGeneratorImpl referenceGenerator = new CustomerReferenceGeneratorImpl();
        String result = referenceGenerator.generateCustomerReference();

        assertNotNull(result);
        assertEquals(12, result.length());
    }

    @Test
    public void testCustomerReferenceGenerator_should_contain_prefix_ekw() throws Exception {
        CustomerReferenceGeneratorImpl referenceGenerator = new CustomerReferenceGeneratorImpl();
        String result = referenceGenerator.generateCustomerReference();

        assertNotNull(result);
        assertTrue(result.startsWith("EKW"));
    }
}
