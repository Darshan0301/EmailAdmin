package EmailApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataSaver {
    private static final String CSV_FILE = "emails.csv";

    public static void saveEmailData(String firstname, String lastname, String email, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE, true))) {
            // Check if the file is empty, and if so, write the header
            if (new java.io.File(CSV_FILE).length() == 0) {
                writer.write("FirstName,LastName,Email,Password");
                writer.newLine();
            }
            writer.write(firstname + "," + lastname + "," + email + "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the email data.");
            e.printStackTrace();
        }
    }
}

