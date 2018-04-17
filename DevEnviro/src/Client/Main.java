package Client;

import lib.GUI.Application;

public class Main {

    public static void main(String[] args) {
        Application app = new Application(new LanguageElementFactory());
        app.start();
    }
}
