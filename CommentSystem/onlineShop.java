public class onlineShop {
    public static void main(String[] args) {
        Salesitem item = new Salesitem("Laptop Asus", 15000000);
        item.addComment("Fajar", "Produk bagus banget!!!", 5);

        item.showInfo();
        
        item.addComment("Cuttlefish", "Recomended banget asli, tapi minus ga ada GPU", 4);
        item.addComment("ILoveZuma", "Buat main Zuma overkill sih", 5);
        item.addComment("Error Line 40", "Test", 40);
        item.addComment("Fajar", "Testing duplicate author", 1);
        
        item.showInfo();
    }
}
