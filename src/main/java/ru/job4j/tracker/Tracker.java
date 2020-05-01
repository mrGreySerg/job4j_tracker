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
        Item[] temp = new Item[items.length];
        int size = 0;
        for (int index = 0; index < position; index++) {
            if (items[index] != null) {
                temp[size] = items[index];
                size++;
            }
        }
        temp = Arrays.copyOf(temp, size);
        return temp;
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

    public void replace(String id, Item item) {
        int cell = indexOf(id);
        items[cell].setName(item.getName());
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
}
