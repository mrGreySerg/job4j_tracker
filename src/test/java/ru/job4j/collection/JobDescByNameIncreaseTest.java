package ru.job4j.collection;

import org.junit.Test;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobDescByNameIncreaseTest {

    @Test
    public void whenSortedByNameIncrease() {
        Job fix = new Job("fix", 1);
        Job read = new Job("read", 2);
        Job write = new Job("write", 3);
        List<Job> jobs = Arrays.asList(write, read, fix);
        Collections.sort(jobs, new JobDescByNameIncrease());
        List<Job> expected = List.of(fix, read, write);
        assertThat(jobs, is(expected));
    }

    @Test
    public void multiSort() {
        Job fix1 = new Job("fix", 1);
        Job fix2 = new Job("fix", 2);
        Job fix3 = new Job("fix", 3);
        Job read = new Job("read", 2);
        List<Job> jobs = Arrays.asList(fix3, fix1, read, fix2);
        Comparator<Job> multi = new JobDescByNameIncrease()
                .thenComparing(new JobDescByPriorityIncrease());
        Collections.sort(jobs, multi);
        List<Job> expected = List.of(fix1, fix2, fix3, read);
        assertThat(jobs, is(expected));
    }

}