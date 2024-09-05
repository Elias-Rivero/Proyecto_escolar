package es.ies.modeloTxtDB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    private String pathDBFiles = "dbText/";
    private String adminFilePath = pathDBFiles+"nombreAdmin.txt";
    private String clientFilePath = pathDBFiles+"nombreCli.txt";
    private String usersFilePath = pathDBFiles+"usuarios.txt";

    public FileManager() {
        createFileIfNotExists(adminFilePath);
        createFileIfNotExists(clientFilePath);
        createFileIfNotExists(usersFilePath);
        createDefaultAdminUser();
    }

    private void createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + filePath + " - " + e.getMessage());
            }
        }
    }

    public List<String> readUsers() {
        try {
            return Files.readAllLines(Paths.get(usersFilePath));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
            return null;
        }
    }

    public void writeUser(String filePath, String user) {
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(user);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private void createDefaultAdminUser() {
        List<String> users = readUsers();
        boolean adminExists = false;
        if (users != null) {
            for (String user : users) {
                String[] parts = user.split(",");
                if (parts[0].equals("admin") && parts[1].equals("admin")) {
                    adminExists = true;
                    break;
                }
            }
        }
        if (!adminExists) {
            try (FileWriter fw = new FileWriter(usersFilePath, true)) {
                fw.write("admin,admin\n");
                System.out.println("Usuario admin por defecto creado.");
            } catch (IOException e) {
                System.out.println("Error al crear el usuario admin por defecto: " + e.getMessage());
            }
        }
    }

}

