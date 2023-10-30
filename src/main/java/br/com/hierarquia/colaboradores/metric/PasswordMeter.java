package br.com.hierarquia.colaboradores.metric;

import br.com.hierarquia.colaboradores.metric.additions.LowercaseLettersMetric;
import br.com.hierarquia.colaboradores.metric.additions.MiddleNumbersOrSymbolsMetric;
import br.com.hierarquia.colaboradores.metric.additions.NumberOfCharactersMetric;
import br.com.hierarquia.colaboradores.metric.additions.NumbersMetric;
import br.com.hierarquia.colaboradores.metric.additions.SymbolsMetric;
import br.com.hierarquia.colaboradores.metric.additions.UppercaseLettersMetric;
import br.com.hierarquia.colaboradores.metric.deductions.ConsecutiveLowercaseLettersMetric;
import br.com.hierarquia.colaboradores.metric.deductions.ConsecutiveNumbersMetric;
import br.com.hierarquia.colaboradores.metric.deductions.ConsecutiveUppercaseLettersMetric;
import br.com.hierarquia.colaboradores.metric.deductions.LettersOnlyMetric;
import br.com.hierarquia.colaboradores.metric.deductions.RepeatCharactersMetric;
import br.com.hierarquia.colaboradores.metric.deductions.SequentialLettersMetric;
import br.com.hierarquia.colaboradores.metric.deductions.SequentialNumbersMetric;
import br.com.hierarquia.colaboradores.metric.deductions.SequentialSymbolsMetric;
import br.com.hierarquia.colaboradores.metric.model.Complexity;
import br.com.hierarquia.colaboradores.metric.model.Metric;
import br.com.hierarquia.colaboradores.metric.model.PasswordStrength;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PasswordMeter {

    public PasswordMeter() {
        this.metrics = Arrays.asList(
                new LowercaseLettersMetric(),
                new MiddleNumbersOrSymbolsMetric(),
                new NumberOfCharactersMetric(),
                new NumbersMetric(),
                new SymbolsMetric(),
                new UppercaseLettersMetric(),
                new ConsecutiveLowercaseLettersMetric(),
                new ConsecutiveNumbersMetric(),
                new ConsecutiveUppercaseLettersMetric(),
                new LettersOnlyMetric(),
                new RepeatCharactersMetric(),
                new SequentialLettersMetric(),
                new SequentialNumbersMetric(),
                new SequentialSymbolsMetric()
        );
    }

    private List<Metric> metrics;

    private int score(String password) {
        int len = password.length();
        int score = 0;
        for (Metric m : this.metrics) {
            int n = m.count(password);
            int bonus = m.rate(n, len);
            score += bonus;
        }
        return checkRange(score);
    }

    private int checkRange(int score) {
        if (score < 0)
            return 0;
        else if (score > 100)
            return 100;
        else
            return score;
    }

    public PasswordStrength measure(String password) {
        int score = score(password);
        return new PasswordStrength(score , Complexity.getComplexity(score));
    }

}
