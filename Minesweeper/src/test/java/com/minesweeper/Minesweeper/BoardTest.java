package com.minesweeper.Minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {


    @Test
    void visitASquare() {
        Board board = new Board(3,1);
        board.setBoard(1,1);
        board.visitASquare(0,1);
        assertEquals(true,board.getASquare(0,1).isVisible());
    }


    @Test
    void setBoard() {
        Board board = new Board(2,2);
        board.setBoard(0,0);
        assertEquals(2, board.getASquare(0,0).getValue());
    }

    @Test
    void makeAllVisible() {
        Board board = new Board(4,1);
        board.makeAllVisible();
        board.visitASquare(1,1);
        assertEquals(16,board.getNumberOfVisibleSquares());
    }
}