package com.minesweeper.Minesweeper;
import java.util.Random;

public class Board {
    private Square[][] board;
    private int size;
    private int numberOfMines;
    private int numberOfVisibleSquares;

    public Board(int size, int numberOfMines) {
        this.size = size;
        this.numberOfMines = numberOfMines;
        this.numberOfVisibleSquares = 0;
        board = new Square[size][size];
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Square();
            }
        }
    }

    public int getSize(){return size;}

    public void visitASquare(int x, int y) {
        if(!board[x][y].isVisible()) {
            increaseNumberOfVisibleSquares();
            board[x][y].setVisible(true);
        }
    }

    public boolean isThePlayerWins() {
        return (size*size - numberOfVisibleSquares)==numberOfMines;
    }

    public int getNumberOfVisibleSquares() {
        return numberOfVisibleSquares;
    }

    private void increaseNumberOfVisibleSquares() {
        numberOfVisibleSquares++;
    }

    public Square getASquare(int x,int y)
    {
        return board[x][y];
    }

    public void setBoard(int firstX,int firstY)
    {
        visitASquare(firstX,firstY);
        for(int i=0;i<numberOfMines;i++) {
            Random rand = new Random();
            int rand_x = rand.nextInt(size);
            int rand_y = rand.nextInt(size);

            while(!(rand_x != firstX || rand_y != firstY))
            {
                rand_x = rand.nextInt(size);
                rand_y = rand.nextInt(size);
            }

            board[rand_x][rand_y].setIsItAMine(1);
        }

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++) {
                int value = 0;
                if(board[i][j].getIsItAMine() == 1) board[i][j].setValue(-1);
                else {
                    if (i > 0) {
                        if (j > 0) value += board[i - 1][j - 1].getIsItAMine();
                        value += board[i - 1][j].getIsItAMine();
                        if (j < size - 1) value += board[i - 1][j + 1].getIsItAMine();
                    }
                    if (j > 0) value += board[i][j - 1].getIsItAMine();
                    if (j < size - 1) value += board[i][j + 1].getIsItAMine();
                    if (i < size - 1) {
                        if (j > 0) value += board[i + 1][j - 1].getIsItAMine();
                        value += board[i + 1][j].getIsItAMine();
                        if (j < size - 1) value += board[i + 1][j + 1].getIsItAMine();
                    }
                    board[i][j].setValue(value);
                }
            }

        }
    }

    public void printBoard()
    {
        System.out.println("\n" + "Current stats of the board : ");
        System.out.print("\t");
        for(int i=0;i<size;i++) System.out.print(i + "\t");
        System.out.println();
        for(int i=0;i<size;i++)
        {
            System.out.print(i  + "\t");
            for(int j=0;j<size;j++)
            {
                System.out.print(board[i][j].getCharValue() + "\t");
                //System.out.print(board[i][j].getCharValue() + "  ");
            }
            System.out.println();
        }
    }

    public void makeAllVisible()
    {
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++) {
                visitASquare(i,j);
            }
        }
    }

}
