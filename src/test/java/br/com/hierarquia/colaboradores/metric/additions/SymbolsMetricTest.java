package br.com.hierarquia.colaboradores.metric.additions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymbolsMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new SymbolsMetric();
    }

    @Test
    public void count() {
        int n = metric.count("{Aaa@Bb5Cc*Dd} 2/_^~[];.,<>");
        assertEquals(15, n);
    }

    @Test
    public void zero() {
        int n = metric.count("2Aaa1BbCc5D9d 0");
        assertEquals(0, n);
    }

}