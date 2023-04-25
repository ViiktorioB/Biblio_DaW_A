package orientadoBiblio;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
   
    // ATRIBUTOS CLASE BIBLIOTECA
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Biblioteca> listaPersonal;

    // CONSTRUCTORES CLASE BIBLIOTECA
    public Biblioteca(){
    
    }

    public Biblioteca(String nombre, ArrayList<Libro> listaLibros, ArrayList<Biblioteca> listaPersonal) {
        this.nombre = nombre;
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }
    public Biblioteca(Biblioteca copBiblioteca){
        this.nombre = copBiblioteca.nombre;
        this.listaLibros = new ArrayList<>(copBiblioteca.listaLibros);
        this.listaPersonal = new ArrayList<>(copBiblioteca.listaPersonal);
    }


    // GETTERS Y SETTERS DE CLASE BIBLIOTECA
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if (nombre.charAt(0) >= 'A' && nombre.charAt(0) <= 'Z') {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre de la biblioteca debe empezar con mayúscula.");
        }
    }

    public ArrayList<Libro> getListaLibros(){
        return listaLibros;
    }
    public void setListaLibros(ArrayList<Libro> listaLibros){
        this.listaLibros = listaLibros;
    }

    public ArrayList<Biblioteca> getListaPersonal(){
        return listaPersonal;
    }
    public void setListaPersonal(ArrayList<Biblioteca> listaPersonal){
        this.listaPersonal = listaPersonal;
    }

    // ToString CLASE BIBLIOTECA
    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", listaLibros=" + listaLibros + ", listaPersonal=" + listaPersonal
                + "]";
    }

    // METODOS CLASE BIBLIOTECA
    public void mostrarLibros(){
        System.out.println("Lista de libros de la biblioteca " + this.nombre + ":");
        for (int i = 0; i < this.listaLibros.size(); i++) {
            System.out.println(this.listaLibros.get(i));
        }
    }

    public void mostrarLibrosDisponibles(){
        System.out.println("Lista de libros disponibles en la biblioteca " + this.nombre + ":");
        for (int i = 0; i < this.listaLibros.size(); i++) {
            if (this.listaLibros.get(i).getN_copias_disponibles() > 0) {
                System.out.println(this.listaLibros.get(i));
            }
        }
    }
    

}

