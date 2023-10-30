package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsecutiveLowercaseLettersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new ConsecutiveLowercaseLettersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("abcAa1a*a b");
        assertEquals(3, n);
    }

    @Test
    public void zero() {
        int n = metric.count("a7cAa1a*a$ b");
        assertEquals(0, n);
    }

}