public class Vehiculo {
    private static Vehiculo[] vehiculos = new Vehiculo[10];
    private static int tamano = 10;
    private static int posAnadir = 0;
    private int modelo;
    private String marca;
    private double valorComercial;
    private String color;
    public static Vehiculo[] getVehiculos() {
        return vehiculos;
    }
    public static void setVehiculos(Vehiculo[] vehiculos) {
        Vehiculo.vehiculos = vehiculos;
    }
    public static int getTamano() {
        return tamano;
    }
    public static void setTamano(int tamano) {
        Vehiculo.tamano = tamano;
    }
    // Tambien funciona para saber la cantidad de vehiculos
    public static int getPosAnadir() {
        return posAnadir;
    }
    public static void setPosAnadir(int posAnadir) {
        Vehiculo.posAnadir = posAnadir;
    }
    public int getModelo() {
        return modelo;
    }
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getValorComercial() {
        return valorComercial;
    }
    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Vehiculo() {
    }
    public Vehiculo(int modelo, String marca, double valorComercial) {
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valorComercial;
        this.color = "verde";
    }
    public Vehiculo(int modelo, String marca, double valorComercial, String color) {
        this.modelo = modelo;
        this.marca = marca;
        this.valorComercial = valorComercial;
        this.color = color;
    }
    @Override
    public String toString() {
        return "Modelo=" + modelo + ", marca=" + marca + ", valor comercial=" + valorComercial + ", color="
                + color;
    }
    public static String toStringVehiculos(){
        String datosVehiculos = "";
        if(Vehiculo.getPosAnadir() == 0){
            return "Base de datos vacia";
        }
        for (int i = 0; i < Vehiculo.getPosAnadir(); i++) {
            datosVehiculos += (i+1) + ". " + Vehiculo.getVehiculos()[i].toString() + "\n";
        }
        return datosVehiculos;
    }    
    public static void agregarVehiculo(Vehiculo nuevo){
        Vehiculo.getVehiculos()[Vehiculo.getPosAnadir()] = nuevo;
        Vehiculo.setPosAnadir(Vehiculo.getPosAnadir()+1);
    }
    public static String toStringVehiculosVerdes(){
        String datosVehiculos = "";
        if(Vehiculo.getPosAnadir() == 0){
            return "Base de datos vacia";
        }
        for (int i = 0; i < Vehiculo.getPosAnadir(); i++) {
            if(Vehiculo.getVehiculos()[i].getColor().equals("Verde")){
                datosVehiculos += (i+1) + ". " + Vehiculo.getVehiculos()[i].toString() + "\n";
            }
        }
        if(datosVehiculos.equals("")){
            return "La base de datos no tiene vehiculos de color verde";
        } else {
            return datosVehiculos;
        }
    }
    public static String toStringVehiculosModelos00to21(){
        String datosVehiculos = "";
        if(Vehiculo.getPosAnadir() == 0){
            return "Base de datos vacia";
        }
        for (int i = 0; i < Vehiculo.getPosAnadir(); i++) {
            if(Vehiculo.getVehiculos()[i].getModelo() >= 2000 && Vehiculo.getVehiculos()[i].getModelo() <= 2021){
                datosVehiculos += (i+1) + ". " + Vehiculo.getVehiculos()[i].toString() + "\n";
            }
        }
        if(datosVehiculos.equals("")){
            return "La base de datos no tiene vehiculos entre el rango de modelos especificado";
        } else {
            return datosVehiculos;
        }
    }
}
