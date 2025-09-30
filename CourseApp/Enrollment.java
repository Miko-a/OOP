public class Enrollment {
    private Mahasiswa mahasiswa;
    private MataKuliah mataKuliah;
    private String semester;

    public Enrollment(Mahasiswa mahasiswa, MataKuliah mataKuliah, String semester) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.semester = semester;
    }

    public Mahasiswa getMahasiswa() { return mahasiswa; }
    public MataKuliah getMataKuliah() { return mataKuliah; }
    public String getSemester() { return semester; }

    @Override
    public String toString() {
        return String.format("%s mengambil kelas %s '%s' pada semester: %s",
                mahasiswa.getNrp(), mataKuliah.getKode(), mataKuliah.getNama(), semester);
    }
}
