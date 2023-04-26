package fr.ekwateur.backend.common.external;

import fr.ekwateur.backend.common.port.ICustomerReferenceGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomerReferenceGeneratorImpl implements ICustomerReferenceGenerator {
    private static final String PREFIX = "EKW";
    private static final int ID_LENGTH = 8;
    private static final String DIGITS = "0123456789";

    @Override
    public String GenerateCustomerReference() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++) {
            int index = random.nextInt(DIGITS.length());
            sb.append(DIGITS.charAt(index));
        }
        return PREFIX + "-" + sb;
    }
}
