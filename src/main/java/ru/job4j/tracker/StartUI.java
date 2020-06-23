package ru.job4j.tracker;

import java.util.List;

/**
 * Создает меню выбора для различных действий с tracker.
 */
public class StartUI {

    /**
     * Выводит меню с возможностью выбора дальнейших действий по списку.
     *
     * @param input   - объект типа Input.
     * @param tracker - объект типа Tracker.
     * @param actions - список классов имплементирующих UserAction,
     *                производящих действия с Tracker.
     */
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Печатает меню выбора.
     */
    private void showMenu(List<UserAction> actions) {
        System.out.println(System.lineSeparator() + "Menu.");
        int index = 0;
        for (UserAction action : actions) {
            System.out.println(index + ". " + action.name());
            index++;
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateAction(),
                new PrintAction(),
                new EditAction(),
                new DeleteAction(),
                new FindItemByIdAction(),
                new FindItemByNameAction(),
                new ExitTrackerAction()
        );
        new StartUI().init(validate, tracker, actions);
    }

}
