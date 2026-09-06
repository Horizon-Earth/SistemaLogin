package horizonlogin;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import horizonlogin.view.LoginFrame;
import horizonlogin.view.SplashScreen;

public class HorizonLoginApp {

    public static void main(String[] args) {
        aplicarLookAndFeel();

        SplashScreen splash = new SplashScreen();
        splash.exibirPor(2000, () -> {
            LoginFrame tela = new LoginFrame();
            tela.setVisible(true);
        });
    }

    private static void aplicarLookAndFeel() {
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
    }
}