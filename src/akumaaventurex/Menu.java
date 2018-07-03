package akumaaventurex;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Menu implements Runnable {

	long tempoparaThread;
	public int sequencia;
	public int segura;
	BufferedImage imagem[];
	BufferedImage nomeautor;
	BufferedImage nomejava;
	BufferedImage akumatouchesquerdo;
	BufferedImage akumatouch2esquerdo;
	BufferedImage akumatouchdireito;
	BufferedImage akumatouch2direito;
	BufferedImage akuminhaf;
	BufferedImage akuminhat;
	Thread thread;
	BufferedImage nomemenu;
	int indica;

	public Menu() {
		sequencia = 0;
		segura = 0;
		imagem = new BufferedImage[99];
		nomeautor = null;
		nomejava = null;
		akumatouchesquerdo = null;
		akumatouch2esquerdo = null;
		akumatouchdireito = null;
		akumatouch2direito = null;
		akuminhaf = null;
		akuminhat = null;
		thread = new Thread(this);
		nomemenu = null;
		indica = 0;
		try {
			imagem[0] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao00.gif"));
			imagem[1] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao01.gif"));
			imagem[2] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao02.gif"));
			imagem[3] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao03.gif"));
			imagem[4] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao04.gif"));
			imagem[5] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao05.gif"));
			imagem[6] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao06.gif"));
			imagem[7] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao07.gif"));
			imagem[8] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao08.gif"));
			imagem[9] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao09.gif"));
			imagem[10] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao10.gif"));
			imagem[11] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao11.gif"));
			imagem[12] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao12.gif"));
			imagem[13] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao13.gif"));
			imagem[14] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao14.gif"));
			imagem[15] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao15.gif"));
			imagem[16] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao16.gif"));
			imagem[17] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao17.gif"));
			imagem[18] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao18.gif"));
			imagem[19] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao19.gif"));
			imagem[20] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao20.gif"));
			imagem[21] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao21.gif"));
			imagem[22] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao22.gif"));
			imagem[23] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao23.gif"));
			imagem[24] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao24.gif"));
			imagem[25] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao25.gif"));
			imagem[26] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao26.gif"));
			imagem[27] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao27.gif"));
			imagem[28] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao28.gif"));
			imagem[29] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao29.gif"));
			imagem[30] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao30.gif"));
			imagem[31] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao31.gif"));
			imagem[32] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao32.gif"));
			imagem[33] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao33.gif"));
			imagem[34] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao34.gif"));
			imagem[35] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao35.gif"));
			imagem[36] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao36.gif"));
			imagem[37] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao37.gif"));
			imagem[38] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao38.gif"));
			imagem[39] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao39.gif"));
			imagem[40] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao40.gif"));
			imagem[41] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao41.gif"));
			imagem[42] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao42.gif"));
			imagem[43] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao43.gif"));
			imagem[44] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao44.gif"));
			imagem[45] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao45.gif"));
			imagem[46] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao46.gif"));
			imagem[47] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao47.gif"));
			imagem[48] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao48.gif"));
			imagem[49] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao49.gif"));
			imagem[50] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao50.gif"));
			imagem[51] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao51.gif"));
			imagem[52] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao52.gif"));
			imagem[53] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao53.gif"));
			imagem[54] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao54.gif"));
			imagem[55] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao55.gif"));
			imagem[56] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao56.gif"));
			imagem[57] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao57.gif"));
			imagem[58] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao58.gif"));
			imagem[59] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao59.gif"));
			imagem[60] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao60.gif"));
			imagem[61] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao61.gif"));
			imagem[62] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao62.gif"));
			imagem[63] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao63.gif"));
			imagem[64] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao64.gif"));
			imagem[65] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao65.gif"));
			imagem[66] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao66.gif"));
			imagem[67] = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/introducao67.gif"));
		} catch (IOException ex) {
			System.out.println("Imagens akuma fogo parte1 menu nao carregada");
		}
		try {
			imagem[69] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo00.gif"));
			imagem[70] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo01.gif"));
			imagem[71] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo02.gif"));
			imagem[72] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo03.gif"));
			imagem[73] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo04.gif"));
			imagem[74] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo05.gif"));
			imagem[75] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo06.gif"));
			imagem[76] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo07.gif"));
			imagem[77] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo08.gif"));
			imagem[78] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo09.gif"));
			imagem[79] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo10.gif"));
			imagem[80] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo11.gif"));
			imagem[81] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo12.gif"));
			imagem[82] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo13.gif"));
			imagem[83] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo14.gif"));
			imagem[84] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo15.gif"));
			imagem[85] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo16.gif"));
			imagem[86] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo17.gif"));
			imagem[87] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo18.gif"));
			imagem[88] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo19.gif"));
			imagem[89] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo20.gif"));
			imagem[90] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo21.gif"));
			imagem[91] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo22.gif"));
			imagem[92] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo23.gif"));
			imagem[93] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo24.gif"));
			imagem[94] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo25.gif"));
			imagem[95] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo26.gif"));
			imagem[96] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo27.gif"));
			imagem[97] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo28.gif"));
			imagem[98] = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumafogo29.gif"));
			akumatouchesquerdo = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumataunt0.gif"));
			akumatouch2esquerdo = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/akumataunt1.gif"));
			akumatouchdireito = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/akumatauntdir0.gif"));
			akumatouch2direito = ImageIO
					.read(new File(
							"imagens/Menu/Akumafogo/introducaoinicio/akumatauntdir1.gif"));
			akuminhaf = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/miniakumaf.gif"));
			akuminhat = ImageIO.read(new File(
					"imagens/Menu/Akumafogo/introducaoinicio/miniakumat.gif"));
			nomemenu = ImageIO.read(new File("imagens/Menu/menux.png"));
		} catch (IOException ex) {
			System.out.println("Imagens akuma fogo parte2 menu nao carregada");
		}
	}

	public BufferedImage getImagem() {
		return imagem[sequencia];
	}

	public BufferedImage getNomemenu() {
		return nomemenu;
	}

	public BufferedImage getAkumatouchesquerdo() {
		if (sequencia % 2 == 0) {
			return akumatouchesquerdo;
		} else {
			return akumatouch2esquerdo;
		}
	}

	public BufferedImage getAkumatouchdireito() {
		if (sequencia % 2 == 0) {
			return akumatouchdireito;
		} else {
			return akumatouch2direito;
		}
	}

	public BufferedImage getMiniakumaf() {
		return akuminhaf;
	}

	public BufferedImage getMiniakumat() {
		return akuminhat;
	}

	public BufferedImage getNomeautor() {
		return nomeautor;
	}

	public BufferedImage getNomejava() {
		return nomejava;
	}

	public void run() {
		do {
			try {
				if (sequencia == 0) {
					segura++;
				}
				if (sequencia < 96 && segura > 13) {
					sequencia++;
				} else if (segura > 13) {
					sequencia = 69;
				}
				Thread.sleep(100L);
			} catch (InterruptedException ex) {
			}
		} while (true);
	}
}
