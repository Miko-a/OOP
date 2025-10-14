public class MenuProduk {
    private int id;
    private String nama_produk;
    private int harga;
    private int stok; // Tambahkan field stok

    public MenuProduk(int id, String nama_produk, int harga, int stok) {
        this.id = id;
        this.nama_produk = nama_produk;
        this.harga = harga;
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public int getId() {
        return id;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override   
    public String toString() {
        return id + " " + nama_produk + " " + harga + ", stok = " + stok;
    }
}