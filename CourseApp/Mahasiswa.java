public class Mahasiswa {
    private String nrp;
    private String nama;
    private String jurusan;

    public Mahasiswa(String nrp, String nama, String jurusan) {
        this.nrp = nrp;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public String getNrp() { return nrp; }
    public String getNama() { return nama; }
    public String getJurusan() { return jurusan; }

    public void setNama(String nama) {
        if (nama == null || nama.isEmpty()) throw new IllegalArgumentException("Nama tidak boleh kosong");
        this.nama = nama;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", nrp, nama, jurusan);
    }
}
