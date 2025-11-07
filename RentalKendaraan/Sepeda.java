package RentalKendaraan;

public class Sepeda extends Kendaraan {
    private String jenisSepeda;

    public Sepeda(String merk, String model, int tahunProduksi, String jenisSepeda) {
        super(merk, model, tahunProduksi); // reference to Kendaraan's constructor
        this.jenisSepeda = jenisSepeda;
    }

    // getter
    public String getJenisSepeda() { return jenisSepeda;}

    public String detailInformation() {
        return "Sepeda: " + super.detailInformation() + ", Jenis sepeda: " + jenisSepeda;
    }
}
