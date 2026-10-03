/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Represents a galleon, the largest ship in the fleet, occupying 5 positions.
 * <p>
 * Unlike the other ships, the galleon is T-shaped. The orientation of the
 * T depends on the bearing given when the ship is created.
 */
public class Galleon extends Ship {
    private static final Integer SIZE = 5;
    private static final String NAME = "Galeao";

    /**
     * Creates a galleon with the given bearing, starting at the given position.
     *
     * @param bearing the orientation of the galleon
     * @param pos     the starting position of the galleon
     * @throws NullPointerException     if the bearing is {@code null}
     * @throws IllegalArgumentException if the bearing is not a valid orientation
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Returns the size of the galleon.
     *
     * @return the number of positions occupied by the galleon (5)
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Fills the positions of a galleon facing north: a horizontal bar of
     * three positions with a vertical stem of two positions below its centre.
     *
     * @param pos the starting position of the galleon
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Fills the positions of a galleon facing south: a vertical stem of two
     * positions with a horizontal bar of three positions below it.
     *
     * @param pos the starting position of the galleon
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Fills the positions of a galleon facing east: a vertical bar of three
     * positions with a horizontal stem extending to its left.
     *
     * @param pos the starting position of the galleon
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Fills the positions of a galleon facing west: a vertical bar of three
     * positions with a horizontal stem extending to its right.
     *
     * @param pos the starting position of the galleon
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
