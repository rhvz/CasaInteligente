package com.example;

public class Tv
{
    private boolean ligaDesliga;

    public boolean isLigaDesliga() {
        return ligaDesliga;
    }

    public void setLigaDesliga(boolean ligaDesliga) {
        this.ligaDesliga = ligaDesliga;
    }

    public void desligar() 
    {
        setLigaDesliga(false); 
    }

    public void ligar()
    {
        setLigaDesliga(true);
    }

    public boolean ligadoOuNao()
    {
       return isLigaDesliga();
    }
    public int mudaCanal(int novoCanal)
    {
        if(novoCanal >= 0)
        {
        mudaCanal(novoCanal);
        return novoCanal;
        }
        else
        {
            System.out.println("O canal deve ser de um número não negativo.");
            return -1;
        }
    }

    public String getCanal() {
        return null;
    }
}
