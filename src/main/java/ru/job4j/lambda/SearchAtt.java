package ru.job4j.lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class SearchAtt {

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> func) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att : list) {
            if (func.test(att)) {
                result.add(att);
            }
        }
        return result;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> item = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, item);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> item = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, item);
    }

}
