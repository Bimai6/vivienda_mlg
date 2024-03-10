package testvivienda;

//2

public class PisoImpl extends ViviendaImpl implements Vivienda, Piso, Comparable<Vivienda>{
    private int planta;
    private char puerta;

    @Override
    public int getPlanta() {
        return this.planta;
    }

    @Override
    public char getPuerta() {
        return this.puerta;
    }

    @Override
    public void setPlanta(int planta) {
        this.planta = planta;
    }

    @Override
    public void setPuerta(char puerta) {
        this.puerta = puerta;
    }
    
    //4
    public boolean equals(Object o){
         boolean b = false;
         if(o instanceof Piso){
             Piso p = (Piso) o;
             b = super.equals(p) && this.planta == p.getPlanta() && this.puerta == p.getPuerta();
         }
         return b;
     }
    
    public int compareTo(Piso p){
        int n;
        n= super.compareTo(p);
        if(n==0){
            n= Integer.compare(this.planta, p.getPlanta());
            if(n==0){
                n= Character.compare(this.puerta, p.getPuerta());
            }
        }
        return n;
    }
    
    //6

    public PisoImpl(int planta, char puerta, double superficie, double precio, Operacion operacion, String direccion) {
        super(superficie, precio, operacion, direccion);
        this.planta = planta;
        this.puerta = puerta;
    }

    public PisoImpl() {
        super();
        this.planta = 0;
        this.puerta = ' ';
    }
    
    
}
