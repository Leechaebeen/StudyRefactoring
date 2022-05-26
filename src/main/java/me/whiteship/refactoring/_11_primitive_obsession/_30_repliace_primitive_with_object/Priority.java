package me.whiteship.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;

public class Priority {
    private String value;

    private List<String> legalValues = List.of("low", "normal", "high", "rush");

    public Priority(String value) {
        if(!legalValues.contains(value)){
            throw new IllegalArgumentException("Illegal value for priority " + value);
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    private int index() {
        return this.legalValues.indexOf(this.value);
    }

    public boolean isHigherThan(Priority other) {
        return this.index() > other.index();
    }


}
