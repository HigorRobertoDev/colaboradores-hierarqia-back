package br.com.hierarquia.colaboradores.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "colaboradores")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "senha", length = 100, nullable = false)
    private String senha;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "complexity", length = 100, nullable = false)
    private String complexity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hierarquia")
    private Hierarquia hierarquia;

}
