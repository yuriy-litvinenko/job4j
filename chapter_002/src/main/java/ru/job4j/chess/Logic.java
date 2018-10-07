package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws FigureNotFoundException, ImpossibleMoveException, OccupiedWayException {
        boolean rst = false;
        try {
            int index = this.findBy(source);
            figureCheck(index);
            Cell[] steps = this.figures[index].way(source, dest);
            stepsValidate(steps);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        } catch (FigureNotFoundException fnf) {
            System.out.println("Figure not found.");
        } catch (ImpossibleMoveException ime) {
            System.out.println("This is impossible move.");
        } catch (OccupiedWayException owe) {
            System.out.println("Figure Way is occupied.");
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    private void stepsValidate(Cell[] steps) {
        for (Cell cell : steps) {
            if (findBy(cell) != -1) {
                throw new OccupiedWayException("Array has not empty cells.");
            }
        }
    }

    private void figureCheck(int index) {
        if (index == -1) {
            throw new FigureNotFoundException("Out of range.");
        }
    }
}
