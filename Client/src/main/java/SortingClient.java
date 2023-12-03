

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
        latencyTracker.start();
        iceHandler.sendSortingRequest(filePath);
        List<String> sortedData = dataReceiver.receiveSortedData();
        latencyTracker.stop();
        System.out.println("Sorted Data: " + sortedData);
    }
}
