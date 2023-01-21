package com.insignia.financial;

import static com.insignia.financial.Constants.*;

/**
 * the information state(behaviour and direction) of robot, the relation of grid
 */
public class Robot {
    Grid grid;
    String currentDirection;

    // when the robot put on the grid, it is the current state of robot
    public Robot(int x, int y, String currentDirection){
        this.grid = new Grid(x, y);
        this.currentDirection = currentDirection;
    }

    /**
     * move Robot, turn Left or Right Robot
     * @param command
     * @return String
     */
    public String moveRobot(String command) {
        switch (command) {
            case "MOVE" -> move(currentDirection);
            case "LEFT" -> currentDirection = turn("LEFT");
            case "RIGHT" -> currentDirection = turn("RIGHT");
        }
        return grid.toString() + "," + currentDirection;
    }

    /**
     * direction(East, South, West, North)
     *
     * @param direction
     */
    public void move(String direction) {
        switch (direction) {
            case "EAST" -> {
                grid.setX(grid.getX() + EAST[0]);
                grid.setY(grid.getY() + EAST[1]);
            }
            case "SOUTH" -> {
                grid.setX(grid.getX() + SOUTH[0]);
                grid.setY(grid.getY() + SOUTH[1]);
            }
            case "WEST" -> {
                grid.setX(grid.getX() + WEST[0]);
                grid.setY(grid.getY() + WEST[1]);
            }
            case "NORTH" -> {
                grid.setX(grid.getX() + NORTH[0]);
                grid.setY(grid.getY() + NORTH[1]);
            }
        }
        Validation.isValidRange(grid);
    }

    /**
     * move left or right rotation
     * @param leftRight
     * @return
     */
    public String turn(String leftRight) {
        String nextDirection = "";

        // if the left or right does not show, it is the same direction of current direction.
        if("".equals(leftRight)) return currentDirection;

        for (int i = 0; i < 4; i++) {
            if (currentDirection.equals(FACE[i])) {
                if ("RIGHT".equals(leftRight)) {
                    if (++i > 3) i = 0;
                    nextDirection = FACE[i];
                    break;
                } else if ("LEFT".equals(leftRight)) {
                    if (--i < 0) i = 3;
                    nextDirection = FACE[i];
                    break;
                }else{
                    nextDirection = currentDirection;
                }
            }
        }
        return nextDirection;
    }
}