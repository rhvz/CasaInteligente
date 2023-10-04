public class Tv
{
    private boolean ligaDesliga;
    private int canal;

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
        setCanal(novoCanal);
        return novoCanal;
        }
        else
        {
            System.out.println("O canal deve ser de um número não negativo.");
            return -1;
        }
    }
}
