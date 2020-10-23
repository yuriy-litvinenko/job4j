package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void bishopBlackTestWay1() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Cell[] actual = bishop.way(bishop.position(), Cell.H8);
        Cell[] expected = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopBlackTestWay2() {
        BishopBlack bishop = new BishopBlack(Cell.H1);
        Cell[] actual = bishop.way(bishop.position(), Cell.A8);
        Cell[] expected = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopBlackTestWay3() {
        BishopBlack bishop = new BishopBlack(Cell.A8);
        Cell[] actual = bishop.way(bishop.position(), Cell.H1);
        Cell[] expected = {Cell.B7, Cell.C6, Cell.D5, Cell.E4, Cell.F3, Cell.G2, Cell.H1};
        assertThat(actual, is(expected));
    }

    @Test
    public void bishopBlackTestWay4() {
        BishopBlack bishop = new BishopBlack(Cell.H8);
        Cell[] actual = bishop.way(bishop.position(), Cell.A1);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1};
        assertThat(actual, is(expected));
    }
}
