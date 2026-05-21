package sistemagestióninventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String PATH_ARCHIVO = "inventario.dat";
        
        // Creamos el Scanner para leer desde la consola
        Scanner teclado = new Scanner(System.in);

        System.out.println("=================================================================");
        System.out.println("        SISTEMA DE GESTIÓN DE INVENTARIO - RETROGAMING          ");
        System.out.println("=================================================================");

        // Paso 1: Crear el objeto Inventario original
        System.out.println("\n[PASO 1]: Inicializando primer contenedor de Inventario...");
        Inventario inventarioOriginal = new Inventario();

        // Paso 2: Solicitar los datos de los 3 videojuegos por teclado
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
            
            // ¡IMPORTANTE! Limpieza del buffer del Scanner:
            // Al leer un número, el salto de línea (\n) se queda en el teclado. 
            // Usamos nextLine() suelto para consumirlo y que no dañe la siguiente lectura.
            teclado.nextLine(); 

            // Creamos la instancia con los datos ingresados y la añadimos de una vez
            Videojuego nuevoJuego = new Videojuego(titulo, plataforma, anio, precio);
            inventarioOriginal.agregarVideojuego(nuevoJuego);
        }

        // Paso 4: Mostrar en consola el inventario inicial para verificar
        System.out.println("\n[PASO 4]: Evaluando estado del Inventario Inicial:");
        System.out.println("-----------------------------------------------------------------");
        inventarioOriginal.listarInventario();
        System.out.println("-----------------------------------------------------------------");

        // Paso 5: Ejecutar el método de guardado (Serialización)
        System.out.println("\n[PASO 5]: Invocando rutina de persistencia binaria...");
        inventarioOriginal.guardarDatos(PATH_ARCHIVO);

        // Paso 6: Simular un reinicio creando un nuevo objeto vacío
        System.out.println("\n[PASO 6]: --- SIMULANDO REINICIO COMPLETO DEL PROGRAMA ---");
        System.out.println("Creando una nueva instancia de Inventario limpia en memoria RAM...");
        Inventario inventarioClonVacio = new Inventario();
        
        System.out.println("Verificando nuevo contenedor antes de la carga:");
        System.out.println("-----------------------------------------------------------------");
        inventarioClonVacio.listarInventario();
        System.out.println("-----------------------------------------------------------------");

        // Paso 7: Ejecutar el método de carga (Deserialización) sobre la instancia vacía
        System.out.println("\n[PASO 7]: Reconstruyendo información desde '" + PATH_ARCHIVO + "'...");
        inventarioClonVacio.cargarDatos(PATH_ARCHIVO);

        // Paso 8: Listar el nuevo inventario para certificar la recuperación exitosa
        System.out.println("\n[PASO 8]: Evaluando estado del Nuevo Inventario (Post-Persistencia):");
        System.out.println("-----------------------------------------------------------------");
        inventarioClonVacio.listarInventario();
        System.out.println("-----------------------------------------------------------------");

        // Validación adicional de búsqueda interactiva
        System.out.print("\n[VALIDACIÓN ADICIONAL]: Ingrese una plataforma para buscar en el sistema: ");
        String plataformaBusqueda = teclado.nextLine();
        inventarioClonVacio.buscarPorPlataforma(plataformaBusqueda);
        
        // Cerramos el scanner al finalizar el programa
        teclado.close();
        
        System.out.println("\n=================================================================");
        System.out.println("             DEMOSTRACIÓN FINALIZADA CON ÉXITO                  ");
        System.out.println("=================================================================");
    }
}