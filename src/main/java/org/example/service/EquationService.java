package org.example.service;

import org.example.repository.EquationRepository;

import static org.example.parser.EquationParser.evaluateExpression;

public class EquationService  {

    EquationRepository repository = new EquationRepository();

    public void saveEquation(String equation) {
        repository.saveEquation(equation);
    }

    public void saveRoot(double root) {
        repository.saveRoot(root);
    }

    public void findEquationByRoot(double root) {
        repository.findEquationsByRoot(root);
    }

    public void evaluateEquations(String equation, double value) {
        evaluateExpression(equation, value);
    }
}
