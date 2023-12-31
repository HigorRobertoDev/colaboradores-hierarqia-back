package br.com.hierarquia.colaboradores.metric.additions;

import br.com.hierarquia.colaboradores.metric.model.Metric;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolsMetric implements Metric {
    private static final Pattern REGEX = Pattern.compile("([^a-zA-Z\\d\\s]+)");

    @Override
    public int count(String password) {
        Matcher matcher = REGEX.matcher(password);
        int count = 0;
        while (matcher.find())
            count += matcher.group().length();
        return count;
    }

    @Override
    public int rate(int n, int len) {
        return +(n * 6);
    }
}
