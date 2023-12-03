import com.zeroc.Ice.Communicator;
import Ice.ObjectPrx;
import Ice.Util;
import SortingSystem.SortingMasterPrx;
import SortingSystem.SortingMasterPrxHelper;

public class ICEClientHandler {
    private Communicator iceCommunicator;
    private SortingMasterPrx sortingMasterProxy;

    public ICEClientHandler() {
        // Inicializa el ICE communicator y crea el proxy
        try {
            iceCommunicator = Util.initialize();
            String proxyString = "SortingMaster:default -p 10000"; // Ejemplo de proxyString
            ObjectPrx base = iceCommunicator.stringToProxy(proxyString);
            sortingMasterProxy = SortingMasterPrxHelper.checkedCast(base);
            if (sortingMasterProxy == null) {
                throw new Error("Invalid proxy");
            }
        } catch (Ice.LocalException e) {
            e.printStackTrace();
        }
    }

    public void sendSortingRequest(String filePath) {
        // Enviar la solicitud de ordenamiento al SortingMaster
        try {
            sortingMasterProxy.sortData(filePath);
        } catch (Ice.LocalException e) {
            e.printStackTrace();
        }
    }

    public String receiveSortedData() {
        // Implementar lógica para recibir los datos ordenados
        // Esto puede depender de cómo está configurada tu aplicación
        return "sorted data"; // Esto es un placeholder
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
