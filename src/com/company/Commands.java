package com.company;

public class Commands {
    public int initial = 0;
    public int x = 0;
    public int y = 0;
    public int drawX = 0;
    public int drawY = 0;
    public int[][] grid;    //First index is x, second is y
    public String facing = "north";
    public String pen = "up";

    // Getter
    public int getInitial() {return initial;}
    public int getX() {
        return x;
    }
    public int getY() {return y;}
    public int getdrawX() {
        return drawX;
    }
    public int getdrawY() {return drawY;}
    public int isDrawn(int x, int y) {return grid[x][y];}
    public String getFacing() {
        return facing;
    }
    public String getPen() {
        return pen;
    }

    // Setter
    public void setInitial(int newInitial) {
        this.initial = newInitial;
        this.grid = new int[newInitial][newInitial];
        for (int i = 0; i < newInitial; ++i){
            for (int ii = 0; ii < newInitial; ++ii){
                grid[i][ii] = 0;
            }
        }
    }
    public void setX(int newX) {
        this.x = newX;
    }
    public void setY(int newY) {
        this.y = newY;
    }
    public void setdrawX(int newdrawX) {
        this.drawX = newdrawX;
    }
    public void setdrawY(int newdrawY) {
        this.drawY = newdrawY;
    }
    public void setFacing(String newFacing) {
        this.facing = newFacing;
    }
    public void setPen(String newPen) {
        this.pen = newPen;
    }

    public void drawX(int lengthX){
        int startX = getX();
        int startY = getY();
        if (lengthX > 0) {
            for (int i = 0; i <= lengthX; ++i) {
                grid[startX + i][startY] = 1;
            }
        }
        else {
            for (int i = 0; i >= lengthX; --i) {
                grid[startX - i][startY] = i;
            }
        }
    }

    public void drawY(int lengthY){
        int startX = getX();
        int startY = getY();
        if (lengthY > 0) {
            for (int i = 0; i <= lengthY; ++i) {
                grid[startX][startY + i] = 1;
            }
        }
        else {
            for (int i = 0; i >= lengthY; --i) {
                grid[startX][startY - i] = i;
            }
        }
    }
}
