package com.escola.escolatecnica.service;

import com.escola.escolatecnica.dto.TurmaDTO;
import com.escola.escolatecnica.modelos.Aluno;
import com.escola.escolatecnica.modelos.Curso;
import com.escola.escolatecnica.modelos.Matricula;
import com.escola.escolatecnica.modelos.Turma;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TurmaServiceTest {

    @Mock
    private TurmaRepository turmaRepository;

    @Mock
    private CursoService cursoService;

    @Mock
    private MatriculaService matriculaService;

    @InjectMocks
    private TurmaService turmaService;

    @Test
    void testSalvarComSucesso() {
        // entrada
        TurmaDTO turmaDTO = new TurmaDTO("14/03/2020", "27/05/2020",
                1L, Arrays.asList(1L, 2L, 3L, 4L));

        Curso curso = new Curso();
        List<Aluno> alunos = Arrays.asList(new Aluno());
        List<Matricula> matriculas = Arrays.asList(new Matricula());
        Turma turma = new Turma(turmaDTO.getDataInicio(),
                turmaDTO.getDataFinal(), curso);

        when(cursoService.findById(turmaDTO.getIdCurso())).thenReturn(curso);
        when(turmaRepository.save(turma)).thenReturn(turma);

        // execução
        Turma atual = turmaService.save(turmaDTO);

        // verificação
        assertEquals(turma, atual);
        verify(cursoService, times(1)).findById(turmaDTO.getIdCurso());
        verify(turmaRepository).save(turma);
        verify(matriculaService).save(turma, turmaDTO.getIdAlunos());
    }

}
