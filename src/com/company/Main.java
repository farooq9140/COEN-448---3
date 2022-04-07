package com.company;

import java.util.Scanner;

public class Main {
    static Commands obj = new Commands();

    public static void main(String[] args) {
        System.out.println("*Type 'help' if you need help");
        int i = 0;
        while (i == 0){
            Scanner sc= new Scanner(System.in);
            System.out.println("\n>Enter command: ");
            String str = sc.nextLine().toLowerCase();
            String [] splitStr = str.split("\\s+");
            Main.mainFunction(splitStr, str);
            if (str.equals("q")){
                i = 1;}
        }
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

    public static void mainFunction (String[] splitStr, String str){
       if (splitStr.length == 2 && ! Main.isNumeric(splitStr[1])){
           obj.setHistory(str + " - *Incorrect input, please try again*");
           System.out.println("*Incorrect input, please try again*");}
       else if (str.charAt(0) == 'i' && splitStr.length == 2 && Integer.parseInt(splitStr[1]) > 0) {
           obj.setHistory(str + " - Initialize");
           obj.Initialize(Integer.parseInt(splitStr[1]));}
       else if (str.equals("d")){
           obj.setHistory(str + " - Down");
           obj.Down();}
       else if (str.equals("u")){
           obj.setHistory(str + " - Up");
           obj.Up();}
       else if (str.charAt(0) == 'm' && splitStr.length == 2 && Integer.parseInt(splitStr[1]) > 0){
           obj.setHistory(str + " - Move");
           obj.Move(Integer.parseInt(splitStr[1]));}
       else if (str.equals("r")){
           obj.setHistory(str + " - Right");
           obj.TurnRight();}
       else if (str.equals("l")){
           obj.setHistory(str + " - Left");
           obj.TurnLeft();}
       else if (str.equals("p")){
           obj.setHistory(str + " - Print");
           obj.Print();}
       else if (str.equals("c")){
           obj.setHistory(str + " - Check");
           obj.Check();}
       else if (str.equals("h")){
           obj.setHistory(str + " - History");
           obj.History();}
       else if (str.equals("q")){
           System.out.println("Quit");}
       else if (str.equals("help")){
           obj.setHistory(str + " - Help");
           System.out.println("I # = Initialize\nC = Check\nD = Pen down\nU = Pen up\nM # = Move\nR = Turn right\nL = Turn left\nP = Print\nH = History\nQ = Exit");}
       else{
           obj.setHistory(str + " - *Incorrect input, please try again*");
           System.out.println("*Incorrect input, please try again*");}
        }
}
