package com.insignia.financial;

/**
 * For multi robot
 */
public class MultiRobot extends Robot{
    public MultiRobot(int x, int y, String currentDirection, String name){
        super(x, y, currentDirection);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
