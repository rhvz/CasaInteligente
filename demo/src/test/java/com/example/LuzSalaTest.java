package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class LuzSalaTest {
    
    @Test
    public void testLigar()
    {
        Luz luz = new Luz();
        assertFalse(luz.isLigaDesliga());

        luz.ligar();
        assertTrue(luz.isLigaDesliga());

        assertEquals(luz.ligadoOuNão(), true);
    }

}
