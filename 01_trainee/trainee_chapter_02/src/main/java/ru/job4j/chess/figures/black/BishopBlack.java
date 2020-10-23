package ru.job4j.chess.figures.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;
    private int size, deltaX, deltaY;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps;
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Not diagonal move.");
        } else {
            steps = new Cell[Math.abs(size)];
            for (int index = 0, stepX = deltaX, stepY = deltaY; index < steps.length; index++, stepX = stepX + deltaX, stepY = stepY + deltaY) {
                steps[index] = getCell(source.x + stepX, source.y + stepY);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean rst = false;
        if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            deltaX = (source.x > dest.x) ? -1 : 1;
            deltaY = (source.y > dest.y) ? -1 : 1;
            size = source.x - dest.x;
            rst = true;
        }
        return rst;
    }

    private Cell getCell(int x, int y) {
        Cell cellRes = null;
        for (Cell cell: Cell.values()) {
            if (cell.x == x && cell.y == y) {
                cellRes = cell;
            }
        }
        return cellRes;
    }
}
