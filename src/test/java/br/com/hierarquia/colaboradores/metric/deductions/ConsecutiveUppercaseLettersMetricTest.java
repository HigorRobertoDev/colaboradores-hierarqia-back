package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsecutiveUppercaseLettersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new ConsecutiveUppercaseLettersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("ABCaA1A*A B");
        assertEquals(3, n);
    }

    @Test
    public void zero() {
        int n = metric.count("A7CaA1A*A$ B");
        assertEquals(0, n);
    }

}