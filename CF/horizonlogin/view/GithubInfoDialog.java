package horizonlogin.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Caixa com informações do projeto no GitHub: organização e repositório,
 * cada um com um botão próprio para abrir a respectiva página.
 */
public class GithubInfoDialog extends JDialog {

    private static final String ORGANIZACAO = "Horizon Earth";
    private static final String URL_ORGANIZACAO = "https://github.com/Horizon-Earth";

    private static final String REPOSITORIO = "SistemaLogin";
    private static final String URL_REPOSITORIO = "https://github.com/Horizon-Earth/SistemaLogin";

    public GithubInfoDialog(JFrame pai) {
        super(pai, "Informações do GitHub", true); // true = janela modal
        montarInterface();
    }

    private void montarInterface() {
        setSize(360, 240);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel("Horizon Login no GitHub", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTitulo.setBorder(new EmptyBorder(14, 0, 0, 0));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelInfo = new JPanel(new GridLayout(2, 1, 12, 12));
        painelInfo.setBorder(new EmptyBorder(16, 20, 16, 20));
        painelInfo.setBackground(Color.WHITE);

        painelInfo.add(criarLinha("Organização: " + ORGANIZACAO, "Abrir organização", URL_ORGANIZACAO));
        painelInfo.add(criarLinha("Repositório: " + REPOSITORIO, "Abrir repositório", URL_REPOSITORIO));

        add(painelInfo, BorderLayout.CENTER);
    }

    private JPanel criarLinha(String texto, String textoBotao, String url) {
        JPanel linha = new JPanel(new BorderLayout(8, 0));
        linha.setBackground(Color.WHITE);

        JLabel lblTexto = new JLabel(texto);
        lblTexto.setFont(new Font("SansSerif", Font.PLAIN, 13));

        JButton btn = new JButton(textoBotao);
        btn.addActionListener(e -> abrirLink(url));

        linha.add(lblTexto, BorderLayout.CENTER);
        linha.add(btn, BorderLayout.EAST);
        return linha;
    }

    private void abrirLink(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (IOException | URISyntaxException ex) {
            JOptionPane.showMessageDialog(this,
                    "Não foi possível abrir o link:\n" + url,
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}