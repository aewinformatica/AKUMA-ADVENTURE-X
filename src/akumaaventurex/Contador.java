package akumaaventurex;

public class Contador {

	public static double NANOS_EM_UM_SEGUNDO = 1000000000D;
	protected long pulsosPorSegundo;
	protected long framesPorSegundo;
	protected long nanoTimeAnterior;
	protected long pulsosContados;
	protected long framesContados;

	public Contador() {
	}

	public void inicia() {
		nanoTimeAnterior = System.nanoTime();
		pulsosContados = 0L;
		framesContados = 0L;
		pulsosPorSegundo = 0L;
		framesPorSegundo = 0L;
	}

	public void contaPulso() {
		pulsosContados++;
		verifica();
	}

	public void contaFrame() {
		framesContados++;
		verifica();
	}

	protected void verifica() {
		if ((double) (System.nanoTime() - nanoTimeAnterior) > NANOS_EM_UM_SEGUNDO) {
			pulsosPorSegundo = pulsosContados;
			framesPorSegundo = framesContados;
			pulsosContados = 0L;
			framesContados = 0L;
			nanoTimeAnterior = System.nanoTime();
		}
	}

	public void sleep(long miliSecondsToSleep) {
		try {
			Thread.sleep(miliSecondsToSleep);
		} catch (Exception e) {
		}
	}

	public long getPulsosPorSegundo() {
		return pulsosPorSegundo;
	}

	public long getFramesPorSegundo() {
		return framesPorSegundo;
	}

}
