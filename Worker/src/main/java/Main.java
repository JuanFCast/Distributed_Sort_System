package main.java;

import Sorter.Master;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.CommunicatorDestroyedException;
import com.zeroc.Ice.InitializationData;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class MasterServer {
    public static void main(String[] args) {
        int status = 0;
        Communicator communicator = null;

        try {
            InitializationData initData = new InitializationData();
            communicator = Util.initialize(args, initData);

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("MasterAdapter", "tcp -h localhost -p 10000");
            WorkerPrx[] workers = ;// Obtener referencias a los trabajadores (puedes usar IceGrid para esto)
            MasterImpl masterImpl = new MasterImpl(workers);
            adapter.add(masterImpl, Util.stringToIdentity("Master"));
            adapter.activate();

            System.out.println("Servidor del maestro en ejecución...");

            communicator.waitForShutdown();
        } catch (Exception e) {
            e.printStackTrace();
            status = 1;
        } finally {
            if (communicator != null) {
                try {
                    communicator.destroy();
                } catch (CommunicatorDestroyedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.exit(status);
    }
}
