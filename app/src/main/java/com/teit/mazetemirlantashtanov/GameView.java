package com.teit.mazetemirlantashtanov;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    Maze mz;
    private Paint wallPaint , playerPaint , exitPaint , keyPaint;
    public int dimension;
    private float cellSize , hMargin , wMargin;
    public boolean screenCreated = false;
    public boolean keyGetted = false;

    public void SetDimension(int dim){
        this.dimension = dim;
    }


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        wallPaint = new Paint();
        wallPaint.setColor(Color.BLACK);
        wallPaint.setStrokeWidth(4);

        playerPaint = new Paint();
        playerPaint.setColor(Color.BLUE);

        exitPaint = new Paint();
        exitPaint.setColor(Color.RED);

        keyPaint = new Paint();
        keyPaint.setColor(Color.YELLOW);



    }

    @Override
    protected void onDraw(Canvas canvas) {

        // todo : create maze =>
        if(!this.screenCreated){
            mz = new Maze(this.dimension);
            mz.createMaze();
            //set Logical boolean to not recreate again our maze =>
            this.screenCreated = true;
        }


        canvas.drawColor(Color.LTGRAY);

        int width = getWidth();
        int height = getHeight();

        if(width/height < 1){
            cellSize = width / (this.dimension+1);
        }
        else {
            cellSize = height/(this.dimension+1);
        }

        hMargin = (width - this.dimension*cellSize) / 2;
        wMargin = (height - this.dimension*cellSize)/2;

        canvas.translate(hMargin,wMargin);

        for(int i=0; i<this.dimension;i++){
            for(int j=0; j< this.dimension;j++){
                if(mz.cells[i][j].topWall){
                    canvas.drawLine(
                            i*cellSize,
                            j*cellSize,
                            (i+1)*cellSize,
                            j*cellSize,
                            wallPaint
                    );
                }
                if(mz.cells[i][j].leftWall){
                    canvas.drawLine(
                            i*cellSize,
                            j*cellSize,
                            i*cellSize,
                            (j+1)*cellSize,
                            wallPaint
                    );
                }
                if(mz.cells[i][j].bottomWall){
                    canvas.drawLine(
                            i*cellSize,
                            (j+1)*cellSize,
                            (i+1)*cellSize,
                            (j+1)*cellSize,
                            wallPaint
                    );
                }
                if(mz.cells[i][j].rightWall){
                    canvas.drawLine(
                            (i+1)*cellSize,
                            j*cellSize,
                            (i+1)*cellSize,
                            (j+1)*cellSize,
                            wallPaint
                    );
                }
            }
        }

        float margin = cellSize/6;

        canvas.drawRect(
                mz.player.column*cellSize+margin,
                mz.player.row*cellSize+margin,
                (mz.player.column+1)*cellSize-margin,
                (mz.player.row+1)*cellSize-margin,
                playerPaint
        );

        canvas.drawRect(
                mz.exit.column*cellSize+margin,
                mz.exit.row*cellSize+margin,
                (mz.exit.column+1)*cellSize-margin,
                (mz.exit.row+1)*cellSize-margin,
                exitPaint
        );

        canvas.drawRect(
                mz.key.column*cellSize+margin,
                mz.key.row*cellSize+margin,
                (mz.key.column+1)*cellSize-margin,
                (mz.key.row+1)*cellSize-margin,
                keyPaint
        );
    }

    public boolean canMoveUP(){
        if(!mz.player.topWall){
            return true;
        }
        return false;
    }

    public boolean canMoveLEFT(){
        if(!mz.player.leftWall){
            return true;
        }
        return false;
    }

    public boolean canMoveRIGHT(){
        if(!mz.player.rightWall){
            return true;
        }
        return false;
    }

    public boolean canMoveDOWN(){
        if(!mz.player.bottomWall){
            return true;
        }
        return false;
    }

    public boolean userGetKey(){
        if(mz.player == mz.key){
            keyGetted = true;
            keyPaint.setColor(Color.TRANSPARENT);
            playerPaint.setColor(Color.MAGENTA);
            exitPaint.setColor(Color.GREEN);
            return true;
        }
        return false;
    }

    public boolean userCameToExit(){
        if(keyGetted){
            if(mz.player == mz.exit){
                return true;
            }
        }
        return false;
    }

    public void Move(String toWhere){
        if(toWhere.equals("Up")){
                mz.player = mz.cells[mz.player.column][mz.player.row-1];
                if(!keyGetted){
                    userGetKey();
                }
        }
        if(toWhere.equals("Left")){
                mz.player = mz.cells[mz.player.column-1][mz.player.row];
                if(!keyGetted){
                    userGetKey();
                }
        }
        if(toWhere.equals("Right")){
                mz.player = mz.cells[mz.player.column+1][mz.player.row];
                if(!keyGetted){
                    userGetKey();
                }
        }
        if(toWhere.equals("Down")){
                mz.player = mz.cells[mz.player.column][mz.player.row+1];
                if(!keyGetted){
                    userGetKey();
                }
        }
        invalidate();
    }
}