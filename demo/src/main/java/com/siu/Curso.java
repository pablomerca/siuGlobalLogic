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
    private Set<Profesor> profesores;
    private Set<Alumno> alumnos;
    private List<Examen> examenes;
    private List<Alumno> alumnosReprobados;
    private List<Alumno> alumnosAprobados;
    private List<Alumno> alumnosPendientes;
    
    public Curso(String nombre, List<Profesor> profesores) {
        this.nombre = nombre;
        this.profesores = new HashSet<>(profesores);
        this.disponible = false;
    }

    public float calcularPromedio(Alumno alumno){
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

    //public ConsultarExamenes()
    
    public void consultarNotas(Alumno alumno){
        List<Examen> examenes_alumno = obtenerExamenesPorAlumno(alumno);
        for (var examen : examenes_alumno) {
            System.out.println(" - Nota: " + examen.getNota());
        }
    }
    
    public List<Alumno> listarEstadoAlumnosAprobados(){
        for (var alumno : alumnos) {
            if (alumnoAprobo(alumno)) {
                alumnosAprobados.add(alumno);
            }
        }
        return alumnosAprobados;
    }
    
    public List<Alumno> listarEstadoAlumnosPendientes(){
        for (var alumno : alumnos) {
            if (!alumnoAprobo(alumno) && !alumnosReprobados.contains(alumno)) {
                alumnosPendientes.add(alumno);
            }
        }
        return alumnosPendientes;
    }

    public List<Alumno> listarEstadoAlumnosReprobados(){
        for (var alumno : alumnos) {
            if (!alumnoAprobo(alumno)) {
                alumnosReprobados.add(alumno);
            }
        }
        return alumnosReprobados;
    }

    private List<Examen> obtenerExamenesPorAlumno(Alumno alumno) {
        List<Examen> examenes_alumno = new ArrayList<>();
        for (var examen : this.examenes) {
            if (examen.esDelAlumno(alumno)) {
                examenes_alumno.add(examen);
            }
        }
        return examenes_alumno;
    }

    private boolean alumnoAprobo(Alumno alumno){
        List<Examen> examenes = obtenerExamenesPorAlumno(alumno); 
        return criterioAprobacion.alumnoAprobo(examenes);
    }

    public void agregarTema(Tema tema) {
        temas.add(tema);
    }

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    public void inscribirAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void modificarProfesores(List<Profesor> profesores) {
        this.profesores = new HashSet<>(profesores);
    }

    public void activarCurso() {
        this.disponible = true;
    }

    public void desactivarCurso() {
        this.disponible = false;
    }
}
