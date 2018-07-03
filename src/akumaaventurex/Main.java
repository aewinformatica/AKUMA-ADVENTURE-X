package akumaaventurex;

import java.applet.AudioClip;
import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		Cenario1ComIntroducaoeMenu fase1 = new Cenario1ComIntroducaoeMenu();
		int fim = 0;
		
		fase1.setBackground(Color.BLACK);
		
		do {
			fase1.setBackground(Color.BLACK);
			fase1.inicializa();
			fase1.gameloopFase1();
			do {
				if (fase1.vidas <= 0) {
					break;
				}
				fase1.reinicia();
				fase1.gameloopFase1();
				if (fase1.perdeuojogo) {
					fase1.vidas--;
				}
			} while (true);
			fase1.musicajogo.stop();
			fase1.musicajogo2.stop();
			fase1.musicachefe.stop();
			fase1.thread.interrupt();
			fase1.thread.stop();
		} while (true);

	}

}
