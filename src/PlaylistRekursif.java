import java.util.ArrayList;

/*
 * Deskripsi:
 * Program ini mengembangkan sistem manajemen playlist musik dengan
 * menambahkan analisis rekursif dan pengukuran efisiensi algoritmik
 * pada tiga operasi utama: totalDurasi, tampilkanMundur, dan cariDurasiTerpanjang.
 * Data lagu (Lagu.java) dan data testing (DataLagu.java) memakai durasi
 * dalam satuan detik dan disimpan dalam ArrayList<Lagu>.
 */
public class PlaylistRekursif {

    static ArrayList<Lagu> playlist;

    // totalDurasi()
    // Tujuan       : menghitung total seluruh durasi lagu (dalam detik) dalam playlist secara rekursif
    // Base case    : n == 0  -> tidak ada lagu tersisa, kembalikan 0
    // Recursive case: durasi lagu ke-(n-1) dijumlahkan dengan totalDurasi(list, n-1)
    // Kompleksitas waktu: O(n), karena setiap elemen array diproses tepat satu kali
    static int totalDurasi(ArrayList<Lagu> list, int n) {
        if (n == 0) {
            return 0;
        }
        return list.get(n - 1).getDurasi() + totalDurasi(list, n - 1);
    }

    /**
     * Fungsi: tampilkanMundur()
     *
     * Tujuan:
     * Menampilkan seluruh daftar lagu dari indeks terakhir hingga indeks pertama
     * menggunakan metode rekursif (reverse traversal).
     *
     * Base Case:
     * Jika index < 0, maka seluruh lagu telah ditampilkan sehingga proses rekursi berhenti.
     *
     * Recursive Case:
     * Menampilkan lagu pada indeks saat ini, kemudian memanggil kembali fungsi
     * dengan index - 1.
     *
     * Big-O:
     * Time Complexity : O(n)
     * Space Complexity: O(n) karena menggunakan call stack rekursif.
     */
    static void tampilkanMundur(ArrayList<Lagu> list, int index) {
        if (index < 0) {
            return;
        }
        System.out.println((index + 1) + ". " + list.get(index));
        tampilkanMundur(list, index - 1);
    }

    /**
     * Fungsi: cariDurasiTerpanjang()
     *
     * Tujuan:
     * Mencari durasi lagu paling panjang pada playlist menggunakan rekursi.
     *
     * Base Case:
     * Jika index == 0, maka durasi lagu pertama langsung dikembalikan.
     *
     * Recursive Case:
     * Membandingkan durasi lagu saat ini dengan hasil pencarian durasi
     * terbesar dari indeks sebelumnya menggunakan Math.max().
     *
     * Big-O:
     * Time Complexity : O(n)
     * Space Complexity: O(n) karena terdapat n pemanggilan rekursif.
     */
    static int cariDurasiTerpanjang(ArrayList<Lagu> list, int index) {
        if (index == 0) {
            return list.get(0).getDurasi();
        }
        int sisaTerpanjang = cariDurasiTerpanjang(list, index - 1);
        return Math.max(list.get(index).getDurasi(), sisaTerpanjang);
    }

    // Fungsi bantu (helper) rekursif untuk mendapatkan objek Lagu dengan durasi
    // terpanjang, dipakai supaya menu output bisa menampilkan judul & artisnya juga
    // (logika dan kompleksitasnya sama seperti cariDurasiTerpanjang: O(n))
    static Lagu cariLaguTerpanjang(ArrayList<Lagu> list, int index) {
        if (index == 0) {
            return list.get(0);
        }
        Lagu sisaTerpanjang = cariLaguTerpanjang(list, index - 1);
        return (list.get(index).getDurasi() > sisaTerpanjang.getDurasi()) ? list.get(index) : sisaTerpanjang;
    }

    // main() - struktur utama program & tampilan menu/output
    public static void main(String[] args) {
        // Data playlist diambil dari DataLagu.java (5 lagu).
        playlist = DataLagu.buatPlaylist5();

        int n = playlist.size();

        System.out.println("=== ANALISIS REKURSIF PLAYLIST ===");
        System.out.println("Jumlah lagu : " + n);

        // Pengukuran waktu eksekusi totalDurasi()
        long startTotal = System.nanoTime();
        int total = totalDurasi(playlist, n);
        long endTotal = System.nanoTime();
        System.out.printf("Total durasi : %d:%02d menit%n", total / 60, total % 60);

        // Pengukuran waktu eksekusi cariDurasiTerpanjang() / cariLaguTerpanjang()
        long startTerpanjang = System.nanoTime();
        Lagu terpanjang = cariLaguTerpanjang(playlist, n - 1);
        long endTerpanjang = System.nanoTime();
        System.out.println("Lagu terpanjang : " + terpanjang);

        System.out.println();
        System.out.println("Daftar lagu (ditampilkan terbalik):");

        // Pengukuran waktu eksekusi tampilkanMundur()
        long startMundur = System.nanoTime();
        tampilkanMundur(playlist, n - 1);
        long endMundur = System.nanoTime();

        System.out.println();
        System.out.println("Execution Time (totalDurasi): " + (endTotal - startTotal) / 1_000_000 + " ms");
        System.out.println("Execution Time (tampilkanMundur): " + (endMundur - startMundur) / 1_000_000 + " ms");
        System.out.println("Execution Time (cariDurasiTerpanjang): " + (endTerpanjang - startTerpanjang) / 1_000_000 + " ms");
    }
}
