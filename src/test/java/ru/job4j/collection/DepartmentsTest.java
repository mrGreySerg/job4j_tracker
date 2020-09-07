package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class DepartmentsTest {

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("K1/SK1");
        List<String> expect = Arrays.asList("K1", "K1/SK1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNoneChange() {
        List<String> input = Arrays.asList("K1", "K1/SK1");
        List<String> expect = Arrays.asList("K1", "K1/SK1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortAsc() {
        List<String> input = Arrays.asList("K2", "K1/SK1", "K2/SK1", "K1");
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K2", "K2/SK1");
        Collections.sort(input, new DepIncreaseComp());
        assertThat(input, is(expect));
    }

    @Test
    public void sortDesc() {
        List<String> input = Arrays.asList("K2", "K1/SK1", "K1/SK2", "K2/SK2", "K2/SK1", "K1");
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK2", "K1", "K1/SK1", "K1/SK2");
        Departments.sortDesc(input);
        assertThat(input, is(expect));
    }

}