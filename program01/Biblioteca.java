package program01;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    private static ArrayList<Carrera> carreras =new ArrayList<>();
    static Scanner entrada=new Scanner(System.in);



    public static void main(String[] args) {
        int opcion=0;
        do {
            /*System.out.println("1. Agregrar libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Mostrar estante mas Solicitado");
            System.out.println("4. Salir");*/

            System.out.println("""
                    
                    1. Agregar libro
                    2. Prestar libro
                    3. Mostrar carrera mas solicitado
                    4. Salir
                    """);

            System.out.println("INGRESE UNA OPCION: ");
            opcion= entrada.nextInt();

            switch (opcion){

                case 1:
                    System.out.println("Ingrese datos del Libro isbn & titulo: ");
                    entrada.nextLine(); //para evitar problemas
                    String[] datos=entrada.nextLine().split(" & ");

                    //objeto
                    Libro libro =new Libro(datos[0],datos[1],false );

                    int numeroCarrera=0;
                    String nombreEstante ="";

                    //

                    if (carreras.isEmpty()){
                        numeroCarrera=0;
                        System.out.println("Ingrese Nombre de la Carrera: ");
                        nombreEstante=entrada.nextLine();
                    }else {
                        for (int i = 0; i< carreras.size(); i++){
                            System.out.println(i + "-->" + carreras.get(i).getNombreCarrera());
                        }
                        System.out.println(carreras.size() + "--> Disponible");

                        System.out.println("Selecione un Numero de Estante: ");
                        numeroCarrera=entrada.nextInt();
                        if (numeroCarrera>= carreras.size()){
                            System.out.println("Ingrese Nombre del Estante: ");
                            entrada.nextLine();
                            nombreEstante=entrada.nextLine();
                        }

                    }

                    agregarLibro(numeroCarrera, nombreEstante,libro);

                    break;
                case 2:
                    System.out.println("Ingrese el ISBN: " );
                    entrada.nextLine();
                    String isbn=entrada.nextLine();
                    prestarLibro(isbn);

                    for (int i = 0; i< carreras.size(); i++){
                        carreras.get(i).mostrarLibros();
                    }
                    break;
                case 3:

                    mostrarEstanteMasSolicitado();

                    break;
                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("OPCION NO VALIDO");
                    break;
            }

        }while (opcion!=0);
    }


    //METODOS

    public  static void agregarLibro(int numeroDelEstante, String nombreEstante, Libro libro1){

        if (numeroDelEstante < carreras.size()){
            carreras.get(numeroDelEstante).agregarLibroEnCarrera(libro1);
        }else {
            Carrera carrera1 =new Carrera(nombreEstante);
            carrera1.agregarLibroEnCarrera(libro1);

            carreras.add(carrera1);
        }

        System.out.println(carreras);
        for (int i = 0; i< carreras.size(); i++){
            carreras.get(i).mostrarLibros();
        }
    }

    public  static void prestarLibro(String isbn){
        int prestado=0;
        for (int i = 0; i< carreras.size(); i++){
            if (carreras.get(i).buscarLibroISBN(isbn)!=null){
                carreras.get(i).buscarLibroISBN(isbn).setPrestado(true);
                prestado=1;
                break;
            }

        }
        if (prestado==1){
            System.out.println("El libro con ISBN: " +isbn + "ha sido prestado");
        }else {
            System.out.println("El libro no existe en nuestra biblioteca.");
        }
    }

    public  static void mostrarEstanteMasSolicitado(){
        int masSolicitado=0;
        Carrera carreraAuxiliar =null;
        for (int i = 0; i< carreras.size(); i++){

            if (masSolicitado==0&& i==0){
                masSolicitado= carreras.get(i).buscarLibrosPrestados();
                carreraAuxiliar = carreras.get(i);
            }

            if (carreras.get(i).buscarLibrosPrestados()>masSolicitado){
                masSolicitado= carreras.get(i).buscarLibrosPrestados();
                carreraAuxiliar = carreras.get(i);
            }

        }
        if (masSolicitado==0){
            System.out.println("No se han presado libros");
        }else {

        System.out.println("La carrera  " + carreraAuxiliar.getNombreCarrera() + " es mas solicitado " +masSolicitado + " libros prestados");

    }



}}
