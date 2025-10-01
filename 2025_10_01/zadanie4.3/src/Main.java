import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Projects\\Mobilki\\zadanie4.3\\src\\przyklad.txt"));
            List<String> good3lines = new ArrayList<>();
            List<String> good5lines = new ArrayList<>();

            for (String line : lines) {
                int number = Integer.parseInt(line);
                for (String line2 : lines) {
                    int number2 = Integer.parseInt(line2);
                    if (number2 % number == 0 && number2 != number) {
                        for (String line3 : lines) {
                            int number3 = Integer.parseInt(line3);
                            if (number3 % number2 == 0 && number3 != number2) {
                                good3lines.add((line + " " + line2 + " " + line3));
                                for (String line4 : lines) {
                                    int number4 = Integer.parseInt(line4);
                                    if (number4 % number3 == 0 && number4 != number3) {
                                        for (String line5 : lines) {
                                            int number5 = Integer.parseInt(line5);
                                            if (number5 % number4 == 0 && number5 != number4) {
                                                good5lines.add((line + " " + line2 + " " + line3 + " " + line4 + " " + line5));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(good3lines.size());
            System.out.println(good5lines.size());
            try (FileWriter writer = new FileWriter("C:\\Projects\\Mobilki\\2025_10_01\\zadanie4.3\\src\\good3lines.txt")) {
                for (String seq : good3lines) {
                    writer.write(seq + System.lineSeparator());
                }
            }
            System.out.println("Data successfully written!");

        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
