package com.minesweeper.Minesweeper;

public class Square {
    private int isItAMine;
    private int value;
    private boolean visible;

    public Square() {
        value = 0;
        isItAMine = 0;
        visible = false;
    }

    public char getCharValue() {
        if(!visible) return '_';
        else {
            if (value == -1) return '*';
            else return (char) (value + '0');
        }
    }

    public int getIsItAMine() {
        return isItAMine;
    }

    public void setIsItAMine(int isItAMine) {
        this.isItAMine = isItAMine;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
