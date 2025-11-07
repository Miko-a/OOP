package RentalKendaraan;

public class Penyewa {
    private String name;
    private String startDate;
    private int duration;
    private Kendaraan kendaraanVar;

    public Penyewa (String name, String startDate, int duration, Kendaraan kendaraan) {
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
        this.kendaraanVar = kendaraan;
    }

    public String getName() { return name;}
    public String getStartDate() { return startDate;}
    public int getDuration() { return duration;}
    public Kendaraan getKendaraan() { return kendaraanVar;}

    public void detailInformation() {
        System.out.println(name + " - Durasi sewa: " + duration + " hari , mulai " + startDate + " , Kendaraan: " + kendaraanVar.detailInformation());
    }

    @Override
    public String toString() {
        return name + " " + kendaraanVar.detailInformation();
    }
}