package org.example;

public interface Monster {

    void subtick() throws PlayerDeathException;

    /**
     * This method is used to move the monster
     *
     * @throws PlayerDeathException if the player dies
     */

    void mo() throws PlayerDeathException;

    /**
     * This method is used to attack the player
     */

    void attack() throws PlayerDeathException;

    /**
     * This method is used to get the position of the monster
     */
    String getPos();

    /**
     * This method is used to get the total position of the monster
     */
    int getTotalPos();
}
