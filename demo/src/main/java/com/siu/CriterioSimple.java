package com.siu;

import java.util.List;
import java.util.Scanner;

public class CriterioSimple implements Criterio {
    private float notaMinima;

    public CriterioSimple(Scanner scanner) {
        System.out.println("Ingrese la nota mínima para aprobar:");
        notaMinima = scanner.nextFloat();
    }

    @Override
    public boolean alumnoAprobo(List<Examen> examenes) {
        for (Examen examen : examenes) {
            if (examen.getNota() < notaMinima) {
                return false; // El alumno no aprobó si alguna nota es menor a la mínima
            }
        }
        return true; 
    }
    
}
