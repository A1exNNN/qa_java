package com.example;

import java.util.List;

public interface Predator {

    List<String> eatMeat() throws Exception;
    // throws — ключевое слово, используется в сигнатуре метода
    // для предупреждения о том, что метод может выбросить исключение.
}
