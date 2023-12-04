import java.util.List;

public class SortingClient {
    private ICEClientHandler iceHandler;
    private LatencyTracker latencyTracker;
    private DataReceiver dataReceiver;

    public SortingClient() {
        this.iceHandler = new ICEClientHandler();
        this.latencyTracker = new LatencyTracker();
        this.dataReceiver = new DataReceiver();
    }

    public void requestFileSorting(String filePath) {
        try {
            latencyTracker.start();
            iceHandler.sendSortingRequest(filePath); //Envía la solicitud de ordenamiento
            List<String> sortedData = dataReceiver.receiveSortedData(); // Recibe los datos ordenados
            handleSortResponse(sortedData);
        } catch (Exception e) {
            ErrorHandling.handleError(e);
        } finally {
            calculateAndDisplayLatency();
        }
    }

    private void handleSortResponse(List<String> sortedData) {
        if (sortedData != null && sortedData.size() != 0) {
            displaySortedData(sortedData);
        } else {
            System.out.println("No data received or data is empty.");
        }
    }

    private void displaySortedData(List<String> sortedData) {
        // Aquí puedes implementar una lógica más compleja para mostrar los datos
        System.out.println("Sorted Data: " + sortedData);
    }

    public void calculateAndDisplayLatency() {
        latencyTracker.stop();
        System.out.println("Latency: " + latencyTracker.getLatency() + " ms");
    }

    public void shutdown() {
        iceHandler.closeConnection(); // Asegúrate de que ICEClientHandler tenga este método
    }
}
