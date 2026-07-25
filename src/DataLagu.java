/*
 * Class DataLagu
 * Digunakan untuk menyediakan data playlist lagu HIVI!
 * untuk eksperimen n = 3, n = 5, dan n = 10.
 */
public class DataLagu {
    // Data testing 3 lagu
    public static Lagu[] buatPlaylist3() {
        return new Lagu[] {
                new Lagu("Remaja", "HIVI!", 3.38),
                new Lagu("Siapkah Kau 'Tuk Jatuh Cinta Lagi", "HIVI!", 4.06),
                new Lagu("Pelangi", "HIVI!", 3.42)
        };
    }
    // Data testing 5 lagu
    public static Lagu[] buatPlaylist5() {
        return new Lagu[] {
                new Lagu("Remaja", "HIVI!", 3.38),
                new Lagu("Siapkah Kau 'Tuk Jatuh Cinta Lagi", "HIVI!", 4.06),
                new Lagu("Pelangi", "HIVI!", 3.42),
                new Lagu("Mata Ke Hati", "HIVI!", 3.48),
                new Lagu("Orang Ke 3", "HIVI!", 4.02)
        };
    }
    // Data testing 10 lagu
    public static Lagu[] buatPlaylist10() {
        return new Lagu[] {
                new Lagu("Remaja", "HIVI!", 3.38),
                new Lagu("Siapkah Kau 'Tuk Jatuh Cinta Lagi", "HIVI!", 4.06),
                new Lagu("Pelangi", "HIVI!", 3.42),
                new Lagu("Mata Ke Hati", "HIVI!", 3.48),
                new Lagu("Orang Ke 3", "HIVI!", 4.02),
                new Lagu("Kereta Kencan", "HIVI!", 4.10),
                new Lagu("Sama-Sama Tahu", "HIVI!", 3.52),
                new Lagu("Tersenyum, Untuk Siapa?", "HIVI!", 3.45),
                new Lagu("Musim Hujan", "HIVI!", 3.56),
                new Lagu("Bumi dan Bulan", "HIVI!", 4.15)
        };
    }
}