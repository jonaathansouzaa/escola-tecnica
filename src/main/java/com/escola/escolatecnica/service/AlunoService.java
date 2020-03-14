package com.escola.escolatecnica.service;

import com.escola.escolatecnica.modelos.Aluno;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        if(aluno.getNome() == null) {
            throw new NullPointerException();
        }

        return alunoRepository.save(aluno);
    }
}
