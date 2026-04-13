package com.siu;

import java.util.List;

public class Administrador extends Rol {
    public Administrador(String nombre) {
        super(nombre);
    }

    public Curso agregarCurso(String nombre, List<Profesor> profesores){
        return new Curso(nombre, profesores);
    }

    public void modificarNombreCurso(String nombre, Curso curso) {
        if (curso == null) {
            return;
        }
        curso.modificarNombre(nombre);
    }

    public void modificarProfesoresCurso(List<Profesor> profesores, Curso curso) {
        if (curso == null) {
            return;
        }
        curso.modificarProfesores(profesores)
    }

    public void eliminarCurso(Curso curso){
        // por el momento solo lo desactiva
        curso.desactivarCurso();
    }

    public Persona agregarPersona() {
        
    }

    public void asignarRol(Persona persona, Rol rol){
        persona.agregarRol(rol);
    }

    public void darDeBaja(Persona persona){

    }   

    public void modificarDatos(Persona persona, String nuevoNombre, String nuevoEmail){

    }



}
