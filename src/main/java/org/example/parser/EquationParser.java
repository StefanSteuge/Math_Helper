package org.example.parser;

import java.util.Stack;

public class EquationParser {

    public static double evaluateExpression(String expression, Double variableValue) {

        Stack<Double> numbers = new Stack<>();

        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == 'x' && variableValue != null) {
                numbers.push(variableValue);
            } else if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();

                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (ch == '(' || ch == '√') {
                operations.push(ch);
            } else if (ch == ')') {

                while (!operations.isEmpty() && operations.peek() != '(') {
                    numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.isEmpty() ? 0 : numbers.pop()));
                }

                if (!operations.isEmpty()) {
                    operations.pop();
                }

                if (!operations.isEmpty() && operations.peek() == '√') {
                    operations.pop();
                    numbers.push(Math.sqrt(numbers.pop()));
                }
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                if ((ch == '+' || ch == '-') && (i == 0 || expression.charAt(i - 1) == '(')) {
                    numbers.push(0.0); // Для виразів типу "-x" або "(-x)"            }

                    while (!operations.isEmpty() && hasPrecedence(ch, operations.peek())) {
                        numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.isEmpty() ? 0 : numbers.pop()));
                    }

                    operations.push(ch);
                }
            }

            while (!operations.isEmpty()) {
                numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.isEmpty() ? 0 : numbers.pop()));
            }
        }

        return numbers.pop();
    }

    public static double applyOperation(char operation, double b, double a) {
        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                yield a / b;
            }
            default -> 0;
        };
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == '√') {
            return false;
        }
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }
}

