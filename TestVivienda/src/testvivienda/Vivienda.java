package testvivienda;

interface Vivienda extends Comparable<Vivienda>{
     double getSuperficie();
     void setSuperficie(double superficie);
     double getPrecio();
     void setPrecio(double precio);
     Operacion getOperacion();
     void setOperacion(Operacion operacion);
     String getDireccion();
     void setDireccion(String direccion);
     double getRebaja();
     boolean esOperacion (Operacion operacion);
     double comisionInmobiliaria();
     String getDireccionDeLaMasCostosaSiSonMismaOperacion(Vivienda vivienda);
     String viviendaSegunTamanyo();
     String getLocalidad();
     void modifySuperficie(double[] array);
     double getPrecioPorM2();
}
