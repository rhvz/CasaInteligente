package com.example;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArCondicionadoTest {
    
    @Test
    public void testLigaDesliga()
    {
        ArCondicionado ac = new ArCondicionado();
        
        ac.ligar();
        assertTrue(ac.isLigaDesliga());

        ac.desligar();
        assertFalse(ac.isLigaDesliga());

        assertEquals(ac.ligadoouNao(), false);
    }

}
