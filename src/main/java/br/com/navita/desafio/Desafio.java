package br.com.navita.desafio;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Desafio {

    private final Integer VALOR_MAXIMO =  100000000;
    private final Integer ZERO = 0;
    private final Integer MENOS_UM = -1;

    public Integer solution(Integer n) {


        if (n == null) {
            return ZERO;
        }

        String numero = n.toString();
        int ultimoIndice = numero.length() - 1;
        List<String> numeros = gerarNumeros(numero, 0, ultimoIndice);
        Integer maiorValor = this.extrairMaiorNumero(numeros);

        if (maiorValor > VALOR_MAXIMO) {
            return MENOS_UM;
        }

        return maiorValor;
    }

    private Integer extrairMaiorNumero(List<String> numeros) {
        return numeros.stream()
                      .map(Integer::parseInt)
                      .max(Comparator.comparing(Integer::valueOf))
                      .orElseThrow(RuntimeException::new);
    }

    private List<String> gerarNumeros(String numero, int primeiroIndice, int ultimoIndice) {
        List<String> numeros = new ArrayList<String>();
        if (primeiroIndice == ultimoIndice) {
            numeros.add(numero);
        } else {
            for (int i = primeiroIndice; i <= ultimoIndice; i++) {
                numero = trocarPosicao(numero, primeiroIndice, i);
                numeros.addAll(gerarNumeros(numero, primeiroIndice + 1, ultimoIndice));
                numero = trocarPosicao(numero, primeiroIndice, i);
            }
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

