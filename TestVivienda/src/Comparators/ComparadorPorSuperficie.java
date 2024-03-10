/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparators;

import java.util.Comparator;
import testvivienda.Piso;

/**
 *Comparador externo para ordenar los pisos por superficie
 * @author Mario Lebrero García
 */
public class ComparadorPorSuperficie implements Comparator<Piso>{
    public int compare(Piso p1, Piso p2){
        return Double.compare(p1.getSuperficie(), p2.getSuperficie());
    }
}
