package ru.job4j.tracker;

/**
 * Создает меню выбора для различных действий с tracker.
 */
public class StartUI {

    /**
     * Выводит меню с возможностью выбора дальнейших действий по списку.
     *
     * @param input   - объект типа Input.
     * @param tracker - объект типа Tracker.
     * @param actions - массив классов имплементирующих UserAction,
     *                производящих действия с Tracker.
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Печатает меню выбора.
     */
    private void showMenu(UserAction[] actions) {
        System.out.println(System.lineSeparator() + "Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        UserAction[] actions = {
                new CreateAction(),
                new PrintAction(),
                new EditAction(),
                new DeleteAction(),
                new FindItemByIdAction(),
                new FindItemByNameAction(),
                new ExitTrackerAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
