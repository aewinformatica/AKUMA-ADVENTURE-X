package akumaaventurex;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

// Referenced classes of package akumaaventurex:
//            Menu, Contador, AKUMA

public final class Cenario1ComIntroducaoeMenu extends JFrame implements
		KeyListener, Runnable {

	private BufferStrategy buffer;
	AKUMA akuma;
	public BufferedImage fundo;
	public BufferedImage fundofrente;
	public BufferedImage fumaca;
	public BufferedImage menu;
	public BufferedImage auxnome;
	AudioClip MusicaMenu;
	AudioClip musicajogo;
	AudioClip musicajogo2;
	AudioClip musicachefe;
	AudioClip musicafimfase;
	AudioClip musicaintroducao;
	AudioClip click;
	boolean perdeuojogo;
	boolean apertouEnter;
	int posicaofundox;
	int posicaofundox2;
	int posicaofundofrentex;
	int posicaofundofrentex2;
	int fumacafrente1;
	int fumacafrente2;
	int sequencia;
	int Opcao;
	int paracontroleok;
	int inimigos;
	int proximo;
	int vidas;
	static Font font = new Font("SanSerif", 1, 24);
	private boolean Fimdefase;
	private Random aleatorio;
	Thread thread;
	long tempodothread;
	int FPS;
	int pontuacao;
	int trocamusica;
	Menu Menudatela;
	Contador contaframes;
	double NANOS_ESPERADOS_POR_PULSO;
	float alpha;
	float add;
	int movimento;

	public Cenario1ComIntroducaoeMenu() {
		fundo = null;
		fundofrente = null;
		fumaca = null;
		menu = null;
		auxnome = null;
		MusicaMenu = null;
		musicajogo = null;
		musicajogo2 = null;
		musicachefe = null;
		musicafimfase = null;
		musicaintroducao = null;
		click = null;
		perdeuojogo = false;
		apertouEnter = false;
		sequencia = -1;
		Opcao = 1;
		paracontroleok = 0;
		inimigos = 0;
		proximo = 0;
		vidas = 10;
		Fimdefase = false;
		aleatorio = new Random();
		thread = new Thread(this);
		tempodothread = 0L;
		FPS = 60;
		pontuacao = 0;
		trocamusica = 0;
		Menudatela = new Menu();
		contaframes = new Contador();
		NANOS_ESPERADOS_POR_PULSO = Contador.NANOS_EM_UM_SEGUNDO / (double) FPS;
		alpha = 0.0F;
		add = 0.0F;
		movimento = 0;
		setTitle("AKUMA ADVENTURE - VERS\303O DEMO 03/07/2018(WAGNER GONÇALVES DE JESUS)");
		setSize(1024, 768);
		setDefaultCloseOperation(3);
		setVisible(true);
		setLocationRelativeTo(null);
		setIgnoreRepaint(true);
		setFocusable(true);
		addKeyListener(this);
		createBufferStrategy(2);
		buffer = getBufferStrategy();
		try {
			fumaca = ImageIO.read(new File("imagens/smoke2.png"));
		} catch (IOException ioe) {
			System.out.println("Imagem fumaca nao carregada");
		}
		try {
			click = Applet.newAudioClip((new File("sons/Click.wav")).toURL());
		} catch (Exception ioe) {
			System.out.println("Musica nao carregada");
		}
	}

	void inicializa() {
		akuma = new AKUMA();
		setBackground(Color.BLACK);
		posicaofundox = 0;
		posicaofundox2 = 1194;
		posicaofundofrentex = 0;
		fumacafrente1 = 0;
		fumacafrente2 = 1194;
		try {
			fundo = ImageIO.read(new File("imagens/fundo.png"));
		} catch (IOException ioe) {
			System.out.println("Imagem fundo nao carregada");
		}
		try {
			musicajogo = Applet.newAudioClip((new File("sons/FASE1.wav"))
					.toURL());
		} catch (Exception ioe) {
			System.out.println("Musica fase1 nao carregada");
		}
		musicajogo.loop();
		contaframes.inicia();
		proximo = 0;
		inimigos = 0;
	}

	public void LoopIntroducao() {
		tempodothread = 2000L;
		sequencia = 0;
		try {
			musicaintroducao = Applet.newAudioClip((new File(
					"sons/introducao.wav")).toURL());
		} catch (Exception ioe) {
			System.out.println("Musica introducao nao carregada");
		}
		musicaintroducao.loop();
		long nanoTimeDoProximoPulso = System.nanoTime();
		while (sequencia < 15 && !apertouEnter) {
			for (; System.nanoTime() > nanoTimeDoProximoPulso; nanoTimeDoProximoPulso = (long) ((double) nanoTimeDoProximoPulso + NANOS_ESPERADOS_POR_PULSO)) {
				Thread.yield();
			}

			atualizatelaIntroducao();
		}
		musicaintroducao.stop();
		apertouEnter = false;
	}

	public void LoopMenu() {
		long nanoTimeDoProximoPulso = System.nanoTime();
		try {
			MusicaMenu = Applet.newAudioClip((new File("sons/menu.wav"))
					.toURL());
		} catch (Exception ioe) {
			System.out.println("Musica menu nao carregada");
		}
		MusicaMenu.loop();
		tempodothread = 2000L;
		Menudatela.thread.start();
		for (int para = 0; para == 0;) {
			for (; System.nanoTime() > nanoTimeDoProximoPulso; nanoTimeDoProximoPulso = (long) ((double) nanoTimeDoProximoPulso + NANOS_ESPERADOS_POR_PULSO)) {
				Thread.yield();
			}

			if (Opcao == 1 && apertouEnter && paracontroleok == 1) {
				para = 1;
			}
			if (Opcao == 4 && apertouEnter && paracontroleok == 1) {
				System.exit(0);
				thread.stop();
			}
			atualizatelaMenu();
		}

		Menudatela.thread.stop();
		MusicaMenu.stop();
		paracontroleok = 0;
	}

	void reinicia() {
		paracontroleok = 0;
		perdeuojogo = false;
	}

	void gameloopFase1() {
		long nanoTimeDoProximoPulso = System.nanoTime();
		while (!perdeuojogo) {
			for (; System.nanoTime() > nanoTimeDoProximoPulso; nanoTimeDoProximoPulso = (long) ((double) nanoTimeDoProximoPulso + NANOS_ESPERADOS_POR_PULSO)) {
				atualizaDadosechecaColisoes();
			}

			desenhatela();
		}
	}

	public void atualizaDadosechecaColisoes() {
		akuma.move();
	}

	public void desenhatela() {
		Graphics2D grafico = (Graphics2D) buffer.getDrawGraphics();
		Font aux = new Font("Ravie", 2, 40);
		Font auxmissaocompleta = new Font("Ravie", 2, 55);
		Font auxvidachefe = new Font("Ravie", 2, 20);
		contaframes.contaFrame();
		grafico.clearRect(0, 0, getWidth(), getHeight());
		grafico.drawImage(fundo, 0, 0, null);
		if (akuma.estado == 1) {
			grafico.drawImage(akuma.getAkumaimagem(), akuma.posicaox,
					akuma.posicaoy + 8, null);
		} else {
			grafico.drawImage(akuma.getAkumaimagem(), akuma.posicaox,
					akuma.posicaoy, null);
		}
		grafico.setColor(Color.MAGENTA);
		for (int b = 0; b < 5; b++) {
			grafico.drawRect(8 + b, 25 + b, 980, 50);
		}

		grafico.setColor(Color.CYAN);
		grafico.drawRect(5, 23, 990, 60);
		grafico.drawString(
				(new StringBuilder()).append("VIDAS: ").append(akuma.vida)
						.toString(), 50, 60);
		grafico.setColor(Color.red);
		grafico.drawString(
				(new StringBuilder()).append("Magia: ").append(akuma.magia)
						.toString(), 330, 60);
		grafico.setColor(Color.YELLOW);
		grafico.drawString((new StringBuilder()).append("Pontua\347\343o:")
				.append(pontuacao).toString(), 700, 60);
		grafico.drawString(
				(new StringBuilder()).append("X:").append(akuma.posicaox)
						.toString(), 650, 160);
		grafico.drawString(
				(new StringBuilder()).append("Y:").append(akuma.posicaoy)
						.toString(), 700, 160);
		grafico.drawString(
				(new StringBuilder()).append("PULO:").append(akuma.pulo)
						.toString(), 600, 250);
		grafico.drawString(
				(new StringBuilder()).append("ESTADO:").append(akuma.estado)
						.toString(), 750, 300);
		grafico.drawString(
				(new StringBuilder()).append("Direcao:").append(akuma.direcaox)
						.toString(), 550, 350);
		grafico.setColor(Color.YELLOW);
		if (Fimdefase) {
			grafico.setFont(auxmissaocompleta);
			grafico.drawString("MISS\303O COMPLETADA", 120, 340);
			grafico.setFont(auxvidachefe);
			grafico.drawString(
					"(Continua - Obrigado por Jogar,se gostou Comente onde baixou !)",
					90, 380);
		}
		buffer.show();
		grafico.setFont(font);
		grafico.dispose();
	}

	public void atualizatelaIntroducao() {
		Graphics2D grafico = (Graphics2D) buffer.getDrawGraphics();
		grafico.clearRect(0, 0, getWidth(), getHeight());
		Font aux = new Font("Showcard Gothic", 1, 100);
		movimento++;
		if (movimento > 420) {
			movimento = 0;
		}
		grafico.setBackground(Color.BLACK);
		grafico.setComposite(AlphaComposite.SrcOver.derive(alpha));
		alpha += add;
		if ((double) alpha < 0.80000000000000004D) {
			add = 0.02F;
		} else if ((double) alpha > 0.97999999999999998D) {
			add = -0.02F;
		}
		grafico.setFont(aux);
		if (sequencia < 8) {
			grafico.setBackground(Color.BLACK);
			grafico.setColor(Color.ORANGE);
		}
		if (sequencia == 0) {
			grafico.drawString("2", 400, 400);
		}
		if (sequencia == 2) {
			grafico.drawString("20", 400, 400);
		}
		if (sequencia == 4) {
			grafico.drawString("201", 400, 400);
		}
		if (sequencia == 6) {
			grafico.drawString("2011", 400, 400);
		}
		if (sequencia >= 8 && sequencia < 10) {
			grafico.drawImage(Menudatela.getNomeautor(), 0, 100, null);
		}
		if (sequencia >= 12 && sequencia < 14) {
			grafico.drawImage(Menudatela.getNomejava(), 0, 100, null);
		}
		grafico.setTransform(new AffineTransform());
		grafico.setFont(font);
		grafico.drawImage(fumaca, 500 + movimento, 10, null);
		grafico.drawImage(fumaca, 600 + movimento, 10, null);
		grafico.drawImage(fumaca, -10 + movimento, 50, null);
		grafico.drawImage(fumaca, -300 + movimento, 50, null);
		buffer.show();
		grafico.dispose();
	}

	public void atualizatelaMenu() {
		Graphics2D grafico = (Graphics2D) buffer.getDrawGraphics();
		grafico.clearRect(0, 0, getWidth(), getHeight());
		Font aux = new Font("Ravie", 1, 40);
		Font aux2 = new Font("SanSerif", 1, 14);
		grafico.setBackground(Color.BLACK);
		grafico.setComposite(AlphaComposite.SrcOver.derive(alpha));
		alpha += add;
		if ((double) alpha < 0.80000000000000004D) {
			add = 0.02F;
		} else if ((double) alpha > 0.97999999999999998D) {
			add = -0.02F;
		}
		grafico.setFont(aux);
		grafico.setColor(Color.RED);
		if (Menudatela.sequencia < 68) {
			grafico.drawImage(Menudatela.getImagem(), 200, 13, null);
		} else {
			grafico.drawImage(Menudatela.getImagem(), 80, 13, null);
		}
		grafico.drawImage(Menudatela.getNomemenu(), 0, 43, null);
		grafico.drawImage(Menudatela.getAkumatouchesquerdo(), 10, 550, null);
		grafico.drawImage(Menudatela.getAkumatouchdireito(), 800, 550, null);
		if (paracontroleok == 0 || paracontroleok == -3) {
			paracontroleok = 1;
			apertouEnter = false;
		}
		if (Opcao == 1 && sequencia > 5) {
			grafico.drawImage(Menudatela.akuminhaf, 320, 410, null);
			grafico.drawImage(Menudatela.akuminhat, 675, 410, null);
		} else if (Opcao == 2 && sequencia > 5) {
			grafico.drawImage(Menudatela.akuminhaf, 275, 475, null);
			grafico.drawImage(Menudatela.akuminhat, 720, 475, null);
		} else if (Opcao == 3 && sequencia > 5) {
			grafico.drawImage(Menudatela.akuminhaf, 335, 550, null);
			grafico.drawImage(Menudatela.akuminhat, 635, 550, null);
		} else if (Opcao == 4 && sequencia > 5) {
			grafico.drawImage(Menudatela.akuminhaf, 375, 615, null);
			grafico.drawImage(Menudatela.akuminhat, 595, 615, null);
		}
		grafico.drawImage(fumaca, 0 + Menudatela.sequencia * 2, 100, null);
		grafico.drawImage(fumaca, 100 + Menudatela.sequencia, 100, null);
		grafico.setFont(aux2);
		grafico.setColor(Color.CYAN);
		for (int b = 0; b < 5; b++) {
			grafico.drawRect(390 + b, 720 + b, 230, 35);
		}

		grafico.setColor(Color.WHITE);
		grafico.drawString("WAGNER GONÇALVES DE JESUS", 405, 740);
		grafico.drawString("          2018", 450, 752);
		grafico.dispose();
		buffer.show();
	}

	public void gameOver() {
		musicajogo2.stop();
		paracontroleok = -3;
		tempodothread = 20L;
		sequencia = 0;
		Graphics2D grafico = (Graphics2D) buffer.getDrawGraphics();
		grafico.clearRect(0, 0, getWidth(), getHeight());
		Font aux = new Font("Ravie", 1, 80);
		apertouEnter = false;
		try {
			MusicaMenu = Applet.newAudioClip((new File("sons/gameover.wav"))
					.toURL());
		} catch (Exception ioe) {
			System.out.println("Musica menu nao carregada");
		}
		MusicaMenu.loop();
		try {
			fundo = ImageIO.read(new File("imagens/NaveFundo.png"));
		} catch (IOException ioe) {
			System.out.println("Imagem nao carregada");
		}
		grafico.drawImage(fundo, 380, 250, null);
		long nanoTimeDoProximoPulso = System.nanoTime();
		do {
			if (sequencia >= 550) {
				break;
			}
			for (; System.nanoTime() > nanoTimeDoProximoPulso; nanoTimeDoProximoPulso = (long) ((double) nanoTimeDoProximoPulso + NANOS_ESPERADOS_POR_PULSO)) {
				Thread.yield();
			}

			grafico.setComposite(AlphaComposite.SrcOver.derive(alpha));
			grafico.setFont(aux);
			grafico.setColor(Color.red);
			if (sequencia < 360) {
				grafico.drawString("F I M D E J O G O", 35, 0 + sequencia);
			} else {
				grafico.drawString("F I M D E J O G O", 35, 360);
			}
			grafico.setColor(Color.BLUE);
			grafico.drawString("F I M D E J O G O", 35, 360);
			alpha += add;
			buffer.show();
			if ((double) alpha < 0.80000000000000004D) {
				add = 0.02F;
			} else if ((double) alpha > 0.97999999999999998D) {
				add = -0.02F;
			}
		} while (true);
		MusicaMenu.stop();
		grafico.dispose();
	}

	public void Instrucoes() {
		tempodothread = 20L;
		sequencia = 0;
		Graphics2D grafico = (Graphics2D) buffer.getDrawGraphics();
		grafico.clearRect(0, 0, getWidth(), getHeight());
		Font aux = new Font("Ravie", 1, 80);
		setBackground(Color.BLACK);
		apertouEnter = false;
		try {
			fundo = ImageIO.read(new File("imagens/instrucoes.png"));
		} catch (IOException ioe) {
			System.out.println("Imagem nao carregada");
		}
		grafico.drawImage(fundo, 5, 25, null);
		long nanoTimeDoProximoPulso = System.nanoTime();
		do {
			if (apertouEnter) {
				break;
			}
			for (; System.nanoTime() > nanoTimeDoProximoPulso; nanoTimeDoProximoPulso = (long) ((double) nanoTimeDoProximoPulso + NANOS_ESPERADOS_POR_PULSO)) {
				Thread.yield();
			}

			grafico.setComposite(AlphaComposite.SrcOver.derive(alpha));
			alpha += add;
			buffer.show();
			if ((double) alpha < 0.80000000000000004D) {
				add = 0.02F;
			} else if ((double) alpha > 0.97999999999999998D) {
				add = -0.02F;
			}
		} while (true);
		apertouEnter = false;
		setBackground(Color.WHITE);
		grafico.dispose();
	}

	public void keyTyped(KeyEvent keyevent) {
	}

	public void keyPressed(KeyEvent e) {
		akuma.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		akuma.keyReleased(e);
	}

	public void run() {
		while (!Thread.interrupted()) {
			sequencia++;
			try {
				Thread.sleep(tempodothread);
			} catch (InterruptedException ex) {
			}
		}
	}

}
