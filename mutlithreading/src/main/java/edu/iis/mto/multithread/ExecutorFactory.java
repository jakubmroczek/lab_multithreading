package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class ExecutorFactory {

    public enum Behaviour {
        SEQUENTIAL,
        ASYNCHRONOUS
    }

    public static Executor create(Behaviour behaviour) {
        switch (behaviour) {
            case SEQUENTIAL:
                return Runnable::run;

            case ASYNCHRONOUS:
                return command -> {
                    new Thread(command).run();
                };
        }
        
        //dummy but javac complains
        throw new IllegalArgumentException("Should not happen");
    }

}
