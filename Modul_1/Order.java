package Modul_1;

public class Order {
   private Barang barang;
   private int amount;

   public Order(Barang barang, int amount) {
      this.barang = barang;
      this.amount = amount;
   }

   public int getTotalPrice() {
      return this.barang.getPrice() * this.amount;
   }

   public Barang getBarang() {
      return this.barang;
   }

   public int getAmount() {
      return this.amount;
   }

   public void printNota() {
      System.out.println(barang.getName() + " x " + getAmount() + " = Rp" + getTotalPrice());
   }

}
