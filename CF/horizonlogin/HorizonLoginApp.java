// v1.1 - Organização em pacotes (MVC básico) + UML

// Objetivo
//separar responsabilidades em três pacotes, seguindo uma ideia simplificada do padrão MVC (Model-View-Controller):

package horizonlogin;

import javax.swing.UIManager;

import horizonlogin.view.LoginFrame;

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

        // Inicializa e exibe a tela de login
        LoginFrame tela = new LoginFrame();
        tela.setVisible(true);
    }
}