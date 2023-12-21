package org.example.service;

import org.example.repository.EquationRepository;

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

}
