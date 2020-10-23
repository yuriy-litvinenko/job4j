package ru.job4j.list;

class SimpleQueue<T> {

    private SimpleStack<T> in = new SimpleStack<>();
    private SimpleStack<T> out = new SimpleStack<>();

    T poll() {
        if (out.getSize() == 0) {
            reload();
        }
        return out.poll();
    }

    void push(T value) {
        in.push(value);
    }

    private void reload() {
        while (in.getSize() > 0) {
            out.push(in.poll());
        }
    }
}
