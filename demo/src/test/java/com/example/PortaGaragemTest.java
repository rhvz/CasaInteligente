package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class PortaGaragemTest {
    @Test
    public void testCanal()
    {
        PortaGaragem portaG = new PortaGaragem();
    
        portaG.abrir();
        assertTrue(portaG.isAbertoFechado());
    
        portaG.fechar();
        assertFalse(portaG.isAbertoFechado());

        assertEquals(portaG.abertoOuNao(), false);

    }
}
