package ru.job4j.gc;

public class User {
    private byte[] obj;

    User(int size) {
        obj = new byte[size];
        System.out.println("New object created");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Object garbage collected");
    }
}
