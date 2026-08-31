// v0.3 — Identidade visual (ícone da aplicação + Look and Feel)

// Objetivo
// Adicionar ícone próprio e dar uma aparência mais moderna

package horizonlogin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class HorizonLoginApp {

    public static void main(String[] args) {

        // Aplica o tema "Nimbus" para deixar os botões e campos com visual moderno
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Não foi possível carregar o Look and Feel Nimbus.");
        }

        // Cria a janela principal do aplicativo e define o título
        JFrame frame = new JFrame("Horizon Login");
        
        // Faz o programa fechar completamente ao clicar no "X" da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define a largura (400) e a altura (400) da janela em pixels
        frame.setSize(400, 400); 
        
        // Centraliza a janela no meio da tela do computador
        frame.setLocationRelativeTo(null);

        // Cria o painel que vai receber os componentes (botões, textos, imagens)
        JPanel painelLogin = new JPanel();
        
        // Define o layout GridBagLayout (organiza os componentes em uma grade/tabela)
        painelLogin.setLayout(new GridBagLayout());

        // Cria o objeto que controla a posição e o espaçamento de cada componente na grade
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Adiciona uma margem de 8 pixels ao redor de cada componente (cima, esquerda, baixo, direita)
        gbc.insets = new Insets(8, 8, 8, 8);
        
        // Faz com que os componentes estiquem horizontalmente para preencher o espaço da célula
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- SEÇÃO DO ÍCONE DO PAINEL ---
        
        // Busca o arquivo da imagem dentro da pasta do projeto (pasta CF)
        URL urlIcone = HorizonLoginApp.class.getResource("/ICONS/horizon_icon.png");
        
        // Transforma a imagem carregada em um objeto ImageIcon utilizável pelo Swing
        ImageIcon icon = new ImageIcon(urlIcone);
        
        // Cria um rótulo (Label) contendo apenas a imagem do ícone
        JLabel lblIconePainel = new JLabel(icon); 
        
        // Posiciona o ícone na primeira coluna (X = 0) e na primeira linha (Y = 0) da grade
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        // Faz o ícone ocupar o espaço de 2 colunas para ficar centralizado acima dos campos
        gbc.gridwidth = 2; 
        
        // Alinha o ícone exatamente no centro da célula da grade
        gbc.anchor = GridBagConstraints.CENTER; 
        
        // Adiciona o ícone ao painel principal
        painelLogin.add(lblIconePainel, gbc);
        
        // Também define a imagem como ícone oficial da janela (para funcionar fora do Ubuntu)
        frame.setIconImage(icon.getImage());

        // --- SEÇÃO DOS CAMPOS DE TEXTO E BOTÕES ---
        
        // Reseta a largura do componente para 1 coluna (os próximos elementos usam tamanho normal)
        gbc.gridwidth = 1; 

        // Rótulo "Usuário:"
        JLabel lblUsuario = new JLabel("Usuário:");
        gbc.gridx = 0; // Coluna 0 (Esquerda)
        gbc.gridy = 1; // Linha 1 (Abaixo do ícone)
        gbc.weightx = 0.0; // ALTERADO: Coluna da esquerda não ganha peso, ficando compactada à esquerda
        gbc.anchor = GridBagConstraints.WEST; // Garante alinhamento total à esquerda
        painelLogin.add(lblUsuario, gbc);

        // Campo de Texto do Usuário
        JTextField txtUsuario = new JTextField(15);
        gbc.gridx = 1; // Coluna 1 (Direita)
        gbc.gridy = 1; // Linha 1
        gbc.weightx = 1.0; // ALTERADO: Dá peso total à coluna da direita para "empurrar" a coluna 0 para a esquerda
        painelLogin.add(txtUsuario, gbc);

        // Rótulo "Senha:"
        JLabel lblSenha = new JLabel("Senha:");
        gbc.gridx = 0; // Coluna 0 (Esquerda)
        gbc.gridy = 2; // Linha 2
        gbc.weightx = 0.0; // Compacta à esquerda
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(lblSenha, gbc);

        // Campo de Senha
        JPasswordField txtSenha = new JPasswordField(15);
        gbc.gridx = 1; // Coluna 1 (Direita)
        gbc.gridy = 2; // Linha 2
        gbc.weightx = 1.0; // ALTERADO: Mantém o peso na coluna da direita
        painelLogin.add(txtSenha, gbc);

        // Botão Entrar
        JButton btnEntrar = new JButton("Entrar");
        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 3; // Linha 3
        gbc.weightx = 1.0; // Mantém o peso à direita
        gbc.fill = GridBagConstraints.NONE; // ALTERADO: Evita que o botão estique e mude de tamanho
        gbc.anchor = GridBagConstraints.WEST; // ALTERADO: Alinha o botão "Entrar" diretamente colado na esquerda do seu próprio bloco
        painelLogin.add(btnEntrar, gbc);

        // Adiciona o painel configurado dentro da janela principal (JFrame)
        frame.add(painelLogin);
        
        // Torna a janela visível na tela (por padrão ela inicia oculta)
        frame.setVisible(true);
    }
}