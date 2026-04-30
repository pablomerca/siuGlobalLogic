package com.siu;

import java.util.List;

public class Examen {

    private List<Tema> temas;
    private Curso curso;
    private Persona alumno;
    private float nota;

    public Examen(List<Tema> temas, Curso curso, Persona alumno, float nota) {
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

    public Persona getAlumno() {
        return alumno;
    }

    public float getNota() {
        return nota;
    }

    public boolean esDelAlumno(Persona alumnoComparado) {
        return this.alumno.equals(alumnoComparado);
    }

    public void cargarNota(float nota, Persona alumno){
        if (esDelAlumno(alumno)) {
            this.nota = nota;
        } else {
            System.out.println("El alumno no corresponde al examen.");
        }
    }
}
