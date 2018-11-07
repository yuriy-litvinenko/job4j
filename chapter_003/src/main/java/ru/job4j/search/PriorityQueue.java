package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        boolean result = false;
        if (!tasks.isEmpty()) {
            for (int index = 0; index < tasks.size(); index++) {
                if (task.getPriority() <= tasks.get(index).getPriority()) {
                    tasks.add(index, task);
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
