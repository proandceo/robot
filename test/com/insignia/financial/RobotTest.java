package com.insignia.financial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {

    @Test
    public void checkOutOfRange(){
        Robot robot = new Robot(0, 0, "SOUTH");
        robot.move("WEST");
        Assertions.assertEquals("0,0", robot.grid.toString());

        robot = new Robot(0,0,"SOUTH");
        robot.move("SOUTH");
        Assertions.assertEquals("0,0", robot.grid.toString());

        robot = new Robot(6,6,"SOUTH");
        robot.move("EAST");
        Assertions.assertEquals("4,4", robot.grid.toString());

        robot = new Robot(4,4,"SOUTH");
        robot.move("NORTH");
        Assertions.assertEquals("4,4", robot.grid.toString());
    }

    @Test
    public void turnLeft(){
        Assertions.assertEquals("EAST",
                new Robot(0,0, "SOUTH").turn("LEFT"));
    }

    @Test
    public void turnRight(){
        Assertions.assertEquals("WEST",
                new Robot(0,0, "SOUTH").turn("RIGHT"));
    }
}