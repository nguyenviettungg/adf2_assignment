package human_resource;

import human_resource.view.ConsoleView;

public class MainThread {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        view.generateMenu();
    }
}
