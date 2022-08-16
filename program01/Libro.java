package program01;

import java.time.LocalDate;

public class Libro {
    //atributos
    private String isbn;
    private String titulo;
    private boolean prestado;

    // constructor de libro
    public  Libro(String isbn, String titulo, Boolean prestado){
        this.isbn=isbn;
        this.titulo=titulo;
        this.prestado=prestado;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString(){
        LocalDate tiempo = LocalDate.now();

        String estado= "Disponible";
        //if(this.presado===true)
        if (this.prestado){
            estado="No Disponible";
        }

        return "ISBN: " + this.isbn +" " + "TITULO: " + this.titulo +"     " + "ESTADO: " +estado  + "dia: " +  tiempo;
    }
}
