/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Represents a caravel ship in the Battleship game.
 *
 * <p>A caravel occupies two positions on the game board. Its positions depend on its bearing.</p>
 */
public class Caravel extends Ship {
    private static final Integer SIZE = 2;
    private static final String NAME = "Caravela";

    /**
     * @param bearing the bearing where the Caravel heads to
     * @param pos     initial point for positioning the Caravel
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.Ship#getSize()
     */
    /**
     * Returns the size of the caravel.
     *
     * @return the size of the caravel, which is 2
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
