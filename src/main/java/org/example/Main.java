package org.example;

import java.util.concurrent.TimeUnit;

public class Main {
    /* main method */
    public static void main(String[] args) {
        boolean win = true;
        int maintick = 0;
        LeftMonster MonsterL = new LeftMonster(25);
        RightMonster MonsterR = new RightMonster(20);
        System.out.println("Succesfully created a new game");
        System.out.println(
                "Initialized Monster Left at " + MonsterL.getPos() + " and AI level " + MonsterL.ailevel);
        System.out.println(
                "Initialized Monster Right at " + MonsterR.getPos() + " and AI level " + MonsterL.ailevel);
        print(0,0);
        while (maintick < 500) {
            System.out.println("Tick: " + maintick);
            try {
                MonsterL.subtick();
                MonsterR.subtick();
            } catch (PlayerDeathException e) {
                System.out.println("Spieler ist gestorben");
                win = false;
                break;
            }
            print(MonsterL.getTotalPos(), MonsterR.getTotalPos());
            maintick++;
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("Broken");
            }
        }
        if (win) {
            System.out.println("Spieler hat gewonnen");
        }
    }
    /* print method */
    public static void print(int LeftMonster, int Rightmonster) {
        String[] row1 = new String[]{"2", "1", "1", "2", "3"};
        String[] row2 = new String[]{"3", "4"};
        String[] row3 = new String[]{"4", "5"};
        if (LeftMonster <= 1) {
            row1[LeftMonster] = "#";
        }
        if (LeftMonster == 2) {
            row2[0] = "#";
        }
        if (LeftMonster == 3) {
            row3[0] = "#";
        }
        if (Rightmonster <= 2) {
            row1[Rightmonster + 2] = "#";
        }
        if (Rightmonster == 3) {
            row2[1] = "#";
        }
        if (Rightmonster == 4) {
            row3[1] = "#";
        }
        System.out.println("[" + row1[1] + "]-[" + row1[0] + "]|[" + row1[2] + "]-[" + row1[3] + "]-[" + row1[4] + "]");
        System.out.println("[" + row2[0] + "]         [" + row2[1] + "]");
        System.out.println("[" + row3[0] + "]         [" + row3[1] + "]");
    }
    // []-[]|[]-[]-[]
    // []       []
    // []       []
}
