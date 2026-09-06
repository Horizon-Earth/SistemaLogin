package horizonlogin.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import horizonlogin.controller.LoginController;

public class LoginFrame extends JFrame {

    private static final int MAX_TENTATIVAS = 3;

    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JCheckBox chkMostrarSenha;
    private JButton btnEntrar;

    private final LoginController controller;
    private int tentativasRestantes = MAX_TENTATIVAS;

    public LoginFrame() {
        this.controller = new LoginController();
        montarInterface();
    }

    private void montarInterface() {
        setTitle("Horizon Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- SEÇÃO DO ÍCONE DO PAINEL (igual à v1.1) ---
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

        gbc.gridwidth = 1;

        JLabel lblUsuario = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(lblUsuario, gbc);

        txtUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        painelLogin.add(txtUsuario, gbc);

        JLabel lblSenha = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(lblSenha, gbc);

        txtSenha = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        painelLogin.add(txtSenha, gbc);

        // Checkbox "Mostrar senha"
        chkMostrarSenha = new JCheckBox("Mostrar senha");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(chkMostrarSenha, gbc);

        chkMostrarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkMostrarSenha.isSelected()) {
                    txtSenha.setEchoChar((char) 0); // 0 = sem máscara, mostra o texto puro
                } else {
                    txtSenha.setEchoChar('•'); // volta a mascarar
                }
            }
        });

        btnEntrar = new JButton("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        painelLogin.add(btnEntrar, gbc);

        ActionListener acaoLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tentarLogin();
            }
        };

        // O botão dispara login ao ser clicado...
        btnEntrar.addActionListener(acaoLogin);
        // ...e os campos de texto disparam login ao apertar Enter
        txtUsuario.addActionListener(acaoLogin);
        txtSenha.addActionListener(acaoLogin);

        add(painelLogin);
    }

    private void tentarLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (controller.autenticar(usuario, senha)) {
            // Abre a tela de painel...
            DashboardFrame dashboard = new DashboardFrame(usuario);
            dashboard.setVisible(true);
            // ...e fecha a tela de login
            this.dispose();
        } else {
            tentativasRestantes--;

            if (tentativasRestantes > 0) {
                JOptionPane.showMessageDialog(this,
                        "Usuário ou senha inválidos.\nTentativas restantes: " + tentativasRestantes,
                        "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Número máximo de tentativas excedido. Acesso bloqueado.",
                        "Acesso bloqueado", JOptionPane.ERROR_MESSAGE);
                bloquearFormulario();
            }
        }
    }

    private void bloquearFormulario() {
        btnEntrar.setEnabled(false);
        txtUsuario.setEnabled(false);
        txtSenha.setEnabled(false);
        chkMostrarSenha.setEnabled(false);
    }
}