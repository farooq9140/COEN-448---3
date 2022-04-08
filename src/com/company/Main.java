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
            obj.mainFunction(splitStr, str);
            if (str.equals("q")){
                i = 1;}
        }
    }
}
