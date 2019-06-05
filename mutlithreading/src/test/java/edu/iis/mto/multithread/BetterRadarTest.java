package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static edu.iis.mto.multithread.ExecutorFactory.Behaviour.SEQUENTIAL;
import static org.mockito.Mockito.*;

public class BetterRadarTest {

    @Test
    @RepeatedTest(100)
    public void launchPatriotWhenNoticesAScudMissle() {
        final int missilesLaunched = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(new PatriotLaunchingStrategyImpl(batteryMock, missilesLaunched),
                ExecutorFactory.create(SEQUENTIAL));
        radar.notice(new Scud());
        verify(batteryMock, times(missilesLaunched)).launchPatriot();
    }

}
