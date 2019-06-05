package edu.iis.mto.multithread;

import java.util.stream.IntStream;

public class PatriotLaunchingStrategyImpl implements PatriotLaunchingStrategy {

    private PatriotBattery battery;
    private int missilesLaunched;

    public PatriotLaunchingStrategyImpl(PatriotBattery battery, int missilesLaunched) {
        this.battery = battery;
        this.missilesLaunched = missilesLaunched;
    }

    @Override
    public void launchPatriot() {
        IntStream.range(0, missilesLaunched).forEach(x -> battery.launchPatriot());
    }
}
