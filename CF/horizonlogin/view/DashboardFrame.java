package horizonlogin.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class DashboardFrame extends JFrame {

    public DashboardFrame(String nomeUsuario) {
        setTitle("Horizon Login — Painel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 300);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("ICONS/horizon_icon.png"));

        JLabel lblBoasVindas = new JLabel("Bem-vindo, " + nomeUsuario + "!", SwingConstants.CENTER);
        lblBoasVindas.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(lblBoasVindas, BorderLayout.CENTER);

        add(criarBotaoVoltar(), BorderLayout.SOUTH);
        setJMenuBar(criarMenu());
    }

    private JButton criarBotaoVoltar() {
        JButton btnVoltar = new JButton("Voltar ao Login");
        btnVoltar.addActionListener(e -> voltarParaLogin());
        return btnVoltar;
    }

    private void voltarParaLogin() {
        // Fecha o painel atual...
        dispose();
        // ...e reabre a tela de login do zero (tentativas e campos limpos)
        LoginFrame telaLogin = new LoginFrame();
        telaLogin.setVisible(true);
    }

    private JMenuBar criarMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuAjuda = new JMenu("Sobre");
        JMenuItem itemSobre = new JMenuItem("Sobre o Horizon Login");
        itemSobre.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Horizon Login\nProjeto de estudo em Java Swing.\nVersão atual (v3.2).",
                "Sobre",
                JOptionPane.INFORMATION_MESSAGE
        ));
        menuAjuda.add(itemSobre);

        JMenu menuGithub = new JMenu("GitHub");
        JMenuItem itemRepo = new JMenuItem("Abrir repositório no GitHub");
        itemRepo.addActionListener(e -> abrirLink("https://github.com/Horizon-Earth/SistemaLogin"));
        menuGithub.add(itemRepo);

        menuBar.add(menuAjuda);
        menuBar.add(menuGithub);
        return menuBar;
    }

    private void abrirLink(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (IOException | URISyntaxException e) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível abrir o link:\n" + url,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}