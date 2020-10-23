package ru.job4j.control;

class GeneralParent {

    static int getParent(int first, int second) {
        first = Math.floorDiv(first, 2);
        second = Math.floorDiv(second, 2);
        int result = first;
        while (first != second) {
            if (first < second) {
                second = Math.floorDiv(second, 2);
            }
            if (first > second) {
                first = Math.floorDiv(first, 2);
            }
            if (first == second) {
                result = first;
            }
        }
        return result;
    }
}
