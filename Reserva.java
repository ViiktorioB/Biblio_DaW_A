package orientadoBiblio;

import java.util.Scanner;

public class Reserva {
   
    private String usuario;
    private String tituloLibro;

    public Reserva(String usuario, String tituloLibro) {
        this.usuario = usuario;
        this.tituloLibro = tituloLibro;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    @Override
    public String toString() {
        return "Reserva [usuario=" + usuario + ", tituloLibro=" + tituloLibro + "]";
    }

}


