package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Equation {

    private long id;
    private String equation;

    public Equation(String equation) {
        this.equation = equation;
    }

    public Equation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equation equation1 = (Equation) o;
        return Objects.equals(id, equation1.id) && Objects.equals(equation, equation1.equation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, equation);
    }

    @Override
    public String toString() {
        return "Equation{" +
                "id=" + id +
                ", equation='" + equation + '\'' +
                '}';
    }
}
