package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Root {

    private final Long id;
    private Long equationId;
    private double value;

    public Root(Long id, Long equationId, double value) {
        this.id = id;
        this.equationId = equationId;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Root root = (Root) o;
        return Double.compare(value, root.value) == 0 && Objects.equals(id, root.id) && Objects.equals(equationId, root.equationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, equationId, value);
    }

    @Override
    public String toString() {
        return "Root{" +
                "id=" + id +
                ", equationId=" + equationId +
                ", value=" + value +
                '}';
    }
}
