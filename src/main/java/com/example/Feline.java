package com.example;

import java.util.List;

// extends в Java означает создание подкласса, который наследует свойства и методы из суперкласса.
// implements означает реализацию интерфейса.
public class Feline extends Animal implements Predator {

    private Animal animal;

    // Добавляю конструктор
    public Feline(Animal animal) {
        this.animal = animal;
    }

    //  Добавляю аннотации, которые указывают, что элемент подкласса переопределяет элемент родительского класса
    @Override
    public List<String> eatMeat() throws Exception {
        return animal.getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(3);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}


// При использовании extends подкласс получает доступ ко всем открытым свойствам и методам суперкласса.
// Интерфейс — это шаблон, который может содержать только абстрактные методы и константы.
// Чтобы получить доступ к методам интерфейса, его нужно реализовать в другом классе с помощью ключевого слова implements.
// При этом класс должен предоставить реализацию для всех методов, объявленных в интерфейсе.

