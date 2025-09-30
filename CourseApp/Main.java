import java.util.*;

public class Main {
    public static void main(String[] args) {
        EnrollmentManager mgr = new EnrollmentManager();
        seedData(mgr);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Sistem Pengambilan Mata Kuliah ===");
            System.out.println("1. List Dosen");
            System.out.println("2. List Mahasiswa");
            System.out.println("3. List Mata Kuliah");
            System.out.println("4. Enroll Mahasiswa ke Mata Kuliah");
            System.out.println("5. Lihat KRS Mahasiswa per Semester");
            System.out.println("6. Unenroll");
            System.out.println("7. List Semua Enrollments");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            String pilih = sc.nextLine().trim();

            switch (pilih) {
                case "1" -> mgr.getAllDosen().forEach(System.out::println);
                case "2" -> mgr.getAllMahasiswa().forEach(System.out::println);
                case "3" -> mgr.getAllMataKuliah().forEach(System.out::println);

                case "4" -> {
                    System.out.print("NRP: ");
                    String nrp = sc.nextLine();
                    System.out.print("Kode MK: ");
                    String kode = sc.nextLine();
                    System.out.print("Semester: ");
                    String sem = sc.nextLine();
                    System.out.println(mgr.enroll(nrp, kode, sem) ? "Enroll sukses" : "Enroll gagal");
                }
                case "5" -> {
                    System.out.print("NRP: ");
                    String nrp = sc.nextLine();
                    System.out.print("Semester: ");
                    String sem = sc.nextLine();
                    mgr.getKrs(nrp, sem).forEach(System.out::println);
                }
                case "6" -> {
                    System.out.print("NRP: ");
                    String nrp = sc.nextLine();
                    System.out.print("Kode MK: ");
                    String kode = sc.nextLine();
                    System.out.print("Semester: ");
                    String sem = sc.nextLine();
                    System.out.println(mgr.unenroll(nrp, kode, sem) ? "Berhasil dihapus" : "Gagal hapus");
                }
                case "7" -> mgr.listEnrollments().forEach(System.out::println);
                case "0" -> {
                    sc.close();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }

    private static void seedData(EnrollmentManager mgr) {
        Dosen d1 = new Dosen("D001", "Dr. Riyanarto Sarno", "Profesor");
        Dosen d2 = new Dosen("D002", "Siti Aminah", "Lektor");
        mgr.addDosen(d1);
        mgr.addDosen(d2);

        Mahasiswa m1 = new Mahasiswa("5025241193", "Farrel Jatmiko", "Teknik Informatika");
        Mahasiswa m2 = new Mahasiswa("5025241194", "Aldo Pratama", "Teknik Informatika");
        mgr.addMahasiswa(m1);
        mgr.addMahasiswa(m2);

        MataKuliah mk1 = new MataKuliah("IF101", "Algoritma dan Pemrograman", 3, d1);
        MataKuliah mk2 = new MataKuliah("IF102", "Struktur Data", 3, d1);
        MataKuliah mk3 = new MataKuliah("MTK101", "Matematika Diskrit", 2, d2);
        mgr.addMataKuliah(mk1);
        mgr.addMataKuliah(mk2);
        mgr.addMataKuliah(mk3);

        mgr.enroll(m1.getNrp(), mk1.getKode(), "1");
        mgr.enroll(m1.getNrp(), mk2.getKode(), "1");
    }
}
