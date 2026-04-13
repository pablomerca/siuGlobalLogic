package com.siu;

import java.util.List;
import java.util.Scanner;

public class CriterioCombinado implements Criterio {
    private float notaMinimaExamen;
    private float notaMinimaPromedio;

    public CriterioCombinado (Scanner scannerNotaExamen, Scanner scannerNotaPromedio) {
        System.out.println("Ingrese la nota mínima de cada examen para aprobar:");
        notaMinimaExamen = scannerNotaExamen.nextFloat();
        System.out.println("Ingrese la nota mínima de promedio para aprobar:");
        notaMinimaPromedio = scannerNotaPromedio.nextFloat();
    }

    @Override
    public boolean alumnoAprobo(List<Examen> examenes) {
        float sumaPromedio = 0;
        float promedio = 0;
        for (Examen examen : examenes) {
            sumaPromedio += examen.getNota();            
            if (examen.getNota() < notaMinimaExamen) {
                return false; 
            }
        }
        promedio = sumaPromedio / examenes.size(); 
        return promedio >= notaMinimaPromedio; 
    }
}
