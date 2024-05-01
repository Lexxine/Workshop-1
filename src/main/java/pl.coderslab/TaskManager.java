package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    public static String[][] tasks = new String[0][3];

    public static void main(String[] args) {
        loadData();
        selectAnOption();

    }

    public static void loadData() {

        File file = new File("tasks.csv");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String task = scanner.nextLine();
                String[] str = task.split(",");
                int rows = tasks.length;
                tasks = Arrays.copyOf(tasks, rows + 1);
                tasks[rows] = new String[3];
                for (int i = 0; i < 3 && i < str.length; i++) {
                    tasks[rows][i] = str[i].trim();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }


    public static void selectAnOption() {

        System.out.println(ConsoleColors.BLUE + "Please select an option:" + ConsoleColors.RESET);
        String[] selectionArray = {"add", "remove", "list", "exit"};
        for (String s : selectionArray) {
            System.out.println(s);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "list":
                    for (String[] row : tasks) {
                        for (String element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "exit":
                    exit("tasks.csv");
                    System.out.println(ConsoleColors.RED + "Bye, bye.");
                    return;

                default:
                    System.out.println("Please select a correct option.");
            }
        }
    }

    public static void addTask() {
        Scanner scanner = new Scanner(System.in);
        int rows = tasks.length;
        tasks = Arrays.copyOf(tasks, rows + 1);
        tasks[rows] = new String[3];
        System.out.println("Please add task description");
        String description = scanner.nextLine();
        tasks[rows][0] = description;
        System.out.println("Please add task due date");
        String date = scanner.nextLine();
        tasks[rows][1] = date;
        System.out.println("Is your task important: true/false");
        String importance = scanner.nextLine();
        tasks[rows][2] = importance;

    }

    public static void removeTask() {
        while (true) {
            System.out.println("Please select number of task to remove.");
            Scanner scanner = new Scanner(System.in);
            try {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Please select a number.");
                }
                int taskNumber = scanner.nextInt();
                tasks = ArrayUtils.remove(tasks, taskNumber - 1);
                System.out.println("Task was successfully deleted.");
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please select correct option");

            }
        }
    }

    public static void exit(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            System.out.println("plik nie istnieje");
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.out.println("Błąd podczas tworzenia pliku");
            }
            return;
        }
        try (PrintWriter pw = new PrintWriter("tasks.csv")) {
            for (String[] row : tasks) {
                for (int i = 0; i < row.length; i++) {
                    pw.print(row[i]);
                    if (i < row.length - 1) {
                       pw.print(",");
                   }
                }
                pw.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Błąd przy zapisie");
        }
    }
}

