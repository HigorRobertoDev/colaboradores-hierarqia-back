package br.com.hierarquia.colaboradores.metric.additions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UppercaseLettersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new UppercaseLettersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("{AAa@Bb5Cc*Dd} ");
        assertEquals(5, n);
    }

    @Test
    public void zero() {
        int n = metric.count("{a@b5c*d} ");
        assertEquals(0, n);
    }

}