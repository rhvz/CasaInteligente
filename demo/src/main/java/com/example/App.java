package com.example;

import java.util.Scanner;

public class App 
{
    private static Scanner scanner = new Scanner(System.in);
    private static Tv tv = new Tv();
    private static Luz luz = new Luz();
    private static ArCondicionado ac = new ArCondicionado();
    private static PortaGaragem portaGaragem = new PortaGaragem();
    private static Geladeira gelo = new Geladeira();
    private static Cortina persiana = new Cortina();  

    public static void main(String[] args) 
    {
        while (true) 
        {
            exibirMenu();
            int choice = scanner.nextInt();
            if (choice == 0) 
            {
                System.out.println("Saindo do programa.");
                break;
            } else 
            {
                executarAcao(choice);
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n===> BEM VINDO À CASA INTELIGENTE <===\n");
        System.out.println("Escolha o que será feito:");
        System.out.println("1. Ligar/desligar TV;");
        System.out.println("2. Definir canal da TV;");
        System.out.println("3. Ligar/Desligar Luzes;");
        System.out.println("4. Ligar/Desligar Ar Condicionado;");
        System.out.println("5. Abrir/Fechar Porta da Garagem;");
        System.out.println("6. Ligar/Desligar Geladeira;");
        System.out.println("7. Abrir/Fechar Cortinas;");
        System.out.println("0. Sair.\n");
        System.out.print("Escolha uma opção: ");
    }

    private static void executarAcao(int choice) 
    {
        switch (choice) 
        {
            case 1:
                inverterLigacaoTV();
                break;
            case 2:
                definirCanalTV();
                break;
            case 3:
                switchLuzes();
                break;
            case 4:
                switchAc();
                break;
            case 5:
                switchPortaGaragem();
                break;
            case 6:
                switchGeladeira();
                break;
            case 7:
                switchCortinas();
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void inverterLigacaoTV() 
    {
        if (tv.isLigaDesliga()) 
        {
            tv.desligar();
        } else 
        {
            tv.ligar();
        }
        System.out.println("TV ligada: " + tv.isLigaDesliga());
    }

    private static void definirCanalTV() 
    {
        System.out.print("Digite o canal da TV: ");
        int channel = scanner.nextInt();
        tv.mudaCanal(channel);
        System.out.println("A TV está no canal " + tv.getCanal());
    }

    private static void switchLuzes()
    {
        if(luz.isLigaDesliga())
        {
            luz.desligar();
        }else
        {
            luz.ligar();
        }
        System.out.println("As luzes estão ligadas: " + luz.isLigaDesliga());
    }

    private static void switchAc()
    {
        if(ac.isLigaDesliga())
        {
            ac.desligar();
        }else
        {
            ac.ligar();
        }
        System.out.println("O Ar Condicionado está ligado: " + ac.isLigaDesliga());
    }

    private static void switchPortaGaragem()
    {
        if(portaGaragem.isAbertoFechado())
        {
            portaGaragem.fechar();
        }else
        {
            portaGaragem.abrir();
        }
        System.out.println("A Porta da Garagem está aberta: " + portaGaragem.isAbertoFechado());
    }
    private static void switchGeladeira()
    {
        if(gelo.isLigaDesliga())
        {
            gelo.desligar();
        }else
        {
            gelo.ligar();
        }
        System.out.println("A Geladeira está ligada: " + gelo.isLigaDesliga());
    }
    private static void switchCortinas()
    {
        if(persiana.isAbertoFechado())
        {
            persiana.fechar();
        }else
        {
            persiana.abrir();
        }
        System.out.println("As cortinas estão abertas: " + persiana.isAbertoFechado());
    }


}

