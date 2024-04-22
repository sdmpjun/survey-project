package ap;

/**
 *
 * @author Chen Bingru
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.List;
import java.io.*;
import java.util.Base64;

public class Group16Controller implements Initializable {
    
    @FXML
    private AnchorPane Login;
    
    @FXML
    private Button loginButton;

    @FXML
    private Label label;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    
    private List<String> readAdminUsernames() throws IOException {
        return Files.readAllLines(Paths.get("admin.txt"));
    }

    // Method to encrypt the password
    private String encryptPassword(String password) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(hash); // Using Base64 to encode the byte array
    }

    // Method to read encrypted password from binary file
    private String readEncryptedPassword() throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("passwords.bin"))) {
            return (String) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    void loginButton(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            List<String> admins = readAdminUsernames();
            String encryptedStoredPassword = readEncryptedPassword();
            String encryptedInputPassword = encryptPassword(password);

            if (admins.contains(username) && encryptedInputPassword.equals(encryptedStoredPassword)) {
                // login successfully
                System.out.println("login successfully");
                // Jump to QuestionManagement.fxml
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("QuestionManagement.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Scene scene = loginButton.getScene();
                    scene.setRoot(root);
                } catch (Exception e) {
                    System.out.println("Cant load a new window");
                }
            } else {
                // login failure
                System.out.println("login failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Check if passwords.bin exists, if not, create it
        File passwordsFile = new File("passwords.bin");
        if (!passwordsFile.exists()) {
            try {
                String encryptedPassword = encryptPassword("123456");
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(passwordsFile))) {
                    oos.writeObject(encryptedPassword);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}