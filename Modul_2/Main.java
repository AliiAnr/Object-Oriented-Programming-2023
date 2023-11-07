package Modul_2;

public class Main {
   public static void main(String[] args) {
      Monster monster = new Monster("Sally", 80, 20, 10);
      Alien alien = new Alien("Zograd", 80, 20, 10);
      monster.showEntity();
      alien.showEntity();
      System.out.println();
      System.out.println("Battle Start!");
      System.out.println();
      int turnMons = 1, turnAlien = 1;
      while (true) {

         if (monster.getCount() == 3) {
             System.out.println("The monster use special attack!");
             monster.setHealth(monster.specialSKill());
             System.out.println(monster.getName() + " | " + monster.getHealth());
             System.out.println(alien.getName() + " | " + alien.getHealth());
             System.out.println();
             turnMons = 1;
         } else {
             System.out.println("The monster " + monster.getName() + " attacks " + alien.getName() + " with a normal attack!");
             alien.setHealth(alien.getHealth() - monster.attack(alien));
             turnMons++;
             monster.setCount(turnMons);
             System.out.println(monster.getName() + " | " + monster.getHealth());
             System.out.println(alien.getName() + " | " + alien.getHealth());
             System.out.println();
         }
         if (alien.getCount() == 4) {
             System.out.println("The alien " + alien.getName() + " attacks " + monster.getName() + " with a special attack!");
             monster.setHealth(monster.getHealth() - alien.specialSKill());
             System.out.println(alien.getName() + " | " + alien.getHealth());
             System.out.println(monster.getName() + " | " + monster.getHealth());
             turnAlien = 1;
             System.out.println();
         } else {
             System.out.println("The alien " + alien.getName() + " attacks " + monster.getName() + " with a normal attack!");
             monster.setHealth(monster.getHealth() - alien.attack(monster));
             turnAlien++;
             alien.setCount(turnAlien);
             System.out.println(alien.getName() + " | " + alien.getHealth());
             System.out.println(monster.getName() + " | " + monster.getHealth());
             System.out.println();
         }
     
         if (alien.getHealth() <= 0) {
             alien.dead();
             System.out.println("The monster " + monster.getName() + " Wins!");
             break;
         }
         else if (monster.getHealth() <= 0) {
             System.out.println("The alien " + alien.getName() + " Wins!");
             monster.dead();
             break;
         }
     }
   }
}