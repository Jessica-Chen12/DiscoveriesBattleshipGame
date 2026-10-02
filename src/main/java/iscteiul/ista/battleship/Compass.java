/**
 *
 */
package iscteiul.ista.battleship;

/**
 * @author fba
 */
public enum Compass {
    NORTH('n'), SOUTH('s'), EAST('e'), WEST('o'), UNKNOWN('u');

    private final char c;

    /**
     * Creates a compass direction with its corresponding character.
     *
     * @param c the character representing the compass direction
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Returns the character representing this compass direction.
     *
     * @return the direction character
     */
    public char getDirection() {
        return c;
    }

    /**
     * Returns the character representation of this compass direction as a string.
     *
     * @return the direction character as a string
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converts a character into its corresponding compass direction.
     *
     * @param ch the character to convert
     * @return the corresponding compass direction, or {@link #UNKNOWN} if the character does not represent a known direction
     * */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
