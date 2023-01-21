package com.insignia.financial;

import java.util.Scanner;

/**
 * initial class
 */
public class Init {
    String[] command = {};
    Scanner sc;
    Robot robot;
    String result;

    /**
     * check input data, call robot, and move Robot
     * @return String
     */
    public String inputCommands(){
        do {
            sc = new Scanner(System.in);
            command = sc.nextLine().split(",| ");
            if ("PLACE".equals(command[0])) {
                if (Validation.validCommands(command)) {
                    int x = Integer.parseInt(command[1]); // x
                    int y = Integer.parseInt(command[2]); // y
                    String cardinalPoint = command[3];  // direction
                    robot = callRobot(x, y, cardinalPoint);
                }
            }else{
                result = moveRobot(command[0]);
            }
        } while(!"REPORT".equals(command[0]));
        return "\nOutput: " + result;
    }

    /**
     * move Robot(MOVE, LEFT, RIGHT)
     * @param command
     * @return String
     */
    private String moveRobot(String command) {
        return robot.moveRobot(command);
    }

    /**
     * call robot
     * @param x
     * @param y
     * @param cardinalPoint
     * @return Robot
     */
    private Robot callRobot(int x, int y, String cardinalPoint) {
        return new Robot(x, y, cardinalPoint);
//        return new MultiRobot(x, y, cardinalPoint, "Robot name");
    }
}