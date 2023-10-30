package br.com.hierarquia.colaboradores.metric.deductions;

import br.com.hierarquia.colaboradores.metric.model.Metric;

public class NumbersOnlyMetric implements Metric {
    private static final String REGEX = "^[\\d\\s]*$";

    @Override
    public int count(String password) {
        return password.matches(REGEX) ? password.length() : 0;
    }

    @Override
    public int rate(int n, int len) {
        return -n;
    }
}
