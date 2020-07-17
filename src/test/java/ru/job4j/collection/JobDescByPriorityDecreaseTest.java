package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobDescByPriorityDecreaseTest {

    @Test
    public void whenSortedByPriorityDecrease() {
        Job fix = new Job("fix", 1);
        Job read = new Job("read", 2);
        Job write = new Job("write", 3);
        List<Job> jobs = Arrays.asList(fix, read, write);
        Collections.sort(jobs, new JobDescByPriorityDecrease());
        List<Job> expected = Arrays.asList(write, read, fix);
        assertThat(jobs, is(expected));
    }

    @Test
    public void multiSort() {
        Job fix1 = new Job("fix1", 1);
        Job fix2 = new Job("fix2", 1);
        Job fix3 = new Job("fix3", 1);
        Job read = new Job("read", 2);
        List<Job> jobs = Arrays.asList(fix3, fix1, read, fix2);
        Comparator<Job> multi = new JobDescByPriorityDecrease()
                .thenComparing(new JobDescByNameDecrease());
        Collections.sort(jobs, multi);
        List<Job> expected = Arrays.asList(read, fix3, fix2, fix1);
        assertThat(jobs, is(expected));
    }

}