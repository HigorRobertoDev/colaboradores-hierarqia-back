package br.com.hierarquia.colaboradores.controller;

import br.com.hierarquia.colaboradores.metric.PasswordMeter;
import br.com.hierarquia.colaboradores.metric.model.PasswordStrength;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/password-meter")
public class PasswordMeterController {

    @GetMapping(value = "/{password}")
    public ResponseEntity<PasswordStrength> measurePassword(@PathVariable("password") String password) {
        PasswordMeter passwordMeter = new PasswordMeter();
        PasswordStrength passwordStrength = passwordMeter.measure(password);
        return ResponseEntity.status(HttpStatus.OK).body(passwordStrength);
    }


}
