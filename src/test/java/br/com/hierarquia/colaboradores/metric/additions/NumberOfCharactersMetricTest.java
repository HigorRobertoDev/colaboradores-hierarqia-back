package br.com.hierarquia.colaboradores.metric.additions;

import br.com.hierarquia.colaboradores.metric.model.Metric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfCharactersMetricTest {
    private Metric metric;

    @BeforeEach
    public void setUp() {
        metric = new NumberOfCharactersMetric();
    }

    @Test
    public void count() {
        int n = metric.count(" 1@aA[].,#$ ");
        assertEquals(12, n);
    }

    @Test
    public void zero() {
        int n = metric.count("");
        assertEquals(0, n);
    }

}