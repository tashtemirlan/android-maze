package com.teit.mazetemirlantashtanov;

import java.util.ArrayList;

public class Cell {
    boolean
            topWall = true,
            leftWall = true,
            rightWall = true,
            bottomWall = true,
            visited = false

                    ;

    int column , row;

    public Cell(int column, int row){
        this.column = column;
        this.row = row;
    }

}
