package com.lucsms.senhavalida.services;

import com.lucsms.senhavalida.util.VerificacaoCaracteres;
import org.springframework.stereotype.Service;

import com.lucsms.senhavalida.services.exceptions.ValidacaoException;

@Service
public class SenhaService {

	public boolean validaSenha(String senha) throws ValidacaoException {

        VerificacaoCaracteres verificacao = new VerificacaoCaracteres();

        if (senha.length() < 1) {
            return false;
        }

        if (!(verificacao.ehMaiMinEspecial(senha))){
            return false;
        }

        if (!(verificacao.temRepetidoEspaço(senha))) {
            return false;
        }

        return true;
    }

}
