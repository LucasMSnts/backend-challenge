package com.lucsms.senhavalida.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VerificacaoCaracteresTest {

    private VerificacaoCaracteres verificacao = new VerificacaoCaracteres();

    @Test
    public void verificarMaiusculaMinisculaEspecialOk() {

        Boolean valida = verificacao.ehMaiMinEspecial("AbTp9!fok");

        assertTrue(valida);
    }

    @Test
    public void verificarTamanhoNOk() {

        Boolean valida = verificacao.tamanhoSenha("AbTp9!f");

        assertFalse(valida);
    }

    @Test
    public void verificarEspecialNOk() {

        Boolean valida = verificacao.ehMaiMinEspecial("AAAbbbCc");

        assertFalse(valida);
    }

    @Test
    public void verificarMaiusculaNOk() {

        Boolean valida = verificacao.ehMaiMinEspecial("bbb!a");

        assertFalse(valida);
    }

    @Test
    public void verificarMinisculaNOk() {

        Boolean valida = verificacao.ehMaiMinEspecial("AAA!C");

        assertFalse(valida);
    }

    @Test
    public void verificarRepetidoEspaçoOk() {

        Boolean valida = verificacao.temRepetidoEspaco("AbTp9!fok");

        assertTrue(valida);
    }

    @Test
    public void verificarRepetidoNOk() {

        Boolean valida = verificacao.temRepetidoEspaco("AAAbbbCc");

        assertFalse(valida);
    }

    @Test
    public void verificarEspaçoNOk() {

        Boolean valida = verificacao.temRepetidoEspaco("AAAb bCc");

        assertFalse(valida);
    }
}
