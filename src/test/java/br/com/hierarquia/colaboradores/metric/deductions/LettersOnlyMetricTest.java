package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LettersOnlyMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new LettersOnlyMetric();
    }

    @Test
    public void count() {
        int n = metric.count(" aSdfgHj ");
        assertEquals(9, n);
    }

    @Test
    public void zero() {
        int n = metric.count("aSdfgHj1");
        assertEquals(0, n);
    }

}