package br.com.hierarquia.colaboradores.metric.additions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowercaseLettersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new LowercaseLettersMetric();
    }

    @Test
    public void count() {
        int n = metric.count("{Aaa@Bb5Cc*Dd} ");
        assertEquals(5, n);
    }

    @Test
    public void zero() {
        int n = metric.count("{A@B5C*D} ");
        assertEquals(0, n);
    }
}
