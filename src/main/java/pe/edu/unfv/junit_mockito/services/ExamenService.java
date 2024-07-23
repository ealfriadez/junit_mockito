package pe.edu.unfv.junit_mockito.services;

import pe.edu.unfv.junit_mockito.models.Examen;

import java.util.Optional;

public interface ExamenService {

    Optional<Examen> findExamenPorNombre(String nombre);

    Examen findExamenPorNombreConPreguntas(String nombre);
}
