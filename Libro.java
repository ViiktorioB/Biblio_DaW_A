package orientadoBiblio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Libro {

   
    // ATRIBUTOS CLASE LIBRO
    private String ISBN;
    private String título;
    private String autor;
    private String editorial;
    private int N_copias;
    private int N_copias_disponibles;
    private static int N_titulos = 0;
    
    
    // CONSTRUCTORES CLASE LIBRO
    public Libro(){

    }

    public Libro(String ISBN, String título, String autor, String editorial, int N_copias, int N_copias_disponibles) {
        this.ISBN = ISBN;
        this.título = título;
        this.autor = autor;
        this.editorial = editorial;
        this.N_copias = N_copias;
        this.N_copias_disponibles = N_copias_disponibles;
        N_titulos++;
    }

    public Libro(Libro copiaLibro){
        this.ISBN = copiaLibro.ISBN;
        this.título = copiaLibro.título;
        this.autor = copiaLibro.autor;
        this.editorial = copiaLibro.editorial;
        this.N_copias = copiaLibro.N_copias;
        this.N_copias_disponibles = copiaLibro.N_copias_disponibles;
        N_titulos++;
    }

    // SETTERS Y GETTERS CLASE LIBRO
    public String getISBN() {
        return ISBN;
    }  
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTítulo() {
        return título;
    }
    public void setTítulo(String título) {
        this.título = título;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getN_copias() {
        return N_copias;
    }
    public void setN_copias(int N_copias) {
     // Control del set para que las copias nunca pedan ser menor a uno.
     if(N_copias < 1){
        System.out.println("No puede haber menos de una copia.");
        this.N_copias = 1;
        }
    }

    public int getN_copias_disponibles() {
        return N_copias_disponibles;
    }
    public void setN_copias_disponibles(int N_copias_disponibles) {
         // Control del set para que las copias nunca pedan ser menor a uno.
         if(N_copias < 1){
            System.out.println("No puede haber menos de una copia.");
            this.N_copias_disponibles = 1;
        }
    }

    // ToString CLASE LIBRO
    @Override
    public String toString() {
        return "Libro [ISBN=" + ISBN + ", título=" + título + ", autor=" + autor + ", editorial=" + editorial
                + ", N_copias=" + N_copias + ", N_copias_disponibles=" + N_copias_disponibles + "]";
    }


    // METODOS CLASE JAVA

    public static void añadirLibro( ArrayList<Libro> listaLibros){
        Scanner scanner = new Scanner(System.in);
        System.out.println("INTRODUZCA LOS DATOS PARA AÑADIR UN LIBRO");
        System.out.println("");
        System.out.println("Cual es el ISBN?: ");
        String ISBN = scanner.nextLine();

        System.out.println("Cual es el titulo del libro?: ");
        String titulo = scanner.nextLine();

        System.out.println("Cual es el autor del libro?: ");
        String autor = scanner.nextLine();

        System.out.println("Cuale es la editorial del libro?: ");
        String editorial = scanner.nextLine();

        System.out.println("Cual es el numero de copias del libro?: ");
        int n_copias = scanner.nextInt();

        Libro libro = new Libro(ISBN, titulo, autor, editorial, n_copias, n_copias);
        listaLibros.add(libro);
        libro.toString();
    }


    public static void eliminarLibro(ArrayList<Libro> listaLibros) {
        Scanner scanner = new Scanner(System.in);
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros para eliminar.");
            return;
        }
        System.out.println("Introduce el ISBN del libro a eliminar:");
        String ISBN = scanner.nextLine();

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getISBN().equals(ISBN)) {
                if (listaLibros.get(i).getN_copias_disponibles() < listaLibros.get(i).getN_copias()) {
                    System.out.println("No se puede eliminar un libro que tiene reservas.");
                    return;
                }
                System.out.print("Está usted seguro de querer eliminar el libro? (S/N): ");
                String siono = scanner.nextLine();
                if (siono.equalsIgnoreCase("S")) {
                    listaLibros.remove(i);
                    System.out.println("Libro eliminado correctamente.");
                }
                return;
            }
        }
        System.out.println("No se ha encontrado ningún libro con ese ISBN.");
    }


    public static int buscarISBN(ArrayList<Libro> listaLibros){
        Scanner scanner = new Scanner(System.in);
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros para buscar.");
            return -1;
        }
        System.out.println("Introduce el ISBN del libro que deseas encontrar:");
        String ISBN = scanner.nextLine();

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getISBN().equals(ISBN)) {
                System.out.println("El libro que buscas se encunetra en la posicion ");
                return i;
            } 
        }
        System.out.println("No hay libro con esa ISBN ");
        return -1;
    }
    

    public static void bucarLibro(ArrayList<Libro> listaLibros){
        Scanner scanner = new Scanner(System.in);
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros para buscar.");
            return;
        }
        System.out.println("Introduce el titulo del libro que deseas encontrar:");
        String titulo = scanner.nextLine();
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getTítulo().contains(titulo)) {
               System.out.println(listaLibros.get(i).toString());
            } 
        }
    }
}



