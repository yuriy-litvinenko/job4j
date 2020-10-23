package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NodeHasCycleTest {

    @SuppressWarnings("unchecked")
    @Test
    public void whenCycleIsInTheEndOfSequenceThenGetTrue() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        assertThat(Node.hasCycle(first), is(true));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void whenCycleIsAtTheMiddleOfSequenceThenGetTrue() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        first.next = second;
        second.next = third;
        third.next = second;
        assertThat(Node.hasCycle(first), is(true));
    }
}
