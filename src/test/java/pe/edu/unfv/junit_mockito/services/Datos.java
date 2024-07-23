package pe.edu.unfv.junit_mockito.services;

import pe.edu.unfv.junit_mockito.models.Examen;

import java.util.List;

public class Datos {

    public final static List<Examen>  EXAMENES = List.of(
                                            new Examen(5L, "Matematicas"),
                                            new Examen(6L, "Lenguaje"),
                                            new Examen(7L, "Ciencias"),
                                            new Examen(8L, "Historia"),
                                            new Examen(9L, "Ingles"),
                                            new Examen(10L, "Comunicacion"),
                                            new Examen(11L, "Biologia"),
                                            new Examen(12L, "Quimica")
                                    );

    public final static List<String>  PREGUNTAS = List.of(
                                                        "aritmetica",
                                                        "algebra",
                                                        "trigonometria",
                                                        "estadistica",
                                                        "integrales",
                                                        "derivadas",
                                                        "geometria",
                                                        "adicion"
                                                    );
}
