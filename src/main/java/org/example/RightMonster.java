package org.example;

import java.util.Random;

public class RightMonster implements Monster {
  public int position;
  public int ailevel;
  private final String[] printpos =
      new String[] {
        "LivingRoomCenter", "LivingRoomRight", "Kitchen", "RHallwayFar", "RHallwayClose"
      };

  public RightMonster(int ailevel) {
    position = 0;
    this.ailevel = ailevel;
  }


  /**
   * This method is used to get the position of the monster
   */
  @Override
  public String getPos() {
    return printpos[position];
  }
  /**
   * This method is used to get the total position of the monster
   */
  @Override
  public int getTotalPos(){return position;}
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
      } else if( position == 1){
        if (randint % 2 == 0){
          position=2;
        }
        else{
          position=3;
        }
      }else if(position == 2){
        position = 1;
      }
      else if (position == 4) {
        System.out.println("Right Monster: Attack Opportunity");
        attack();
      } else if (randint % 2 == 0) {
        ++position;
      } else {
        --position;
      }
      System.out.println("Right Monster: Moved to: " + getPos());
    } else {
      System.out.println("Right Monster: Failed Movement Opportunity");
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
      System.out.println("Right Monster: Attack failed");
      position = 2;
    }
  }
}
