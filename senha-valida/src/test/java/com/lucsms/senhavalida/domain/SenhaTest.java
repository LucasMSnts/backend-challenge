package com.lucsms.senhavalida.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SenhaTest {

    @Test
    public void instanciaSenhaTeste() {
        Senha senhaInstacia = new Senha("AbTp9!fok");

        assertEquals(false, senhaInstacia.getSenhaValida());
    }
}
