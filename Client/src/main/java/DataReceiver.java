import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;
import Sorter.MasterPrx;
import Sorter.StringSequence;
import java.util.List;

public class DataReceiver {
    private MasterPrx masterProxy;

    public List<String> receiveSortedData() {
        try {
            StringSequence sortedData = masterProxy.getSortedResults();
            return sortedData;
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            return null;
        }
    }
}
