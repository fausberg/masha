package lab_5_c;

import java.io.*;

public class Main {
    public static String fileName = "test.txt";

    public static void main(String[] args) throws Exception {
        try {
            double sum = 0.0;
            int count = 0;
            FileInputStream fileStream = new FileInputStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
            String line = null;
            while((line = reader.readLine()) != null) {
                try {
                    double num = Double.parseDouble(line.trim());
                    sum += num;
                    count++;
                } catch (NumberFormatException e) {
                    throw new InvalidNumberException("Invalid number format in file: " + line);
                }
            }
            reader.close();
            FileWriter fileWriter = new FileWriter("c.txt" ,true);
            double average = count > 0 ? sum / count : 0.0;
            fileWriter.write(String.valueOf(sum));
            fileWriter.append("\n");
            fileWriter.write(String.valueOf(average));
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new IOException(e);
        } catch (OutOfMemoryError e) {
            throw new MemoryAllocationException("Not enough memory to read file: " + fileName);
        }
    }
}
