package ru.job4j.generic;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
abstract class Base {
    private final String id;

    Base(final String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }
}
