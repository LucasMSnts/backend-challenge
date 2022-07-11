package com.lucsms.senhavalida.resource;

import com.lucsms.senhavalida.domain.Senha;
import com.lucsms.senhavalida.services.SenhaService;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SenhaResourceTest {

    private SenhaService service = mock(SenhaService.class);

    private SenhaResource senha = new SenhaResource();

    @Test
    public void validarSenhaResource() {
        Senha validar = new Senha("AbTp9!fok");

        when(service.validaSenha(any())).thenReturn(true);

        senha.validateSenha("AbTp9!fok");

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Senha> r = new ResponseEntity<>(validar, HttpStatus.OK);

        assertEquals(r.getStatusCode(), senha.);
    }

}
