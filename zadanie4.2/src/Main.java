import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Projects\\Mobilki\\2025_09_24\\src\\przyklad.txt"));
            int liczbaMaxCzynniki = 0;
            int maxCzynniki = 0;

            int liczbaMaxRozne = 0;
            int maxRozne = 0;
            for (String line  : lines) {
                int liczba = Integer.parseInt(line);
                int temp = liczba;
                List<Integer> czynniki = new ArrayList<>();
                for (int i = 2; i <= temp; i++) {
                    while (temp % i == 0) {
                        czynniki.add(i);
                        temp /= i;
                    }
                }
                int ileCzynnikow = czynniki.size();
                for(int i = 0; i < czynniki.size()-1; i++){
                    if(czynniki.get(i)==czynniki.get(i+1))
                    {
                        czynniki.remove(i+1);
                    }
                }
                int ileRoznych = czynniki.size();

                if (ileCzynnikow > maxCzynniki) {
                    maxCzynniki = ileCzynnikow;
                    liczbaMaxCzynniki = liczba;
                }

                if (ileRoznych > maxRozne) {
                    maxRozne = ileRoznych;
                    liczbaMaxRozne = liczba;
                }

            }
            System.out.println(liczbaMaxCzynniki + " " + maxCzynniki + " " + liczbaMaxRozne + " " + maxRozne);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
