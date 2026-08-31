// v0.1 - Janela vazia (primeiro JFrame)

// - Objetivo
// Criar a janela mais simples possível.

package horizonlogin;

import javax.swing.JFrame;

public class HorizonLoginApp {

	public static void main(String[] args) {
		
		// Cria a janela principal
		
		JFrame frame = new JFrame("Horizon Login");
		
		// Define o que acontece quando o usuário clica no X (fechar)
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Define o tamanho da janela (largura x altura, em pixels)

		frame.setSize(400 , 300);
		
		// Centraliza a janela na tela
		
		frame.setLocationRelativeTo(null);
		
		// Torna a janela visível
		
		frame.setVisible(true);
		
	}

}