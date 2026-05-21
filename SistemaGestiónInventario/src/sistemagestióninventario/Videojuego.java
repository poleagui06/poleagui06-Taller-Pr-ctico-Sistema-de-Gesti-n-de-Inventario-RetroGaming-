package sistemagestióninventario;

import java.io.Serializable;

public class Videojuego implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private String plataforma;
    private int anioLanzamiento;
    private double precio;

    public Videojuego(String titulo, String plataforma, int anioLanzamiento, double precio) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anioLanzamiento = anioLanzamiento;
        this.precio = precio;
    }

    public void mostrarInformacion() {
        System.out.printf("  • Título: %-25s | Plataforma: %-12s | Año: %d | Precio: $%.2f%n",
                this.titulo, this.plataforma, this.anioLanzamiento, this.precio);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
