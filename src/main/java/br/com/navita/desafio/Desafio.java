package br.com.navita.desafio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        char [] elementos = n.toString().toCharArray();
        List<Integer> numeros = criarElementosInteiros(elementos);
        List<Integer> numerosOrdenados = ordenarElementosDecrescente(numeros);
        Integer maiorValor = montarMaiorNumeroPossivel(numerosOrdenados);

        if (maiorValor > VALOR_MAXIMO) {
            return MENOS_UM;
        }

        return maiorValor;
    }

    private List<Integer> criarElementosInteiros(char [] elementos) {
        List<Integer> numeros = new ArrayList<>();
        for (char i : elementos) {
            String valor = String.valueOf(i);
            numeros.add(Integer.valueOf(valor));
        }
        return numeros;
    }

    private Integer montarMaiorNumeroPossivel(List<Integer> numeros) {
        StringBuilder sb = new StringBuilder();
        numeros.forEach(sb::append);
        return Integer.valueOf(sb.toString());
    }

    private List<Integer> ordenarElementosDecrescente(List<Integer> numeros) {
        return numeros.stream()
                      .sorted(Comparator.reverseOrder())
                      .collect(Collectors.toList());
    }

    private Boolean isNumeroValido(Integer numero) {
        return numero != null && numero > ZERO;
    }

}

