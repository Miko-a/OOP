package RentalKendaraan;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private ArrayList<Kendaraan> kendaraanVar;
    private ArrayList<Penyewa> penyewaVar;

    public Main() {
        kendaraanVar = new ArrayList<>();
        penyewaVar = new ArrayList<>();

        // seed kendaraan
        // index 0 - 5
        kendaraanVar.add(new Mobil("Toyota", "Avanza", 2018, 4));
        kendaraanVar.add(new Mobil("Honda", "Brio", 2019, 4));
        kendaraanVar.add(new Mobil("Suzuki", "Ertiga", 2020, 4));
        kendaraanVar.add(new Mobil("Daihatsu", "Xenia", 2017, 4));
        kendaraanVar.add(new Mobil("Mitsubishi", "Pajero", 2016, 4));
        kendaraanVar.add(new Mobil("Toyota", "Hiace", 2021, 4));

        // index 6 - 9
        kendaraanVar.add(new Motor("Yamaha", "NMAX", 2020, 2));
        kendaraanVar.add(new Motor("Honda", "Beat", 2019, 2));
        kendaraanVar.add(new Motor("Suzuki", "Satria", 2018, 2));
        kendaraanVar.add(new Motor("Kawasaki", "Ninja", 2021, 2));

        // index 10 - 13
        kendaraanVar.add(new Sepeda("Polygon", "Heist", 2021, "Sport"));
        kendaraanVar.add(new Sepeda("Giant", "ATX", 2020, "Gunung"));
        kendaraanVar.add(new Sepeda("United", "Boston", 2019, "Sport"));
        kendaraanVar.add(new Sepeda("Wimcycle", "Element", 2022, "Anak-anak"));

        // seed penyewa
        penyewaVar.add(new Penyewa("Andi", "05-11-2025", 3, kendaraanVar.get(0)));      // mobil
        penyewaVar.add(new Penyewa("Budi", "12-06-2024", 1, kendaraanVar.get(1)));      // mobil
        penyewaVar.add(new Penyewa("Citra", "01-07-2024", 6, kendaraanVar.get(5)));     // mobil
        penyewaVar.add(new Penyewa("Dewi", "20-08-2024", 2, kendaraanVar.get(6)));      // motor
        penyewaVar.add(new Penyewa("Eko", "15-09-2024", 5, kendaraanVar.get(7)));       // motor
        penyewaVar.add(new Penyewa("Faisal", "30-10-2024", 4, kendaraanVar.get(9)));    // motor
        penyewaVar.add(new Penyewa("Gita", "22-11-2024", 0, kendaraanVar.get(10)));     // sepeda
    }
    
    // this function is template from google
    public void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    public void showMenu() {
        System.out.println("==========================================================");
        System.out.println("Selamat datang di Rental Kendaraan OOP!");
        System.out.println("Silahkan pilih salah satu menu yang tersedia.");
        System.out.println("1. Lihat daftar kendaraan yang tersedia.");
        System.out.println("2. Tampilkan daftar penyewa beserta kendaraan yang disewa.");
        System.out.println("3. Ajukan sewa");
        System.out.println("4. Batalkan sewa");
        System.out.println("5. Keluar");
        System.out.print("Pilihan menu: ");
    }

    public static void main(String[] args) {
        Main mainObj = new Main();  
        Scanner scan = new Scanner(System.in);

        int pilihan = 0;
        
        while (pilihan != 5) {
            mainObj.showMenu();
            pilihan = scan.nextInt();
            scan.nextLine(); 
            switch (pilihan) {
                case 1: // List kendaraan
                    mainObj.clearConsole();
                    System.out.println("List kendaraan: ");
                    for (int i = 1; i <= mainObj.kendaraanVar.size(); i++) {
                        System.out.print(i + ". ");
                        System.out.println(mainObj.kendaraanVar.get(i-1).detailInformation());
                    }
                    break;

                case 2: // List penyewa
                    mainObj.clearConsole();
                    System.out.println("List penyewa:");
                    for (int i = 1; i <= mainObj.penyewaVar.size(); i++) {
                        System.out.print(i + ". ");
                        mainObj.penyewaVar.get(i-1).detailInformation();
                    }
                    break;

                case 3: // Ajuan sewa
                    System.out.print("Masukkan nama anda: ");
                    String addNama = scan.nextLine();
                    
                    System.out.print("Masukkan tanggal mulai sewa (DD-MM-YYYY): ");
                    String date = scan.nextLine();

                    System.out.print("Masukkan durasi sewa yang diinginkan: ");
                    int duration = scan.nextInt();

                    System.out.print("Masukkan nomor kendaraan yang ingin anda sewa: ");
                    int idx = scan.nextInt();
                    scan.nextLine(); // consume newline after reading idx

                    System.out.println("Terima kasih, permintaan anda sedang diproses.");

                    Kendaraan kend = mainObj.kendaraanVar.get(idx - 1);
                    mainObj.penyewaVar.add(new Penyewa(addNama, date, duration, kend));
                    
                    break;

                case 4: // Batalkan sewa
                    System.out.print("Masukkan nama anda untuk proses pencarian data: ");
                    String deleteNama = scan.nextLine();

                    int foundIndex = -1;
                    for (int i = 0; i < mainObj.penyewaVar.size(); i++) {
                        if (mainObj.penyewaVar.get(i).toString().contains(deleteNama)) {
                            foundIndex = i;
                            break;
                        }
                    }
                    if (foundIndex >= 0) {
                        mainObj.penyewaVar.remove(foundIndex);
                        mainObj.clearConsole();
                        System.out.println("Sewa berhasil dibatalkan.");
                    } else {
                        mainObj.clearConsole();
                        System.out.println("Nama tidak ditemukan.");
                    }
                    break;

                case 5:
                    mainObj.clearConsole();
                    System.out.println("Terima kasih! Sampai jumpa lagi!");
                    break;

                default:
                    mainObj.clearConsole();
                    System.out.println("Pilihan tidak valid. Silahkan pilih ulang!");
                    break;
            }
        }
        scan.close();
    }

    
}
