package pe.edu.unfv.junit_mockito.repositories;

import pe.edu.unfv.junit_mockito.models.Examen;

import java.util.List;

public interface ExamenRepository {

    List<Examen> findAll();
}
