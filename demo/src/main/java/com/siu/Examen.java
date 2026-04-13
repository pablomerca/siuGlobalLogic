package com.siu;

import java.util.List;

public class Examen {

    private List<Tema> temas;
    private Curso curso;
    private Alumno alumno;
    private float nota;

    public Examen(List<Tema> temas, Curso curso, Alumno alumno, float nota) {
        this.temas = temas;
        this.curso = curso;
        this.alumno = alumno;
        this.nota = nota;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public Curso getCurso() {
        return curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public float getNota() {
        return nota;
    }

    public boolean esDelAlumno(Alumno alumno) {
        
    }
    
}
