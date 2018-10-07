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
        Cell[] steps;
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Not diagonal move.");
        } else {
            steps = new Cell[size];
            for (int index = 0; index < size; index++) {
                steps[index] = getCell(source.x + deltaX + index, source.y + deltaY + index);
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

    public Cell getCell(int x, int y) {
        Cell cell = null;
        if (x == 0 && y == 7) {cell = Cell.A1;}
        if (x == 0 && y == 6) {cell = Cell.A2;}
        if (x == 0 && y == 5) {cell = Cell.A3;}
        if (x == 0 && y == 4) {cell = Cell.A4;}
        if (x == 0 && y == 3) {cell = Cell.A5;}
        if (x == 0 && y == 2) {cell = Cell.A6;}
        if (x == 0 && y == 1) {cell = Cell.A7;}
        if (x == 0 && y == 0) {cell = Cell.A8;}
        if (x == 1 && y == 7) {cell = Cell.B1;}
        if (x == 1 && y == 6) {cell = Cell.B2;}
        if (x == 1 && y == 5) {cell = Cell.B3;}
        if (x == 1 && y == 4) {cell = Cell.B4;}
        if (x == 1 && y == 3) {cell = Cell.B5;}
        if (x == 1 && y == 2) {cell = Cell.B6;}
        if (x == 1 && y == 1) {cell = Cell.B7;}
        if (x == 1 && y == 0) {cell = Cell.B8;}
        if (x == 2 && y == 7) {cell = Cell.C1;}
        if (x == 2 && y == 6) {cell = Cell.C2;}
        if (x == 2 && y == 5) {cell = Cell.C3;}
        if (x == 2 && y == 4) {cell = Cell.C4;}
        if (x == 2 && y == 3) {cell = Cell.C5;}
        if (x == 2 && y == 2) {cell = Cell.C6;}
        if (x == 2 && y == 1) {cell = Cell.C7;}
        if (x == 2 && y == 0) {cell = Cell.C8;}
        if (x == 3 && y == 7) {cell = Cell.D1;}
        if (x == 3 && y == 6) {cell = Cell.D2;}
        if (x == 3 && y == 5) {cell = Cell.D3;}
        if (x == 3 && y == 4) {cell = Cell.D4;}
        if (x == 3 && y == 3) {cell = Cell.D5;}
        if (x == 3 && y == 2) {cell = Cell.D6;}
        if (x == 3 && y == 1) {cell = Cell.D7;}
        if (x == 3 && y == 0) {cell = Cell.D8;}
        if (x == 4 && y == 7) {cell = Cell.E1;}
        if (x == 4 && y == 6) {cell = Cell.E2;}
        if (x == 4 && y == 5) {cell = Cell.E3;}
        if (x == 4 && y == 4) {cell = Cell.E4;}
        if (x == 4 && y == 3) {cell = Cell.E5;}
        if (x == 4 && y == 2) {cell = Cell.E6;}
        if (x == 4 && y == 1) {cell = Cell.E7;}
        if (x == 4 && y == 0) {cell = Cell.E8;}
        if (x == 5 && y == 7) {cell = Cell.F1;}
        if (x == 5 && y == 6) {cell = Cell.F2;}
        if (x == 5 && y == 5) {cell = Cell.F3;}
        if (x == 5 && y == 4) {cell = Cell.F4;}
        if (x == 5 && y == 3) {cell = Cell.F5;}
        if (x == 5 && y == 2) {cell = Cell.F6;}
        if (x == 5 && y == 1) {cell = Cell.F7;}
        if (x == 5 && y == 0) {cell = Cell.F8;}
        if (x == 6 && y == 7) {cell = Cell.G1;}
        if (x == 6 && y == 6) {cell = Cell.G2;}
        if (x == 6 && y == 5) {cell = Cell.G3;}
        if (x == 6 && y == 4) {cell = Cell.G4;}
        if (x == 6 && y == 3) {cell = Cell.G5;}
        if (x == 6 && y == 2) {cell = Cell.G6;}
        if (x == 6 && y == 1) {cell = Cell.G7;}
        if (x == 6 && y == 0) {cell = Cell.G8;}
        if (x == 7 && y == 7) {cell = Cell.H1;}
        if (x == 7 && y == 6) {cell = Cell.H2;}
        if (x == 7 && y == 5) {cell = Cell.H3;}
        if (x == 7 && y == 4) {cell = Cell.H4;}
        if (x == 7 && y == 3) {cell = Cell.H5;}
        if (x == 7 && y == 2) {cell = Cell.H6;}
        if (x == 7 && y == 1) {cell = Cell.H7;}
        if (x == 7 && y == 0) {cell = Cell.H8;}
        return cell;
    }
}
