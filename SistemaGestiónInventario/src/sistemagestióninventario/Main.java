package sistemagestióninventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String PATH_ARCHIVO = "inventario.dat";

        Scanner teclado = new Scanner(System.in);

        System.out.println("=================================================================");
        System.out.println("        SISTEMA DE GESTIÓN DE INVENTARIO - RETROGAMING          ");
        System.out.println("=================================================================");

        System.out.println("\n[PASO 1]: Inicializando primer contenedor de Inventario...");
        Inventario inventarioOriginal = new Inventario();

        System.out.println("[PASO 2]: Registro de videojuegos por teclado...");
        
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n--- Datos del Videojuego #" + i + " ---");
            
            System.out.print("Ingrese el Título: ");
            String titulo = teclado.nextLine();
            
            System.out.print("Ingrese la Plataforma (ej: NES, SEGA, PS1): ");
            String plataforma = teclado.nextLine();
            
            System.out.print("Ingrese el Año de Lanzamiento: ");
            int anio = teclado.nextInt();
            
            System.out.print("Ingrese el Precio: ");
            double precio = teclado.nextDouble();
            
            teclado.nextLine(); 

            Videojuego nuevoJuego = new Videojuego(titulo, plataforma, anio, precio);
            inventarioOriginal.agregarVideojuego(nuevoJuego);
        }

        System.out.println("\n[PASO 4]: Evaluando estado del Inventario Inicial:");
        System.out.println("-----------------------------------------------------------------");
        inventarioOriginal.listarInventario();
        System.out.println("-----------------------------------------------------------------");

        System.out.println("\n[PASO 5]: Invocando rutina de persistencia binaria...");
        inventarioOriginal.guardarDatos(PATH_ARCHIVO);

        System.out.println("\n[PASO 6]: --- SIMULANDO REINICIO COMPLETO DEL PROGRAMA ---");
        System.out.println("Creando una nueva instancia de Inventario limpia en memoria RAM...");
        Inventario inventarioClonVacio = new Inventario();
        
        System.out.println("Verificando nuevo contenedor antes de la carga:");
        System.out.println("-----------------------------------------------------------------");
        inventarioClonVacio.listarInventario();
        System.out.println("-----------------------------------------------------------------");

        System.out.println("\n[PASO 7]: Reconstruyendo información desde '" + PATH_ARCHIVO + "'...");
        inventarioClonVacio.cargarDatos(PATH_ARCHIVO);

        System.out.println("\n[PASO 8]: Evaluando estado del Nuevo Inventario (Post-Persistencia):");
        System.out.println("-----------------------------------------------------------------");
        inventarioClonVacio.listarInventario();
        System.out.println("-----------------------------------------------------------------");

        System.out.print("\n[VALIDACIÓN ADICIONAL]: Ingrese una plataforma para buscar en el sistema: ");
        String plataformaBusqueda = teclado.nextLine();
        inventarioClonVacio.buscarPorPlataforma(plataformaBusqueda);

        teclado.close();
        
        System.out.println("\n=================================================================");
        System.out.println("             DEMOSTRACIÓN FINALIZADA CON ÉXITO                  ");
        System.out.println("=================================================================");
    }
}