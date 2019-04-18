package ru.job4j.list;

public class Node<T> {
    private T value;
    Node<T> next;

    Node(T value) {
        this.value = value;
    }

    static boolean hasCycle(Node first) {
        Node tmp1 = first;
        Node tmp2 = first;

        while (tmp2 != null && tmp2.next != null) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next.next;
            if (tmp1 == tmp2) {
                return true;
            }
        }
        return false;
    }
}
