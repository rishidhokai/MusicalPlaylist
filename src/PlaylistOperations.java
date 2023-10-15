import java.util.InputMismatchException;
import java.util.Scanner;
public class PlaylistOperations {
    private Playlist pl = new Playlist();
    private SongRecord sr = new SongRecord();

    /**
     * @param args
     * main method
     *
     * prompts the menu in the beginning
     */
    public static void main (String[] args) {
        PlaylistOperations po = new PlaylistOperations();
        Scanner input = new Scanner(System.in);

        System.out.println("(A) Add song");
        System.out.println("(G) Get song");
        System.out.println("(R) Remove song");
        System.out.println("(P) Print all songs");
        System.out.println("(B) Print songs by artist");
        System.out.println("(S) Size");
        System.out.println("(>) Play song");
        System.out.println("(N) New playlist");
        System.out.println("(V) Change playlist");
        System.out.println("(C) Copy playlist paste playlist");
        System.out.println("(E) Compare playlists");
        System.out.println("(D) Print all playlist names ");
        System.out.println("(Q) Quit");

        System.out.print("\nEnter selection: ");



        String option;
        do {
            option = input.next();

            if (option.toUpperCase().charAt(0) == 'Q') {
                break;
            }
            po.choices(option.toUpperCase());
            System.out.print("\nEnter selection: ");
        }
        while (!false);
        po.choices(option.toUpperCase());

    }

    /**
     * @param option
     * takes in a user inputted letter to do a specified action
     */
    public void choices(String option){
        try {
            Scanner input = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            pl.setPlName("Original");
            switch (option) {
                case "A":
                    if (pl.size() == 50) {
                        System.out.println("Playlist's full chief");
                        break;
                    }
                    System.out.print("Enter the song title: ");
                    String title = input.nextLine();

                    System.out.print("Enter the song artist: ");
                    String artist = input2.nextLine();

                    System.out.print("Enter the song length (minutes): ");
                    int mins = input.nextInt();

                    if (mins < 0) {
                        do {
                            System.out.println("Time can't be negative");
                            System.out.print("Enter the song length (minutes): ");
                            mins = input.nextInt();
                        }
                        while (mins < 0);
                    }

                    System.out.print("Enter the song length (seconds): ");
                    int secs = input.nextInt();

                    if (secs < 0 || secs >= 60) {
                        do {
                            if (secs < 0)
                                System.out.println("Seconds cant be negative");
                            if (secs >= 60)
                                System.out.println("Seconds cant be over 60");
                            //                        if (secs )
                            System.out.print("Enter the song length (seconds): ");
                            secs = input.nextInt();
                        }
                        while (secs < 0 || secs >= 60);
                    }

                    System.out.print("Enter the position: ");
                    int pos = input.nextInt();
                    if (pos > pl.size()+1 || pos == 0) {
                        do {
                            if (pos > 50) {
                                System.out.println("position out of range. Must be <50");
                            }
                            else {
                                System.out.println("Can't add here. Fill up empty space");
                            }
                            System.out.print("Enter the position: ");
                            pos = input.nextInt();
                        }
                        while (pos > pl.size()+1 || pos == 0) ;
                    }

                    SongRecord sr = new SongRecord(title, artist, mins, secs);
                    pl.addSong(sr, pos);
                    System.out.println("\n" + title + " by " + artist + " was added to position " + pos);
                    break;
                case "G":
                    System.out.print("Enter the position: ");
                    pos = input.nextInt();
                    if (pl.getSong(pos) == null) {
                        System.out.println("No song at position " + pos + " to remove");
                        break;
                    }
                    int position = (pos);
                    System.out.println();
                    System.out.printf("%-10s  %-30s  %-30s %-30s", "Song#", "Title", "Artist", "Length");
                    System.out.println("\n--------------------------------------------------------------------------------------------");
                    System.out.print(position);
                    System.out.print(pl.getSong(pos).toString());
                    break;
                case "R":
                    System.out.print("Enter the position: ");
                    pos = input.nextInt();
                    if (pos > 50) {
                        do {
                            System.out.println("position out of range. Must be <50");
                            System.out.print("Enter the position: ");
                            pos = input.nextInt();
                        }
                        while (pos > 50);
                    }
                    pl.removeSong(pos);
                    break;
                case "P":
                    System.out.println();
                    System.out.printf("%-10s  %-30s  %-30s %-30s", "Song#", "Title", "Artist", "Length");
                    System.out.println("\n--------------------------------------------------------------------------------------------");
                    pl.printAllSongs();
                    break;
                case "B":
                    System.out.print("Enter the artist: ");
                    artist = input2.nextLine();
                    Playlist aryNewPlaylist = Playlist.getSongsByArtist(pl, artist); //sets new playlist to the new playlist by artist

                    if (aryNewPlaylist.getSong(1) == null) {
                        System.out.println("No songs by the artist " + "\"" + artist + "\"");
                    }
                    else {
                        System.out.printf("%-10s  %-30s  %-30s %-30s", "Song#", "Title", "Artist", "Length");
                        System.out.println("\n--------------------------------------------------------------------------------------------");
                        aryNewPlaylist.printAllSongs();
                    }
                    //HALP
                    break;
                case "S":
                    System.out.println("There are " + pl.size() + " song(s) in the current playlist");
                    break;
                case ">":
                    System.out.println("Playing song...");
                    break;
                case "N":
                    System.out.print("Enter playlist name: ");
                    String playlist = input2.nextLine();
                    Playlist npl = new Playlist(playlist);
//                    pl.setPlName(playlist);
                    pl.addPlaylist(npl);
                    break;
                case "V":
                    System.out.print("Enter playlist to change to: ");
                    playlist = input2.nextLine();
                    System.out.println("Changing to playlist \"" + playlist + "\"");
                    break;
                case "C":
                    System.out.print("Enter new playlist to copy this one to: ");
                    playlist = input2.nextLine();
                    System.out.println("Copied this playlist and pasted it into \"" + playlist + "\"");
                    Playlist npl2 = new Playlist(playlist);
                    pl.addPlaylist(npl2);
                    break;
                case "E":
                    System.out.print("Enter playlist you wish to compare: ");
                    playlist = input2.nextLine();
                    if (pl.equals(playlist) == true)
                        System.out.println("These two are the same");
                    else
                        System.out.println("These two are not the same");
                    break;
                case "D":
                    System.out.println();
                    System.out.printf("%-10s  %-30s", "Song#", "Playlist");
                    System.out.println("\n--------------------------");
                    pl.printAllPlaylists();
                    break;
                case "Q":
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid input...");

            }
        }
        catch (InputMismatchException e) {
            System.out.println("must enter an integer!");

        }

    }




}
