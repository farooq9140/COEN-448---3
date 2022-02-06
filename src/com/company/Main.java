package com.company;

import java.util.Scanner;

public class Main {
    static Commands obj = new Commands();

    public static void main(String[] args) {
        int i = 0;
        System.out.println("*Type 'help' if you need help");
        while (i == 0){
            Scanner sc= new Scanner(System.in);
            System.out.println("\n>Enter command: ");
            String str = sc.nextLine().toLowerCase();
            String [] splitStr = str.split("\\s+");
            if (splitStr.length == 2 && !isNumeric(splitStr[1])){
                System.out.println("*Incorrect input, please try again*");}
            else if (str.charAt(0) == 'i' && splitStr.length == 2 && Integer.parseInt(splitStr[1]) > 0) {
                Initialize(Integer.parseInt(splitStr[1]));}
            else if (str.equals("d")){
                Down();}
            else if (str.equals("u")){
                Up();}
            else if (str.charAt(0) == 'm' && splitStr.length == 2 && Integer.parseInt(splitStr[1]) > 0){
                Move(Integer.parseInt(splitStr[1]));}
            else if (str.equals("r")){
                TurnRight();}
            else if (str.equals("l")){
                TurnLeft();}
            else if (str.equals("p")){
                Print();}
            else if (str.equals("c")){
                Check();}
            else if (str.equals("q")){
                i = 1;}
            else if (str.equals("help")){
                System.out.println("I # = Initialize\nC = Check\nD = Pen down\nU = Pen up\nM # = Move\nR = Turn right\nL = Turn left\nP = Print\nQ = Exit");}
            else
                System.out.println("*Incorrect input, please try again*");
        }

    }

    public static void Initialize(int initial){
        System.out.println(">System initalized to a " + initial+ "x" + initial + " array.");
        obj.setInitial(initial);
        obj.setX(0);
        obj.setY(0);
        obj.setFacing("north");
        obj.setPen("up");
    }
    public static void Check(){
        int x = obj.getX();
        int y = obj.getY();
        String pen = obj.getPen();
        String facing = obj.getFacing();
        System.out.println(">Position: " + x + ", " + y + " - Pen: " + pen + " - Facing: " + facing);
    }
    public static void Down(){
        obj.setPen("down");
        System.out.println(">Pen down");
    }
    public static void Up(){
        obj.setPen("up");
        System.out.println(">Pen up");
    }
    public static void Move(int move){
        int initial = obj.getInitial();
        int x = obj.getX();
        int y = obj.getY();
        int drawX = obj.getdrawX();
        int drawY = obj.getdrawY();
        String pen = obj.getPen();
        String facing = obj.getFacing();
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
                        obj.drawY(move);
                    }
                    obj.setY(y);
                }
                case "south" -> {
                    y -= move;
                    if (pen.equals("down")) {
                        obj.drawY(-move);
                    }
                    obj.setY(y);
                }
                case "east" -> {
                    x += move;
                    if (pen.equals("down")) {
                        obj.drawX(move);
                    }
                    obj.setX(x);
                }
                case "west" -> {
                    x -= move;
                    if (pen.equals("down")) {
                        obj.drawX(-move);
                    }
                    obj.setX(x);
                }
            }
            System.out.println(">Move by "+ move);}
    }
    public static void TurnRight(){
        String facing = obj.getFacing();
        switch (facing) {
            case "north" -> obj.setFacing("east");
            case "south" -> obj.setFacing("west");
            case "east" -> obj.setFacing("south");
            case "west" -> obj.setFacing("north");
        }
        System.out.println(">Turn Right");
    }
    public static void TurnLeft(){
        String facing = obj.getFacing();
        switch (facing) {
            case "north" -> obj.setFacing("west");
            case "south" -> obj.setFacing("east");
            case "east" -> obj.setFacing("north");
            case "west" -> obj.setFacing("south");
        }
        System.out.println(">Turn Left");
    }
    public static void Print(){
        int size = obj.getInitial();
        int x = obj.getdrawX();
        int y = obj.getdrawY();
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
                if (obj.isDrawn(ii, i) == 0) {
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
        /*for (int i = 0; i < x; i++) {
            result = new String(new char[i]).replace("\0", "* ");
        }
        System.out.println(result + "* *");
        for (int i = 0; i < y; i++) {
            System.out.println("*");
        }*/
    }

    public static boolean isNumeric(final CharSequence cs) {
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

