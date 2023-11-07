package Modul_2;

public abstract class Entity {
   private String name;
   private int health;
   private int attack;
   private int defence;
   public Entity(){}
   
   public Entity(String name, int health, int attack, int defence){
      this.name = name;
      this.health = health;
      this.attack = attack;
      this.defence = defence;
   }
   
   public String getName(){
      return name;
   }
   
   public int getHealth(){
      return health;
   }
   
   public int getAttack(){
      return attack;
   }
   
   public int getDefence(){
      return defence;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   public void setHealth(double health){
      this.health = (int) health;
   }
   
   public void setAttack(int attack){
      this.attack = attack;
   }
   
   public void setDefence(int defence){
      this.defence = defence;
   }
   
   public abstract void showEntity();
}
