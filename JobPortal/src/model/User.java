package JobPortal.src.model;

import java.util.Scanner;

public abstract class User {
    protected int id;
    protected String name;
    protected Scanner sc = new Scanner(System.in);

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void showMenu();
}
