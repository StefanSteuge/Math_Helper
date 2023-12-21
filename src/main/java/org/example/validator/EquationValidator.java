package org.example.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.util.Constants.EQUATION_REGEX_2;

public class EquationValidator {

    public static boolean isValidEquation(String equation) {
        if (equation == null || equation.trim().isEmpty()) {
            System.out.println("Рівняння не може бути порожнім.");
            return false;
        }

        if (!isBracketPlacementCorrect(equation)) {
            System.out.println("Некоректне розміщення дужок у рівнянні.");
            return false;
        }

        if (!isExpressionValid(equation)) {
            System.out.println("Некоректно введений вираз у рівнянні.");
            return false;
        }

        return true;
    }

    private static boolean isBracketPlacementCorrect(String equation) {
        int count = 0;
        for (char c : equation.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    private static boolean isExpressionValid(String equation) {
        Pattern pattern = Pattern.compile(EQUATION_REGEX_2);
        Matcher matcher = pattern.matcher(equation);
        return !matcher.matches();
    }
}
