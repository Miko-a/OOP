public class Transaksi {
    private MenuProduk produk;
    private int jumlah;
    private int totalHarga;

    public Transaksi(MenuProduk produk, int jumlah, int totalHarga) {
        this.produk = produk;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "produk=" + produk + ", jumlah=" + jumlah + ", totalHarga=" + totalHarga + '}';
    }
}
