package program01;

import java.util.ArrayList;

public class Carrera {

    private  String nombreCarrera;
    private ArrayList<Libro> libros=new ArrayList<>();

    //Constructor
    public Carrera(String nombreCarrera){
        this.nombreCarrera=nombreCarrera;

    }
    // metos para mostrar lista de libros
    public  void mostrarLibros(){
        for (int i=0; i<libros.size(); i++){
            System.out.println(libros.get(i));
        }

    }
    //metodo para buscar lirbo

    public  Libro buscarLibroISBN (String isbn){
        //OBJ
        Libro libroAux=null;

        for (int i=0; i<libros.size();i++){
            if (isbn.equals(libros.get(i).getIsbn()));
            libroAux=libros.get(i);
        }

        return libroAux;
    }
    //
    public  int buscarLibrosPrestados(){
        int contadorPrestados=0;

        for (int i=0;i<libros.size();i++){
            if (libros.get(i).isPrestado()){
                contadorPrestados++;
            }
        }
        //prueba
        return contadorPrestados;
    }

    public  void agregarLibroEnCarrera(Libro libro1){
        libros.add(libro1);
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreEstante) {
        this.nombreCarrera = nombreEstante;
    }

    @Override
    public  String toString(){
        return "NOMBRE CARRERA: " + this.nombreCarrera;
    }
}
