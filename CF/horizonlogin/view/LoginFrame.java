package horizonlogin.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import horizonlogin.controller.LoginController;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private final LoginController controller;

    public LoginFrame() {
        this.controller = new LoginController();
        montarInterface();
    }

    private void montarInterface() {
        // Cria a janela principal do aplicativo e define o título
        setTitle("Horizon Login");
        
        // Faz o programa fechar completamente ao clicar no "X" da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define a largura (400) e a altura (400) da janela em pixels
        setSize(400, 400);
        
        // Centraliza a janela no meio da tela do computador
        setLocationRelativeTo(null);

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
            setIconImage(icon.getImage());
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
        txtUsuario = new JTextField(15);
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
        txtSenha = new JPasswordField(15);
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
                tentarLogin();
            }
        });

        // Adiciona o painel configurado dentro da janela principal (JFrame)
        add(painelLogin);
    }

    private void tentarLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        // Valida o usuário e senha informados via Controller
        if (controller.autenticar(usuario, senha)) {
            JOptionPane.showMessageDialog(this, 
                    "Login realizado com sucesso!", 
                    "Sucesso", 
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, 
                    "Usuário ou senha incorretos.", 
                    "Erro de Autenticação", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}