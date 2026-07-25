/*
 * Class Lagu
 * Digunakan untuk menyimpan data sebuah lagu,
 * yaitu judul, artis, dan durasi.
 */
public class Lagu {
    // Atribut
    private String judul;
    private String artis;
    private double durasi;
    // Constructor
    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }
    // Getter
    public String getJudul() {
        return judul;
    }
    public String getArtis() {
        return artis;
    }
    public double getDurasi() {
        return durasi;
    }
    // Menampilkan informasi lagu
    @Override
    public String toString() {
        return String.format(
                "%s - %s (%.2f menit)",
                judul,
                artis,
                durasi
        );
    }
}