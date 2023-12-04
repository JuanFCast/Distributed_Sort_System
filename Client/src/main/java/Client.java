public class Client {
    public static void main(String[] args) {
        SortingClient sortingClient = new SortingClient();
        ClientUI ui = new ClientUI();

        try {
            ui.displayMenu();
            sortingClient.requestFileSorting("path/to/file");

        } finally {
            sortingClient.shutdown();
        }
    }
}
