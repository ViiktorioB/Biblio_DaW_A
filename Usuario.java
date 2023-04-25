package orientadoBiblio;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String NIF;
    private String contraseña;
    private static int NumLibrosReservados = 0;
    private static ArrayList<Reserva> listaReservas;


  

    public Usuario(){

    }

    public Usuario(String nombre, String apellidos, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        if(contraseña.length() >= 8){
            this.contraseña = contraseña;
        }else {
            System.out.println("La contraseña tiene que tener mas de 8 caracteres.");
        }
        listaReservas = new ArrayList<Reserva>();
        
    }

    public Usuario(Usuario copiaUsuario){
        this.nombre = copiaUsuario.nombre;
        this.apellidos = copiaUsuario.apellidos;
        this.NIF = copiaUsuario.NIF;
        this.contraseña = copiaUsuario.contraseña;
        this.listaReservas = copiaUsuario.listaReservas;
    } 

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        if(contraseña.length() >= 8){
            this.contraseña = contraseña;
        }else {
            System.out.println("La contraseña tiene que tener mas de 8 caracteres.");
        }
    }

    public static int getNumLibrosReservados() {
        return NumLibrosReservados;
    }

    public static void setNumLibrosReservados(int getNumLibrosReservados) {
        Usuario.NumLibrosReservados = getNumLibrosReservados;
    }

        
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + NIF + ", contraseña=" + contraseña
                + "]";
    }


    // METODOS DE LA CLASE USUARIO

    public static void añadirUsuario( ArrayList <Usuario> listaUsuarios){
        Scanner scanner = new Scanner(System.in);
        System.out.println("AÑADIR PERSONA DE GESTION DE BIBLIOTECA");
        System.out.println("");
        System.out.println("Cual es el nombre?: ");
        String nombre = scanner.nextLine();

        System.out.println("Cual es el apellido?: ");
        String apellido = scanner.nextLine();

        System.out.println("Cual es el NIF?: ");
        String NIF = scanner.nextLine();

        System.out.println("Cual es la contraseña (Mas de 8 caracteres): ");
        String contraseña = scanner.nextLine();
      
       Usuario usuario= new Usuario(nombre,apellido,NIF,contraseña);
       listaUsuarios.add(usuario);
       System.out.println("El usuario que has añadido es " + nombre + " " + apellido);
    } 
   

    public static void eliminarUsuario(ArrayList <Usuario> listaUsuarios){
        Scanner scanner = new Scanner(System.in);
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios para eliminar.");
        }
        System.out.println("Introduce el Nombre del usuario que desea eliminar:");
        String nombre = scanner.nextLine();

        for(int i = 0; i<listaUsuarios.size(); i++){
            if(listaUsuarios.get(i).getNombre().equals(nombre)){
                System.out.print("Está usted seguro de querer elimina al usuario? (S/N): ");
                String siono = scanner.nextLine();
                if (siono.equalsIgnoreCase("S")) {
                    listaUsuarios.remove(i);
                    System.out.println("Usuario eliminado correctamente.");
                }
            }
        }
    }
    
        public static void reservarLibro(ArrayList<Reserva> listaReservas) {
            if(Usuario.getNumLibrosReservados()>=5){
                System.out.println("No se pueden reservar mas de 5 libros");
            }else{
            System.out.println("Cual es tu nombre de usuario?");
            Scanner sc_usuarios = new Scanner(System.in);
            String usuarios = sc_usuarios.nextLine();
            System.out.println("Que libro deseas reservar?");
            Scanner sc_libro = new Scanner(System.in);
            String libros = sc_libro.nextLine();

            Reserva reserva = new Reserva(usuarios, libros);
            listaReservas.add(reserva);
            System.out.println(reserva.toString());
            }
            Usuario.setNumLibrosReservados(NumLibrosReservados++);
        }

        public static void eliminarReserva(ArrayList<Reserva> listaReservas){
            Scanner scanner = new Scanner(System.in);
            if (listaReservas.isEmpty()) {
                System.out.println("No hay libros para eliminar.");
                return;
            }

            System.out.println("Introduce el nombre del usuario a eliminar:");
            String nombre = scanner.nextLine();
            for (int i = 0; i < listaReservas.size(); i++) {
                if (listaReservas.get(i).getUsuario().equals(nombre)) {
                    System.out.print("Está usted seguro de querer eliminar el libro? (S/N): ");
                    String siono = scanner.nextLine();
                    if (siono.equalsIgnoreCase("S")) {
                        listaReservas.remove(i);
                        System.out.println("Libro eliminado correctamente.");
                    }
                    return;
                }
            }
            System.out.println("No se ha encontrado ningún libro con ese ISBN.");
        
        }
    
}

