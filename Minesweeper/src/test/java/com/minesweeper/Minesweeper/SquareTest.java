package com.minesweeper.Minesweeper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void getCharValue() {
        Square s = new Square();
        s.setValue(-1);
        s.setVisible(true);
        assertEquals('*',s.getCharValue());
    }

    @Test
    void getIsItAMine() {
        Square s = new Square();
        s.setIsItAMine(1);
        assertEquals(1,s.getIsItAMine());
    }
}