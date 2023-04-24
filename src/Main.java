import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import static java.nio.file.Paths.*;

class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        caesarCipher();
        System.out.println(" Let's break cipher of encoded message. To choose kind of decoding way type in console: \"Brute\" - " +
                " for Brute Force method   or \"Statistical\" - for Statistic method");

        String vvod = SCANNER.nextLine();

        while (!vvod.equalsIgnoreCase("brute") && !vvod.equalsIgnoreCase("statistical")) {
            System.out.println("Incorrect input. Try again.");
            vvod = SCANNER.nextLine();
        }

        if (vvod.equalsIgnoreCase("brute")) {
            System.out.println("You have chosen Brute Force method for decoding");
            bruteDeCipher();
            System.out.println("Let's check text file BruteForce");
        } else if (vvod.equalsIgnoreCase("statistical")) {
            System.out.println("You have chosen Statistic method for decoding.");
            statisticalDeCipher();
            System.out.println("Let's check text file StatisticalDeCipher");
        }
    }

     static void caesarCipher() throws IOException {
        // Receive path to original file
        // Create file for writing coded message

        Path path = Paths.get("./src/Caesar.txt");

        if (!path.toFile().exists()) {
            throw new IOException("Something wrong. Check is original file exist.");
        }

        try (FileWriter writer = new FileWriter("./src/Cipher.txt")) {
            List<String> text = Files.readAllLines(path);  //Read text in file
            String textToString = text.toString().replaceAll("^\\[|\\]$", ""); //Convert text in file to String without buckets
            String result = CaesarCipherASCII.cipherASCII(textToString, 5); // Message coding
            writer.write(result); //Write coded message in created file
        }
    }

    static void bruteDeCipher() throws IOException {

        Path path2 = get("./src/Cipher.txt");

        if (!path2.toFile().exists()) {
            throw new IOException("Something wrong. Check is original file exist.");
        }

        try (FileWriter writer2 = new FileWriter("./src/BruteForce.txt")) {
            List<String> text2 = Files.readAllLines(path2);
            String textToString2 = text2.toString().replaceAll("^\\[|\\]$", "");
            String result2 = BruteForce.bruteForce(BruteForce.varietyList(textToString2));
            writer2.write(result2);
        }
    }

    private static void statisticalDeCipher() throws IOException {
        Path path3 = get("./src/Cipher.txt");

        if (!path3.toFile().exists()) {
            throw new IOException("Something wrong. Check is original file exist.");
        }

        try (FileWriter writer3 = new FileWriter("./src/StatisticalDeCipher.txt")) {
            List<String> text3 = Files.readAllLines(path3);
            String result3 = Statistical.statisticalDeCipher(text3.toString());
            writer3.write(result3);
        }
    }
}
