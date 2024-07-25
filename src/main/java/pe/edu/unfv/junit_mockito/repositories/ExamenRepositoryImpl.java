package pe.edu.unfv.junit_mockito.repositories;

import pe.edu.unfv.junit_mockito.models.Examen;

import java.util.Collections;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepository{

    @Override
    public Examen save(Examen examen) {
        return null;
    }

    @Override
    public List<Examen> findAll() {
        return Collections.emptyList();
                /*List.of(
                new Examen(5L, "Matematicas"),
                new Examen(6L, "Lenguaje"),
                new Examen(7L, "Ciencias"),
                new Examen(8L, "Historia"),
                new Examen(9L, "Ingles"),
                new Examen(10L, "Comunicacion"),
                new Examen(11L, "Biologia"),
                new Examen(12L, "Quimica")
        );*/
    }
}
