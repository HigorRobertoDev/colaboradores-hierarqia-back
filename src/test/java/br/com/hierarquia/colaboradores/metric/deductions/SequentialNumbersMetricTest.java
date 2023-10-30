package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialNumbersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new SequentialNumbersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("!1 234 568%$");
        assertEquals(1, n);
    }

    @Test
    public void zero() {
        int n = metric.count("!1 23 4 568%$");
        assertEquals(0, n);
    }

}