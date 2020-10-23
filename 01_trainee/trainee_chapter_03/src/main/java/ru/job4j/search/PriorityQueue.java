package ru.job4j.search;

import java.util.LinkedList;

class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    void put(Task task) {
        var result = false;
        if (!tasks.isEmpty()) {
            for (var index = 0; index < tasks.size(); index++) {
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

    Task take() {
        return this.tasks.poll();
    }
}
