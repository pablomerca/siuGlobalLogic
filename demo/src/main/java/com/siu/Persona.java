package com.siu;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Persona {
    private String nombre;
    private String email;
    private boolean activa;
    private final EnumSet<Rol> roles;

    public Persona(String nombre) {
        this(nombre, null);
    }

    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.roles = EnumSet.noneOf(Rol.class);
        this.activa = true;
    }

    public void agregarRol(Rol rol) {
        Objects.requireNonNull(rol, "El rol no puede ser nulo.");
        roles.add(rol);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Set<Rol> getRoles() {
        return Collections.unmodifiableSet(EnumSet.copyOf(roles));
    }

    public boolean tieneRol(Rol rol) {
        return roles.contains(rol);
    }

    private void modificarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    private void modificarEmail(String nuevoEmail) {
        this.email = nuevoEmail;
    }

    private void desactivar() {
        this.activa = false;
    }

    public void asignarRol(Persona persona, Rol rol) {
        exigirRol(Rol.ADMINISTRADOR);
        if (persona != null) {
            persona.agregarRol(rol);
        }
    }

    public void darDeBaja(Persona persona) {
        exigirRol(Rol.ADMINISTRADOR);
        if (persona != null) {
            persona.desactivar();
        }
    }

    public void modificarDatos(Persona persona, String nuevoNombre, String nuevoEmail) {
        exigirRol(Rol.ADMINISTRADOR);
        if (persona != null) {
            persona.modificarNombre(nuevoNombre);
            persona.modificarEmail(nuevoEmail);
        }
    }

    public void realizarInscripcion(Curso curso) {
        exigirRol(Rol.ALUMNO);
        curso.inscribirAlumno(this);
    }

    public void agregarTema(Tema tema, Curso curso) {
        exigirRol(Rol.PROFESOR);
        curso.agregarTema(tema);
    }

    public void agregarExamen(Examen examen, Curso curso) {
        exigirRol(Rol.PROFESOR);
        curso.agregarExamen(examen);
    }

    public void cargarNota(float nota, Persona alumno, Examen examen) {
        exigirRol(Rol.PROFESOR);
        examen.cargarNota(nota, alumno);
    }

    public Curso agregarCurso(String nombre, List<Persona> profesores) {
        exigirRol(Rol.ADMINISTRADOR);
        return new Curso(nombre, profesores);
    }

    public void modificarNombreCurso(String nombre, Curso curso) {
        exigirRol(Rol.ADMINISTRADOR);
        if (curso != null) {
            curso.modificarNombre(nombre);
        }
    }

    public void modificarProfesoresCurso(List<Persona> profesores, Curso curso) {
        exigirRol(Rol.ADMINISTRADOR);
        if (curso != null) {
            curso.modificarProfesores(profesores);
        }
    }

    public void eliminarCurso(Curso curso) {
        exigirRol(Rol.ADMINISTRADOR);
        if (curso != null) {
            curso.desactivarCurso();
        }
    }

    public Persona agregarPersona(String nombre, String email) {
        exigirRol(Rol.ADMINISTRADOR);
        return new Persona(nombre, email);
    }

    private void asegurarActivo() {
        if (!activa) {
            throw new IllegalStateException("La persona está dada de baja.");
        }
    }

    private void exigirRol(Rol rol) {
        asegurarActivo();
        if (!tieneRol(rol)) {
            throw new IllegalStateException("La persona no tiene el rol requerido: " + rol);
        }
    }
}

