package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainTest {
    Commands obj = new Commands();
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errorStreamCaptor = new ByteArrayOutputStream();
    private static final PrintStream originalOutput = System.out;
    private static final PrintStream originalError = System.err;
    Main main = new Main();

    @BeforeAll
    public static void setupAll() {
        System.out.println("Print before each unit test");
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setErr(new PrintStream(errorStreamCaptor));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOutput);
        System.setErr(originalError);
    }

    @Test
    @DisplayName("Initialize obj position and array size")
    public void testinitialize() {
        obj.Initialize(8);
        assertEquals(obj.getX(), 0);
        assertEquals(obj.getX(), 0);
        assertEquals(obj.getFacing(), "north");
        assertEquals(obj.getPen(), "up");
    }

    @Test
    @DisplayName("Check position of obj")
    public void testcheck() {
        outputStreamCaptor.reset();
        obj.Check();
        int x = obj.getX();
        int y = obj.getY();
        String pen = obj.getPen();
        String facing = obj.getFacing();
        String expected = ">Position: " + x + ", " + y + " - Pen: " + pen + " - Facing: " + facing + "\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
    }

    @Test
    @DisplayName("Check if pen is down")
    public void testdown() {
        obj.Initialize(8);
        obj.Down();
        assertEquals(obj.getPen(), "down");
    }

    @Test
    @DisplayName("Check if pen is up")
    public void testup() {
        obj.Initialize(10);
        obj.Up();
        assertEquals(obj.getPen(), "up");

    }

    @Test
    @DisplayName("Test how obj moves in array")
    public void testmove() {

        obj.Initialize(8);
        obj.Move(6);


        assertEquals(6, obj.getY());
        assertEquals(0, obj.getX());

        obj.TurnRight();
        obj.Move(3);

        assertEquals(3, obj.getX());
        assertEquals(6, obj.getY());

        obj.TurnRight();
        obj.Move(1);

        assertEquals(3, obj.getX());
        assertEquals(5, obj.getY());

        obj.TurnRight();
        obj.Move(1);

        assertEquals(2, obj.getX());
        assertEquals(5, obj.getY());

    }

    @Test
    @DisplayName("Test when obj turns to the right")
    public void testturnRight() {
        obj.Initialize(8);

        assertEquals( "north", obj.getFacing());
        obj.TurnRight();
        assertEquals( "east", obj.getFacing());
        obj.TurnRight();
        assertEquals("south", obj.getFacing());
        obj.TurnRight();
        assertEquals("west", obj.getFacing());
        obj.TurnRight();
        obj.TurnRight();
        obj.TurnRight();
        assertEquals("south", obj.getFacing());
        obj.TurnRight();
        obj.TurnRight();
        assertEquals("north", obj.getFacing());
    }

    @Test
    @DisplayName("Test when obj turns to the left")
    public void testturnLeft() {
        obj.Initialize(8);
        assertEquals( "north", obj.getFacing());
        obj.TurnLeft();
        assertEquals( "west", obj.getFacing());
        obj.TurnLeft();
        assertEquals("south", obj.getFacing());
        obj.TurnLeft();
        assertEquals("east", obj.getFacing());
        obj.TurnLeft();
        obj.TurnLeft();
        obj.TurnLeft();
        assertEquals("south", obj.getFacing());
        obj.TurnLeft();
        obj.TurnLeft();
        assertEquals("north", obj.getFacing());
    }

    @Test
    @DisplayName("Test drawing in y direction")
    public void testDrawY() {
        obj.Initialize(8);
        obj.drawY(5);
        obj.Print();

        obj.Initialize(8);
        obj.setY(6);
        obj.drawY(-5);
        obj.Print();
    }

    @Test
    @DisplayName("Test drawing in x direction")
    public void testDrawX() {
        obj.Initialize(8);
        obj.drawX(5);
        obj.Print();

        obj.Initialize(8);
        obj.setX(6);
        obj.drawX(-5);
        obj.Print();
    }

    @Test
    @DisplayName("Test the print of obj")
    public void testPrint() {
        obj.Initialize(8);
        obj.setPen("down");
        obj.Move(6);
        obj.TurnRight();
        obj.Move(3);
        outputStreamCaptor.reset();
        obj.Print();
        String expected = "  +----------------+\r\n7 |                |\r\n6 | * * * *        |\r\n5 | *              |\r\n4 | *              |\r\n3 | *              |\r\n2 | *              |\r\n1 | *              |\r\n0 | *              |\r\n  +----------------+\r\n    0 1 2 3 4 5 6 7\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
    }

    @Test
    @DisplayName("Test main")
    public void testMain(){
        outputStreamCaptor.reset();
        String d = "d";
        String [] d2 = d.split("\\s+");
        obj.mainFunction(d2,d);
        String expected = ">Pen down\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String u = "u";
        String [] u2 = u.split("\\s+");
        obj.mainFunction(u2,u);
        expected = ">Pen up\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String l = "l";
        String [] l2 = l.split("\\s+");
        obj.mainFunction(l2,l);
        expected = ">Turn Left\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String r = "r";
        String [] r2 = r.split("\\s+");
        obj.mainFunction(r2,r);
        expected = ">Turn Right\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String c = "c";
        String [] c2 = c.split("\\s+");
        obj.mainFunction(c2,c);
        expected = ">Position: 0, 0 - Pen: up - Facing: north\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String m = "m 1";
        String [] m2 = m.split("\\s+");
        obj.mainFunction(m2,m);
        expected = "y out of bounds,try again\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String i = "i 8";
        String [] i2 = i.split("\\s+");
        obj.mainFunction(i2,i);
        expected = ">System initialized to a 8x8 array.\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String q = "q";
        String [] q2 = q.split("\\s+");
        obj.mainFunction(q2,q);
        expected = "Quit\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String p = "p";
        String [] p2 = p.split("\\s+");
        obj.mainFunction(p2,p);
        expected = "  +----------------+\r\n7 |                |\r\n6 |                |\r\n5 |                |\r\n4 |                |\r\n3 |                |\r\n2 |                |\r\n1 |                |\r\n0 |                |\r\n  +----------------+\r\n    0 1 2 3 4 5 6 7\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String help = "help";
        String [] help2 = help.split("\\s+");
        obj.mainFunction(help2,help);
        expected = "I # = Initialize\nC = Check\nD = Pen down\nU = Pen up\nM # = Move\nR = Turn right\nL = Turn left\nP = Print\nH = History\nQ = Exit\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String str2 = "val";
        String [] splitStr2 = str2.split("\\s+");
        obj.mainFunction(splitStr2,str2);
        expected = "*Incorrect input, please try again*\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String str3 = "123";
        String [] splitStr3 = str3.split("\\s+");
        obj.mainFunction(splitStr3,str3);
        expected = "*Incorrect input, please try again*\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();

        String str4 = "i i";
        String [] splitStr4 = str4.split("\\s+");
        obj.mainFunction(splitStr4,str4);
        expected = "*Incorrect input, please try again*\r\n";
        assertEquals(outputStreamCaptor.toString(), expected);
        outputStreamCaptor.reset();
    }

    @Test
    @DisplayName("Test main")
    public void testNumberic(){
        assertTrue(obj.isNumeric("12"));
        assertFalse(obj.isNumeric("string"));
    }

    @Test
    @DisplayName("Test history function")
    public void testHistory(){
        outputStreamCaptor.reset();
        String d = "d";
        String [] d2 = d.split("\\s+");
        obj.mainFunction(d2,d);

        String u = "u";
        String [] u2 = u.split("\\s+");
        obj.mainFunction(u2,u);

        String l = "l";
        String [] l2 = l.split("\\s+");
        obj.mainFunction(l2,l);

        String hello = "hello";
        String [] hello2 = l.split("\\s+");
        obj.mainFunction(hello2,hello);

        List<String> expected = new ArrayList<>();
        expected.add("d - Down");
        expected.add("u - Up");
        expected.add("l - Left");
        expected.add("hello - *Incorrect input, please try again*");

        assertEquals(obj.History(),expected);
    }

}