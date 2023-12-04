module Sorter {

    sequence<string> StringSequence;

    interface Worker {
        void processData(StringSequence data);
        // Métodos adicionales según sea necesario
    };

    interface Master {
        void distributeWork(StringSequence data);
        void startSorting(string filePath);
        StringSequence getSortedResults();
        // Métodos adicionales para la gestión del proceso de ordenamiento
    };
};
