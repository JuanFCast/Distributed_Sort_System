import java.util.Scanner;

public class ClientUI {

    public ClientUI(){
        sc = new Scanner(System.in);
    }

    //Menu principal
    public void displayMenu() {
        System.out.println("1. Sort File");
        System.out.println("2. Exit");
    }

    public int getUserChoice(int opt) {
        System.out.println("Option: ");
        return 0;
    }

    public String getFilePathFromUser() {
        // Implement file path input logic
        return "path/to/file";
    }
}
