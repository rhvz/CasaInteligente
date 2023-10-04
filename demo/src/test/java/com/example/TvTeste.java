package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TvTeste {
    @Test
    public void testCanal()
    {
        Tv tvSala = new Tv();
    
        tvSala.ligar();
        assertTrue(tvSala.isLigaDesliga());
    
        tvSala.desligar();
        assertFalse(tvSala.isLigaDesliga());
    }
}
