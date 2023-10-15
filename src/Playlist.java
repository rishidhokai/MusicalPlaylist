public class Playlist implements Cloneable{
    private final int MAX_SONGS = 51;
    private int size = 0;
    private static int plIndex = 1;
    private SongRecord arySongs [];
    private Playlist aryPlaylist [];
    private String plName = "";

    /**
     * base constructor
     */
    public Playlist() {
      arySongs = new SongRecord[MAX_SONGS];
      aryPlaylist = new Playlist[MAX_SONGS];
    }

    /**
     * @param plName
     * sets the name of a playlist
     */
    public Playlist(String plName) {
        aryPlaylist = new Playlist[MAX_SONGS];
        this.plName = plName;
    }

    /**
     * @param plName
     * sets the name of the Playlist
     */
    public void setPlName(String plName) {
        this.plName = plName;
    }
    /**
     * @return the name of the Playlist
     */
    public String getPlName() {
        return plName;
    }

    /**
     * @param song
     * sets the song that will be added
     * @param position
     * sets the position in which the song will be added
     */
    public void addSong(SongRecord song, int position) {
        int firstNull = 0;
        for (int i = 1; i < MAX_SONGS; i++) {
            if (arySongs[i] == null) {
                firstNull = i;
                break;
            }
        }

        if (arySongs[position] == null) {
            arySongs[position] = song;
            size++;
        }
        else {
            for (int emptySpace = firstNull; arySongs[position] != song; emptySpace--) {
                arySongs[emptySpace] = arySongs[emptySpace-1];
                if (arySongs[position] == arySongs[position+1]) {
                    arySongs[position] = song;
                    size++;
                    break;
                }
            }
        }
    }

    /**
     * @param other
     * sets the name of the playlist to add
     */
    public void addPlaylist(Playlist other) {
        aryPlaylist[plIndex] = other;
        plIndex++;
    }

    /**
     * @param position
     * sets the position in which the song will be removed
     */
    public void removeSong(int position) {
        if (arySongs[position] == null) {
            System.out.println("Nothing to remove");
        }
        else {
            for (int i = 1; i < MAX_SONGS; i++) {
                if (arySongs[i] == null) {
                    continue;
                }
                arySongs[i] = arySongs[i+1];
            }
            size--;
            System.out.println("Song removed at position " + position);
        }
    }

    /**
     * @param position
     * sets the position of the playlist to lookup and see the song
     * @return the song at the provided position
     */
    public SongRecord getSong(int position) {
        return arySongs[position];
    }

    /**
     * Prints all my songs, formatted
     */
    public void printAllSongs() {
        for (int i = 1; i < MAX_SONGS; i++) {
            if (arySongs[i] != null) {
                String seconds = arySongs[i].getSeconds() + "";
                if (arySongs[i].getSeconds() < 10) {
                    seconds = "0" + arySongs[i].getSeconds();
                }
                System.out.printf("%-10d  %-30s  %-30s %-30s", (i), arySongs[i].getTitle(), arySongs[i].getArtist(), (arySongs[i].getMinutes()) + ":" + seconds);
                System.out.println();
            }
            else {
                continue;
            }
        }
    }

    /**
     * Prints all my playlists, formatted
     */
    public void printAllPlaylists() {
        for (int i = 1; i < MAX_SONGS; i++) {
            if (aryPlaylist[i] != null) {
                System.out.printf("%-10d  %-30s", (i), aryPlaylist[i].getPlName());
                System.out.println();
            }
            else {
                continue;
            }
        }
    }

    /**
     * @param originalList
     * sets the original playlist that will be searched
     * @param artist
     * sets the artist name in which to search for
     * @return the new playlist with songs by only given artist
     */
    public static Playlist getSongsByArtist(Playlist originalList, String artist) {
        Playlist songsByArtist = new Playlist();
        int newPlaylist = 1;
        for (int i = 1; i < 51; i++) {
            if (originalList.arySongs[i]!= null) {
                if (originalList.arySongs[i].getArtist().equalsIgnoreCase(artist)) {
                    songsByArtist.addSong(originalList.arySongs[i], newPlaylist);
                    newPlaylist++;
                }
            }
            else {
                continue;
            }
        }
        return songsByArtist;
    }

    /**
     * @return the string representation of a playlist. it think
     */
    public String toString() {
        return super.toString();
    }

    /**
     * @return clone of this playlist
     */
    public Object clone() {
        Playlist plClone = new Playlist();
        for (int i = 1; i < MAX_SONGS; i++) {
            if (arySongs[i]!= null) {
                plClone.addSong(arySongs[i], i);
            }
            else {
                continue;
            }
        }
        return plClone;
    }

    /**
     * @param obj
     * sets the object that is being compared
     * @return T/F depending on if the 2 objects are the same/equal
     */
    public boolean equals (Object obj) {
        //compares 2 playlist for some reason
        if (obj instanceof Playlist) {
            if (this.equals(obj)) {
                return true;
            }
        }
        else {
            System.out.println("Object's not a playlist. compare two of those...");
        }
        return false;
    }

    /**
     * @return the number of songs in the Playlist
     */
    public int size() {
        return size;
    }
}
