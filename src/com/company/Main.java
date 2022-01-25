package com.company;

import java.util.Scanner;

public class Main {
    static Commands obj = new Commands();

    public static void main(String[] args) {
        int i = 0;
        while (i == 0){
            Scanner sc= new Scanner(System.in);
            System.out.println("\n>Enter command: ");
            String str = sc.nextLine();
            String [] splitStr = str.split("\\s+");
            if (str.charAt(0) == 'I' && splitStr.length == 2) {
                Initialize(Integer.parseInt(splitStr[1]));}
            else if (str.equals("D")){
                Down();}
            else if (str.equals("U")){
                Up();}
            else if (str.charAt(0) == 'M' && splitStr.length == 2){
                Move(Integer.parseInt(splitStr[1]));}
            else if (str.equals("R")){
                TurnRight();}
            else if (str.equals("L")){
                TurnLeft();}
            else if (str.equals("P")){
                Print();}
            else if (str.equals("C")){
                Check();}
            else if (str.equals("Q")){
                i = 1;}
            else
                System.out.println("*Incorrect input, please try again*");
        }

    }

    public static void Initialize(int initial){
        System.out.println(">System initalized to a " + initial+ "x" + initial + " array.");
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
        int x = obj.getX();
        int y = obj.getY();
        int drawX = obj.getdrawX();
        int drawY = obj.getdrawY();
        String pen = obj.getPen();
        String facing = obj.getFacing();
        switch (facing) {
            case "north" -> {
                y += move;
                obj.setY(y);
            }
            case "south" -> {
                y -= move;
                obj.setY(y);
            }
            case "east" -> {
                x += move;
                obj.setX(x);
            }
            case "west" -> {
                x -= move;
                obj.setX(x);
            }
        }
        if (pen.equals("down")) {
            switch (facing) {
                case "north" -> {
                    drawY += move;
                    obj.setdrawY(drawY);
                }
                case "south" -> {
                    drawY -= move;
                    obj.setdrawY(drawY);
                }
                case "east" -> {
                    drawX += move;
                    obj.setdrawX(drawX);
                }
                case "west" -> {
                    drawX -= move;
                    obj.setX(drawX);
                }
            }
        }
        System.out.println(">Move by "+ move);
    }
    public static void TurnRight(){
        String facing = obj.getFacing();
        switch (facing) {
            case "north" -> {
                obj.setFacing("east");
            }
            case "south" -> {
                obj.setFacing("west");
            }
            case "east" -> {
                obj.setFacing("south");
            }
            case "west" -> {
                obj.setFacing("north");
            }
        }
        System.out.println(">Turn Right");
    }
    public static void TurnLeft(){
        String facing = obj.getFacing();
        switch (facing) {
            case "north" -> {
                obj.setFacing("west");
            }
            case "south" -> {
                obj.setFacing("east");
            }
            case "east" -> {
                obj.setFacing("north");
            }
            case "west" -> {
                obj.setFacing("south");
            }
        }
        System.out.println(">Turn Left");
    }
    public static void Print(){
        int x = obj.getdrawX();
        int y = obj.getdrawY();
        String result = "";
        for (int i = 0; i < x; i++) {
            result = new String(new char[i]).replace("\0", "* ");
        }
        System.out.println(result + "* *");
        for (int i = 0; i < y; i++) {
            System.out.println("*");
        }
    }
}

