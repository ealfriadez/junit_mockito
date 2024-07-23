package pe.edu.unfv.junit_mockito.repositories;

import java.util.List;

public interface PreguntasRepository {

    List<String> findPreguntasPorExamenId(Long id);
}
