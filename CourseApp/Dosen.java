public class Dosen {
    private String nip;
    private String nama;
    private String jabatan;

    public Dosen(String nip, String nama, String jabatan) {
        this.nip = nip;
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public String getNip() { return nip; }
    public String getNama() { return nama; }
    public String getJabatan() { return jabatan; }

    public void setNama(String nama) {
        if (nama == null || nama.isEmpty()) throw new IllegalArgumentException("Nama tidak boleh kosong");
        this.nama = nama;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s)", nip, nama, jabatan);
    }
}
