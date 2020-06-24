package br.com.navita.desafio;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesafioTest {

    private Desafio desafio;
    private final Integer MENOS_UM = -1;
    private final Integer ZERO = 0;
    private final Integer TRES_DOIS_UM = 321;

    @Before
    public void setUp() {
        this.desafio = new Desafio();
    }

    @Test
    public void deveRetornarZeroQuandoValorInformadoForZERO() {
        assertEquals(ZERO, this.desafio.solution(0));
    }

    @Test
    public void deveRetornarZeroQuandoValorInformadoForNulo() {
        assertEquals(ZERO, this.desafio.solution(null));
    }

    @Test
    public void deveRetornarZeroQuandoValorInformadoForNegativo() {
        assertEquals(ZERO, this.desafio.solution(-7));
    }

    @Test
    public void deveRetornar321QuandoInformado123() {
        assertEquals(TRES_DOIS_UM, this.desafio.solution(123 ));
    }

    @Test
    public void deveRetornarMenosUmQuandoOMaiorNumeroInformadoForMaiorQue100000000() {
        assertEquals(MENOS_UM, this.desafio.solution(121314343));
    }

}