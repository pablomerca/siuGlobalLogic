package com.siu;

import java.util.List;

public class CriterioPromedio implements Criterio {
    private float promedioMinimo;
    public CriterioPromedio(float promedioMinimo) {
        this.promedioMinimo = promedioMinimo;
    }

    public boolean cumplePromedio(Persona alumno, Curso curso) {
        return curso.calcularPromedio(alumno) >= promedioMinimo;
    }

    @Override
    public boolean alumnoAprobo(List<Examen> examenes) {
        float promedio = 0;
        for (Examen examen : examenes) {
            promedio += examen.getNota();
        }
        promedio /= examenes.size();
        return promedio >= promedioMinimo;
    }
}
