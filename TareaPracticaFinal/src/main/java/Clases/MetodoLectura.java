
package Clases;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

public class MetodoLectura extends Thread {

    //Dat -> List
    //Txt -> for
    private List<Usuarios> UsersDat;
    private int opcion;
    private String rutaUTxt;
    private String rutaUDat;

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

    public void lecturaTxt() {

        try {

            FileReader fr = new FileReader(this.rutaUTxt);

            BufferedReader bf = new BufferedReader(fr);

            String retorno = bf.readLine();

            while (retorno != null) {

                System.out.println(retorno);
                retorno = bf.readLine();

            }

            bf.close();  //Se cierra primero el ultimo en abrirse
            fr.close();
        } catch (IOException e) {

            System.out.println("Error en la lectura Txt");
            e.printStackTrace(System.out);

        }
    }

    public void lecturaDat() {

        try {

            FileInputStream fi = new FileInputStream(this.rutaUDat);
            ObjectInputStream oi = new ObjectInputStream(fi);

            this.UsersDat = (List<Usuarios>) oi.readObject();

            if (this.UsersDat.isEmpty()) {

                System.out.println("La lista del dat esta vacia");

            } else {

                this.UsersDat.forEach(System.out::println);

            }

            oi.close();
            fi.close();
        } catch (IOException e) {

            System.out.println("Error en la lectura Dat");

            e.printStackTrace(System.out);

        } catch (ClassNotFoundException ex) {

            System.out.println("Error");
            ex.printStackTrace(System.out);
        }

    }



    @Override
    public void run() {

        switch (this.opcion) {

            case 1:

                System.out.println("Muestra Txt");
                lecturaTxt();
                break;
            case 2:

                System.out.println("Muesta Dat");
                lecturaDat();
                break;
            default:

                System.out.println("Se ingreso una opcion sin respuesta");

        }

    }
    
}    

    
