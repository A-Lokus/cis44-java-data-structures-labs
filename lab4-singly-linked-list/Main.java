import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int userChoice = 0;

        System.out.println("-----Playlist Interface-----");
        System.out.println("1. Add song");
        System.out.println("2. Remove song");
        System.out.println("3. Play song");
        System.out.println("4. Display playlist");
        System.out.println("5. Exit");
        System.out.println();

        do{
            System.out.print("Enter your choice: ");
            userChoice = input.nextInt();
            input.nextLine();
            switch(userChoice) {
                case 1:
                    System.out.println("Enter song title:");
                    String title = input.nextLine();
                    System.out.println("Enter song artist:");
                    String artist = input.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;
                case 2:
                    System.out.println("Enter song title to remove:");
                    String removedTitle = input.nextLine();
                    playlist.removeSong(removedTitle);
                    break;
                case 3:
                    playlist.playNext();
                    break;
                case 4:
                    playlist.displayPlaylist();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();
        }while(userChoice != 5);
    }
}