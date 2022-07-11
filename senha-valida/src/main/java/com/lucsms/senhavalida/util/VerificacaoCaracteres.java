package com.lucsms.senhavalida.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class VerificacaoCaracteres {

	private final Pattern caracterEspecial = Pattern.compile("^(?=.*[!@#$%^&*()-+])" +
            "(?=.*[a-z])(?=.*[A-Z]).+$");

    public boolean ehMaiMinEspecial(String caracter) {
        if (!(caracterEspecial.matcher(caracter).matches()))
            return false;
        return true;
    }

    public boolean temRepetidoEspaco(String senha) {
        // cria um mapa vazio
        Map<Character, Integer> freq = new HashMap<>();

        // mantém uma contagem de cada caractere da String no mapa
        for (char c: senha.toCharArray()) {
            if (c == ' ') return false;
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c: senha.toCharArray())
        {
            // diminui a frequência dos caracteres no mapa
            freq.put(c, freq.get(c) - 1);

            // se a frequência se tornar 0, apagua do mapa
            if (freq.get(c) == 0) {
                freq.remove(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
