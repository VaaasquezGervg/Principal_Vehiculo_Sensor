import java.util.Scanner;

public class Principal{
    public static void mostrarMenu(){
        Scanner lector = new Scanner(System.in);
        int op = -1;
        while(op != 0){
            System.out.println("Que desea hacer?");
            System.out.println("0. Salir");
            System.out.println("1. Insertar vehiculo");
            System.out.println("2. Ver BD de vehiculos");
            System.out.println("3. Cantidad de vehiculos en BD");
            System.out.println("4. Ver BD de vehiculos verdes");
            System.out.println("5. Ver BD de vehiculos con modelo entre 2000 y 2021");
            System.out.println("6. Insertar sensor");
            System.out.println("7. Ver BD de sensores");
            System.out.println("8. Cantidad de sensores en BD");
            System.out.println("9. Ver BD sensores de tipo temperatura");
            System.out.println("666. Ver BD ordenada de sensores de tipo temperatura");
            op = lector.nextInt();
            if(op == 0){
                System.out.println("Hasta luego");
            } else if(op == 1){
                if(Vehiculo.getPosAnadir() == Vehiculo.getTamano()){
                    System.out.println("Error, base de datos llena");
                } else{
                    System.out.println("Modelo: ");
                    int modelo = lector.nextInt();
                    System.out.println("Marca: ");
                    String marca = lector.next();
                    System.out.println("Precio: ");
                    double valorComercial = lector.nextDouble();
                    System.out.println("Color: ");
                    String color = lector.next();
                    Vehiculo.agregarVehiculo(new Vehiculo(modelo, marca, valorComercial, color));
                    System.out.println("Se agrego correctamente");
                }
            }  else if(op == 2) {
                System.out.println(Vehiculo.toStringVehiculos());
            } else if(op == 3) {
                System.out.println(Vehiculo.getPosAnadir());
            } else if(op == 4) {
                System.out.println(Vehiculo.toStringVehiculosVerdes());
            } else if(op == 5) {
                System.out.println(Vehiculo.toStringVehiculosModelos00to21());
            } else if(op == 6) {
                if(Sensor.getPosAnadir() == Sensor.getTamano()){
                    System.out.println("Error, base de datos llena");
                } else {
                    System.out.println("Tipo:");
                    String tipo = lector.next();
                    System.out.println("Valor: ");
                    double valor = lector.nextDouble();
                    Sensor.agregarSensor(new Sensor(tipo, valor));
                    System.out.println("Se agrego correctamente");
                }
            } else if(op == 7) {
                System.out.println(Sensor.toStringSensores());
            } else if(op == 8) {
                System.out.println(Sensor.getPosAnadir());
            } else if(op == 9) {
                System.out.println(Sensor.toStringSensoresTemperatura());
            } else if(op == 666) {
                System.out.println(Sensor.toStringSensoresTemperaturaOrdenado());
            } else {
                System.out.println("Error, ingrese nuevamente la opcion");
            }
        }
    }
    public static void main(String[] args) {
        mostrarMenu();
    }
}