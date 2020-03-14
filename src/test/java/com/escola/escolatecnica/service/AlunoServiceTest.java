package com.escola.escolatecnica.service;

import com.escola.escolatecnica.modelos.Aluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.security.RunAs;
import javax.validation.constraints.Null;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @Test
    void salvaAlunoComSucesso() {
        // entradas / inputs
        Aluno esperado = new Aluno("Jonathan", "123456", "08/01/1988", "51-995938846");

        Mockito.when(alunoRepository.save(esperado)).thenReturn(esperado);
        // execução
        Aluno atual = alunoService.salvar(esperado);

        // verificação / validação
        assertEquals(esperado, atual);
        Mockito.verify(alunoRepository, Mockito.times(1)).save(esperado);
    }

    @Test()
    void falhaAoSalvarAlunoSemNome() {
        // entradas / inputs
        Aluno esperado = new Aluno(null, "123456", "08/01/1988", "51-995938846");

        // execução / verificação / validação
        Assertions.assertThrows(NullPointerException.class, () -> {
            alunoService.salvar(esperado);
        });
        Mockito.verifyNoInteractions(alunoRepository);
    }

}
