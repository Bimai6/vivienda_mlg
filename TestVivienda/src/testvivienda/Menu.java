/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testvivienda;

import Excepciones.CatalogoException;
import Excepciones.MenuException;
import java.util.Scanner;

/**
 *
 * @author Mario Lebrero García
 */
public class Menu {

    //18 Prefiero tenerlo en una clase para hacerle javadoc
    /**
     * Muestra un menú interactivo para realizar operaciones en el catálogo de
     * pisos.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @param c El catálogo de pisos sobre el que se realizarán las operaciones.
     */
    public static void menu(Scanner sc, Catalogo c) {
        int option;
        do {
            System.out.println("1. Añadir nuevo piso");
            System.out.println("2. Eliminar un piso");
            System.out.println("3. Mostra piso con el menor precio por superficie");
            System.out.println("4. Rebajar pisos");
            System.out.println("5. Filtrar por precio  por superficie");
            System.out.println("6. Visualizar catálogo");
            System.out.println("7. Salir del menú");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    optionOne(sc, c);
                    break;
                case 2:
                    optionTwo(sc, c);
                    break;
                case 3:
                    optionThree(c);
                    break;
                case 4:
                    optionFour(sc, c);
                    break;
                case 5:
                    optionFive(sc, c);
                    break;
                case 6:
                    System.out.println(c);
                    break;
                case 7:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("La opción seleccionada tiene que estar entre 1 y 7");
                    break;
            }
        } while (option != 7);
    }

    //18.1
    /**
     * Agrega un nuevo piso al catálogo.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @param c El catálogo de pisos donde se agregará el piso.
     */
    private static void optionOne(Scanner sc, Catalogo c) {
        System.out.println("Introduzca la planta: ");
        int planta = Integer.parseInt(sc.nextLine());
        System.out.println("Introduzca la puerta: ");
        String puertaString = "";

        try {
            String comprueba = sc.nextLine();
            checkStringLength(puertaString);
            puertaString = comprueba;

        } catch (MenuException e) {
            System.out.println(e);
        }
        char puerta = puertaString.charAt(0);

        System.out.println("Introduzca la superficie: ");
        double superficie = Double.parseDouble(sc.nextLine());

        System.out.println("Introduzca la precio: ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.println("Introduzca el número de la Operación que tendrá: ");
        System.out.println("1. Venta");
        System.out.println("2. Alquiler");
        System.out.println("3. Alquiler con opción a venta");
        int option = Integer.parseInt(sc.nextLine());
        Operacion operacion = null;
        switch (option) {
            case 1:
                operacion = Operacion.VENTA;
                break;
            case 2:
                operacion = Operacion.ALQUILER;
                break;
            case 3:
                operacion = Operacion.ALQUILER_CON_OPCION_A_VENTA;
                break;
            default:
                System.out.println("La operación debe ser válida");
                break;
        }

        System.out.println("Introduzca la dirección: ");
        String direccion = sc.nextLine();

        Piso p = new PisoImpl(planta, puerta, superficie, precio, operacion, direccion);
        c.addPiso(p);

        //Creo el toString en catálago
        System.out.println(c);
    }

    //18.2
    /**
     * Elimina un piso del catálogo.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @param c El catálogo de pisos donde se eliminará el piso.
     */
    private static void optionTwo(Scanner sc, Catalogo c) {
        System.out.println("Escriba el numero de planta");
        int planta = Integer.parseInt(sc.nextLine());

        System.out.println("Escriba la letra de puerta");
        String puerta = "";
        try {
            String prueba = sc.nextLine();
            checkStringLength(prueba);
            puerta = prueba;

        } catch (MenuException e) {
            System.out.println(e);
        }

        System.out.println("Escriba la dirección");
        String direccion = sc.nextLine();

        Piso p = new PisoImpl(planta, puerta.charAt(0), 0, 0, null, direccion);
        try {
            c.removePiso(p);
        } catch (CatalogoException e) {
            System.out.println(e);
        }

    }

    //18.3
    /**
     * Muestra la dirección del piso con el menor precio por superficie.
     *
     * @param c El catálogo de pisos donde se buscará el piso.
     */
    private static void optionThree(Catalogo c) {
        System.out.println(c.getLowestPricedBySurfacePiso());
    }

    //18.4
    /**
     * Aplica un descuento al precio de los pisos con superficie mayor que la
     * dada.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @param c El catálogo de pisos donde se aplicará el descuento.
     */
    private static void optionFour(Scanner sc, Catalogo c) {
        System.out.println("Introduce la superficie");
        double superficie = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el porcentaje de rebaja (Valores del 1 al 100).");
        int porcentaje = Integer.parseInt(sc.nextLine()) / 100;
        c.rebajaPrecioCuandoSuperficieMayorQue(superficie, porcentaje);
        System.out.println(c);
    }

    //18.5
    /**
     * Filtra los pisos por precio y superficie y muestra los resultados.
     *
     * @param sc Scanner para leer la entrada del usuario.
     * @param c El catálogo de pisos que se filtrará.
     */
    private static void optionFive(Scanner sc, Catalogo c) {
        System.out.println("Introduzca el precio para comparación: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("Introduzca la superficie para comparación: ");
        double superficie = Double.parseDouble(sc.nextLine());
        System.out.println(c.getPisosSuperficieMayorYPrecioMenorQue(precio, superficie));
    }

    /**
     * Verifica la longitud de una cadena y lanza una excepción si es inválida.
     *
     * @param s La cadena cuya longitud se verificará.
     * @throws MenuException Si la longitud de la cadena es inválida.
     */
    private static void checkStringLength(String s) throws MenuException {
        if (!s.matches("[a-zA-Z]{1}")) {
            throw new MenuException("La longitud de este carácter");
        }
    }
}
