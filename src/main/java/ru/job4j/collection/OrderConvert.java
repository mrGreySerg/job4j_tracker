package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

/**
 * Конвертирует список заявок в коллекцию HashMap.
 * Ключ - номер заявки, значение - сама заявка.
 * @author Kustrin Sergei.
 * @version 1.0.
 */
public class OrderConvert {

    /**
     * Конвертер списка заявок в коллекцию HashMap.
     * @param orders - список заявок.
     * @return - коллекция HashMap.
     */
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }

}
