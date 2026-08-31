package horizonlogin.controller;

import horizonlogin.model.Usuario;

public class LoginController {

    // Credencial fixa do sistema (sem banco de dados)
    private final Usuario usuarioValido = new Usuario("root", "toor");

    /**
     * Verifica se o usuário e a senha informados são válidos.
     */
    public boolean autenticar(String usuarioDigitado, String senhaDigitada) {
        return usuarioValido.getUsuario().equals(usuarioDigitado)
                && usuarioValido.getSenha().equals(senhaDigitada);
    }
}