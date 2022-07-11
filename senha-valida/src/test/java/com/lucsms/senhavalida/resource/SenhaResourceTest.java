package com.lucsms.senhavalida.resource;

import com.lucsms.senhavalida.domain.Senha;
import com.lucsms.senhavalida.services.SenhaService;
import com.lucsms.senhavalida.util.VerificacaoCaracteres;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SenhaResourceTest {

    @InjectMocks
    private SenhaResource resourceMock = new SenhaResource();

    @Mock
    private ResponseEntity<Senha> response;

    private SenhaService serviceMock = mock(SenhaService.class);
    private VerificacaoCaracteres verificacaoMock = mock(VerificacaoCaracteres.class);

    @Test
    public void validarSenhaResource() {
        when(serviceMock.validaSenha(anyString())).thenReturn(true);

        ResponseEntity<Senha> r = resourceMock.validateSenha("AbTp9!fok");

        assertEquals(true, r.getBody().getSenhaValida());
    }

    @Test
    public void validarSenhaVaziaResource() {

        ResponseEntity<Senha> r = resourceMock.senhaVazia();

        assertEquals(false, r.getBody().getSenhaValida());
    }
}
