import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "sample.txt";

        while (true) {
            System.out.println("\nFile Handling Utility");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    writeFile(filename, scanner);
                    break;
                case 2:
                    readFile(filename);
                    break;
                case 3:
                    modifyFile(filename, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void writeFile(String filename, Scanner scanner) {
        try {
            FileWriter writer = new FileWriter(filename, false);
            System.out.print("Enter text to write to file: ");
            String content = scanner.nextLine();
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void readFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String line;
            System.out.println("File content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void modifyFile(String filename, Scanner scanner) {
        try {
            System.out.print("Enter new content to append: ");
            String newContent = scanner.nextLine();
            FileWriter writer = new FileWriter(filename, true);
            writer.write("\n" + newContent);
            writer.close();
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
