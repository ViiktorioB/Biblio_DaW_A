package orientadoBiblio;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) {

        // Creo la variable que almacenará lo que elige el usuario 
        int opcion;
        int opcion_libro;
        int opcion_usuario;
        int opcion_persona;
        ArrayList<Libro> listaLibros = new ArrayList<Libro>();
        ArrayList<Biblioteca> listaBibliotecas = new ArrayList<Biblioteca>();
        ArrayList <Persona> listaPersona = new ArrayList<Persona>();
        ArrayList <Usuario> listaUsuarios = new ArrayList<Usuario>();
        ArrayList <Reserva> listaReservas = new ArrayList<Reserva>();

        // Creamos una biblioteca ya que los metodos de biblioteca son instanciados y necestian de objeto no como el caso de los static
        Biblioteca biblioteca = new Biblioteca("Borja Moll", listaLibros, listaBibliotecas);

        do {

            /*  Utilizo el codigo ANSI para cambiar el color de la consola 
            url:https://www.campusmvp.es/recursos/post/como-cambiar-los-colores-de-la-consola-con-java-y-system-out-println.aspx
            https://dryant.com/programacion/como-poner-el-texto-de-color-en-la-consola-o-terminal-ejemplo-en-java/
            */

            System.out.println("\n--------------------------------------------------");
            System.out.println("\u001B[45m\u001B[30m                 BIENVENIDO A LA BIBLIOTECA                 \u001B[0m");
            System.out.println("--------------------------------------------------\n");
            System.out.format("\u001B[44m%-50s %-10s\u001B[0m\n", "¿QUÉ NECESITA REALIZAR?", "ELIGE");
            System.out.println("1. GESTION DE LIBROS");
            System.out.println("2. GESTION DE USUARIOS");
            System.out.println("3. GESTION DEL PERSONAL");
            System.out.println("0. Salir");
            System.out.println("--------------------------------------------------\n");
            System.out.println("\u001B[31m RESPUESTA\u001B[0m");
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();

            if(opcion == 0){
                System.out.println("Saliendo del programa...");
                break;
            }

            if(opcion == 1){
                System.out.println("--------------------------------------------------");
                System.out.println("\u001B[45m\u001B[30m                 GESTIÓN DE LIBROS                 \u001B[0m");
                System.out.println("--------------------------------------------------");
                System.out.format("\u001B[44m%-50s %-10s\u001B[0m\n", "¿QUÉ NECESITA REALIZAR?", "ELIGE");
                System.out.println("1. Añadir libro");
                System.out.println("2. Eliminar libro");
                System.out.println("3. Buscar libro por ISBN");
                System.out.println("4. Buscar libro por título");
                System.out.println("5. Mostrar todos los libros");
                System.out.println("6. Mostrar todos los libros disponibles");
                System.out.println("--------------------------------------------------");
                System.out.println("\u001B[31m RESPUESTA\u001B[0m");
                Scanner sc_libro = new Scanner(System.in);
                opcion_libro = sc_libro.nextInt();

                switch(opcion_libro){
                    
                    case 1:
                    Libro.añadirLibro(listaLibros);
                    break;

                    case 2:
                    Libro.eliminarLibro(listaLibros);
                    break;

                    case 3: 
                    Libro.buscarISBN(listaLibros);
                    break;

                    case 4: 
                    Libro.bucarLibro(listaLibros);
                    break;

                    case 5:
                    biblioteca.mostrarLibros();
                    break;

                    case 6:
                    biblioteca.mostrarLibrosDisponibles();
                    break;

                }

            }
            if(opcion == 2){
                System.out.println("\n--------------------------------------------------");
                System.out.println("\u001B[45m\u001B[30m                 GESTIÓN DE PERSONAL                 \u001B[0m");
                System.out.println("--------------------------------------------------\n");
                System.out.format("\u001B[44m%-50s %-10s\u001B[0m\n", "¿QUÉ NECESITA REALIZAR?", "ELIGE");
                System.out.println("1. Añadir Persona");
                System.out.println("2. Eliminar Persona");
                System.out.println("--------------------------------------------------\n");
                System.out.println("\u001B[31m RESPUESTA\u001B[0m");
                Scanner sc_persona = new Scanner(System.in);
                opcion_persona= sc_persona.nextInt();

                switch(opcion_persona){
                    case 1:
                    Persona.añadirPersona(listaPersona);
                    break;
                    
                    case 2:
                    Persona.eliminarPersona(listaPersona);
                    break;
                }
               
            }

            if(opcion == 3){
                System.out.println("\n--------------------------------------------------");
                System.out.println("\u001B[45m\u001B[30m                 GESTIÓN DE PERSONAL                 \u001B[0m");
                System.out.println("--------------------------------------------------\n");
                System.out.format("\u001B[44m%-50s %-10s\u001B[0m\n", "¿QUÉ NECESITA REALIZAR?", "ELIGE");
                System.out.println("1. Añadir Usuario");
                System.out.println("2. Eliminar Usuario");
                System.out.println("3. Crear Reserva");
                System.out.println("4. Eliminar Reseva");
                System.out.println("--------------------------------------------------\n");
                System.out.println("\u001B[31m RESPUESTA\u001B[0m");

                Scanner sc_usuario = new Scanner(System.in);
                opcion_usuario= sc_usuario.nextInt();

                switch(opcion_usuario){
                    case 1:
                    Usuario.añadirUsuario(listaUsuarios);
                    break;
                    
                    case 2:
                    Usuario.eliminarUsuario(listaUsuarios);
                    break;

                    case 3:
                    Usuario.reservarLibro(listaReservas);

                    case 4:
                    Usuario.eliminarReserva(listaReservas);

                }
            }else{
                System.out.println("No has seleecioando ninguna de las opciones");
                break;
            }
           
           
        }  while(opcion != 0);
    }
}

