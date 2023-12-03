import java.util.Scanner;

public class ClientUI {

    private Scanner sc;

    public ClientUI(){
        sc = new Scanner(System.in);
    }

    //Menu principal
    public void displayMenu() {
        System.out.println("1. Sort File");
        System.out.println("2. Exit");
    }

    public int getUserChoice() {
        // Implement user input logic
        return 0;
    }

    public String getFilePathFromUser() {
        // Implement file path input logic
        return "path/to/file";
    }
}
