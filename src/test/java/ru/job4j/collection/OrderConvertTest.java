package ru.job4j.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("1"), is(new Order("1", "dress")));
    }

    @Test
    public void whenProcess2Orders() {
        Order firstOrder = new Order("1", "Dress");
        Order secondOrder = new Order("2", "Lamp");
        List<Order> orders = List.of(firstOrder, secondOrder);
        HashMap<String, Order> expected = new HashMap<>();
        expected.put(firstOrder.getNumber(), firstOrder);
        expected.put(secondOrder.getNumber(), secondOrder);
        HashMap<String, Order> result = OrderConvert.process(orders);
        assertThat(result, is(expected));
    }

}