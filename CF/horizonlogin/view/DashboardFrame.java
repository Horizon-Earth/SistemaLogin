package horizonlogin.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

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

        setJMenuBar(criarMenu());
    }

    private JMenuBar criarMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuAjuda = new JMenu("Sobre");

        JMenuItem itemSobre = new JMenuItem("Sobre o Horizon Login");
        itemSobre.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Horizon Login\nProjeto de estudo em Java Swing.\nVersão atual (v3.0).",
                "Sobre",
                JOptionPane.INFORMATION_MESSAGE
        ));

        menuAjuda.add(itemSobre);
        menuBar.add(menuAjuda);
        return menuBar;
    }
}