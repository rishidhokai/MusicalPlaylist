public class SongRecord {
    private String title;
    private String artist;
    private int minutes;
    private int seconds;

    public SongRecord () {
        title = "";
        artist = "";
        minutes = 0;
        seconds = 0;
    }

    /**
     * base constructor
     */
    public SongRecord (String title, String artist, int minutes, int seconds) {
        this.title = title;
        this.artist = artist;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * @return song title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return length of songs in minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return length of song in seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * @param title
     * sets the title of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param artist
     * sets the songwriter
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @param minutes
     * sets the length of the song in minutes
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    /**
     * @param seconds
     * sets the length of the song in seconds
     */
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * @return string representation of a song including title, artist, and time
     */
    public String toString() {
        String seconds = getSeconds() + "";
        if (getSeconds() < 10) {
            seconds = "0" + getSeconds();
        }

        String answer = String.format("%-10s %-31s %-30s %-30s", "", getTitle(), getArtist(), (getMinutes() + ":" + seconds) );
        return answer;
    }
}
