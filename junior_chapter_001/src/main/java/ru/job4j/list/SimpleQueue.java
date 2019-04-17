package ru.job4j.list;

public class SimpleQueue<T> {

    private LinkedListContainer<SimpleStack<T>> stackList = new LinkedListContainer<>();

    public SimpleQueue() {
        stackList.add(new SimpleStack<>());
        stackList.add(new SimpleStack<>());
    }

    public T poll() {
        if (stackList.get(1).getSize() == 0) {
            reload();
        }
        return stackList.get(1).poll();
    }

    public void push(T value) {
        stackList.get(0).push(value);
    }

    private void reload() {
        while (stackList.get(0).getSize() > 0) {
            stackList.get(1).push(stackList.get(0).poll());
        }
    }
}
