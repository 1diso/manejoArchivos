import java.io.*;

public class operacionesBinario {
    public static void main(String[] args) {
        //Especificamos la ruta de el archivo que vamos a usar
        String filePath = "D:\\programacion\\vscode\\tema 6\\pruebaBinario2.txt";
        //Verifica que el archivo exista
        File file = new File(filePath);
        //Si no existe lo crea
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Archivo binario creado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo binario: " + e.getMessage());
            }
        }
        // escritura en el archivo 
        writeToFile(filePath, new int[] { 2, 2, 37, 4, 5 });

        //lectura del archivo 
        int[] numbers = readFromFile(filePath);
        System.out.println("Contenido del archivo: ");
        for (int num : numbers) {
            System.out.println(num);
        }

        // busqueda en el archivo 
        boolean found = searchInFile(filePath, 3);
        if (found) {
            System.out.println("El número 3 se encontró en el archivo.");
        } else {
            System.out.println("El número 3 no se encontró en el archivo.");
        }
    }

    private static void writeToFile(String filePath, int[] numbers) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             DataOutputStream dos = new DataOutputStream(fos)) {
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Archivo binario escrito exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo binario: " + e.getMessage());
        }
    }

    private static int[] readFromFile(String filePath) {
        int[] numbers = new int[0];

        try (FileInputStream fis = new FileInputStream(filePath);
             DataInputStream dis = new DataInputStream(fis)) {
            int fileSize = fis.available();
            int numCount = fileSize / 4; // asignamos 4 bytes por entero

            numbers = new int[numCount];
            for (int i = 0; i < numCount; i++) {
                numbers[i] = dis.readInt();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo binario: " + e.getMessage());
        }

        return numbers;
    }

    private static boolean searchInFile(String filePath, int number) {
        try (FileInputStream fis = new FileInputStream(filePath);
             DataInputStream dis = new DataInputStream(fis)) {
            while (dis.available() > 0) {
                int num = dis.readInt();
                if (num == number) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar en el archivo binario: " + e.getMessage());
        }

        return false;
    }
}
