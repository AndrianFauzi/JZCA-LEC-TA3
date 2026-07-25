public class PlaylistRekursif {
    /*
     * ============================================================
     * FUNGSI totalDurasi()
     * ============================================================
     *
     * Tujuan:
     * Menghitung total durasi seluruh lagu dalam playlist
     * menggunakan rekursi.
     *
     * Base Case:
     * Jika n == 0, tidak ada lagu yang perlu dijumlahkan,
     * sehingga fungsi mengembalikan 0.
     *
     * Recursive Case:
     * Durasi lagu ke-(n-1) ditambah dengan hasil
     * totalDurasi untuk n-1 lagu sebelumnya.
     *
     * Recurrence:
     * T(n) = T(n-1) + O(1)
     *
     * Growth Rate:
     * Linear
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n), karena menggunakan recursive call stack.
     * ============================================================
     */
    static double totalDurasi(Lagu[] list, int n) {
        // Base case
        if (n == 0) {
            return 0;
        }
        // Recursive case
        return list[n - 1].getDurasi()
                + totalDurasi(list, n - 1);
    }
    /*
     * ============================================================
     * FUNGSI tampilkanMundur()
     * ============================================================
     *
     * Tujuan:
     * Menampilkan lagu dari akhir playlist menuju awal
     * playlist menggunakan rekursi.
     *
     * Base Case:
     * Jika index < 0, seluruh lagu telah ditampilkan
     * dan proses rekursi berhenti.
     *
     * Recursive Case:
     * Menampilkan lagu pada index saat ini, kemudian
     * memanggil fungsi kembali dengan index - 1.
     *
     * Recurrence:
     * T(n) = T(n-1) + O(1)
     *
     * Growth Rate:
     * Linear
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n), karena menggunakan recursive call stack.
     * ============================================================
     */
    static void tampilkanMundur(Lagu[] list, int index) {
        // Base case
        if (index < 0) {
            return;
        }
        // Nomor output tetap maju: 1, 2, 3, ...
        int nomor = list.length - index;
        System.out.println(
                nomor + ". " + list[index]
        );
        // Recursive case
        tampilkanMundur(list, index - 1);
    }
    /*
     * ============================================================
     * FUNGSI cariDurasiTerpanjang()
     * ============================================================
     *
     * Tujuan:
     * Mencari nilai durasi lagu terpanjang dalam playlist
     * menggunakan rekursi.
     *
     * Base Case:
     * Jika index == 0, hanya lagu pertama yang diperiksa,
     * sehingga durasinya langsung dikembalikan.
     *
     * Recursive Case:
     * Mencari durasi terpanjang dari index sebelumnya,
     * kemudian membandingkannya dengan durasi lagu
     * pada index saat ini.
     *
     * Recurrence:
     * T(n) = T(n-1) + O(1)
     *
     * Growth Rate:
     * Linear
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n), karena menggunakan recursive call stack.
     * ============================================================
     */
    static double cariDurasiTerpanjang(
            Lagu[] list,
            int index) {
        // Base case
        if (index == 0) {
            return list[0].getDurasi();
        }
        // Recursive case
        double terpanjangSebelumnya =
                cariDurasiTerpanjang(
                        list,
                        index - 1
                );
        return Math.max(
                list[index].getDurasi(),
                terpanjangSebelumnya
        );
    }
    /*
     * ============================================================
     * FUNGSI cariLaguTerpanjang()
     * ============================================================
     *
     * Tujuan:
     * Mencari objek Lagu dengan durasi terpanjang agar
     * judul dan artisnya dapat ditampilkan.
     *
     * Base Case:
     * Jika index == 0, lagu pertama dikembalikan.
     *
     * Recursive Case:
     * Membandingkan lagu pada index saat ini dengan lagu
     * terpanjang dari index sebelumnya.
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n)
     * ============================================================
     */
    static Lagu cariLaguTerpanjang(
            Lagu[] list,
            int index) {
        // Base case
        if (index == 0) {
            return list[0];
        }
        // Recursive case
        Lagu terpanjangSebelumnya =
                cariLaguTerpanjang(
                        list,
                        index - 1
                );
        if (list[index].getDurasi()
                > terpanjangSebelumnya.getDurasi()) {
            return list[index];
        }
        return terpanjangSebelumnya;
    }
    /*
     * ============================================================
     * FUNGSI jalankanEksperimen()
     * ============================================================
     *
     * Digunakan untuk menjalankan seluruh operasi rekursif
     * dan mengukur execution time untuk playlist tertentu.
     * ============================================================
     */
    static void jalankanEksperimen(Lagu[] playlist) {
        int n = playlist.length;
        System.out.println();
        System.out.println("==============================================");
        System.out.println("===       ANALISIS REKURSIF PLAYLIST       ===");
        System.out.println("==============================================");
        System.out.println("Jumlah lagu : " + n);
        // ========================================================
        // 1. TOTAL DURASI
        // ========================================================
        long startTotal = System.nanoTime();
        double total = totalDurasi(
                playlist,
                n
        );
        long endTotal = System.nanoTime();
        double waktuTotal =
                (endTotal - startTotal) / 1_000_000.0;
        System.out.printf(
                "Total durasi : %.2f menit%n",
                total
        );
        // ========================================================
        // 2. CARI DURASI TERPANJANG
        // ========================================================
        long startTerpanjang = System.nanoTime();
        double durasiTerpanjang =
                cariDurasiTerpanjang(
                        playlist,
                        n - 1
                );
        long endTerpanjang = System.nanoTime();
        double waktuTerpanjang =
                (endTerpanjang - startTerpanjang)
                        / 1_000_000.0;
        /*
         * Mencari objek lagunya untuk menampilkan
         * judul dan artis.
         *
         * Pengukuran waktunya dipisahkan agar execution time
         * cariDurasiTerpanjang hanya mengukur fungsi yang
         * memang diminta dalam tugas.
         */
        Lagu laguTerpanjang =
                cariLaguTerpanjang(
                        playlist,
                        n - 1
                );
        System.out.printf(
                "Lagu terpanjang : \"%s\" - %s (%.2f menit)%n",
                laguTerpanjang.getJudul(),
                laguTerpanjang.getArtis(),
                durasiTerpanjang
        );
        // ========================================================
        // 3. TAMPILKAN PLAYLIST TERBALIK
        // ========================================================
        System.out.println();
        System.out.println(
                "Daftar lagu (ditampilkan terbalik):"
        );
        long startMundur = System.nanoTime();
        tampilkanMundur(
                playlist,
                n - 1
        );
        long endMundur = System.nanoTime();
        double waktuMundur =
                (endMundur - startMundur)
                        / 1_000_000.0;
        // ========================================================
        // 4. EXECUTION TIME
        // ========================================================
        System.out.println();
        System.out.println("=== EXECUTION TIME ===");
        System.out.printf(
                "Execution Time (totalDurasi)          : %.6f ms%n",
                waktuTotal
        );
        System.out.printf(
                "Execution Time (tampilkanMundur)      : %.6f ms%n",
                waktuMundur
        );
        System.out.printf(
                "Execution Time (cariDurasiTerpanjang) : %.6f ms%n",
                waktuTerpanjang
        );
        System.out.println("==============================================");
    }
    /*
     * ============================================================
     * MAIN METHOD
     * ============================================================
     *
     * Menjalankan eksperimen dengan tiga ukuran data:
     * n = 3
     * n = 5
     * n = 10
     * ============================================================
     */
    public static void main(String[] args) {
        // Mengambil data testing
        Lagu[] playlist3 =
                DataLagu.buatPlaylist3();
        Lagu[] playlist5 =
                DataLagu.buatPlaylist5();
        Lagu[] playlist10 =
                DataLagu.buatPlaylist10();
        System.out.println("==============================================");
        System.out.println("     EKSPERIMEN ALGORITMA REKURSIF");
        System.out.println("==============================================");
        // Eksperimen n = 3
        jalankanEksperimen(playlist3);
        // Eksperimen n = 5
        jalankanEksperimen(playlist5);
        // Eksperimen n = 10
        jalankanEksperimen(playlist10);
        System.out.println();
        System.out.println("==============================================");
        System.out.println("          EKSPERIMEN SELESAI");
        System.out.println("==============================================");
    }
}