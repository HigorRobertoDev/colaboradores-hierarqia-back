package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialLettersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new SequentialLettersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("!AaBc deG%$");
        assertEquals(1, n);
    }

    @Test
    public void zero() {
        int n = metric.count("!Aa Bc deG%$");
        assertEquals(0, n);
    }

}