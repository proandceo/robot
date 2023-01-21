package com.insignia.financial;

import java.util.Arrays;
import static com.insignia.financial.Constants.FACE;
import static com.insignia.financial.Constants.ZERO;
import static com.insignia.financial.Constants.SIZE;

/**
 * Check validation of input data
 */
public class Validation {

    /**
     * check validation of commands
     * @param init
     * @return boolean
     */
    public static boolean validCommands(String[] init) {
        return ("PLACE".equals(init[0])
                && init[1].chars().allMatch(Character::isDigit)
                && init[2].chars().allMatch(Character::isDigit)
                && Arrays.stream(FACE).anyMatch(init[3]::equals));
    }

    /**
     * check the range of Grid
     * @param grid
     */
    public static void isValidRange(Grid grid) {
        if (grid.getX() <= ZERO) grid.setX(ZERO);
        if (grid.getY() <= ZERO) grid.setY(ZERO);
        if (grid.getX() >= SIZE) grid.setX(SIZE - 1);
        if (grid.getY() >= SIZE) grid.setY(SIZE - 1);
    }
}
