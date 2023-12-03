package main.java;

import Sorter.Master;
import Sorter.Worker;

public class MasterImpl implements Master {
    private WorkerPrx[] workers;

    public MasterImpl(WorkerPrx[] workers) {
        this.workers = workers;
    }

    @Override
    public void distributeWork(String[] data) {
        int workerCount = workers.length;
        int dataPerWorker = data.length / workerCount;

        for (int i = 0; i < workerCount; i++) {
            int startIndex = i * dataPerWorker;
            int endIndex = (i == workerCount - 1) ? data.length : (i + 1) * dataPerWorker;
            String[] workerData = Arrays.copyOfRange(data, startIndex, endIndex);
            workers[i].processDataAsync(workerData);
        }
    }
}
