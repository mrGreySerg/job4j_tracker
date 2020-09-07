package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class AttachmentSort {

    public static void main(String[] args) {
        List<Attachment> myList = Arrays.asList(
                new Attachment("image1", 100),
                new Attachment("image2", 34),
                new Attachment("image3", 13)
        );
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        myList.sort(comparator);
        System.out.println(myList);
        Comparator<Attachment> nameCompare = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        myList.sort(nameCompare);
        System.out.println(myList);
    }

}
