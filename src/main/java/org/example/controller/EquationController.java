package org.example.controller;

import org.example.service.EquationService;

import java.util.Scanner;

import static org.example.validator.EquationValidator.isValidEquation;

public class EquationController {
    EquationService service = new EquationService();
    static Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Введіть математичне рівняння:");
        while (true) {
            String equation = scanner.nextLine();
            if (isValidEquation(equation)) {
                System.out.println("Рівняння коректне. Збереження....");
                service.saveEquation(equation);
            } else {
                System.out.println("Некоректне рівняння. Спробуйте ще раз.");
            }
        }

    }

    public static double getRoot() {
        System.out.print("Введіть корінь рівняння: ");

        while (!scanner.hasNextDouble()) {
            System.out.print("Некоректний ввід. Введіть корінь рівняння: ");
            scanner.next();
        }

        double root = scanner.nextDouble();
        scanner.nextLine();

        return root;
    }

}
