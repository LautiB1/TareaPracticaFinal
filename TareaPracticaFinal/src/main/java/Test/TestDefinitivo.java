
package Test;

import Clases.MetodoEscritura;
import Clases.MetodoLectura;
import Clases.Usuarios;
import Clases.UsuariosDAOImp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDefinitivo {

    public static void main(String[] args) {

        List<Usuarios> usuarioEnvio = new ArrayList<>();
        List<Usuarios> usuariosRecepcion = new ArrayList<>();

        usuarioEnvio.add(new Usuarios("Zoe", "Mancini", "zoe@gmail.com", "351248451"));
        usuarioEnvio.add(new Usuarios("Martin", "Perez", "martin@gmail.com", "354248218"));
        usuarioEnvio.add(new Usuarios("Lautaro", "Baldellou", "lautaro@gmail.com", "342574124"));
        usuarioEnvio.add(new Usuarios("Tomas", "Thor", "tomas@gmail.com", "395231475"));
        usuarioEnvio.add(new Usuarios("Raul", "Peder", "raul@gmail.com", "341547932"));
        usuarioEnvio.add(new Usuarios("Sol", "Biner", "sol@gmail.com", "372145795"));
        usuarioEnvio.add(new Usuarios("Gabriel", "Lavalle", "gabriel@gmail.com", "341548745"));

        UsuariosDAOImp usuarioDAO = new UsuariosDAOImp();

        Scanner sn = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("==================================");
            System.out.println("===============MENU===============");
            System.out.println("==================================");
            System.out.println("1 = REGISTRAR LA LISTA USUARIOS");
            System.out.println("2 = MOSTRAR LA LISTA");
            System.out.println("3 = ORDENAR POR ORDEN ALFABETICO");
            System.out.println("4 = CONSULTAR = GRABAR/LEER .txt y .dat");
            System.out.println("5 = CONSULTAR USUARIO POR ID");
            System.out.println("6 = SALIR DEL MENU");
            int opcionMenu = cargarMenu("INGRESE LA OPCION");
            switch (opcionMenu) {

                case 1:
                  
                  try {
                    usuarioDAO.registrar(usuarioEnvio);

                } catch (ClassNotFoundException ex) {

                    System.out.println("Error de la aplicacion");
                    ex.printStackTrace(System.out);

                } catch (SQLException ex) {

                    System.out.println("Error en la conexion");
                    ex.printStackTrace(System.out);

                }

                break;
                case 2:              
              
               try {

                    usuariosRecepcion = usuarioDAO.recuperar();

                } catch (ClassNotFoundException ex) {

                    System.out.println("Error de la aplicacion");
                    ex.printStackTrace(System.out);

                } catch (SQLException ex) {

                    System.out.println("Error en la conexion");
                    ex.printStackTrace(System.out);

                }
                break;
                case 3:
                    
                try {

                    usuariosRecepcion = usuarioDAO.recuperar();

                } catch (ClassNotFoundException ex) {

                    System.out.println("Error de la aplicacion");
                    ex.printStackTrace(System.out);

                } catch (SQLException ex) {

                    System.out.println("Error en la conexion");
                    ex.printStackTrace(System.out);

                }
                break;
                case 4: {
                    Scanner sn1 = new Scanner(System.in);
                    boolean salir1 = false;

                    while (!salir1) {
                        System.out.println("==================================");
                        System.out.println("========MANEJO DE ARCHIVOS========");
                        System.out.println("==================================");
                        System.out.println("1 = GUARDAR USUARIOS EN TXT ");
                        System.out.println("2 = GUARDAR USUARIOS EN DAT");
                        System.out.println("3 = RECUPERAR USUARIOS DEL TXT");
                        System.out.println("4 = RECUPERAR USUARIOS DEL DAT");

                        System.out.println("5 = SALIR");
                        int opcionArchivos = cargarMenuArchivos("INGRESE LA OPCION");

                        switch (opcionArchivos) {

                            case 1: {

                                MetodoEscritura hiloUno = new MetodoEscritura();

                                hiloUno.cargarRutaUTxt("INGRESE EL NOMBRE DEL ARCHIVO TIPO TXT PARA GUARDAR LOS USUARIOS");

                                hiloUno.setUsersTxt(usuarioEnvio);

                                hiloUno.setOpcion(1);

                                hiloUno.run();

                            }

                            break;
                            case 2: {

                                MetodoEscritura hiloDos = new MetodoEscritura();

                                hiloDos.cargarRutaUDat("INGRESE EL NOMBRE DEL ARCHIVO TIPO DAT PARA GUARDAR LOS USUARIOS");

                                hiloDos.setUsersDat(usuarioEnvio);

                                hiloDos.setOpcion(2);

                                hiloDos.run();

                            }

                            break;
                            case 3: {

                                MetodoLectura hiloTres = new MetodoLectura();

                                hiloTres.cargarRutaUTxt("INGRESE LA RUTA A LEER DE LOS USUARIOS");

                                hiloTres.setOpcion(1);

                                hiloTres.start();

                            }

                            break;
                            case 4: {

                                MetodoLectura hiloCuatro = new MetodoLectura();

                                hiloCuatro.cargarRutaUDat("INGRESE LA RUTA A LEER DE LOS USUARIOS");

                                hiloCuatro.setOpcion(2);

                                hiloCuatro.start();

                            }
                            break;
                            case 5: {

                                System.out.println("SALISTE DEL MANEJO DE ARCHIVOS");

                                salir1 = true;
                            }
                            break;

                            default:

                                System.out.println("SOLO NUMEROS ENTRE 1 Y 5");

                        }
                    }
                }
                break;
                case 5:
                    
                 try {

                    usuariosRecepcion = usuarioDAO.recuperarID();

                    int a = cargarId("Ingrese el id del usuario a retornar");
                    boolean flag = false;

                    for (Usuarios usuarios : usuariosRecepcion) {

                        if (a == usuarios.getId()) {

                            System.out.println(usuarios);
                            flag = true;
                        }

                    }

                    if (flag == false) {

                        System.out.println("Error");

                    }

                } catch (ClassNotFoundException ex) {

                    System.out.println("Error de la aplicacion");
                    ex.printStackTrace(System.out);

                } catch (SQLException ex) {

                    System.out.println("Error en la conexion");
                    ex.printStackTrace(System.out);

                }

                break;

                case 6: {

                    System.out.println("SALISTE DEL PROGRAMA");

                    salir = true;

                }
                break;
                default:

                    System.out.println("SOLO NUMEROS ENTRE 1 Y 6");

            }
        }
    }

    public static int cargarMenu(String texto) {

        Scanner sn1 = new Scanner(System.in);
        System.out.println(texto);
        int numero = sn1.nextInt();

        return numero;

    }

    public static int cargarMenuArchivos(String texto) {

        Scanner sn = new Scanner(System.in);
        System.out.println(texto);
        int numero = sn.nextInt();

        return numero;

    }

    public static int cargarId(String texto) {

        Scanner sn = new Scanner(System.in);
        System.out.println(texto);
        int numero = sn.nextInt();

        return numero;

    }

}
