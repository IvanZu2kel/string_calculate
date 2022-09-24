package org.example;


import org.example.project.Handler;

import java.util.Scanner;

import static org.example.project.Handler.FLAG;

public class StringCalcApp {
    private static final Handler handler = new Handler();

    public static void main(String[] args) {
        System.out.println("Чтобы выйти из приложения введите: Выход ");
        while (FLAG) {
            System.out.print("Input: ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                try {
                    String line = scanner.nextLine();
                    if (line.equalsIgnoreCase("Выход")) {
                        FLAG = false;
                    } else {
                        handler.handle(line);
                        System.out.println("-------------------------------");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FLAG = false;
                }
            }
        }
    }
}
