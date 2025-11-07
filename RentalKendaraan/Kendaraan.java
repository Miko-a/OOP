package RentalKendaraan;

public class Kendaraan {
    private String merk;
    private String model;
    private int tahunProduksi;
    private boolean tersedia = true;

    public Kendaraan(String merk, String model, int tahunProduksi) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
    }

    public void setTersedia () { tersedia = false;}

    public String getMerk() { return merk;}
    public String getModel() { return model;}
    public int getTahunProduksi() { return tahunProduksi;}
    public boolean getTersedia() { return tersedia;}

    public String detailInformation() {
         return merk + " " + model + " (" + tahunProduksi + ")";
    }
}
