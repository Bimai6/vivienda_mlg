package testvivienda;

import Comparators.ComparadorPorSuperficie;
import Excepciones.CatalogoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoImpl implements Catalogo {

    List<Piso> lista;

    @Override
    public List<Piso> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "CatalogoImpl{" + "lista=" + lista + '}';
    }

    @Override
    public void setLista(List<Piso> lista) {
        this.lista = lista;
    }

    //7
    /**
     * Introduce un String que será comparado como una operación con las
     * operaciones de los pisos del catálogo cada vez que sean iguales
     * incrementará el contador
     *
     * @param s
     * @return devuelve un contador incrementado por cada vez que coinciden la
     * operación del parametro y la del elemento de la lista,
     */
    @Override
    public int getNumPisosByOperation(String s) {
        try {
            checkOperationAsIndicated(s);
        } catch (CatalogoException e) {
            System.out.println(e);
        }
        int count = 0;
        for (Piso p : this.lista) {
            if (p.esOperacion(Operacion.valueOf(s.toUpperCase()))) {
                count++;
            }
        }
        return count;
    }

    //Utilidad ejercicio 7
    /**
     * Comprueba si la operación pasada por parámetro como String es una de
     * Venta o Alquiler, en caso negativo, lanza una excepción.
     *
     * @param s
     * @throws CatalogoException
     */
    private static void checkOperationAsIndicated(String s) throws CatalogoException {
        if (!(Operacion.ALQUILER == Operacion.valueOf(s.toUpperCase()) || Operacion.VENTA == Operacion.valueOf(s.toUpperCase()))) {
            throw new CatalogoException("La operación no es válida");
        }
    }

    //8
    /**
     * Añade un piso al catálogo si no está presente en él.
     *
     * @param p El piso a añadir al catálogo.
     */
    @Override
    public void addPiso(Piso p) {
        if (!this.lista.contains(p)) {
            this.lista.add(p);
            System.out.println("El piso : " + p + ", fue añadido");
        }
        System.out.println("El piso :" + p + ", no fue añadido porque ya estaba en el catálogo");
    }

    //9
    /**
     * Elimina un piso del catálogo.
     *
     * @param p El piso a eliminar del catálogo.
     * @throws CatalogoException Si el piso no está presente en el catálogo.
     */
    @Override
    public void removePiso(Piso p) throws CatalogoException {
        if (this.lista.contains(p)) {
            this.lista.remove(p);
            System.out.println("El piso : " + p + ", fue eleminado");
        } else {
            throw new CatalogoException("El piso indicado no estaba en el catálogo");
        }
    }

    //10
    /**
     * Calcula el precio total de los pisos en una planta dada.
     *
     * @param planta El número de planta.
     * @return El precio total de los pisos en la planta dada.
     */
    @Override
    public double getPrecioTotalPlanta(int planta) {
        int sum = 0;
        for (Piso p : this.lista) {
            if (p.getPlanta() == planta) {
                sum += p.getPrecio();
            }
        }
        return sum;
    }

    //11
    /**
     * Obtiene la dirección del piso con el precio por metro cuadrado más bajo.
     *
     * @return La dirección del piso con el precio por metro cuadrado más bajo.
     */
    @Override
    public String getLowestPricedBySurfacePiso() {
        double precioMin = Double.MAX_VALUE;
        String s = "";
        for (Piso p : this.lista) {
            if (p.getPrecioPorM2() < precioMin) {
                precioMin = p.getPrecioPorM2();
                s = p.getDireccion();
            }
        }
        return s;
    }

    //12
    /**
     * Obtiene una lista de pisos con superficie mayor que una dada y precio
     * menor que otro dado.
     *
     * @param precio El precio máximo.
     * @param superficie La superficie mínima.
     * @return Una lista de pisos que cumplen las condiciones.
     */
    @Override
    public List<Piso> getPisosSuperficieMayorYPrecioMenorQue(double precio, double superficie) {
        List<Piso> pisos = new ArrayList<>();
        for (Piso p : this.lista) {
            if (p.getPrecio() < precio && p.getSuperficie() > superficie) {
                pisos.add(p);
            }
        }
        return pisos;
    }

    //13
    /**
     * Ordena los pisos del catálogo según la superficie.
     */
    @Override
    public void getCatalogUsingSurfaceComparator() {
        //Hacemos el Comparador en una clase externa
        Collections.sort(this.lista, new ComparadorPorSuperficie());

        for (Piso p : this.lista) {
            System.out.println(p);
        }
    }

    //14
    /**
     * Verifica si hay un piso con un precio menor que el dado.
     *
     * @param precio El precio máximo.
     * @return true si hay al menos un piso con un precio menor que el dado,
     * false de lo contrario.
     */
    @Override
    public boolean hayPisoConMenorPrecio(double precio) {
        for (Piso p : this.lista) {
            if (p.getPrecio() < precio) {
                return true;
            }
        }
        return false;
    }

    //15
    /**
     * Verifica si todos los pisos están por debajo de una cierta planta.
     *
     * @param planta La planta máxima permitida.
     * @return true si todos los pisos están por debajo de la planta dada, false
     * de lo contrario.
     */
    @Override
    public boolean sonTodosLosPisosPorDebajoDe(int planta) {
        for (Piso p : this.lista) {
            if (p.getPlanta() >= planta) {
                return false;
            }
        }
        return true;
    }

    //16
    /**
     * Aplica un descuento al precio de los pisos con superficie mayor que una
     * dada.
     *
     * @param superficie La superficie mínima para aplicar el descuento.
     * @param porcentaje El porcentaje de descuento a aplicar.
     */
    @Override
    public void rebajaPrecioCuandoSuperficieMayorQue(double superficie, double porcentaje) {
        int count = 0;
        boolean b = false;
        for (Piso p : this.lista) {
            if (p.getSuperficie() > superficie) {
                p.setPrecio(p.getPrecio() - p.getPrecio() * porcentaje);
                b = true;
                count++;
            }
        }

        if (b) {
            System.out.println("Se ha modificado el precio de " + count + " pisos");
        } else {
            System.out.println("No se ha modificado el precio de ningún piso");
        }

    }

    //17 no entiendo a que dos archivos te refieres
}
