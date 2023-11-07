package Modul_2;

public class Monster extends Entity implements Behavior {
   private int count;
   
   public Monster(String name,int health,int attack,int defence){
      super(name,health,attack,defence);
   }
   
   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   @Override
   public void showEntity() {
      System.out.println("Monster: " + getName() + " | " + "Health: " + getHealth() + " | " + "Attack: " + getAttack()
            + " | " + "Defence: " + getDefence() + " |");
   }

   @Override
   public void dead() {
      System.out.println("The monster " + getName() + " is dead!");
   }

   @Override
   public int specialSKill() {
      if (getCount() == 3) {
         setCount(0);
         return getHealth() + (getHealth()/2);
      }
      return 0;
   }
   
   public double attack(Entity enemy){
      double demage = getAttack() - enemy.getDefence();
      if (demage < 0) {
         demage = 0;
      }
      return demage;
   }
   
}
