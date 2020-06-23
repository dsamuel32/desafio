package br.com.navita.desafio;

import junit.framework.TestCase;
import org.junit.Before;

public class DesafioTest extends TestCase {

    private Desafio desafio;

    @Before
    public void setUp() {
        this.desafio = new Desafio();
    }

    public void testSolution() {
        this.desafio.solution(123);
    }

}