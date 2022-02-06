package com.company;

import org.junit.Test;

import static org.junit.Assert.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;


public class MainTest {
    Commands obj = new Commands();


    @BeforeAll
    public static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @Test
    @DisplayName("Should initialize robot")
    public void testinitialize() {
        obj.Initialize(8);
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
        obj.Initialize(8);
        obj.setPen("down");
        assertEquals(obj.getPen(), "down");
    }

    @Test
    public void testup() {
        obj.Initialize(10);
        obj.setPen("up");
        assertEquals(obj.getPen(), "up");

    }

    @Test
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

    }

    @Test
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
//
//    @Test
//    public void print() {
//    }
}