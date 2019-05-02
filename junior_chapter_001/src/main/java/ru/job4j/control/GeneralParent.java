package ru.job4j.control;

class GeneralParent {

    static int getParent(int first, int second) {
        first = Math.round(first / 2);
        second = Math.round(second / 2);
        int result = first;
        while (first != second) {
            if (first < second) {
                second = Math.round(second / 2);
            }
            if (first > second) {
                first = Math.round(first / 2);
            }
            if (first == second) {
                result = first;
            }
        }
        return result;
    }
}
