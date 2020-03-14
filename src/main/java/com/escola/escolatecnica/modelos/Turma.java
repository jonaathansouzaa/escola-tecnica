package com.escola.escolatecnica.modelos;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    public Turma(String dataInicio, String dataFinal, Curso curso) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id) &&
                Objects.equals(dataInicio, turma.dataInicio) &&
                Objects.equals(dataFinal, turma.dataFinal) &&
                Objects.equals(curso, turma.curso) &&
                Objects.equals(matriculas, turma.matriculas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataInicio, dataFinal, curso, matriculas);
    }
}
