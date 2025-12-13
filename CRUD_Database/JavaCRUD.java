package CRUD_Database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * JavaCRUD - Aplikasi Manajemen Perpustakaan
 * 
 * Program ini menyediakan fungsi CRUD (Create, Read, Update, Delete)
 * untuk mengelola data buku di database perpustakaanJAVA menggunakan MySQL.
 * 
 * Database: perpustakaanJAVA
 * Tabel: buku (id_buku, judul, pengarang)
 */
public class JavaCRUD {
    // Konstanta untuk koneksi database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  // Driver MySQL
    static final String DB_URL = "jdbc:mysql://localhost:4306/perpustakaan?useSSL=false&serverTimezone=UTC";  // URL database
    static final String USER = "root";  // Username MySQL
    static final String PASS = "";  // Password MySQL
    
    // Objek untuk koneksi dan eksekusi query
    static Connection conn;  // Koneksi ke database
    static Statement stmt;  // Objek untuk eksekusi query SQL
    static ResultSet rs;  // Menyimpan hasil query SELECT
    
    // Objek untuk input dari user
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    /**
     * Method main - Entry point program
     * 
     * Fungsi:
     * 1. Memuat driver MySQL
     * 2. Membuat koneksi ke database
     * 3. Menampilkan menu utama dalam loop
     * 4. Menutup koneksi saat selesai
     */
    public static void main(String[] args) {
        try {
            // Mendaftarkan driver MySQL
            Class.forName(JDBC_DRIVER);

            // Membuat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Loop menu selama koneksi masih aktif
            while (!conn.isClosed()) {
                showMenu();
            }

            // Menutup statement dan koneksi
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method showMenu - Menampilkan menu utama
     * 
     * Menu pilihan:
     * 1. Insert Data (Tambah buku baru)
     * 2. Show Data (Lihat semua buku)
     * 3. Edit Data (Ubah data buku)
     * 4. Delete Data (Hapus buku)
     * 0. Keluar (Tutup program)
     */
    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            // Switch untuk menjalankan fungsi sesuai pilihan user
            switch (pilihan) {
                case 0:
                    System.exit(0);  // Keluar dari program
                    break;
                case 1:
                    insertBuku();  // Tambah buku
                    break;
                case 2:
                    showData();  // Tampilkan semua buku
                    break;
                case 3:
                    updateBuku();  // Update buku
                    break;
                case 4:
                    deleteBuku();  // Hapus buku
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method showData - Menampilkan semua data buku
     * 
     * Query: SELECT * FROM buku
     * Output: Menampilkan ID, Judul, dan Pengarang dalam format tabel
     */
    static void showData() {
        String sql = "SELECT * FROM buku";

        try {
            // Eksekusi query SELECT
            rs = stmt.executeQuery(sql);

            System.out.println("+--------------------------------+");
            System.out.println("| DATA BUKU DI PERPUSTAKAAN |");
            System.out.println("+--------------------------------+");

            // Loop menampilkan setiap baris hasil query
            while (rs.next()) {
                int idBuku = rs.getInt("id_buku");  // Ambil ID buku
                String judul = rs.getString("judul");  // Ambil judul
                String pengarang = rs.getString("pengarang");  // Ambil pengarang

                System.out.println(String.format("%d. %s -- (%s)", idBuku, judul, pengarang));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method insertBuku - Menambahkan buku baru ke database
     * 
     * Proses:
     * 1. Minta input judul dari user
     * 2. Minta input pengarang dari user
     * 3. Buat query INSERT
     * 4. Eksekusi query ke database
     */
    static void insertBuku() {
        try {
            // Ambil input dari user
            System.out.print("Judul: ");
            String judul = input.readLine().trim();

            System.out.print("Pengarang: ");
            String pengarang = input.readLine().trim();

            // Buat query insert dengan placeholder %s
            String sql = "INSERT INTO buku (judul, pengarang) VALUE('%s', '%s')";
            sql = String.format(sql, judul, pengarang);

            // Eksekusi query insert ke database
            stmt.execute(sql);
            System.out.println("Data berhasil ditambahkan!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method updateBuku - Mengubah data buku yang sudah ada
     * 
     * Proses:
     * 1. Minta ID buku yang akan diedit
     * 2. Minta input judul baru
     * 3. Minta input pengarang baru
     * 4. Buat query UPDATE
     * 5. Eksekusi query ke database
     */
    static void updateBuku() {
        try {
            // Ambil input dari user
            System.out.print("ID yang mau diedit: ");
            int idBuku = Integer.parseInt(input.readLine());
            
            System.out.print("Judul: ");
            String judul = input.readLine().trim();
            
            System.out.print("Pengarang: ");
            String pengarang = input.readLine().trim();

            // Buat query UPDATE dengan WHERE clause
            String sql = "UPDATE buku SET judul='%s', pengarang='%s' WHERE id_buku=%d";
            sql = String.format(sql, judul, pengarang, idBuku);

            // Eksekusi query update ke database
            stmt.execute(sql);
            System.out.println("Data berhasil diupdate!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method deleteBuku - Menghapus data buku dari database
     * 
     * Proses:
     * 1. Minta ID buku yang akan dihapus
     * 2. Buat query DELETE dengan WHERE clause
     * 3. Eksekusi query ke database
     * 4. Tampilkan pesan konfirmasi
     */
    static void deleteBuku() {
        try {
            // Ambil input ID buku dari user
            System.out.print("ID yang mau dihapus: ");
            int idBuku = Integer.parseInt(input.readLine());

            // Buat query DELETE dengan WHERE clause untuk ID tertentu
            String sql = String.format("DELETE FROM buku WHERE id_buku=%d", idBuku);

            // Eksekusi query delete dari database
            stmt.execute(sql);

            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
