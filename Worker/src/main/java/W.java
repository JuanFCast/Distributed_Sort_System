package Worker;
import java.net.Inet4Address;

//Magia negra del Ice
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

import Sorter.WorkerPrx;
import Sorter.MasterPrx;



public class W {
    
    public static void main(String[] args) {

        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "worker.cfg")) {
        
            Sorter.WorkerPrx WorkerPrx = Sorter.WorkerPrx
                    .checkedCast(communicator.propertyToProxy("Worker.Proxy"));
            
            ObjectAdapter adapter = communicator.createObjectAdapter("Worker");
            ObjectPrx objectPrx = adapter.add(callbackImp, Util.stringToIdentity("Worker"));
            String hostname = Inet4Address.getLocalHost().getHostName();
            

        }
    }
}

