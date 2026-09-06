package horizonlogin.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreen extends JWindow {

    public SplashScreen() {
        JLabel lblTitulo = new JLabel("Horizon Login", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 26));

        JLabel lblSubtitulo = new JLabel("Carregando...", SwingConstants.CENTER);

        add(lblTitulo, BorderLayout.CENTER);
        add(lblSubtitulo, BorderLayout.SOUTH);

        setSize(320, 180);
        setLocationRelativeTo(null);
    }

    /**
     * Exibe o splash por um tempo determinado (em milissegundos) e então o fecha.
     */
    public void exibirPor(int milissegundos, Runnable aoFinalizar) {
        setVisible(true);
        new Thread(() -> {
            try {
                Thread.sleep(milissegundos);
            } catch (InterruptedException ignored) {
            }
            setVisible(false);
            dispose();
            // Volta para a thread de interface gráfica (Event Dispatch Thread)
            javax.swing.SwingUtilities.invokeLater(aoFinalizar);
        }).start();
    }
}