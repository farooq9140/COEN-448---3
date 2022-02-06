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
        int initial = getInitial();
        int x = getX();
        int y = getY();
        int drawX = getdrawX();
        int drawY = getdrawY();
        String pen = getPen();
        String facing = getFacing();
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
                setY(y);
            }
            case "south" -> {
                y -= move;
                setY(y);
            }
            case "east" -> {
                x += move;
                setX(x);
            }
            case "west" -> {
                x -= move;
                setX(x);
            }
        }
            if (pen.equals("down")) {
                switch (facing) {
                    case "north" -> {
                        drawY += move;
                        setdrawY(drawY);
                    }
                    case "south" -> {
                        drawY -= move;
                        setdrawY(drawY);
                    }
                    case "east" -> {
                        drawX += move;
                        setdrawX(drawX);
                    }
                    case "west" -> {
                        drawX -= move;
                        setX(drawX);
                    }
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
        int x = getdrawX();
        int y = getdrawY();
        String result = "";
        for (int i = 0; i < x; i++) {
            result = new String(new char[i]).replace("\0", "* ");
        }
        System.out.println(result + "* *");
        for (int i = 0; i < y; i++) {
            System.out.println("*");
        }
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
}