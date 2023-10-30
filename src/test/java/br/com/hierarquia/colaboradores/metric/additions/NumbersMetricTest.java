package br.com.hierarquia.colaboradores.metric.additions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new NumbersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("{Aaa@Bb5Cc*Dd} 2");
        assertEquals(2, n);
    }

    @Test
    public void zero() {
        int n = metric.count("{Aaa@Bb/Cc*Dd} /");
        assertEquals(0, n);
    }

}