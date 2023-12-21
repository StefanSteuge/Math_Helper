package org.example.controller;

import org.example.service.EquationService;

import java.util.Scanner;

import static org.example.util.Constants.FINALE_MESSAGE;
import static org.example.util.Constants.MESSAGE_TO_THE_READERS;
import static org.example.validator.EquationValidator.isValidEquation;

public class EquationController {
    EquationService service = new EquationService();
    static Scanner scanner = new Scanner(System.in);


    String input = scanner.nextLine();

    public void run() {

        while (!input.equalsIgnoreCase("exit")) {
            switch (input) {
                case "1" -> {
                    System.out.println("Введіть математичне рівняння:");
                    saveEquation();
                }
                case "2" -> {
                    System.out.print("Введіть корінь рівняння: ");
                    service.saveRoot(getRoot());
                }
                case "3" -> service.findEquationByRoot(getRoot());

                //case "4" -> service.evaluateEquations(equation, getRoot());
            }
            System.out.println(MESSAGE_TO_THE_READERS);
            input = scanner.nextLine();
        }
        System.out.println(FINALE_MESSAGE);
    }

    public void saveEquation() {
        String equation = scanner.nextLine();

        if (isValidEquation(equation)) {
            System.out.println("Рівняння коректне. Збереження....");
            service.saveEquation(equation);
        } else {
            System.out.println("Некоректне рівняння. Спробуйте ще раз.");
        }
    }


    public double getRoot() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Некоректний ввід. Введіть корінь рівняння: ");
            scanner.next();
        }

        double root = scanner.nextDouble();
        scanner.nextLine();

        return root;
    }

}
