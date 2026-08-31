// v0.2 - Interface estática (componentes de login, sem lógica)

// Objetivo
// Adicionar os componentes visuais de um formulário de login:
// rótulos, campo de usuário, campo de senha e botão.
// Ainda sem nenhuma validação.

package horizonlogin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class HorizonLoginApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Horizon Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Painel que vai conter o formulário de login
        JPanel painelLogin = new JPanel();
        painelLogin.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // espaçamento entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- Rótulo e campo: Usuário ---
        JLabel lblUsuario = new JLabel("Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelLogin.add(lblUsuario, gbc);

        JTextField txtUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        painelLogin.add(txtUsuario, gbc);

        // --- Rótulo e campo: Senha ---
        JLabel lblSenha = new JLabel("Senha:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelLogin.add(lblSenha, gbc);

        JPasswordField txtSenha = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        painelLogin.add(txtSenha, gbc);

        // --- Botão de login ---
        JButton btnEntrar = new JButton("Entrar");
        gbc.gridx = 1;
        gbc.gridy = 2;
        painelLogin.add(btnEntrar, gbc);

        // Adiciona o painel na janela
        frame.add(painelLogin);

        frame.setVisible(true);
    }
}