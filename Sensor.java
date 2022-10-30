public class Sensor {
    private static Sensor[] sensores = new Sensor[8];
    private static int tamano = 8;
    private static int posAnadir = 0;
    private String tipo;
    private double valor;
    public static Sensor[] getSensores() {
        return sensores;
    }
    public static void setSensores(Sensor[] sensores) {
        Sensor.sensores = sensores;
    }
    public static int getTamano() {
        return tamano;
    }
    public static void setTamano(int tamano) {
        Sensor.tamano = tamano;
    }
    // Metodo equivalente a cantidad sensores
    public static int getPosAnadir() {
        return posAnadir;
    }
    public static void setPosAnadir(int posAnadir) {
        Sensor.posAnadir = posAnadir;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Sensor() {
    }
    public Sensor(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Tipo=" + tipo + ", valor=" + valor;
    }
    public static String toStringSensores(){
        String datosSensores = "";
        if(Sensor.getPosAnadir() == 0){
            return "Base de datos vacia";
        }
        for (int i = 0; i < Sensor.getPosAnadir(); i++) {
            datosSensores += (i+1) + ". " + Sensor.getSensores()[i].toString() + "\n";
        }
        return datosSensores;
    }
    public static void agregarSensor(Sensor nuevo){
        Sensor.getSensores()[Sensor.getPosAnadir()] = nuevo;
        Sensor.setPosAnadir(Sensor.getPosAnadir() + 1);
    }
    public static String toStringSensoresTemperatura(){
        String datosSensores = "";
        if(Sensor.getPosAnadir() == 0){
            return "Base de datos vacia";
        }
        for (int i = 0; i < Sensor.getPosAnadir(); i++) {
            if(Sensor.getSensores()[i].getTipo().equals("Temperatura")){
                datosSensores += (i+1) + ". " + Sensor.getSensores()[i].toString() + "\n";
            }
        }
        if(datosSensores.equals("")){
            return "No hay sensores de tipo temperatura en la BD";
        } else{
            return datosSensores;
        }
    }
    public static Sensor[] getSensoresTemperatura(){
        int cantidad = 0; 
        for (int i = 0; i < Sensor.getPosAnadir(); i++) {
            if(Sensor.getSensores()[i].getTipo().equals("Temperatura")){
                cantidad++;
            }
        }
        Sensor[] nuevo = new Sensor[cantidad];
        int k = 0;
        for (int i = 0; i < Sensor.getPosAnadir(); i++) {
            if(Sensor.getSensores()[i].getTipo().equals("Temperatura")){
                nuevo[k] = Sensor.getSensores()[i];
                k++;
            }
        }
        for (int i = 0; i < nuevo.length; i++) {
            for (int j = 0; j < nuevo.length-1; j++) {
                if(nuevo[j].getValor() > nuevo[j+1].getValor()){
                    Sensor almacen = nuevo[j];
                    nuevo[j] = nuevo[j+1];
                    nuevo[j+1] = almacen;
                }
            }
        }
        return nuevo;
    }
    public static String toStringSensoresTemperaturaOrdenado(){
        String datosSensores = "";
        Sensor[] temperatura = getSensoresTemperatura();
        if(temperatura.length == 0){
            return "No hay sensores de tipo temperatura";
        }
        for (int i = 0; i < temperatura.length; i++) {
            datosSensores += (i+1) + ". " + temperatura[i].toString() + "\n";
        }
        return datosSensores;
    }
}
