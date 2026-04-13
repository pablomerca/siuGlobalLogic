package com.siu;

import java.util.List;

public class Profesor extends Rol{
    private List<Curso> cursosDictados; 

    public Profesor(String nombre) {
        super(nombre);
    }

    public List<Curso> ListarCursosDictados() {
        return cursosDictados;
    }

    public void AgregarTema (Tema tema, Curso curso){
        // TODO: Implementar lógica para agregar un tema a un curso específico
    }

    public void AgregarExamen (Examen examen, Curso curso){
        // TODO: Implementar lógica para agregar un examen a un curso específico
    }
      
}
