import java.io.*;

public class manejoArchivo {
    private String rutaArchivo;

    public manejoArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void writeArchivo(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) { // Agregado: true para modo de apéndice
            writer.write(content);
            System.out.println("Contenido guardado");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public String readArchivo() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return content.toString();
    }

    public boolean searchArchivo(String searchTerm) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar en el archivo: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
         //Especificamos la ruta de el archivo que vamos a usar
        String rutaArchivo = "D:\\programacion\\vscode\\tema 6\\pruebaText2.txt";
        manejoArchivo fileManager = new manejoArchivo(rutaArchivo);

        // Escritura en el archivo
        fileManager.writeArchivo("hola, esta es una prueba");

        // Lectura de el archivo
        String content = fileManager.readArchivo();
        System.out.println("Contenido del archivo:");
        System.out.println(content);

        // Busqueda en el archivo
        String searchTerm = "hola";
        boolean found = fileManager.searchArchivo(searchTerm);
        if (found) {
            System.out.println("El término '" + searchTerm + "' se encontró en el archivo.");
        } else {
            System.out.println("El término '" + searchTerm + "' no se encontró en el archivo.");
        }
    }
}
