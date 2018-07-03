package akumaaventurex;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class AKUMA implements Runnable {

	Thread thread;
	int sequencia;
	int magia;
	int vida;
	int posicaox;
	int posicaoy;
	int direcaox;
	int lado;
	int estado;
	int pulo;
	BufferedImage akumaparadot[];
	BufferedImage akumaparadof[];
	BufferedImage akumacorrendot[];
	BufferedImage akumacorrendof[];
	BufferedImage akumamagiat[];
	BufferedImage akumamagiaf[];
	BufferedImage akumapulot[];
	BufferedImage akumapulof[];
	BufferedImage akumawin[];
	int puloqualimagem;

	public AKUMA() {
		thread = new Thread(this);
		sequencia = 0;
		magia = 100;
		vida = 10;
		posicaox = 150;
		posicaoy = 546;
		direcaox = 0;
		lado = 0;
		estado = 0;
		pulo = 0;
		akumaparadot = new BufferedImage[6];
		akumaparadof = new BufferedImage[6];
		akumacorrendot = new BufferedImage[6];
		akumacorrendof = new BufferedImage[6];
		akumamagiat = new BufferedImage[6];
		akumamagiaf = new BufferedImage[6];
		akumapulot = new BufferedImage[4];
		akumapulof = new BufferedImage[4];
		akumawin = new BufferedImage[6];
		puloqualimagem = 0;
		try {
			akumaparadof[0] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradof0.png"));
			akumaparadof[1] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradof1.png"));
			akumaparadof[2] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradof2.png"));
			akumaparadof[3] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradof3.png"));
			akumaparadof[4] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradof4.png"));
			akumaparadof[5] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradof5.png"));
			akumaparadot[0] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradot0.png"));
			akumaparadot[1] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradot1.png"));
			akumaparadot[2] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradot2.png"));
			akumaparadot[3] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradot3.png"));
			akumaparadot[4] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradot4.png"));
			akumaparadot[5] = ImageIO.read(new File(
					"imagens/AKUMA/PARADO/paradot5.png"));
		} catch (IOException ex) {
			System.out
					.println("Imagens akuma de movimento parado nao carregada");
		}
		try {
			akumacorrendof[0] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndo0.png"));
			akumacorrendof[1] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndo1.png"));
			akumacorrendof[2] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndo2.png"));
			akumacorrendof[3] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndo3.png"));
			akumacorrendof[4] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndo4.png"));
			akumacorrendof[5] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndo5.png"));
			akumacorrendot[0] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndot0.png"));
			akumacorrendot[1] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndot1.png"));
			akumacorrendot[2] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndot2.png"));
			akumacorrendot[3] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndot3.png"));
			akumacorrendot[4] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndot4.png"));
			akumacorrendot[5] = ImageIO.read(new File(
					"imagens/AKUMA/CORRENDO/correndot5.png"));
		} catch (IOException ex) {
			System.out
					.println("Imagens akuma de movimento correndo nao carregada");
		}
		try {
			akumamagiaf[0] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiafx0.png"));
			akumamagiaf[1] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiafx1.png"));
			akumamagiaf[2] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiafx2.png"));
			akumamagiaf[3] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiafx3.png"));
			akumamagiaf[4] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiafx4.png"));
			akumamagiaf[5] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiafx5.png"));
			akumamagiat[0] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiatx0.png"));
			akumamagiat[1] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiatx1.png"));
			akumamagiat[2] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiatx2.png"));
			akumamagiat[3] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiatx3.png"));
			akumamagiat[4] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiatx4.png"));
			akumamagiat[5] = ImageIO.read(new File(
					"imagens/AKUMA/MAGIA/magiatx5.png"));
		} catch (IOException ex) {
			System.out
					.println("Imagens akuma de movimento magia nao carregada");
		}
		try {
			akumapulot[0] = ImageIO.read(new File(
					"imagens/AKUMA/PULO/pulot1.png"));
			akumapulot[1] = ImageIO.read(new File(
					"imagens/AKUMA/PULO/pulot2.png"));
			akumapulot[2] = ImageIO.read(new File(
					"imagens/AKUMA/PULO/pulot3.png"));
			akumapulof[0] = ImageIO.read(new File(
					"imagens/AKUMA/PULO/pulo1.png"));
			akumapulof[1] = ImageIO.read(new File(
					"imagens/AKUMA/PULO/pulo2.png"));
			akumapulof[2] = ImageIO.read(new File(
					"imagens/AKUMA/PULO/pulo3.png"));
		} catch (IOException ex) {
			System.out.println("Imagens akuma de movimento pulo nao carregada");
		}
		thread.start();
	}

	public void move() {
		if (posicaoy < 545 && puloqualimagem == 1) {
			posicaoy += 2;
		}
		if (direcaox == -1 && posicaox > 10) {
			posicaox -= 4;
		} else if (direcaox == 1 && posicaox < 900) {
			posicaox += 4;
		} else if (direcaox == 2) {
			if (pulo < 150) {
				posicaoy -= 2;
				pulo += 2;
				puloqualimagem = 0;
			} else {
				puloqualimagem = 1;
			}
		}
		if (posicaoy > 544 && puloqualimagem == 1) {
			pulo = 0;
			puloqualimagem = 0;
		}
	}

	public BufferedImage getAkumaimagem() {
		if (posicaoy < 544) {
			if (lado == -1) {
				return akumapulot[puloqualimagem];
			} else {
				return akumapulof[puloqualimagem];
			}
		}
		if (estado == 1) {
			if (lado == -1) {
				return akumacorrendot[sequencia];
			} else {
				return akumacorrendof[sequencia];
			}
		}
		if (estado == 2) {
			if (lado == -1) {
				return akumapulot[0];
			} else {
				return akumapulof[0];
			}
		}
		if (estado == 3) {
			if (lado == -1) {
				return akumamagiat[sequencia];
			} else {
				return akumamagiaf[sequencia];
			}
		}
		if (lado == -1) {
			return akumaparadot[sequencia];
		} else {
			return akumaparadof[sequencia];
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == 65) {
			direcaox = -1;
			lado = -1;
			estado = 1;
		}
		if (key == 68) {
			direcaox = 1;
			lado = 1;
			estado = 1;
		}
		if (key == 32 && pulo == 0 && puloqualimagem == 0) {
			estado = 2;
			direcaox = 2;
		}
		if (key == 70) {
			estado = 3;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == 65) {
			direcaox = 0;
			estado = 0;
		}
		if (key == 68) {
			direcaox = 0;
			estado = 0;
		}
		if (key == 87) {
			estado = 0;
		}
		if (key == 32) {
			direcaox = 0;
			estado = 0;
			pulo = 0;
			puloqualimagem = 1;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(posicaox, posicaoy, 64, 128);
	}

	public void run() {
		do {
			try {
				if (sequencia < 5) {
					sequencia++;
				} else {
					sequencia = 0;
				}
				Thread.sleep(120L);
			} catch (InterruptedException ex) {
				System.out.println("erro thread akuma");
			}
		} while (true);
	}
}
