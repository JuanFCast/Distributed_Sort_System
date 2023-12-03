module Sorter {

    sequence<string> StringSequence; // Alias para la secuencia de strings

    interface Worker {
        void processData(string data);
    };

    interface Master {
        void distributeWork(StringSequence data); // Usando el alias
    };

};