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
        System.out.println("Option: ");
        int o = sc.nextInt();
        System.out.println(o);
        return o;
    }

    public String getFilePathFromUser() {
        System.out.println("Input the file path: ");
        String path = sc.nextLine();
        return path;
    }
}
