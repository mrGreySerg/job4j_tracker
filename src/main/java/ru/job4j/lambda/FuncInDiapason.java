package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FuncInDiapason {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (double i = start; i < end; i++) {
            double result = func.apply(i);
            list.add(result);
        }
        return list;
    }

}
