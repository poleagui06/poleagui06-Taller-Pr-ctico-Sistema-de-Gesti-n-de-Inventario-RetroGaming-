package sistemagestióninventario;

import java.io.*;
import java.util.ArrayList;

public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Videojuego> listaJuegos;

    public Inventario() {
        this.listaJuegos = new ArrayList<>();
    }

    public void agregarVideojuego(Videojuego juego) {
        if (juego != null) {
            this.listaJuegos.add(juego);
        }
    }


    public void listarInventario() {
        if (this.listaJuegos.isEmpty()) {
            System.out.println("  [!] El inventario se encuentra totalmente vacío.");
            return;
        }

        String reporteFinal = "--- CONTENIDO DEL INVENTARIO ACUMULADO ---\n";

        for (Videojuego juego : this.listaJuegos) {

            reporteFinal += String.format("  • Título: %-25s | Plataforma: %-12s | Año: %d | Precio: $%.2f%n", 
                    juego.getTitulo(), juego.getPlataforma(), juego.getAnioLanzamiento(), juego.getPrecio());
        }

        System.out.println(reporteFinal);
    }

    public void buscarPorPlataforma(String plataforma) {
        System.out.println("\n--> Resultados de búsqueda para la plataforma [" + plataforma + "]:");
        boolean banderaCoincidencia = false;

        for (Videojuego juego : this.listaJuegos) {
            
            if (juego.getPlataforma().equalsIgnoreCase(plataforma)) {
                juego.mostrarInformacion();
                banderaCoincidencia = true;
            }
        }

        if (!banderaCoincidencia) {
            System.out.println("  [x] No se registraron videojuegos de la plataforma especificada.");
        }
    }

    public void guardarDatos(String nombreArchivo) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(nombreArchivo)))) {

            oos.writeObject(this.listaJuegos);
            System.out.println(">>> ÉXITO: Los datos fueron serializados correctamente en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println(">>> ERROR Critico al escribir en disco: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(nombreArchivo)))) {

            this.listaJuegos = (ArrayList<Videojuego>) ois.readObject();
            System.out.println(">>> ÉXITO: Los datos fueron recuperados desde: " + nombreArchivo);

        } catch (FileNotFoundException e) {
            System.err.println(">>> ADVERTENCIA: No se encontró el archivo '" + nombreArchivo + "'. Se iniciará un catálogo limpio.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(">>> ERROR al deserializar los datos del archivo: " + e.getMessage());
        }
    }
}
