package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersOnlyMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new NumbersOnlyMetric();
    }

    @Test
    public void count() {
        int n = metric.count(" 1234567890 ");
        assertEquals(12, n);
    }

    @Test
    public void zero() {
        int n = metric.count("1234567890a");
        assertEquals(0, n);
    }

}