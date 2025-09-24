import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Projects\\Mobilki\\zadanie4.1\\src\\przyklad.txt"));
            boolean firstLine = false;
            int counter = 0;
            for (String line  : lines) {
                if(line.charAt(0) == line.charAt(line.length()-1))
                {
                    counter++;
                   if(!firstLine){
                       System.out.println(line);
                   }
                    firstLine = true;
                }
            }
            System.out.println(counter);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
