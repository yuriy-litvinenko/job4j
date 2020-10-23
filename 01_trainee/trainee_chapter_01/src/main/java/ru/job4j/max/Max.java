package ru.job4j.max;

class Max {

    int max(int first, int second) {
        return first > second ? first : second;
    }

    int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
