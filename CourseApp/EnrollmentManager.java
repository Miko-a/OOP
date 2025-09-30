import java.util.*;
import java.util.stream.Collectors;

public class EnrollmentManager {
    private Map<String, Dosen> dosens = new HashMap<>();
    private Map<String, Mahasiswa> mahasiswas = new HashMap<>();
    private Map<String, MataKuliah> matakuliahs = new HashMap<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    // Dosen
    public void addDosen(Dosen d) { dosens.put(d.getNip(), d); }
    public Dosen findDosen(String nidn) { return dosens.get(nidn); }
    public Collection<Dosen> getAllDosen() {
        return dosens.values();
    }

    // Mahasiswa
    public void addMahasiswa(Mahasiswa m) { mahasiswas.put(m.getNrp(), m); }
    public Mahasiswa findMahasiswa(String nrp) { return mahasiswas.get(nrp); }
    public Collection<Mahasiswa> getAllMahasiswa() {
        return mahasiswas.values();
    }

    // MataKuliah
    public void addMataKuliah(MataKuliah mk) { matakuliahs.put(mk.getKode(), mk); }
    public MataKuliah findMataKuliah(String kode) { return matakuliahs.get(kode); }
    public Collection<MataKuliah> getAllMataKuliah() {
        return matakuliahs.values();
    }

    // Enroll
    public boolean enroll(String nrp, String kode, String semester) {
        Mahasiswa m = findMahasiswa(nrp);
        MataKuliah mk = findMataKuliah(kode);
        if (m == null || mk == null) return false;

        boolean exists = enrollments.stream()
                .anyMatch(e -> e.getMahasiswa().getNrp().equals(nrp)
                        && e.getMataKuliah().getKode().equals(kode)
                        && e.getSemester().equalsIgnoreCase(semester));
        if (exists) return false;

        enrollments.add(new Enrollment(m, mk, semester));
        return true;
    }

    public List<MataKuliah> getKrs(String nrp, String semester) {
        return enrollments.stream()
                .filter(e -> e.getMahasiswa().getNrp().equals(nrp)
                        && e.getSemester().equalsIgnoreCase(semester))
                .map(Enrollment::getMataKuliah)
                .collect(Collectors.toList());
    }

    public List<Enrollment> listEnrollments() {
        return Collections.unmodifiableList(enrollments);
    }

    public boolean unenroll(String nrp, String kode, String semester) {
        return enrollments.removeIf(e ->
                e.getMahasiswa().getNrp().equals(nrp) &&
                e.getMataKuliah().getKode().equals(kode) &&
                e.getSemester().equalsIgnoreCase(semester));
    }
}
