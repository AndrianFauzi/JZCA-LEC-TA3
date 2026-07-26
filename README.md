# Playlist Rekursif

## Deskripsi
Program Java yang mengimplementasikan konsep *fungsi rekursif* untuk mengelola playlist lagu.

Program ini memiliki tiga operasi rekursif utama:
- Menghitung total durasi seluruh lagu (totalDurasi())
- Menampilkan playlist dari belakang (tampilkanMundur())
- Mencari lagu dengan durasi terpanjang (cariDurasiTerpanjang())

Selain itu, program juga mengukur waktu eksekusi setiap fungsi menggunakan System.nanoTime().

---

## Struktur Project


PlaylistRekursif.java
Lagu.java
DataLagu.java
README.md


---

## Requirement

- Java Development Kit (JDK) 17 atau lebih baru
- Terminal / Command Prompt / VS Code / IntelliJ IDEA

---

## Cara Compile

Masuk ke folder project, kemudian jalankan:

bash
javac Lagu.java DataLagu.java PlaylistRekursif.java


atau

bash
javac *.java


---

## Cara Menjalankan

bash
java PlaylistRekursif


---

## Data Testing

Data pengujian tersedia pada class DataLagu:

- buatPlaylist3()
- buatPlaylist5()
- buatPlaylist10()

Untuk mengganti jumlah data yang diuji, ubah baris pada method main().

Contoh:

java
playlist = DataLagu.buatPlaylist3();


atau

java
playlist = DataLagu.buatPlaylist5();


atau

java
playlist = DataLagu.buatPlaylist10();


---

## Output Program

Program akan menampilkan:

- Jumlah lagu
- Total durasi playlist
- Lagu dengan durasi terpanjang
- Daftar lagu dalam urutan terbalik
- Execution time setiap fungsi rekursif

---

## Analisis Kompleksitas

| Fungsi | Time Complexity | Space Complexity |
|---------|-----------------|------------------|
| totalDurasi() | O(n) | O(n) |
| tampilkanMundur() | O(n) | O(n) |
| cariDurasiTerpanjang() | O(n) | O(n) |
