import java.io.IOException;
import java.util.*;

public class MonsterMart {
    ArrayList<MenuProduk> produk = new ArrayList<MenuProduk>();
    ArrayList<Transaksi> transaksiLog = new ArrayList<Transaksi>();

    public MonsterMart() {
        produk.add(new MenuProduk(1, "Beng Beng Maxx", 10000, 5));
        produk.add(new MenuProduk(2, "Makanan Terenak", 12000, 0));
        produk.add(new MenuProduk(3, "Fitbar", 9000, 5));
        produk.add(new MenuProduk(4, "Oreo", 8000, 5));
        produk.add(new MenuProduk(5, "Pocari Sweat", 7000, 5));
        produk.add(new MenuProduk(6, "Chocopi", 6000, 5));
        produk.add(new MenuProduk(7, "Cleo", 5000, 5));
        produk.add(new MenuProduk(8, "Aqua", 4000, 5));
    }

    public void tampilkanMenu() {
        System.out.println("Daftar Menu Produk:");
        for (MenuProduk p : produk) {
            System.out.println(p);
        }
    }

    public void ClearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MonsterMart mart = new MonsterMart();
        Scanner sc = new Scanner(System.in);
        
        char exit = 'n';
        do {
            mart.ClearConsole();

            mart.tampilkanMenu();
            System.out.print("Masukkan ID produk yang ingin dibeli: ");
            int idProduk = sc.nextInt();
            System.out.print("Masukkan jumlah yang ingin dibeli: ");
            int jumlah = sc.nextInt();

            MenuProduk produkDipilih = null;
            for (MenuProduk p : mart.produk) {
                if (p.getId() == idProduk) {
                    produkDipilih = p;
                    break;
                }
            }

            if (produkDipilih != null) {
                if (produkDipilih.getStok() < jumlah) {
                    System.out.println("Stok produk tidak cukup. Silakan hubungi admin untuk refill.");
                } else {
                    int totalHarga = produkDipilih.getHarga() * jumlah;
                    System.out.println("Total harga: " + totalHarga);

                    System.out.print("Masukkan jumlah uang pembayaran: ");
                    int bayar = sc.nextInt();

                    System.out.println("Memproses pembayaran...");

                    if (bayar >= totalHarga) {
                        int kembalian = bayar - totalHarga;
                        produkDipilih.setStok(produkDipilih.getStok() - jumlah); // Kurangi stok

                        Transaksi transaksi = new Transaksi(produkDipilih, jumlah, totalHarga);
                        mart.transaksiLog.add(transaksi);

                        System.out.println("Pembayaran berhasil. Kembalian: " + kembalian);
                        System.out.println("Silakan ambil produk Anda.");
                        System.out.println("Transaksi berhasil: \n" + transaksi);
                    } else {
                        System.out.println("Uang tidak cukup. Transaksi dibatalkan.");
                    }
                }
            } else {
                System.out.println("Produk tidak ditemukan.");
            }
            
            System.out.print("Apakah Anda ingin keluar? (y/n): ");
            exit = sc.next().charAt(0);
        } while (exit != 'y');

        mart.ClearConsole();
        System.out.println("Terima kasih telah menggunakan MonsterMart!");
        sc.close();
    } 
}