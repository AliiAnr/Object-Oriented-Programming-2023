package Modul_1;

import java.util.ArrayList;

public class User {
   private String name;
   private double saldo;
   ArrayList<Order> orders = new ArrayList<Order>();

   public User(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public double getSaldo() {
      return this.saldo;
   }

   public void setSaldo(double saldo) {
      if (saldo < 50000) {
         System.out.println(getName() + " Pengisian saldo gagal. jumlah minimal pengisian saldo adalah Rp.50,000.");
      } else {
         this.saldo = saldo;
         System.out.println(getName() + " Saldo berhasil diisi sebesar Rp." + getSaldo());
      }
      System.out.println();
   }

   public void setName(String name) {
      this.name = name;
   }

   public void minSaldo(double saldo) {
      this.saldo -= saldo;
   }

   public void addToOrder(Barang barang, int amount) {
      Order order = new Order(barang, amount);
      this.orders.add(order);
   }

   public void payOrder(Bank bank) {
      double total = 0;
      System.out.println("NOTA " + getName());
      System.out.println("Bank di gunakan: " + bank.getName());
      if (bank.getActive() == true) {
         System.out.println("Diskon bank: " + bank.getBankDiscount() + "%");
         for (Order order : this.orders) {
            order.printNota();
            total += order.getTotalPrice();
         }
         System.out.println("Total belanja sebelum diskon: Rp" + total);
         if (bank.getBankDiscount() == 0) {
            System.out.println("Total belanja setelah diskon: Rp" + total);
         } else {
            double afterDiskon = total * (bank.getBankDiscount() / 100);
            total -= afterDiskon;
            System.out.println("Total belanja setelah diskon: Rp" + total);
         }
         if (saldo >= total) {
            minSaldo(total);
            System.out.println("Sisa saldo: " + getSaldo());
            for (Order order : this.orders) {
               System.out.println("Reduced " + order.getBarang().getName() + " stock by " + order.getAmount());
               order.getBarang().reduceStock(order.getAmount());
            }
         } else {
            System.out.println("Pembayaran gagal. Saldo tidak mencukupi.");
         }

      } else {
         System.out.println("Pembayaran tidak dapat diproses karena bank tidak aktif");
      }
      System.out.println();
   }
}
