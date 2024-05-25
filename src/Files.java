import java.io.*;

public class Files {
    public static void main(String[] args) {
        String nombreArchivo = "miArchivo.txt";

        // Crear un nuevo archivo
        crearArchivo(nombreArchivo);

        // Escribir texto en el archivo
        escribirEnArchivo(nombreArchivo, "¡Hola, mundo!");

        // Buscar un texto específico dentro del archivo
        buscarTexto(nombreArchivo, "mundo");
    }

    public static void crearArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    public static void escribirEnArchivo(String nombreArchivo, String contenido) {
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write(contenido);
            System.out.println("Se escribió correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    public static void buscarTexto(String nombreArchivo, String textoBuscado) {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 0;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(textoBuscado)) {
                    contador++;
                }
            }
            System.out.println("Ocurrencias de \"" + textoBuscado + "\": " + contador);
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el archivo.");
            e.printStackTrace();
        }
    }
}
