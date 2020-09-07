package ru.job4j.lambda;

public class Attachment {

    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "Attachment{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }

}
