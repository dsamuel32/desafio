package br.com.navita.desafio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Desafio {

    private final Integer VALOR_MAXIMO =  100000000;
    private final Integer ZERO = 0;
    private final Integer MENOS_UM = -1;

    public Integer solution(Integer n) {

        if (isNumeroValido(n)) {
            return obterMaiorNumeroIrmao(n);
        }

        return ZERO;
    }

    private Integer obterMaiorNumeroIrmao(Integer n) {
        String numero = n.toString();
        Integer ultimoIndice = numero.length() - 1;
        List<String> numeros = gerarNumeros(numero, 0, ultimoIndice);
        Integer maiorValor = extrairMaiorNumero(numeros);

        if (maiorValor > VALOR_MAXIMO) {
            return MENOS_UM;
        }

        return maiorValor;
    }

    private Boolean isNumeroValido(Integer numero) {
        return numero != null && numero > ZERO;
    }

    private Integer extrairMaiorNumero(List<String> numeros) {
        return numeros.stream()
                      .map(Integer::parseInt)
                      .max(Comparator.comparing(Integer::valueOf))
                      .orElseThrow(RuntimeException::new);
    }

    private List<String> gerarNumeros(String numero, int primeiroIndice, int ultimoIndice) {
        List<String> numeros = new ArrayList<>();
        if (primeiroIndice != ultimoIndice) {
            for (int i = primeiroIndice; i <= ultimoIndice; i++) {
                numero = trocarPosicao(numero, primeiroIndice, i);
                numeros.addAll(gerarNumeros(numero, primeiroIndice + 1, ultimoIndice));
                numero = trocarPosicao(numero, primeiroIndice, i);
            }
        } else {
            numeros.add(numero);
        }
        return numeros;
    }

    private String trocarPosicao(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}

