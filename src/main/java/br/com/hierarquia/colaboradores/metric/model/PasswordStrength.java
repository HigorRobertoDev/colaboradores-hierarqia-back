package br.com.hierarquia.colaboradores.metric.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PasswordStrength {
    private Integer score;
    private String complexity;
}
