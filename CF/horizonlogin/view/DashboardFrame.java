package horizonlogin.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DashboardFrame extends JFrame {

    public DashboardFrame(String nomeUsuario) {
        setTitle("Horizon Login — Painel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage("ICONS/horizon_icon.png"));

        JLabel lblBoasVindas = new JLabel("Bem-vindo, " + nomeUsuario + "!", SwingConstants.CENTER);
        lblBoasVindas.setFont(new Font("SansSerif", Font.BOLD, 18));

        add(lblBoasVindas, BorderLayout.CENTER);
    }
}