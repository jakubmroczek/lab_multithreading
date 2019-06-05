package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private PatriotLaunchingStrategy launchingStrategy;
    private Executor executor;

    public BetterRadar(PatriotLaunchingStrategy launchingStrategy, Executor executor)  {
        this.launchingStrategy = launchingStrategy;
        this.executor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.execute(() -> {
           launchingStrategy.launchPatriot();
        });
    }
}
