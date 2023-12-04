import com.zeroc.Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;
import Sorter.MasterPrx;

public class ICEClientHandler {
    private Communicator iceCommunicator;
    private MasterPrx sortingMasterProxy;

    public ICEClientHandler() {
        // Inicializa el ICE communicator y crea el proxy
        try {
            iceCommunicator = Util.initialize(new String[]{"--Ice.Config=config.client"});
            String proxyString = iceCommunicator.getProperties().getProperty("Master.Proxy");
            ObjectPrx base = iceCommunicator.stringToProxy(proxyString);
            masterProxy = MasterPrx.checkedCast(base);
            if (masterProxy == null) {
                throw new Error("Invalid proxy");
            }
        } catch (Ice.LocalException e) {
            e.printStackTrace();
        }
    }

    public void sendSortingRequest(String filePath) {
        // Enviar la solicitud de ordenamiento al SortingMaster
        try {
            sortingMasterProxy.startSorting(filePath);
        } catch (Ice.LocalException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (iceCommunicator != null) {
            try {
                iceCommunicator.destroy();
            } catch (Ice.LocalException e) {
                e.printStackTrace();
            }
        }
    }
}
