package com.escola.escolatecnica.modelos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataInicio;
    private String dataFinal;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculas;

}
