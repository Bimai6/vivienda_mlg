package testvivienda;

public interface Piso extends Vivienda, Comparable<Vivienda>{

    int getPlanta();

    char getPuerta();

    void setPlanta(int planta);

    void setPuerta(char puerta);
    
}
