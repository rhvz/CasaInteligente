package com.example;

public class Geladeira {
    private boolean ligaDesliga;

    public boolean isLigaDesliga(){
        return ligaDesliga;
    }

    public void setLigaDesliga(boolean ligaDesliga){
        this.ligaDesliga = ligaDesliga;
    }

    public void desligar(){
    setLigaDesliga(false);
    }

    public void ligar(){
        setLigaDesliga(true);
    }

    public boolean ligadoouNao(){
        return isLigaDesliga();
    }
}
