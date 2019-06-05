package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.stream.IntStream;

public class Radar {
	private PatriotBattery battery;
	private Executor executor;

	public Radar(PatriotBattery battery, Executor executor)  {
		this.battery = battery;
		this.executor = executor;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	private void launchPatriot() {
		executor.execute(() -> {
			IntStream.range(0, 10).forEach(x -> battery.launchPatriot());
		});
	}
}
