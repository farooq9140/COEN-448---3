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
           System.out.println("*Incorrect input, please try again*");}
       else if (str.charAt(0) == 'i' && splitStr.length == 2 && Integer.parseInt(splitStr[1]) > 0) {
           obj.Initialize(Integer.parseInt(splitStr[1]));}
       else if (str.equals("d")){
           obj.Down();}
       else if (str.equals("u")){
           obj.Up();}
       else if (str.charAt(0) == 'm' && splitStr.length == 2 && Integer.parseInt(splitStr[1]) > 0){
           obj.Move(Integer.parseInt(splitStr[1]));}
       else if (str.equals("r")){
           obj.TurnRight();}
       else if (str.equals("l")){
           obj.TurnLeft();}
       else if (str.equals("p")){
           obj.Print();}
       else if (str.equals("c")){
           obj.Check();}
       else if (str.equals("q")){
           System.out.println("Quit");;}
       else if (str.equals("help")){
           System.out.println("I # = Initialize\nC = Check\nD = Pen down\nU = Pen up\nM # = Move\nR = Turn right\nL = Turn left\nP = Print\nQ = Exit");}
       else
           System.out.println("*Incorrect input, please try again*");
        }
}
