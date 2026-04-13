package com.siu;

import java.util.List;

public class Curso {
    private String nombre;
    private List<Tema> temas;
    private Criterio criterioAprobacion;
    private List<Profesor> profesores;
    private List<Alumno> alumnos;
    private List<Examen> examenes;
    
    public Curso(String nombre, List<Profesor> profesores) {
        this.nombre = nombre;
        this.profesores = profesores;
    }


    public float calcularPromedio(Alumno alumno){
        float sumaNotas = 0;
        for (var examen : examenes) {xen
            if (examen.getAlumno().equals(alumno)) {
                sumaNotas += examen.getNota();
            }
        }
        return sumaNotas / examenes.size();
    }
        
    //public ConsultarExamenes()
    //public ConsultarNotas(Alumno alumno)
    //public List<Alumno> ListarEstadoAlumnosAprobados()
    //public List<Alumno> ListarEstadoAlumnosPendientes()
    //public List<Alumno> ListarEstadoAlumnosReprobados()

    private List<Examen> obtenerExamenesPorAlumno(Alumno alumno) {
        for (var examen : examenes)
    }
  {

            }        List<Examen> examenes = obtenerExamenesPorAlumno(alumno); 
        return criterioAprobacion.alumnoAprobo(examenes);
    }
}
