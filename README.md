# Sistema de Gestión de Inventario - "RetroGaming"

## Información del Autor
* **Institución:** Universidad Técnica Particular de Loja (UTPL)
* **Componente Académico:** Programación Orientada a Objetos (POO)
* **Estudiante:** Jean Paul Aguilar


---

## 1. Contexto del Problema y Objetivos
La tienda de videojuegos clásicos **"RetroGaming"** requería un sistema interno capaz de gestionar de forma dinámica su catálogo de artículos (título, plataforma, año y precio). El principal desafío técnico radicaba en la volatilidad de la memoria RAM; al cerrarse un programa convencional de consola, toda la información recopilada se pierde por completo.

### Objetivos del Proyecto:
1. **Modelar** estructuras de datos bajo el paradigma de la Programación Orientada a Objetos aplicando un encapsulamiento estricto.
2. **Gestionar** colecciones dinámicas utilizando la API de Java (`ArrayList`) para superar las rigideces operativas de los arreglos estáticos tradicionales.
3. **Garantizar la persistencia** de los datos mediante el mecanismo de **Serialización de Objetos**, desviando el flujo de bytes hacia el disco duro de manera automatizada para evitar pérdidas ante reinicios del sistema.

---

## 2. Arquitectura del Sistema y Fases del Desarrollo

El software se divide en tres fases modulares e interconectadas de manera secuencial:

### Fase 1: Modelado y Encapsulamiento (`Videojuego.java`)
Se diseñó el molde estructural para representar cada artículo. Todos los atributos se definieron con el modificador de acceso `private` para restringir la manipulación externa no autorizada. El acceso y actualización de datos se realiza obligatoriamente a través de métodos accesores públicos (`Getters` y `Setters`). La clase implementa la interfaz de marcador `java.io.Serializable` para habilitar el transporte de sus instancias en flujos binarios.

### Fase 2: Lógica de Negocio y Colecciones (`Inventario.java`)
Esta clase actúa como el motor operativo del sistema. Administra una colección dinámica de tipo `ArrayList<Videojuego>`. Incluye métodos de negocio para agregar juegos y realizar búsquedas filtradas ignorando la distinción entre mayúsculas y minúsculas (`equalsIgnoreCase`). 

> **Optimización de Memoria:** El método `listarInventario()` fue optimizado para evitar la sobrecarga de peticiones I/O en la consola de NetBeans. Utiliza `String.format()` para concatenar paulatinamente el catálogo completo en una sola variable de texto (`String`), disparando un único `System.out.println()` al final del recorrido.

### Fase 3: Persistencia Avanzada (Entrada/Salida Binaria)
La persistencia se maneja de forma eficiente anidando los canales de escritura y lectura física (`FileOutputStream` / `FileInputStream`) dentro de envolturas de memoria intermedia (**`BufferedOutputStream`** y **`BufferedInputStream`**). Esto agrupa los bytes procesados por `ObjectOutputStream` y `ObjectInputStream` antes de impactar el almacenamiento magnético o sólido, mejorando significativamente el rendimiento computacional de la aplicación.

---

## 3. Verificación del Experimento y Evidencias (Run File)

El programa ejecuta satisfactoriamente el ciclo completo solicitado. El archivo binario `inventario.dat` es creado automáticamente por el flujo de Java en la raíz física del directorio de trabajo al momento del guardado, prescindiendo de cualquier configuración manual previa. Al ocurrir la deserialización, la estructura del `ArrayList` se levanta con un mapeo idéntico al capturado primigeniamente por teclado.

### Capturas de Pantalla del Funcionamiento

A continuación, se adjuntan las evidencias de la ejecución completa del archivo principal (`Main.java`):

#### 🔄 1. Ingreso de Datos e Inventario Inicial (Pasos 1 al 4)
*Aquí se evidencia la captura por teclado de los 3 videojuegos y el despliegue del reporte acumulado en la memoria RAM.*
#### 💾 2. Serialización y Reinicio Simulado (Pasos 5 y 6)
*Evidencia del guardado exitoso en el archivo físico y la posterior creación de un nuevo inventario vacío para el experimento.*
#### 📂 3. Deserialización y Recuperación Completa (Pasos 7 y 8 + Búsqueda)
*Demostración de que el sistema reconstruyó los objetos intactos desde el disco duro y validación del motor de búsqueda por plataforma.*
---
