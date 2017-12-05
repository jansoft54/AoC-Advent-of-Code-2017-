import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class IO {
    static ArrayList<String> ReadLine(String filename) {
        ArrayList<String> list = new ArrayList<>();
        String path = new File(filename).getAbsolutePath();
        try (BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line=bf.readLine()) != null)
                list.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
