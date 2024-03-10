package testvivienda;

import Excepciones.ViviendaException;

/**
 * @author Mario Lebrero García
 */

public class ViviendaImpl implements Vivienda, Comparable<Vivienda>{
    
    protected double superficie;
    protected double precio;
    protected Operacion operacion;
    protected String direccion;
    protected final double DESCUENTO= 0.1;
    protected final double comisionAlquiler= 0.08;
    protected final double comisionVenta= 0.14;
    protected final double comisionAlquilerOpcionVenta=0.11;
    
    //2. Constructores
        //2.1
     public ViviendaImpl(double superficie, double precio, Operacion operacion, String direccion){
        
        try{
            checkPrecio(precio);
            this.precio=precio;
        }catch(ViviendaException e){
            System.out.println(e);
        }
        this.superficie=superficie;
        this.operacion=operacion;
        this.direccion=direccion;
    }
        //2.2
     public ViviendaImpl(String direccion){
         this.superficie=90.0;
         this.precio=150000;
         this.operacion=Operacion.VENTA;
         this.direccion=direccion;
     }
        //2.3
     public ViviendaImpl(){
        this.superficie=0;
        this.precio=0;
        this.operacion= Operacion.VENTA;
        this.direccion= "";
        
    }
     //1 Métodos observadores y modificadores
     public double getSuperficie(){
         return this.superficie;
     }
     
     public void setSuperficie(double superficie){
         this.superficie=superficie;
     }
     
     public double getPrecio(){
         return this.precio;
     }
     
     public void setPrecio(double precio){
         this.precio=precio;
     }
     
     public Operacion getOperacion(){
         return this.operacion;
     }
     
     public void setOperacion(Operacion operacion){
         this.operacion=operacion;
     }
     
     public String getDireccion(){
         return this.direccion;
     }
     
     public void setDireccion(String direccion){
         this.direccion=direccion;
     }
     
     //Métodos custom
    //3
     /**
      * Devuelve el precio aplicando un descuento
      * @return devuelve el precio menos el precio multiplicado por el descuento
      */
     public double getRebaja(){
        return this.precio - (this.precio*this.DESCUENTO);
        }
     
    //4
     public String toString(){
         return "Direccion: " + this.direccion + " - precio=" + this.precio + " - superficie=" + this.superficie + " -operación=" +  this.operacion;
     }
     
     //5
     /**
      * Compara si la operación del objeto es igual a la operación pasada por parámetro
      * @param operacion
      * @return devuelve true si la operación del objeto si es igual a la operación pasada por parámetro
      */
     public boolean esOperacion (Operacion operacion){
         return this.operacion.equals(operacion);
     }
     
     //6
     /**
      * Realiza un switch en el que dependiendo del tipo de operación devolverá un una comisión particular para el caso.
      * @return devuelve la comision que es una variable inicializada que cambiara su valor según el caso que tome operacion dentro del switch.
      */
     public double comisionInmobiliaria(){
         double comision= 0;
         
         switch(this.operacion){
             case ALQUILER:
                 comision = this.precio*comisionAlquiler;
                 break;
             case VENTA:
                 comision = this.precio*comisionVenta;
                 break;
             case ALQUILER_CON_OPCION_A_VENTA:
                 comision = this.precio*comisionAlquilerOpcionVenta;
                 break;
         }
         return comision;
     }
     
     //7
     /**
      * Devuelve la dirección del objeto vivienda si su precio es mayor que el precio de la vivienda pasada por parámetro, si la operación de ambas viviendas es la misma,
      * en caso de no tener la misma operación, devuelve una cadena que diga explicitamente que las viviendas no tienen la misma operación,
      * en caso de tener la misma operación, pero que el precio de la vivienda pasada por parámetro sea mayor, se devolverá la dirección de esta.
      * @param vivienda
      * @return devuelve la dirección del objeto vivienda si se cumplen las dos condiciones, 
      * devuelve la dirección de la vivienda pasada por parámetro si no se cumple la segunda, 
      * devuelve una cadena si no se cumple la primera
      */
     public String getDireccionDeLaMasCostosaSiSonMismaOperacion(Vivienda vivienda){
         if(this.operacion.equals(vivienda.getOperacion())){
             if(this.precio > vivienda.getPrecio()){
                 return this.direccion;
             }
             return vivienda.getDireccion();
         }
         return "Las viviendas no tienen la misma operación";
     }
     
     //8
     /** 
      * Devuelve una cadena que especificará el tamaño de la vivienda según el valor que tenga su superficie.
      * @return devuelve la cadena "Vivienda pequeña" si la superficie es menor a 70, 
      * devuelve la cadena "Vivienda mediana" en caso de ser mayor o igual a 70 y menor o igual a 95,
      * devuelve  la cadena "Vivienda grande" en cualquier otro caso.
      */
     public String viviendaSegunTamanyo(){
         if(this.superficie <70){
             return "Vivienda pequeña";
         }else if(this.superficie >= 70 && this.superficie <=95){
             return "Vivienda mediana";
         }
         return "Vivienda grande";
     }
     
     //9
     /**
      * Obtiene la localidad de la vivienda convirtiendo su dirección en un array separdo por ",", devolviendo el valor de la posición uno del array
      * @return devuelve el valor de la posición uno del array de tipo String
      */
     public String getLocalidad(){
         String array[] = this.direccion.split(",");
         return array[1];
     }
     
     //10
     /**
      * Modifica la superficie del objeto vivienda permutando su valor con el de un sumatorio de todos los elementos de un array pasado por parámetro.
      * @param array Array de superficies de cada estancia de la vivienda
      */
     public void modifySuperficie(double[] array){
         double suma= 0;
         for (int i =0; i<array.length; i++){
             suma+= array[i];
            this.superficie = suma;
         }
     }
     
     //Util para las actividades 11.8 y 11.13
     /**
      *  Devuelve el precio por metro cuadrado
      * @return devuele el precio dividido entre la superficie
      */
     public double getPrecioPorM2(){
       return this.precio/this.superficie;
     }
     
     //3
     public boolean equals(Object o){
         boolean b = false;
         if(o instanceof Vivienda){
             Vivienda v = (Vivienda) o;
             b = this.direccion.equals(v.getDireccion());
         }
         return b;
     }
     
     public int compareTo(Vivienda v){
         int n;
         n= this.direccion.compareTo(v.getDireccion());
         return n;
     }
     
     public static void checkPrecio(double precio) throws ViviendaException{
         if(precio <0){
             throw new ViviendaException("El precio no puede ser menor que 0");
         }
     }
}

