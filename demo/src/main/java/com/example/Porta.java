public class Porta{
    Private boolean ligaDesliga;

    public boolean isligaDesliga(){
        return ligaDesliga;
    }

    public void setligaDesliga(boolean,ligaDesliga){
        this.ligaDesliga = ligaDesliga;
    }

    public void desligar(){
        setligaDesliga(ligaDesliga:false);

    }

    public void ligar(){
        setligaDesliga(ligaDesliga,true);
    }

    public boolean ligadoOuNao(){
        return isligaDesliga;
    }



}