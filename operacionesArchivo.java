import java.io.*;

public class operacionesArchivo {
    public static void main(String[] args) {
        String filePath = "D:\\programacion\\vscode\\tema 6\\prueba2.txt";

        // Operación de escritura en el archivo
        writeToFile(filePath, "ola amigos, saludos");

        // Operación de lectura del archivo
        String content = readFromFile(filePath);
        System.out.println("Contenido del archivo: " + content);

        // Operación de búsqueda en el archivo
        boolean found = searchInFile(filePath, "amigos");
        if (found) {
            System.out.println("La palabra 'amigos' se encontró en el archivo.");
        } else {
            System.out.println("La palabra 'amigos' no se encontró en el archivo.");
        }
    }

    private static void writeToFile(String filePath, String content) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             OutputStreamWriter osw = new OutputStreamWriter(fos)) {
            osw.write(content);
            System.out.println("Archivo escrito exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return content.toString();
    }

    private static boolean searchInFile(String filePath, String keyword) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(keyword)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar en el archivo: " + e.getMessage());
        }

        return false;
    }
}
