package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConvertListTest {

    @Test
    public void convertTest() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        List<Integer> input = ConvertList.convert(in);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertThat(input, is(expected));
    }

}