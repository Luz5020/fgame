package org.example;

import java.util.Random;

public class LeftMonster implements Monster {
    public int position;
    public int ailevel;
    private final String[] posprint =
            new String[]{"LivingRoomCenter", "LivingRoomLeft", "LHallwayFar", "LHallwayClose"};

    public LeftMonster(int ailevel) {
        position = 0;
        this.ailevel = ailevel;
    }
    /**
     * This method is used to get the position of the monster
     */
    @Override
    public String getPos() {
        return posprint[position];
    }
/**
     * This method is used to get the total position of the monster
     */
    @Override
    public int getTotalPos() {
        return position;
    }
    /**
     * This method is used to subtick the monster
     *
     * @throws PlayerDeathException
     */
    @Override
    public void subtick() throws PlayerDeathException {
        mo();
    }

    /**
     * This method is used to move the monster
     *
     * @throws PlayerDeathException
     */
    @Override
    public void mo() throws PlayerDeathException {
        // generate number bewteen 1 and 100
        int randint = new Random().nextInt(100) + 1;
        if (randint < ailevel) {
            if (position == 0) {
                position = 1;
            } else if (position == 3) {
                System.out.println("Left Monster: Attack Opportunity");
                attack();
            } else if (randint % 2 == 0) {
                ++position;
            } else {
                --position;
            }
            System.out.println("Left Monster: Moved to: " + getPos());
        } else {
            System.out.println("Left Monster: Failed Movement Opportunity");
        }
    }

    /*This method is used to attack the player*/
    @Override
    public void attack() throws PlayerDeathException {
        // generate number bewteen 1 and 100
        int randint = new Random().nextInt(100) + 1;
        if (randint < ailevel) {
            throw new PlayerDeathException();
        } else {
            System.out.println("Left Monster: Attack failed");
            position = 2;
        }
    }
}
