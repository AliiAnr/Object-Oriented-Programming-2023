package Modul_1;

public class Sepatu extends Barang{
   
   private int shoeSize;
   
   public Sepatu (String name, int price, int shoeSize){
       super(name, price);
       this.shoeSize = shoeSize;
   }
    
   public int getShoeSize(){
       return this.shoeSize;
   }
   
   public void setShoeSize(int shoeSize){
       this.shoeSize = shoeSize;
   }
   
   @Override
   public void reduceStock(int amount){
       super.reduceStock(amount);
   }
}
