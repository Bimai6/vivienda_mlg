/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package testvivienda;

import Excepciones.CatalogoException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface Catalogo {

    //8
    void addPiso(Piso p);

    //13
    void getCatalogUsingSurfaceComparator();

    List<Piso> getLista();

    //11
    String getLowestPricedBySurfacePiso();

    //7
    int getNumPisosByOperation(String s);

    //12
    List<Piso> getPisosSuperficieMayorYPrecioMenorQue(double precio, double superficie);

    //10
    double getPrecioTotalPlanta(int planta);

    //14
    boolean hayPisoConMenorPrecio(double precio);

    //16
    void rebajaPrecioCuandoSuperficieMayorQue(double superficie, double porcentaje);
    //17 no entiendo a que dos archivos te refieres

    //9
    void removePiso(Piso p) throws CatalogoException;

    void setLista(List<Piso> lista);

    //15
    boolean sonTodosLosPisosPorDebajoDe(int planta);
    
}
