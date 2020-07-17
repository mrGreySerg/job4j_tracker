package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class JobDescByNameDecreaseTest {

    @Test
    public void whenSortedByDecreaseName() {
        Job fix = new Job("fix", 1);
        Job read = new Job("read", 2);
        Job write = new Job("write", 3);
        List<Job> jobs = Arrays.asList(write, fix, read);
        List<Job> expected = Arrays.asList(write, read, fix);
        Collections.sort(jobs, new JobDescByNameDecrease());
        assertThat(jobs, is(expected));
    }

    @Test
    public void multiSort() {
        Job fix1 = new Job("fix", 1);
        Job fix2 = new Job("fix", 2);
        Job fix3 = new Job("fix", 3);
        Job read = new Job("read", 2);
        List<Job> jobs = Arrays.asList(fix3, fix1, read, fix2);
        Comparator<Job> multi = new JobDescByNameDecrease()
                .thenComparing(new JobDescByPriorityDecrease());
        Collections.sort(jobs, multi);
        List<Job> expected = Arrays.asList(read, fix3, fix2, fix1);
        assertThat(jobs, is(expected));
    }

}