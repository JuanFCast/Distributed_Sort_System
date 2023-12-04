public class Client {
    public static void main(String[] args) {
        SortingClient sortingClient = new SortingClient();
        try {
            sortingClient.requestFileSorting("path/to/file");
                       
        } finally {
            sortingClient.shutdown();
        }
    }
}
