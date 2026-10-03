/**
 *
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a Battleship game session played against a fleet.
 * <p>
 * Keeps track of the valid shots fired and counts invalid shots, repeated
 * shots, hits and sunk ships.
 *
 * @author fba
 */
public class Game implements IGame {
    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;


    /**
     * Creates a new game against the given fleet, with no shots fired yet.
     *
     * @param fleet the fleet that will be targeted during the game
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     * {@inheritDoc}
     * <p>
     * A valid, non-repeated shot is recorded and, if it hits a ship, the hit
     * is registered on that ship.
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Checks whether the given position lies within the board.
     *
     * @param pos the position to check
     * @return {@code true} if the position is inside the board, {@code false} otherwise
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Checks whether a shot has already been fired at the given position.
     *
     * @param pos the position to check
     * @return {@code true} if the position was already targeted, {@code false} otherwise
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }


    /**
     * Prints the board to the console, using '.' for empty positions and the
     * given marker for each of the given positions.
     *
     * @param positions the positions to mark on the board
     * @param marker    the character used to mark those positions
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }


    /**
     * {@inheritDoc}
     * <p>
     * Valid shots are marked with 'X'.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }


    /**
     * {@inheritDoc}
     * <p>
     * Ship positions are marked with '#'.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}
