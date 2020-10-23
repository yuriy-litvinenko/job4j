package ru.job4j.array;

/**
 * Задание 6.4. Слова начинается с ...
 * @author Юрий Литвиненко
 * @since 22.06.2018
 */
class ArrayChar {
    private char[] data;

    ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // Проверяем, что длина префикса не превышает длину строки
        if (data.length >= value.length) {
            // проверить. что массив data имеет первые элементы одинаковые с value
            for (int index = 0; index < value.length; index++) {
                if (value[index] != data[index]) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
