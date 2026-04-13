package com.siu;

import java.util.List;
import java.util.Scanner;

public class CriterioPromedio implements Criterio {
    private float promedioMinimo;
    public CriterioPromedio(float promedioMinimo) {
        this.promedioMinimo = promedioMinimo;
    }

    public static void main(String[] args) {
        // promedio minimo seteable por consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el promedio minimo para aprobar: ");
        float promedioMinimo = scanner.nextFloat();
        CriterioPromedio criterio = new CriterioPromedio(promedioMinimo);
    }

    public boolean cumplePromedio(Alumno alumno, Curso curso) {
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
