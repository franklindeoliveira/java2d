package java2d;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Principal extends Applet {
	
	@Override
	public void init() {
		setSize(500, 500);
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		
		// Desenha a malha.
		int origemX = 20;
		int origemY = 10;
		int numeroLinhas = 1;
		int numeroColunas = 5;
		int larguraMalha = 100;
		int alturaMalha = 100;
		desenhaMalha(g2d, origemX, origemY, numeroLinhas, numeroColunas, larguraMalha, alturaMalha);
		
		// Obtém um nó da malha.
		int noX = 2;
		int noY = 2;
		getPosicaoNoXMalha(noX, origemX, origemY, numeroLinhas, numeroColunas, larguraMalha, alturaMalha);
		getPosicaoNoYMalha(noY, origemX, origemY, numeroLinhas, numeroColunas, larguraMalha, alturaMalha);
		
	}
	
	private int getPosicaoNoXMalha(int noX, int origemX, int origemY,
			int numeroLinhas, int numeroColunas, int larguraMalha,
			int alturaMalha) {
		
		int alturaCelula = alturaMalha / numeroLinhas;
		
		int posicaoNoX = noX * alturaCelula + origemX;
		
		if (posicaoNoX > alturaMalha || posicaoNoX < origemX) {
			System.out.println("Nó fora da malha");
		}
		return posicaoNoX;
	}
	
	private int getPosicaoNoYMalha(int noY, int origemX, int origemY,
			int numeroLinhas, int numeroColunas, int larguraMalha,
			int alturaMalha) {
		
		int alturaCelula = alturaMalha / numeroLinhas;
		
		int posicaoNoY = noY * alturaCelula + origemY;
		
		if (posicaoNoY > alturaMalha || posicaoNoY < origemY) {
			System.out.println("Nó fora da malha");
		}
		return posicaoNoY;
	}
	
	private void desenhaMalha(Graphics2D g2d, int origemX, int origemY,
			int numeroLinhas, int numeroColunas, int larguraMalha,
			int alturaMalha) {
		
		int larguraCelula = larguraMalha / numeroColunas;
		int alturaCelula = alturaMalha / numeroLinhas;
		
		// Desenha as linhas da malha.
		for (int i = 0; i <= numeroLinhas; i++) {
			g2d.drawLine(origemX, i * alturaCelula + origemY, numeroColunas * larguraCelula + origemX, i * alturaCelula + origemY);
		}
		// Desenha as colunas da malha.
		for (int j = 0; j <= numeroColunas; j++) {
			g2d.drawLine(j * larguraCelula + origemX, origemY, j * larguraCelula + origemX, numeroLinhas * alturaCelula + origemY);
		}
	}
}