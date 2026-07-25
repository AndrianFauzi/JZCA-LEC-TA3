public class Lagu {
    //===ATRIBUT===
    private String judul;
    private String artis;
    private int durasi; //dalam hitungan detik

    //===CONSTRUCTOR===
    public Lagu(String judul, String artis, int durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    //===GETTER===
    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public int getDurasi() {
        return durasi;
    }

    //tampilan dalam format menit:detik (mm:ss)
    public String getDurasiFormatted() {
        int menit = durasi / 60;
        int detik = durasi % 60;
        return String.format("%d:%02d", menit, detik);
    }

    //Override agar format rapih
    @Override
    public String toString() {
        return judul +  " - " + artis + " (" + getDurasiFormatted() + ")";
    }
}
