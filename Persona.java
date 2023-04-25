package orientadoBiblio;

import java.util.ArrayList;
import java.util.Scanner;

public class Persona {

    // ATRIBUTOS CLASE PERSONA
    private String nombre;
    private String apellidos;
    private String NIF;
    private String contraseña;

    public Persona(){

    }

    public Persona(String nombre, String apellidos, String NIF, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        if(contraseña.length() >= 8){
            this.contraseña = contraseña;
        }else {
            System.out.println("La contraseña tiene que tener mas de 8 caracteres.");
        }
        
    }

    public Persona(Persona copiaPersona){
        this.nombre = copiaPersona.nombre;
        this.apellidos = copiaPersona.apellidos;
        this.NIF = copiaPersona.NIF;
        if(contraseña.length() >= 8){
            this.contraseña = copiaPersona.contraseña;
        }else {
            System.out.println("La contraseña tiene que tener mas de 8 caracteres.");
        }
    }

    // GETTERS Y SETTERS DE CLASE PERSONA
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

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + NIF + ", contraseña=" + contraseña
                + "]";
    }


    // METODOS DE CLASE PERSONA

    public static void añadirPersona( ArrayList <Persona> listaPersonas){
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
      
       Persona persona = new Persona(nombre,apellido,NIF,contraseña);
       listaPersonas.add(persona);
       System.out.println("La persona que has añadido es " + nombre + " " + apellido);
    } 
       

    
    public static void eliminarPersona(ArrayList <Persona> listaPersona){
        Scanner scanner = new Scanner(System.in);
        if (listaPersona.isEmpty()) {
            System.out.println("No hay personas para eliminar.");
        }
        System.out.println("Introduce el Nombre de la persona que desea eliminar:");
        String nombre = scanner.nextLine();

        for(int i = 0; i<listaPersona.size(); i++){
            if(listaPersona.get(i).getNombre().equals(nombre)){
                System.out.print("Está usted seguro de querer eliminar a la persona? (S/N): ");
                String siono = scanner.nextLine();
                if (siono.equalsIgnoreCase("S")) {
                    listaPersona.remove(i);
                    System.out.println("Persona eliminada correctamente.");
                }
            }
        }
    }

}

