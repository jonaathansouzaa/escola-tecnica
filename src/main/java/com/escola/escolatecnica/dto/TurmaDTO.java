package com.escola.escolatecnica.dto;

import java.util.List;

public class TurmaDTO {

    private String dataInicio;
    private String dataFinal;
    private Long idCurso;
    private List<Long> idAlunos;

    public TurmaDTO(String dataInicio, String dataFinal, Long idCurso, List<Long> idAlunos) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.idCurso = idCurso;
        this.idAlunos = idAlunos;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public List<Long> getIdAlunos() {
        return idAlunos;
    }

    public void setIdAlunos(List<Long> idAlunos) {
        this.idAlunos = idAlunos;
    }
}
