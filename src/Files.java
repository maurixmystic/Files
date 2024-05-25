import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Files {
    public static void main(String[] args) {
        String nombreCarpeta = "directorio";
        String nombreArchivo = "miArchivo.txt";

        // Crear la carpeta
        crearCarpeta(nombreCarpeta);

        // Crear una lista de nombres de archivos
        List<String> nombresArchivos = Arrays.asList(
                "Perro", "Gato", "Juan", "Daniel", "Juan",
                "Camila", "Gato", "Perro", "Camila", "Daniel"
        );

        // Crear archivos dentro de la carpeta
        for (String nombre : nombresArchivos) {
            crearArchivo(nombreCarpeta + "/" + nombreArchivo, nombre);
        }
    }

    public static void crearCarpeta(String nombreCarpeta) {
        File carpeta = new File(nombreCarpeta);
        if (carpeta.mkdir()) {
            System.out.println("Carpeta creada: " + carpeta.getName());
        } else {
            System.out.println("La carpeta ya existe.");
        }
    }

    public static void crearArchivo(String rutaArchivo, String contenido) {
        try (FileWriter escritor = new FileWriter(rutaArchivo, true)) {
            escritor.write(contenido + "\n");
            System.out.println("Se agregó \"" + contenido + "\" al archivo.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}

