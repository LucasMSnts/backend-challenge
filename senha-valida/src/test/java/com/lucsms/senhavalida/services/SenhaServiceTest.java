package com.lucsms.senhavalida.services;

import com.lucsms.senhavalida.util.VerificacaoCaracteres;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SenhaServiceTest {

    private VerificacaoCaracteres verificacao = mock(VerificacaoCaracteres.class);

    private SenhaService valida = new SenhaService();

    @Test
    public void validacaoSenhaOk() {

        when(verificacao.temRepetidoEspaco(anyString())).thenReturn(true);
        when(verificacao.tamanhoSenha(anyString())).thenReturn(true);
        when(verificacao.ehMaiMinEspecial(anyString())).thenReturn(true);

        Boolean v = valida.validaSenha("AbTp9!fok");

        assertTrue(v);
    }

    @Test
    public void validacaoSenhaVaziaNOk() {

        Boolean v = valida.validaSenha("");

        assertFalse(v);
    }

    @Test
    public void validacaoSenhaTamanhoNOk() {

        when(verificacao.tamanhoSenha(anyString())).thenReturn(false);

        Boolean v = valida.validaSenha("AbTp9");

        assertFalse(v);
    }

    @Test
    public void validacaoSenhaMaiusculaMinusculaEspecialNOk() {

        when(verificacao.tamanhoSenha(anyString())).thenReturn(true);
        when(verificacao.ehMaiMinEspecial(anyString())).thenReturn(false);

        Boolean v = valida.validaSenha("AbTp9nfok");

        assertFalse(v);
    }

    @Test
    public void validacaoSenhaRepetidaEspacoNOk() {

        when(verificacao.tamanhoSenha(anyString())).thenReturn(true);
        when(verificacao.ehMaiMinEspecial(anyString())).thenReturn(true);
        when(verificacao.temRepetidoEspaco(anyString())).thenReturn(false);

        Boolean v = valida.validaSenha("AbTp9 fok");

        assertFalse(v);
    }
}
