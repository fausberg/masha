package a;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public void fileWriter(String massage) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Program From Git\\Masha_lab_4\\a.txt", true);
            fileWriter.write(massage);
            fileWriter.append('\n');
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
