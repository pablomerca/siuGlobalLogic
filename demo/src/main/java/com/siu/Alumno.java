package com.siu;

public class Alumno extends Rol{
    public Alumno(String nombre) {
        super(nombre);
    }

    public void realizarInscripcion (Curso curso) {
        // TODO: Implementar lógica de inscripción
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return this.nombre.equals(alumno.nombre);
    }
}
