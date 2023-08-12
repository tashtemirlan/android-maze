package com.teit.mazetemirlantashtanov;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Maze {
    public Cell[][] cells;
    public int dimension;
    public Cell player , exit , key;

    Maze(int dim){
        this.dimension = dim;
    }

    public Cell getNeightbour(Cell cell){
        ArrayList<Cell> neightbours  = new ArrayList<>();

        //left
        if(cell.column > 0){
            if(!cells[cell.column-1][cell.row].visited){
                neightbours.add(cells[cell.column-1][cell.row]);
            }
        }
        //right
        if(cell.column < this.dimension-1){
            if(!cells[cell.column+1][cell.row].visited){
                neightbours.add(cells[cell.column+1][cell.row]);
            }
        }
        //top
        if(cell.row > 0){
            if(!cells[cell.column][cell.row-1].visited){
                neightbours.add(cells[cell.column][cell.row-1]);
            }
        }
        //bottom
        if(cell.row < this.dimension - 1){
            if(!cells[cell.column][cell.row+1].visited){
                neightbours.add(cells[cell.column][cell.row+1]);
            }
        }

        if(neightbours.size() > 0){
            Random random = new Random();
            int index = random.nextInt(neightbours.size());
            return neightbours.get(index);
        }
        return null;
    }

    public void removeWall(Cell current, Cell next){
        if(current.column == next.column && current.row== next.row+1){
            current.topWall = false;
            next.bottomWall = false;
        }
        if(current.column == next.column && current.row== next.row-1){
            current.bottomWall = false;
            next.topWall = false;
        }
        if(current.column == next.column+1 && current.row== next.row){
            current.leftWall = false;
            next.rightWall = false;
        }
        if(current.column == next.column-1 && current.row== next.row){
            current.rightWall = false;
            next.leftWall = false;
        }
    }

    public void createMaze(){
        Stack<Cell> stack = new Stack<>();
        Cell current , next;

        cells = new Cell[this.dimension][this.dimension];
        for(int i=0; i<this.dimension;i++){
            for(int j=0;j<this.dimension;j++){
                cells[i][j] = new Cell(i,j);
            }
        }

        player = cells[0][0];
        exit = cells[this.dimension-1][this.dimension-1];

        // todo : create where will be key =>
        Random random_key_column = new Random();
        Random random_key_row = new Random();

        int rdn_key_cl = random_key_column.nextInt(this.dimension-1);
        int rdn_key_rw = random_key_row.nextInt(this.dimension-1);

        key = cells[rdn_key_cl][rdn_key_rw];


        current = cells[0][0];
        current.visited = true;

        do{
            next = getNeightbour(current);
            if(next !=null){
                removeWall(current,next);
                stack.push(current);
                current = next;
                current.visited = true;
            }
            else {
                current = stack.pop();
            }
        } while (!stack.empty());
    }
}
