package com.company;

public class Commands {
    public int initial = 0;
    public int x = 0;
    public int y = 0;
    public int drawX = 0;
    public int drawY = 0;
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
    public String getFacing() {
        return facing;
    }
    public String getPen() {
        return pen;
    }

    // Setter
    public void setInitial(int newInitial) { this.initial = newInitial;}
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
}
