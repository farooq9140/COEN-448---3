package com.company;

import org.junit.Test;

import static org.junit.Assert.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;


public class MainTest {

    Main robot = new Main();
    Commands obj = new Commands();


    @BeforeAll
    public static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @Test
    @DisplayName("Should initialize robot")
    public void testinitialize() {
        robot.Initialize(8);
        assertEquals(obj.getX(), 0);
        assertEquals(obj.getX(), 0);
        assertEquals(obj.getFacing(), "north");
        assertEquals(obj.getPen(), "up");
    }

    @Test
    @DisplayName("Should check posit robot")
    public void testcheck() {
        assertEquals(obj.x, obj.getX());
        assertEquals(obj.y, obj.getY());
        assertEquals(obj.pen, obj.getPen());
        assertEquals(obj.facing, obj.getFacing());
    }

    @Test
    public void testdown() {
        robot.Initialize(8);
        obj.setPen("down");
        assertEquals(obj.getPen(), "down");
    }

    @Test
    public void testup() {
        robot.Initialize(10);
        obj.setPen("up");
        assertEquals(obj.getPen(), "up");

    }

    @Test
    public void testmove() {

        robot.Initialize(8);
        robot.Move(6);


        assertEquals(6, obj.getY());
        assertEquals(0, obj.getX());

        robot.TurnRight();
        robot.Move(3);

        assertEquals(3, obj.getX());
        assertEquals(6, obj.getY());

        robot.TurnRight();
        robot.Move(1);

        assertEquals(3, obj.getX());
        assertEquals(5, obj.getY());

    }

    @Test
    public void testturnRight() {
        robot.Initialize(8);

        assertEquals( "north", obj.getFacing());
        robot.TurnRight();
        assertEquals( "east", obj.getFacing());
        robot.TurnRight();
        assertEquals("south", obj.getFacing());
        robot.TurnRight();
        assertEquals("west", obj.getFacing());
        robot.TurnRight();
        robot.TurnRight();
        robot.TurnRight();
        assertEquals("south", obj.getFacing());
        robot.TurnRight();
        robot.TurnRight();
        assertEquals("north", obj.getFacing());
    }

    @Test
    public void testturnLeft() {
        robot.Initialize(8);
        assertEquals( "north", obj.getFacing());
        robot.TurnLeft();
        assertEquals( "west", obj.getFacing());
        robot.TurnLeft();
        assertEquals("south", obj.getFacing());
        robot.TurnLeft();
        assertEquals("east", obj.getFacing());
        robot.TurnLeft();
        robot.TurnLeft();
        robot.TurnLeft();
        assertEquals("south", obj.getFacing());
        robot.TurnLeft();
        robot.TurnLeft();
        assertEquals("north", obj.getFacing());
    }
//
//    @Test
//    public void print() {
//    }
}