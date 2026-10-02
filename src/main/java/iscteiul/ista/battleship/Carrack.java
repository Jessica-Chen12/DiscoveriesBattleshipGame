/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Represents a carrack ship in the Battleship game.
 *
 * <p>A carrack occupies three positions on the game board. Its positions depend on its bearing.</p>
 */
public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Creates a new carrack with the specified bearing and initial position.
     *
     * @param bearing the bearing of the carrack
     * @param pos the initial position of the carrack
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.Ship#getSize()
     */
    /**
     * Returns the size of the carrack.
     *
     * @return the size of the carrack, which is 3
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}
