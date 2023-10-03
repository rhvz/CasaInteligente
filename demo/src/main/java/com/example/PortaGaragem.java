package com.example;

public class PortaGaragem{
    private boolean abertoFechado;

    public boolean isAbertoFechado() {
        return abertoFechado;
    }

    public void setAbertoFechado(boolean abertoFechado) {
        this.abertoFechado = abertoFechado;
    }

    public void fechar() 
    {
        setAbertoFechado(false); 
    }

    public void abrir()
    {
        setAbertoFechado(true);
    }

    public boolean abertoOuNao()
    {
       return isAbertoFechado();
    }
}