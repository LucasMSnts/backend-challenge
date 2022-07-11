package com.lucsms.senhavalida.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class VerificacaoCaracteresTest {

    private VerificacaoCaracteres verificacao = new VerificacaoCaracteres();

    @Test
    public void verificarMaiusculaMinisculaEspecialOk() {

        Boolean valida = verificacao.ehMaiMinEspecial("AbTp9!fok");

        assertTrue(valida);
    }

    @Test
    public void verificarMaiusculaMinisculaEspecialNOk() {

        Boolean valida = verificacao.ehMaiMinEspecial("AAAbbbCc");

        assertFalse(valida);
    }

    @Test
    public void verificarRepetidoEspaçoOk() {

        Boolean valida = verificacao.temRepetidoEspaço("AbTp9!fok");

        assertTrue(valida);
    }

    @Test
    public void verificarRepetidoNOk() {

        Boolean valida = verificacao.temRepetidoEspaço("AAAbbbCc");

        assertFalse(valida);
    }

    @Test
    public void verificarEspaçoNOk() {

        Boolean valida = verificacao.temRepetidoEspaço("AAAb bCc");

        assertFalse(valida);
    }
}
