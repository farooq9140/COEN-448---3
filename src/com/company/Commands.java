package com.company;

public class Commands {
    public int x = 0;
    public int y = 0;
    public String facing = "north";
    public String pen = "up";

    // Getter
    public int getX() {
        return x;
    }
    public int getY() {return y;}
    public String getFacing() {
        return facing;
    }
    public String getPen() {
        return pen;
    }

    // Setter
    public void setX(int newX) {
        this.x = newX;
    }
    public void setY(int newY) {
        this.y = newY;
    }
    public void setFacing(String newFacing) {
        this.facing = newFacing;
    }
    public void setPen(String newPen) {
        this.pen = newPen;
    }
}
