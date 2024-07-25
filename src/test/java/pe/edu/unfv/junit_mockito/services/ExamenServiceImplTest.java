package pe.edu.unfv.junit_mockito.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Answer1;
import org.mockito.stubbing.OngoingStubbing;
import pe.edu.unfv.junit_mockito.models.Examen;
import pe.edu.unfv.junit_mockito.repositories.ExamenRepository;
import pe.edu.unfv.junit_mockito.repositories.PreguntasRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {

    @Mock
    ExamenRepository repository;
    @Mock
    PreguntasRepository preguntasRepository;

    @InjectMocks
    ExamenServiceImpl service;

    Optional<Examen> examen;

    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
//        repository = mock(ExamenRepository.class);
//        preguntasRepository = mock(PreguntasRepository.class);
//        service = new ExamenServiceImpl(repository, preguntasRepository);
    }

    @Test
    void findExamenPorNombre() {

        when(repository.findAll()).thenReturn(Datos.EXAMENES);

        examen = service.findExamenPorNombre("Matematicas");

        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matematicas", examen.orElseThrow().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {

        List<Examen> datos = Collections.emptyList();

        when(repository.findAll()).thenReturn(datos);

        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntasRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Lenguaje");

        assertEquals(8, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("trigonometria"));
    }

    @Test
    void testPreguntasExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntasRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Lenguaje");

        assertEquals(8, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("trigonometria"));

        verify(repository).findAll();
        verify(preguntasRepository).findPreguntasPorExamenId(4L);
    }

    @Test
    void testNoExisteExamenVerify() {
        when(repository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntasRepository.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);

        Examen examen = service.findExamenPorNombreConPreguntas("Lenguaje");

        assertNull(examen);

        verify(repository).findAll();
        verify(preguntasRepository).findPreguntasPorExamenId(anyLong());
    }

    @Test
    void testSaveExamen() {
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);
        when(repository.save(any(Examen.class))).then(new Answer<Examen>(){

            Long secuencia = 15L;
            @Override
            public Examen answer(InvocationOnMock invocation) throws Throwable {
                Examen examen = invocation.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        });

        Examen examen = service.saveExamen(newExamen);
        assertNotNull(examen.getId());
        assertEquals(15L, examen.getId());
        assertEquals("Matematicas", examen.getNombre());

        verify(repository).save(any(Examen.class));
        verify(preguntasRepository).guardarVarias(anyList());

    }
}