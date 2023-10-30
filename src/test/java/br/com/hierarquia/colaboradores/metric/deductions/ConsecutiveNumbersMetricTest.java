package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsecutiveNumbersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new ConsecutiveNumbersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("$1 2 3 4a5*6");
        assertEquals(3, n);
    }

    @Test
    public void zero() {
        int n = metric.count("$1 .2 .3 .4a5*6");
        assertEquals(0, n);
    }

}