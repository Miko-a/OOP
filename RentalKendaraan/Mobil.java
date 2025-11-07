package RentalKendaraan;

public class Mobil extends Kendaraan{
    private int jumlahRoda;

    public Mobil(String merk, String model, int tahunProduksi, int jumlahRoda) {
        super(merk, model, tahunProduksi); // reference to mobil's constructor
        this.jumlahRoda = jumlahRoda;
    }

    public int getJumlahRoda() { return jumlahRoda;}

    public String detailInformation() {
        return "Mobil: " + super.detailInformation() + ", Jumlah roda: " + jumlahRoda;
    }
}
