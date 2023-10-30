package br.com.hierarquia.colaboradores.metric.model;

public interface Metric {
    int count(String password);

    int rate(int n, int len);
}
