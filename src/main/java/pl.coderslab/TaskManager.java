package pl.coderslab;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        selectAnOption();

    }
   public static String[][] tasks = new String[0][3];
    public static String[][] loadData() {

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
        return tasks;
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
                    // removeTask();
                    break;
                case "list":
                    for (String[] row : loadData()) {
                        for (String element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "exit":
                    //exit();
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
        }
    }
    public static void addTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
        String description = scanner.nextLine();
        add(description);
        System.out.println("Please add task due date");
        String date = scanner.nextLine();
        add(date);
        System.out.println("Is your task important: true/false");
        String importance = scanner.nextLine();
        add(importance);

    }
    public static void add(String element){
        String[] task = new String[0];
        task = Arrays.copyOf(task, task.length +1);
        task[task.length-1] =  element;
    }
}
