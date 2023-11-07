package Modul_1;

public class Baju extends Barang{
   private String size;
   
   public Baju(String name, int price, String size){
       super(name, price);
       this.size = size;
   }
   
   public String getSize(){
       return this.size;
   }
   
   public void setSize(String size){
       this.size = size;
   }
   
   @Override
   public void setStock(int stock){
       super.setStock(stock);
   }
   
   @Override
   public void reduceStock(int amount){
      super.reduceStock(amount);
   }
   
   
}
