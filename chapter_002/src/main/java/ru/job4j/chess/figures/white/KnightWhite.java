package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightWhite implements Figure {
    private final Cell position;

    public KnightWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if ((source.y == dest.y + 2 & source.x == dest.x + 1)
                || (source.y == dest.y + 2 & source.x == dest.x - 1)
                || (source.y == dest.y + 1 & source.x == dest.x + 2)
                || (source.y == dest.y + 1 & source.x == dest.x - 2)
                || (source.y == dest.y - 2 & source.x == dest.x + 1)
                || (source.y == dest.y - 2 & source.x == dest.x - 1)
                || (source.y == dest.y - 1 & source.x == dest.x + 2)
                || (source.y == dest.y - 1 & source.x == dest.x - 2)
                ) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
