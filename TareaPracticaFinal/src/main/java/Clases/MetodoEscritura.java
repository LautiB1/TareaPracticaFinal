
package Clases;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MetodoEscritura extends Thread implements Serializable {

    private List<Usuarios> UsersTxt;
    private List<Usuarios> UsersDat;
    private int opcion;
    private String rutaUTxt;
    private String rutaUDat;

    public List<Usuarios> getUsersTxt() {
        return UsersTxt;
    }

    public void setUsersTxt(List<Usuarios> UsersTxt) {
        this.UsersTxt = UsersTxt;
    }

    public List<Usuarios> getUsersDat() {
        return UsersDat;
    }

    public void setUsersDat(List<Usuarios> UsersDat) {
        this.UsersDat = UsersDat;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public String getRutaUTxt() {
        return rutaUTxt;
    }

    public void setRutaUTxt(String rutaUTxt) {
        this.rutaUTxt = rutaUTxt;
    }

    public String getRutaUDat() {
        return rutaUDat;
    }

    public void setRutaUDat(String rutaUDat) {
        this.rutaUDat = rutaUDat;
    }

   
  
    

    public void escribirUDat() {

        try {

            FileOutputStream fo = new FileOutputStream(this.rutaUDat);
            ObjectOutputStream oo = new ObjectOutputStream(fo);

            oo.writeObject(this.UsersDat);

            oo.close(); //Se cierra primero el ultimo en abrirse
            fo.close();
        } catch (IOException e) {

            System.out.println("Se creo el archivo");

        }

    }

    public void escribirUTxt() {

        List<String> escritura = this.UsersTxt.stream().map(x -> x.toString() + "\n").collect(Collectors.toList());

        try {

            FileWriter fw = new FileWriter(this.rutaUTxt, true); //True para que sobrescriba
            BufferedWriter bw = new BufferedWriter(fw);

            for (String u : escritura) {

                bw.write(u);
            }

            System.out.println("Se creo el archivo");

            bw.close(); //Se cierra primero el ultimo en abrirse
            fw.close();

        } catch (IOException e) {

        }

    }

    public void cargarRutaUTxt(String texto) {

        Scanner sn = new Scanner(System.in);
        System.out.println(texto);
        String retorno = sn.nextLine();
        this.rutaUTxt = retorno;

    }

    public void cargarRutaUDat(String texto) {

        Scanner sn = new Scanner(System.in);
        System.out.println(texto);
        String retorno = sn.nextLine();
        this.rutaUDat = retorno;

    }

    @Override
    public void run() {
        switch (this.opcion) {

            case 1:

                escribirUTxt();
                System.out.println("Se escribieron los registros de los usuarios");
                break;
            case 2:

      
                escribirUDat();
                System.out.println("Se escribieron los registros de los usuarios");
                break;
            default:
                System.out.println("Se ingreso una opcion sin respuesta");
        }

    }

   
  
}
