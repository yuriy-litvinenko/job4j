package ru.job4j.chess.figures.white;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;
    private int size, deltaX, deltaY;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Not diagonal move.");
        } else {
            Cell[] steps = new Cell[size];
            for (int index = 0; index < size; index++) {
                steps[index] = Cell(deltaX,deltaY);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        size = source.x - dest.x;
        if (source.x == dest.x + size & source.y == dest.y + size) {
            deltaX = 1;
            deltaY = 1;
            rst = true;
        }
        if (source.x == dest.x + size & source.y == dest.y - size) {
            deltaX = 1;
            deltaY = -1;
            rst = true;
        }
        if (source.x == dest.x - size & source.y == dest.y + size) {
            deltaX = -1;
            deltaY = 1;
            rst = true;
        }
        if (source.x == dest.x - size & source.y == dest.y - size) {
            deltaX = -1;
            deltaY = -1;
            rst = true;
        }
//        if ((source.y == dest.y + size & source.x == dest.x + size)
//                || (source.y == dest.y + size & source.x == dest.x - size)
//                || (source.y == dest.y - size & source.x == dest.x + size)
//                || (source.y == dest.y - size & source.x == dest.x - size)
//                ) {
//            rst = true;
//        }
        return rst;
    }
}
