package br.com.navita.desafio;

import java.util.ArrayList;
import java.util.List;

public class Desafio {

    public Integer solution(Integer n) {
        String str = "123";
        int a = str.length();
        List<String> numeros = gerarNumeros(str, 0, a - 1);
        for (String numero : numeros) {
            System.out.println(numero);
        }
        return 0;
    }

    private Integer extrairMaiorNumero(List<String> numeros) {
        return 0;
    }

    private List<String> gerarNumeros(String numero, int l, int r) {
        List<String> numeros = new ArrayList<String>();
        if (l == r) {
            numeros.add(numero);
        } else {
            for (int i = l; i <= r; i++) {
                numero = trocarPosicao(numero, l, i);
                numeros.addAll(gerarNumeros(numero, l + 1, r));
                numero = trocarPosicao(numero, l, i);
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
