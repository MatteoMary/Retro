package model;
import java.io.*;

public class DataPersistence {

    public static void saveData(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadData(String filePath) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public static void main(String[] args) {
        // Assuming you have a dataString representing your internal data
        String dataString = "SerializedDataHere";

        // Save data to a file
        saveData(dataString, "data.txt");

        // Load data from the file
        String loadedData = loadData("data.txt");

        // Now, 'loadedData' contains the data you saved, and you can use it to populate your internal data structures.
    }
}

