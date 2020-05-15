package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidImport() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        String[] data = {"one", "1"};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter");
        assertThat(
                mem.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(out);
    }

    @Test
    public void whenMaxValue() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(output));
        String[] data = {"9"};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter", 6);
        assertThat(
                output.toString(),
                is(String.format("Please select key from menu.%n"))
        );
        System.setOut(out);
    }
}