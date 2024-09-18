package com.example;

import java.util.List;

public class Cat {

    Predator predator;

    public Cat(Feline feline) {
        this.predator = feline;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

    public String getSound() {
        return "Мяу";
    }
}
