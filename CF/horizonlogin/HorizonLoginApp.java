// v1.0 — Lógica de autenticação (usuário e senha fixos)

// Objetivo
// Fazer o botão "Entrar" realmente validar o usuário e a senha digitados, 
// comparando com os valores fixos combinados: Usuário: root / Senha: toor.

package horizonlogin;

import java.awt.GridBagConstraints; // Define as regras de cada componente dentro do GridBagLayout (como posição X/Y, tamanho e alinhamento).
import java.awt.GridBagLayout; // Gerenciador de layout que organiza os componentes em uma grade de linhas e colunas.
import java.awt.Insets; // Define as margens (espaçamento externo) em pixels nas direções: superior, esquerda, inferior e direita.
import java.awt.event.ActionEvent; // Representa o evento gerado quando uma ação ocorre (por exemplo, o clique em um botão).
import java.awt.event.ActionListener; // Interface que detecta e responde às ações do usuário, disparando um código quando o botão é clicado.
import javax.swing.ImageIcon; // Permite carregar imagens ou ícones do computador para exibi-los na tela (geralmente dentro de botões ou rótulos).
import javax.swing.JButton; // O botão clicável da interface gráfica.
import javax.swing.JFrame; // A janela principal do aplicativo (com os botões de fechar, maximizar e minimizar).
import javax.swing.JLabel; // Um rótulo de texto ou imagem estático na tela, usado para títulos, descrições ou instruções.
import javax.swing.JOptionPane; // Cria caixas de diálogo prontas e rápidas, como alertas de erro, avisos ou perguntas de confirmação.
import javax.swing.JPanel; // Um painel invisível usado para agrupar e organizar outros componentes dentro da janela principal.
import javax.swing.JPasswordField; // Um campo de texto especial para senhas, que mascara os caracteres digitados por bolinhas ou asteriscos.
import javax.swing.JTextField; // Uma caixa de texto de linha única onde o usuário pode digitar dados convencionais (como nome de usuário ou e-mail).
import javax.swing.UIManager; // Permite gerenciar a aparência ("Look and Feel") da interface, deixando as janelas com a cara do sistema operacional (Windows, Mac, Linux).
import java.io.File; // Permite ao Java interagir com arquivos e pastas do computador (útil para verificar caminhos ou abrir fotos).

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

        File arquivoIcone = new File("ICONS/horizon_icon.png");

        ImageIcon icon = null;
        JLabel lblIconePainel = null;

        if (arquivoIcone.exists()) {
            icon = new ImageIcon(arquivoIcone.getAbsolutePath());
            lblIconePainel = new JLabel(icon);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;

            painelLogin.add(lblIconePainel, gbc);
            frame.setIconImage(icon.getImage());
        } else {
            System.err.println("Imagem não encontrada em: " + arquivoIcone.getAbsolutePath());
        }

        // --- SEÇÃO DOS CAMPOS DE TEXTO E BOTÕES ---
        
        gbc.gridwidth = 1; 

        // Rótulo "Usuário:"
        JLabel lblUsuario = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(lblUsuario, gbc);

        // Campo de Texto do Usuário
        JTextField txtUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        painelLogin.add(txtUsuario, gbc);

        // Rótulo "Senha:"
        JLabel lblSenha = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(lblSenha, gbc);

        // Campo de Senha
        JPasswordField txtSenha = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        painelLogin.add(txtSenha, gbc);

        // Botão Entrar
        JButton btnEntrar = new JButton("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(btnEntrar, gbc);

        // --- VALIDAÇÃO DE LOGIN ---
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                // Valida o usuário e senha informados
                if ("root".equals(usuario) && "toor".equals(senha)) {
                    JOptionPane.showMessageDialog(frame, 
                            "Login realizado com sucesso!", 
                            "Sucesso", 
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, 
                            "Usuário ou senha incorretos.", 
                            "Erro de Autenticação", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adiciona o painel configurado dentro da janela principal (JFrame)
        frame.add(painelLogin);
        
        // Torna a janela visível na tela
        frame.setVisible(true);
    }
}