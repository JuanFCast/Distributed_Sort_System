

public class WorkerImp implements Sorter.Worker{

    private Map<Character, ArrayList<String>> groupedArrays;
    
    public void processData(String s, com.zeroc.Ice.Current current){

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
