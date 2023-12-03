import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Worker {
    private Map<Character, ArrayList<String>> groupedArrays;

    public Worker() {
        groupedArrays = new HashMap<>();
    }

    public List<String> work(ArrayList<String> list){
        Map<Character, ArrayList<String>> listOfLists = groupByFirstLetter(list);
        List<String> finalList =processArraysInThreadPool(listOfLists);

        return finalList;
    }

    public Map<Character, ArrayList<String>> groupByFirstLetter(ArrayList<String> input) {
        for (String str : input) {
            char firstLetter = str.charAt(0);

            if (groupedArrays.containsKey(firstLetter)) {
                groupedArrays.get(firstLetter).add(str);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(str);
                groupedArrays.put(firstLetter, newList);
            }
        }

        return groupedArrays;
    }

    public List<String> processArraysInThreadPool(Map<Character, ArrayList<String>> arrays) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(arrays.size());

        // Lista para almacenar los resultados ordenados
        List<String> sortedResult = Collections.synchronizedList(new ArrayList<>());

        for (ArrayList<String> array : arrays.values()) {
            executorService.submit(() -> {
                // Ordenar el array de forma alfabtica
                Collections.sort(array);
                
                // Agregar el array ordenado a la lista compartida
                sortedResult.addAll(array);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        // Ordenar la lista final despus de que todos los hilos hayan terminado
        Collections.sort(sortedResult);

        return sortedResult;
    }
}