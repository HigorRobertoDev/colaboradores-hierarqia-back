package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialSymbolsMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new SequentialSymbolsMetric();
    }

    @Test
    public void count() {
        int n = metric.count("1! @#$ %^*1A");
        assertEquals(1, n);
    }

    @Test
    public void zero() {
        int n = metric.count("1! @a#$ %^*1A");
        assertEquals(0, n);
    }

}