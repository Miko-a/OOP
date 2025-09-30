public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private Dosen dosen;

    public MataKuliah(String kode, String nama, int sks, Dosen dosen) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.dosen = dosen;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSks() { return sks; }
    public Dosen getDosen() { return dosen; }

    @Override
    public String toString() {
        return String.format("%s: %s (%d SKS) - %s", kode, nama, sks, dosen.getNama());
    }
}
