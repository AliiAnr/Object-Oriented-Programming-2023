package Modul_1;

public class Bank extends User {
   private int id;
   private boolean active = true;
   private double bankDiscount = 0;
   
   public Bank(String name, int id){
       super(name);
       this.id = id;
   }
   
   public int getId(){
       return this.id;
   }
   
   public boolean getActive(){
       return this.active;
   }
   
   public double getBankDiscount(){
       return this.bankDiscount;
   }
   
   public void setId(int id){
       this.id = id;
   }
   
   public void setBankDiscount(int bankDiscount){
       this.bankDiscount = bankDiscount;
   }
   
   public void setActive(boolean active){
       this.active = active;
   }
   
   public boolean isActive(){
       return this.active;
   }
}
