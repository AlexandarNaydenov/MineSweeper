package com.minesweeper.Minesweeper;

import java.util.*;

public class Game {

    public Game() {
    }

    public Board start() {
        System.out.println("Enter the Difficulty Level");
        System.out.println("Press 0 for BEGINNER (9 * 9 Cells and 10 Mines)");
        System.out.println("Press 1 for INTERMEDIATE (16 * 16 Cells and 40 Mines)");
        System.out.println("Press 2 for BEGINNER (24 * 24 Cells and 99 Mines)");
        System.out.println();

        Board board = new Board(3,1);
        Scanner scan = new Scanner(System.in);
        int level = scan.nextInt();
        while(level < 0 || level > 2) {
            System.out.println("Incompatible Level. Input again, please : ");
            level = scan.nextInt();
        }
        if (level == 0) {
            board = new Board(9, 10);
        }
        else if (level == 1) {
            board = new Board(16, 40);
        } else {
            board = new Board(24, 99);
        }

        board.printBoard();
        Pair<Integer,Integer> input = input(board);
        int x = input.getFirst();
        int y = input.getSecond();
        board.setBoard(x, y);
        Recursive(board,x,y);

        return board;
    }

    public void otherRounds(Board board){
        while(true){
            board.printBoard();
            Pair<Integer, Integer> input = input(board);
            int x = input.getFirst();
            int y = input.getSecond();

            if(board.getASquare(x,y).getIsItAMine() == 1)
            {
                lose(board);
                break;
            }

            if(board.getASquare(x,y).getIsItAMine() != 1)
            {
                board = Recursive(board,x,y);
                if(board.isThePlayerWins())
                {
                    win(board);
                    break;
                }
            }
        }
    }

    private void lose(Board board)
    {
        board.makeAllVisible();
        board.printBoard();
        System.out.println("You lose!");
    }

    private void win(Board board)
    {
        board.makeAllVisible();
        board.printBoard();
        System.out.println("You won!");
    }


    private Board Recursive(Board board,int currX,int currY)
    {
        if(board.getASquare(currX,currY).getValue() != -1)
        {
            board.visitASquare(currX,currY);
        }
        if (board.getASquare(currX, currY).getValue() == 0) {
            if (currX > 0) {
                if (currY > 0) {
                    if(!board.getASquare(currX-1,currY-1).isVisible()) board = Recursive(board, currX - 1, currY - 1);
                }
                if(!board.getASquare(currX-1,currY).isVisible())board = Recursive(board, currX - 1, currY);
                if (currY < board.getSize() - 1) {
                    if(!board.getASquare(currX-1,currY+1).isVisible()) board = Recursive(board, currX - 1, currY + 1);
                }
            }
            if (currY > 0) {
                if(!board.getASquare(currX,currY-1).isVisible()) board = Recursive(board, currX, currY - 1);
            }
            if (currY < board.getSize() - 1) {
                if(!board.getASquare(currX,currY+1).isVisible()) board = Recursive(board, currX, currY + 1);
            }
            if (currX < board.getSize() - 1) {
                if (currY > 0) {
                    if(!board.getASquare(currX+1,currY-1).isVisible())board = Recursive(board, currX + 1, currY - 1);
                }
                if(!board.getASquare(currX+1,currY).isVisible()) board = Recursive(board, currX + 1, currY);
                if (currY < board.getSize() - 1) {
                    if(!board.getASquare(currX+1,currY+1).isVisible())board = Recursive(board, currX + 1, currY + 1);
                }
            }
        }
        return board;
    }

    private Pair<Integer,Integer> input(Board board)
    {
        System.out.println("Enter your move");
        System.out.println("->");
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        while(x < 0 || x > board.getSize()-1 || y < 0 || y > board.getSize()-1 || board.getASquare(x,y).isVisible()) {
            System.out.println("Incompatible X and Y. Input again, please : ");
            x = scan.nextInt();
            y = scan.nextInt();
        }
        return new Pair<Integer, Integer>(x,y);
    }


}
