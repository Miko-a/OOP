package RentalKendaraan;

public class Kendaraan {
    private String merk;
    private String model;
    private int tahunProduksi;

    public Kendaraan(String merk, String model, int tahunProduksi) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    public String getMerk() { return merk;}
    public String getModel() { return model;}
    public int getTahunProduksi() { return tahunProduksi;}

    public String detailInformation() {
         return merk + " " + model + " (" + tahunProduksi + ")";
    }
}
