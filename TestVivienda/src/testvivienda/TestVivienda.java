package testvivienda;

import Excepciones.ViviendaException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestVivienda {

    public static void main(String[] args) {
        //11 Objetos
            //11.1 
            //Cambiado para no propagar la excepción
            Vivienda v1 =  new ViviendaImpl(80, 850, Operacion.ALQUILER, "Calle Gongora nº 58  - 4ºB, Cordoba");
    
            //11.2
       Vivienda v2 = new ViviendaImpl();
            //11.3
       Vivienda v3 = new ViviendaImpl("");
            //11.4
       Scanner sc = new Scanner(System.in);
       
       double superficie = sc.nextDouble();
       double precio = sc.nextDouble();
       sc.nextLine();
       String direccion = sc.nextLine();
       v2.setSuperficie(superficie);
       v2.setPrecio(precio);
       v2.setDireccion(direccion);
       
       //11.5
       v3.setDireccion("Plaza de las flores nº 24, Úbeda");
       
       //11.6
        System.out.println("El precio de v1 con rebaja es: " +  v1.getRebaja());
        
        //11.7
        System.out.println("La comisión que se lleva la inmobiliaria por v2: " + v2.comisionInmobiliaria());
        
        //11.8
        System.out.println("El precio por metro cuadrado de v2 es: " + v2.getPrecio()/v2.getSuperficie());
        
        //11.9
        System.out.println("La localidad de v1 es: " + v1.getLocalidad());
        
        //11.10
        System.out.println("La dirección de la vivienda con mayor precio entre v2 y v3 es: " + v2.getDireccionDeLaMasCostosaSiSonMismaOperacion(v3));
        
        //11.11
        System.out.println("La dirección de la vivienda con mayor precio entre v1 y v3 es: " + v1.getDireccionDeLaMasCostosaSiSonMismaOperacion(v3));
        
        //11.12
        System.out.println("El tipo de vivienda de v3 es: " + v3.viviendaSegunTamanyo());
        
        //11.13
        if(v1.getPrecioPorM2() < v2.getPrecioPorM2() && v1.getPrecioPorM2()< v3.getPrecioPorM2()){
            System.out.println(v1.toString());
        }else if(v2.getPrecioPorM2() < v1.getPrecioPorM2() && v2.getPrecioPorM2()< v3.getPrecioPorM2()){
            System.out.println(v2.toString());
        }else if(v3.getPrecioPorM2() < v2.getPrecioPorM2() && v3.getPrecioPorM2()< v1.getPrecioPorM2()){
            System.out.println(v3.toString());
        }else{
            System.out.println("No hay una vivienda que tenga un precio menor que otras \"(dos de ellas, o las tres, tienen el mismo precio)\" ");
        }
        /*
        Catalogo c = new CatalogoImpl();
        Menu.menu(sc, c); */
    }
    
}
