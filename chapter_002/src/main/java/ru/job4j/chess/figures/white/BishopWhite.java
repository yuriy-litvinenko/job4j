package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int size = source.x - dest.x;
        Cell[] steps = new Cell[size];
        if ((source.y == dest.y + size & source.x == dest.x + size)
                || (source.y == dest.y + size & source.x == dest.x - size)
                || (source.y == dest.y - size & source.x == dest.x + size)
                || (source.y == dest.y - size & source.x == dest.x - size)
                ) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
