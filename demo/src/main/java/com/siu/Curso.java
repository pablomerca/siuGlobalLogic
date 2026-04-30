package com.siu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Curso {
    private String nombre;
    private boolean disponible;
    private List<Tema> temas;
    private Criterio criterioAprobacion;
    private Set<Persona> profesores;
    private Set<Persona> alumnos;
    private List<Examen> examenes;
    
    public Curso(String nombre, List<Persona> profesores) {
        this.nombre = nombre;
        this.profesores = new HashSet<>();
        if (profesores != null) {
            modificarProfesores(profesores);
        }
        this.temas = new ArrayList<>();
        this.examenes = new ArrayList<>();
        this.alumnos = new HashSet<>();
        this.disponible = false;
    }

    public float calcularPromedio(Persona alumno){
        if (examenes.isEmpty()) {
            return 0;
        }
        float sumaNotas = 0;
        for (var examen : examenes) {
            if (examen.getAlumno().equals(alumno)) {
                sumaNotas += examen.getNota();
            }
        }
        return sumaNotas / examenes.size();
    }
        
    public int cantidadExamenes(){
        return examenes.size();
    }    

    public void consultarNotas(Persona alumno){
        List<Examen> examenes_alumno = obtenerExamenesPorAlumno(alumno);
        for (var examen : examenes_alumno) {
            System.out.println(" - Nota: " + examen.getNota());
        }
    }
    
    public List<Persona> listarEstadoAlumnosAprobados(){
        List<Persona> alumnosAprobados = new ArrayList<>();
        for (var alumno : alumnos) {
            if (alumnoAprobo(alumno)) {
                alumnosAprobados.add(alumno);
            }
        }
        return alumnosAprobados;
    }
    
    public List<Persona> listarEstadoAlumnosPendientes(){
        List<Persona> alumnosPendientes = new ArrayList<>();
        for (var alumno : alumnos) {
            if (!alumnoAprobo(alumno)) {
                alumnosPendientes.add(alumno);
            }
        }
        return alumnosPendientes;
    }

    public List<Persona> listarEstadoAlumnosReprobados(){
        List<Persona> alumnosReprobados = new ArrayList<>();
        for (var alumno : alumnos) {
            if (!alumnoAprobo(alumno)) {
                alumnosReprobados.add(alumno);
            }
        }
        return alumnosReprobados;
    }

    private List<Examen> obtenerExamenesPorAlumno(Persona alumno) {
        List<Examen> examenes_alumno = new ArrayList<>();
        for (var examen : this.examenes) {
            if (examen.esDelAlumno(alumno)) {
                examenes_alumno.add(examen);
            }
        }
        return examenes_alumno;
    }

    private boolean alumnoAprobo(Persona alumno){
        List<Examen> examenes = obtenerExamenesPorAlumno(alumno); 
        if (criterioAprobacion == null || examenes.isEmpty()) {
            return false;
        }
        return criterioAprobacion.alumnoAprobo(examenes);
    }

    public void agregarTema(Tema tema) {
        temas.add(tema);
    }

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    public void inscribirAlumno(Persona alumno) {
        if (alumno != null && !alumno.tieneRol(Rol.ALUMNO)) {
            throw new IllegalStateException("La persona no tiene el rol requerido: " + Rol.ALUMNO);
        }
        alumnos.add(alumno);
    }

    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void modificarProfesores(List<Persona> profesores) {
        Set<Persona> profesoresNuevos = new HashSet<>();
        if (profesores != null) {
            for (Persona profesor : profesores) {
                if (profesor == null || !profesor.tieneRol(Rol.PROFESOR)) {
                    throw new IllegalStateException("La persona no tiene el rol requerido: " + Rol.PROFESOR);
                }
                profesoresNuevos.add(profesor);
            }
        }
        this.profesores = profesoresNuevos;
    }

    public void activarCurso() {
        this.disponible = true;
    }

    public void desactivarCurso() {
        this.disponible = false;
    }
}
