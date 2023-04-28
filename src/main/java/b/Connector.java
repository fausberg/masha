package b;

import java.io.FileWriter;
import java.io.IOException;

public class Connector {

    public void fileWriter(ElectricApplianceList list) {
        try(FileWriter fileWriter = new FileWriter("b.txt", false)) {
            fileWriter.write(list.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
