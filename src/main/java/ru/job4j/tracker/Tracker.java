package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище.
     * @param item - новая заявка.
     * @return - объект item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
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
     * Метод выводит все существующие объекты (!= null) из массива items.
     * @return массив объектов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Метод выводит массив элементов, чьи имена совпадают с назначенным в качестве аргумента.
     * @param key - имя для поиска.
     * @return - массив элементов с совпадающим именем.
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[items.length];
        int size = 0;
        for (int index = 0; index < position; index++) {
            if (items[index].getName().equals(key)) {
                temp[size] = items[index];
                size++;
            }
        }
        temp = Arrays.copyOf(temp, size);
        return temp;
    }

    /**
     * Метод поиска объекта по уникальному id.
     * @param id - уникальный id.
     * @return - возвращает объект с id, или null, если совпадений нет.
     */
    public Item findById (String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * Метод заменяет заявку с сохранением id.
     * 1. Находим индекс заменяемой ячейки по id.
     * 2. Id со старой заявой назначаем нашей новой заявке.
     * Т.к. при замене нужно сохранять старый id.
     * 3. Записываем в ячейку с найденным индексом объект item.
     * @param id - id заявки под замену.
     * @param item - новая заявка.
     * @return true.
     */
    public boolean replace(String id, Item item) {
        int cell = indexOf(id);
        item.setId(id);
        items[cell] = item;
        return true;
    }

    private int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет позицию по id.
     * @param id - id удаляемого объекта.
     */
    public void delete(String id) {
        int cell = indexOf(id);
        System.arraycopy(items, cell + 1, items, cell, position - cell);
        items[position - 1] = null;
        position--;
    }
}
