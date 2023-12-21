package org.example.validator;

public class Temp {

        // Приклад рівняння: x^2 - 5x + 6 = 0
        public static double equation(double x) {
            return x * x - 5 * x + 6;
        }

        public static double findRoot(double lowerBound, double upperBound, double tolerance) {
            double currentGuess = (lowerBound + upperBound) / 2;

            while (Math.abs(equation(currentGuess)) > tolerance) {
                if (equation(currentGuess) * equation(lowerBound) < 0) {
                    upperBound = currentGuess;
                } else {
                    lowerBound = currentGuess;
                }

                currentGuess = (lowerBound + upperBound) / 2;
            }

            return currentGuess;
        }

        public static void main(String[] args) {
            double root = findRoot(1, 4, 1e-9);

            System.out.println("Числовий корінь рівняння: " + root);
            System.out.println("Значення лівої частини рівняння при x=" + root + ": " + equation(root));
            System.out.println("Похибка: " + Math.abs(equation(root)));
        }
    }
