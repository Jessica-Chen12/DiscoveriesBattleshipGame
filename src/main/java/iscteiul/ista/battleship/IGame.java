/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Represents a Battleship game session played against a fleet.
 * <p>
 * Defines the operations needed to fire shots at the fleet and to obtain
 * statistics about the game, such as hits, sunk ships and invalid or
 * repeated shots.
 */
public interface IGame {

    /**
     * Fires a shot at the given position.
     * <p>
     * Shots outside the board are counted as invalid and repeated shots are
     * counted as repeated; neither has any effect on the fleet.
     *
     * @param pos the position being targeted
     * @return the ship sunk by this shot, or {@code null} if no ship was sunk
     */
    IShip fire(IPosition pos);

    /**
     * Returns the valid shots fired so far.
     *
     * @return the positions of all valid, non-repeated shots
     */
    List<IPosition> getShots();

    /**
     * Returns the number of shots fired at positions already targeted.
     *
     * @return the number of repeated shots
     */
    int getRepeatedShots();

    /**
     * Returns the number of shots fired outside the board.
     *
     * @return the number of invalid shots
     */
    int getInvalidShots();

    /**
     * Returns the number of shots that hit a ship.
     *
     * @return the number of hits
     */
    int getHits();

    /**
     * Returns the number of ships that have been sunk.
     *
     * @return the number of sunk ships
     */
    int getSunkShips();

    /**
     * Returns the number of ships that are still floating.
     *
     * @return the number of remaining ships
     */
    int getRemainingShips();

    /**
     * Prints the board, marking the positions of all valid shots fired.
     */
    void printValidShots();

    /**
     * Prints the board, showing the positions of all ships in the fleet.
     */
    void printFleet();
}
