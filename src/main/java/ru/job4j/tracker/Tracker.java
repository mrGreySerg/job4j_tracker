package ru.job4j.tracker;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    /**
     * ArrayList для хранения заявок.
     */
    private List<Item> items = new ArrayList<Item>();

    /**
     * Метод добавления заявки в хранилище.
     * @param item - новая заявка.
     * @return - объект item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return - уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    /**
     * Метод выводит все существующие объекты.
     * @return - список items.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод выводит список элементов, чьи имена совпадают с назначенным в качестве аргумента.
     * @param key - имя для поиска.
     * @return - список элементов с совпадающим именем.
     */
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<Item>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    /**
     * Метод поиска объекта по уникальному id.
     * @param id - уникальный id.
     * @return - возвращает объект с id, или null, если совпадений нет.
     */
    public Item findById (String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * Метод заменяет заявку с сохранением id.
     * 1. Находим индекс заменяемой ячейки по id.
     * 2. Id со старой заявой назначаем нашей новой заявке.
     * Т.к. при замене нужно сохранять старый id.
     * 3. Удаляем из списка items старую заявку item.
     * 4. Записываем в ячейку с найденным индексом объект item.
     * @param id - id заявки под замену.
     * @param item - новая заявка.
     * @return true.
     */
    public boolean replace(String id, Item item) {
        int cell = indexOf(id);
        boolean result = cell != -1;
        if (result) {
            item.setId(id);
            items.remove(cell);
            items.add(cell, item);
        }
        return result;
    }

    private int indexOf(String id) {
        int result = -1;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = items.indexOf(item);
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет позицию по id.
     * @param id - id удаляемого объекта.
     */
    public boolean delete(String id) {
        int cell = indexOf(id);
        boolean result = cell != -1;
        if (result) {
            items.remove(cell);
        }
        return result;
    }
}
