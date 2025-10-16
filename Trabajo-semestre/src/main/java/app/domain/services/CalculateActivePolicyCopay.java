package app.domain.services;

import org.springframework.stereotype.Service;

@Service
public class CalculateActivePolicyCopay {

    private static final double STANDARD_COPAY = 50000;

    public double execute() {
        return STANDARD_COPAY;
    }
}
