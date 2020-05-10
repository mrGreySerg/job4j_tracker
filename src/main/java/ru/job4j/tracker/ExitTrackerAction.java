package ru.job4j.tracker;

public class ExitTrackerAction implements UserAction {

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String answer = input.askStr("Do you really want to exit: (yes/no) ");
        boolean run = answer.equals("yes") ? false : true;
        return run;
    }
}
