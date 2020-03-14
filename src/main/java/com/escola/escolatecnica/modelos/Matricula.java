package com.escola.escolatecnica.modelos;

import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Turma turma;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Aluno aluno;

}
