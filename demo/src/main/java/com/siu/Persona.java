package com.siu;

import java.util.List;

public class Persona {
    private String nombre;
    private List<Rol> roles;    
    private List<Curso> cursos;

    public Persona(String nombre, List<Rol> roles, List<Curso> cursos) {
        this.nombre = nombre;
        this.roles = roles;
        this.cursos = cursos;
    }

    public void inscribirseCurso(Curso curso) {

    }

}

// PERSONA  
// Rol
// Alumno
// Profesor
// Administrador
// Examen
// Tema
// Curso
// Criterio
// CriterioSimple
// CriterioPromedio
// CriterioCombinado
    