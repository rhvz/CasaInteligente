package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class GeladeiraTest {
    
    @Test
    public void testGeladeira()
    {
    Geladeira gelo = new Geladeira();

    gelo.ligar();
    assertTrue(gelo.isLigaDesliga());

    gelo.desligar();
    assertFalse(gelo.isLigaDesliga());


    }
    
}
