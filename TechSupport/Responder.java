import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Responder {
    private Map<String, String> responses;
    private Random random;

    public Responder() {
        responses = new HashMap<>();
        random = new Random();

        // Daftar kata kunci dan respons
        responses.put("error", "Apakah Anda menerima pesan kesalahan? Coba restart sistem.");
        responses.put("help", "Apa yang bisa saya bantu?");
        responses.put("crash", "Kapan crash terjadi? Apakah ada pesan spesifik?");
        responses.put("slow", "Sudahkah Anda memeriksa penggunaan CPU dan RAM?");
        responses.put("update", "Kadang update bisa menyebabkan masalah. Apakah Anda sudah coba rollback?");
        responses.put("virus", "Apakah Anda sudah menjalankan pemindaian antivirus terbaru?");
        responses.put("network", "Periksa koneksi internet Anda atau coba restart router.");
        responses.put("login", "Apakah Anda yakin menggunakan username dan password yang benar?");
        responses.put("install", "Apakah instalasi berhenti di tengah jalan atau muncul pesan kesalahan?");
        responses.put("printer", "Pastikan printer terhubung dan driver-nya sudah diinstal dengan benar.");
    }

    public String generateResponse(String input) {
        String[] words = input.toLowerCase().split("\\s+");
        for (String word : words) {
            if (responses.containsKey(word)) {
                return responses.get(word);
            }
        }

        // Respons umum jika tidak ada kata kunci cocok
        String[] generic = {
            "That sounds interesting. Tell me more.",
            "I see. Can you explain that in more detail?",
            "Hmm, I’m not sure I understand. Please elaborate.",
            "Could you describe the problem more specifically?",
            "That sounds unusual. Tell me more about it."
        };
        return generic[random.nextInt(generic.length)];
    }
}
