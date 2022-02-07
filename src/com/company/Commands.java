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

    public void Initialize(int initial){
        System.out.println(">System initialized to a " + initial+ "x" + initial + " array.");
        setInitial(initial);
        setX(0);
        setY(0);
        setFacing("north");
        setPen("up");
    }
    public void Check(){
        int x = getX();
        int y = getY();
        String pen = getPen();
        String facing = getFacing();
        System.out.println(">Position: " + x + ", " + y + " - Pen: " + pen + " - Facing: " + facing);
    }
    public void Down(){
        setPen("down");
        System.out.println(">Pen down");
    }
    public void Up(){
        setPen("up");
        System.out.println(">Pen up");
    }
    public void Move(int move){
        int initial = this.getInitial();
        int x = this.getX();
        int y = this.getY();
        int drawX = this.getdrawX();
        int drawY = this.getdrawY();
        String pen = this.getPen();
        String facing = this.getFacing();
        if (x+move > initial && facing.equals("east"))
            System.out.println("x out of bounds,try again");
        else if (x-move < 0 && facing.equals("west"))
            System.out.println("x out of bounds,try again");
        else if (y+move > initial && facing.equals("north"))
            System.out.println("y out of bounds,try again");
        else if (y-move < 0 && facing.equals("south"))
            System.out.println("y out of bounds,try again");
        else
            {switch (facing) {
                case "north" -> {
                    y += move;
                    if (pen.equals("down")) {
                        this.drawY(move);
                    }
                    this.setY(y);
                }
                case "south" -> {
                    y -= move;
                    if (pen.equals("down")) {
                        this.drawY(-move);
                    }
                    this.setY(y);
                }
                case "east" -> {
                    x += move;
                    if (pen.equals("down")) {
                        this.drawX(move);
                    }
                    this.setX(x);
                }
                case "west" -> {
                    x -= move;
                    if (pen.equals("down")) {
                        this.drawX(-move);
                    }
                    this.setX(x);
                }
            }
            System.out.println(">Move by "+ move);}
    }
    public void TurnRight(){
        switch (getFacing()) {
            case "north":
                setFacing("east");
                break;
            case "east":
                setFacing("south");
                break;
            case "south":
                setFacing("west");
                break;
            case "west":
                setFacing("north");
                break;
        }
        System.out.println(">Turn Right");
    }
    public void TurnLeft(){
        String facing = getFacing();
        switch (facing) {
            case "north" -> setFacing("west");
            case "south" -> setFacing("east");
            case "east" -> setFacing("north");
            case "west" -> setFacing("south");
        }
        System.out.println(">Turn Left");
    }
    public void Print(){
        int size = this.getInitial();
        int x = this.getdrawX();
        int y = this.getdrawY();
        String limits = "  +";
        for (int i = 0; i < size; ++i) {
            limits += "--";
        }
        limits += "+";
        System.out.println(limits);
        for (int i = size-1; i >= 0; --i) {
            String line = "";
            line += Integer.toString(i);
            line += " |";
            for (int ii = 0; ii < size; ++ii) {
                if (this.isDrawn(ii, i) == 0) {
                    line += "  ";
                }
                else {
                    line += " *";
                }
            }
            line += '|';
            System.out.println(line);
        }
        System.out.println(limits);
        String bottom = "   ";
        for (int i = 0; i < size; ++i) {
            bottom += ' ';
            bottom += Integer.toString(i);
        }
        System.out.println(bottom);
    }

    public boolean isNumeric(final CharSequence cs) {
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
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
                grid[startX + i][startY] = 1;
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
                grid[startX][startY + i] = 1;
            }
        }
    }
}
