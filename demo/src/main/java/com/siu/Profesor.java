package com.siu;

import java.util.List;

public class Profesor extends Rol {
    private List<Curso> cursosDictados; 

    public Profesor(String nombre) {
        super(nombre);
    }

    public List<Curso> listarCursosDictados() {
        return cursosDictados;
    }

    public void agregarTema (Tema tema, Curso curso){
        curso.agregarTema(tema);
    }

    public void agregarExamen (Examen examen, Curso curso){
        curso.agregarExamen(examen);
    }

    public void cargarNota(float nota, Alumno alumno, Examen examen){
        examen.cargarNota(nota, alumno);
    }
      
}
