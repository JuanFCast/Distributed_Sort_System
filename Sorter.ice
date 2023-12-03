module Sorter {

    interface Worker {
        void processData(string data);
    };

    interface Master {
        void distributeWork(string[] data);
    };

};
