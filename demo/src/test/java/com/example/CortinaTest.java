package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class CortinaTest {
    
    @Test
    public void testAbreFecha()
    {
        Cortina cortina = new Cortina();
        assertFalse(cortina.isAbertoFechado());

        cortina.abrir();
        assertTrue(cortina.isAbertoFechado());

        assertEquals(cortina.abertoOuNao(), true);
    }
}
