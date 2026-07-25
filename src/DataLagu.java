import java.util.ArrayList;

public class DataLagu {

    //DATA TESTING 3 LAGU
    public static ArrayList<Lagu> buatPlaylist3() {
        ArrayList<Lagu> playlist = new ArrayList<>();
        playlist.add(new Lagu("Bohemian Rhapsody", "Queen", 355));
        playlist.add(new Lagu("Shape of You",  "Ed Sheeran", 234));
        playlist.add(new Lagu("Blinding Light", "The Weeknd", 200));
        return playlist;
    }

    //DATA TESTING 5 LAGU
    public static ArrayList<Lagu> buatPlaylist5() {
        ArrayList<Lagu> playlist = buatPlaylist3();
        playlist.add(new Lagu ("Someone Like You", "Adele", 284));
        playlist.add(new Lagu ("Uptown Funk", "Bruno Mars", 269));
        return playlist;
    }

    //DATA TESTING 10 LAGU
    public static ArrayList<Lagu> buatPlaylist10() {
        ArrayList<Lagu> playlist = buatPlaylist5();
        playlist.add(new Lagu ("Clair de Lune", "Debussy", 312));
        playlist.add(new Lagu ("Earth Song", "Michael Jackson", 404));
        playlist.add(new Lagu ("Rolling in the Deep", "Adele", 228));
        playlist.add(new Lagu ("Perahu Kertas", "Maudy Ayunda", 235));
        playlist.add(new Lagu ("Elder Flower", "HIGE DANDISM", 292));
        return playlist;
    }
}
