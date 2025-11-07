package RentalKendaraan;

public class Motor extends Kendaraan{
    private int jumlahRoda;

    public Motor (String merk, String model, int tahunProduksi, int jumlahRoda) {
        super(merk, model, tahunProduksi); // reference to Kendaraan's constructor
        this.jumlahRoda = jumlahRoda;
    }

    public int getJumlahRoda() { return jumlahRoda;}

    public String detailInformation() {
        return "Motor: " + super.detailInformation() + ", Jumlah roda: " + jumlahRoda;
    }
}
