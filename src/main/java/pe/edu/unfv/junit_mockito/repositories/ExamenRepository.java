package pe.edu.unfv.junit_mockito.repositories;

import pe.edu.unfv.junit_mockito.models.Examen;

import java.util.List;

public interface ExamenRepository {

    Examen save(Examen examen);
    List<Examen> findAll();
}
