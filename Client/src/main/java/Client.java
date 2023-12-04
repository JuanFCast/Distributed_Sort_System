public class Client {
    public static void main(String[] args) {
        SortingClient sortingClient = new SortingClient();
        ClientUI ui = new ClientUI();

        try {
            ui.displayMenu();
            int opt = ui.getUserChoice();

            if(opt == 1){
                String path = ui.getFilePathFromUser();
                sortingClient.requestFileSorting(path);
            }

        } finally {
            sortingClient.shutdown();
        }
    }
}
