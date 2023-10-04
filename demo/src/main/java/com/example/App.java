package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;


public class App 
{
    private static Scanner scanner = new Scanner(System.in);
    private static Tv tv = new Tv();
    private static Luz luz = new Luz();
    private static ArCondicionado ac = new ArCondicionado();
    private static PortaGaragem portaGaragem = new PortaGaragem();
    private static Geladeira gelo = new Geladeira();
    private static Cortina persiana = new Cortina();
    
    private static final String JSON_FILE_PATH = "demo/src/main/java/com/resources/config/arquivo.json";



    public static void main(String[] args) 
    {
        carregarEstadoDoJSON();
        while (true) 
        {
            exibirMenu();
            int choice = scanner.nextInt();
            if (choice == 0) 
            {
                System.out.println("Saindo do programa.");
                salvarEstadoNoJSON();
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
        System.out.println("2. Ligar/Desligar Luzes;");
        System.out.println("3. Ligar/Desligar Ar Condicionado;");
        System.out.println("4. Abrir/Fechar Porta da Garagem;");
        System.out.println("5. Ligar/Desligar Geladeira;");
        System.out.println("6. Abrir/Fechar Cortinas;");
        System.out.println("0. Sair.\n");
        System.out.print("Escolha uma opção: ");
    }

    private static void executarAcao(int choice) 
    {
        switch (choice) 
        {
            case 1:
                atualizarEstadoTV();
                break;
            case 2:
                atualizarEstadoLuzes();
                break;
            case 3:
                atualizarEstadoArCondicionado();
                break;
            case 4:
                atualizarEstadoPortaGaragem();
                break;
            case 5:
                atualizarEstadoGeladeira();
                break;
            case 6:
                atualizarEstadoCortinas();
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public static void carregarEstadoDoJSON()
    {
        try {
            String jsonContent = lerJSONArquivo(JSON_FILE_PATH);
            if (jsonContent != null) {
                Gson gson = new Gson();
                JsonObject jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();
                
                tv = gson.fromJson(jsonObject.get("tv"), Tv.class);
                luz = gson.fromJson(jsonObject.get("luz"), Luz.class);
                ac = gson.fromJson(jsonObject.get("arCondicionado"), ArCondicionado.class);
                portaGaragem = gson.fromJson(jsonObject.get("portaGaragem"), PortaGaragem.class);
                gelo = gson.fromJson(jsonObject.get("geladeira"), Geladeira.class);
                persiana = gson.fromJson(jsonObject.get("cortina"), Cortina.class);
            } else {
                // Se o arquivo não existe ou está vazio, crie novas instâncias
                tv = new Tv();
                luz = new Luz();
                ac = new ArCondicionado();
                portaGaragem = new PortaGaragem();
                gelo = new Geladeira();
                persiana = new Cortina();
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
            // Em caso de erro, crie novas instâncias
            tv = new Tv();
            luz = new Luz();
            ac = new ArCondicionado();
            portaGaragem = new PortaGaragem();
            gelo = new Geladeira();
            persiana = new Cortina();
        }
    }
    
    private static void salvarEstadoNoJSON() {
        try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
            Gson gson = new Gson();
            JsonObject jsonObject = new JsonObject();
            
            jsonObject.add("tv", gson.toJsonTree(tv));
            jsonObject.add("luz", gson.toJsonTree(luz));
            jsonObject.add("arCondicionado", gson.toJsonTree(ac));
            jsonObject.add("portaGaragem", gson.toJsonTree(portaGaragem));
            jsonObject.add("geladeira", gson.toJsonTree(gelo));
            jsonObject.add("cortina", gson.toJsonTree(persiana));
            
            String json = gson.toJson(jsonObject);
            fileWriter.write(json);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }

    private static void atualizarEstadoTV() {
        Gson gson = new Gson();
    
        try (FileReader fileReader = new FileReader(JSON_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
    
            // Obtém o estado atual da TV do JSON
            boolean tvStatus = jsonObject.get("ligaDesliga").getAsBoolean();
    
            // Inverte o estado da TV
            tvStatus = !tvStatus;
    
            // Atualiza o estado no JSON
            jsonObject.addProperty("ligaDesliga", tvStatus);
    
            // Escreve de volta no arquivo JSON
            try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Estado da TV atualizado: " + (tvStatus ? "ligada" : "desligada"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo JSON da TV: " + e.getMessage());
        }
    }

    private static void atualizarEstadoLuzes() {
        Gson gson = new Gson();
    
        try (FileReader fileReader = new FileReader(JSON_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
    
            // Verifica se a chave "luzesLigadas" existe no JSON
            boolean luzesStatus = jsonObject.has("luzesLigadas") ? jsonObject.get("luzesLigadas").getAsBoolean() : false;
    
            // Inverte o estado das luzes
            luzesStatus = !luzesStatus;
    
            // Atualiza o estado no JSON
            jsonObject.addProperty("luzesLigadas", luzesStatus);
    
            // Escreve de volta no arquivo JSON
            try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Estado das luzes atualizado: " + (luzesStatus ? "ligadas" : "desligadas"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo JSON das luzes: " + e.getMessage());
        }
    }

    private static void atualizarEstadoArCondicionado() {
        Gson gson = new Gson();
    
        try (FileReader fileReader = new FileReader(JSON_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
    
            // Verifica se a chave "arCondicionadoLigado" existe no JSON
            boolean arCondicionadoStatus = jsonObject.has("arCondicionadoLigado") ? jsonObject.get("arCondicionadoLigado").getAsBoolean() : false;
    
            // Inverte o estado do ar condicionado
            arCondicionadoStatus = !arCondicionadoStatus;
    
            // Atualiza o estado no JSON
            jsonObject.addProperty("arCondicionadoLigado", arCondicionadoStatus);
    
            // Escreve de volta no arquivo JSON
            try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Estado do Ar Condicionado atualizado: " + (arCondicionadoStatus ? "ligado" : "desligado"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo JSON do Ar Condicionado: " + e.getMessage());
        }
    }

    private static void atualizarEstadoPortaGaragem() {
        Gson gson = new Gson();
    
        try (FileReader fileReader = new FileReader(JSON_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
    
            // Verifica se a chave "portaGaragemAberta" existe no JSON
            boolean portaGaragemStatus = jsonObject.has("portaGaragemAberta") ? jsonObject.get("portaGaragemAberta").getAsBoolean() : false;
    
            // Inverte o estado da porta da garagem
            portaGaragemStatus = !portaGaragemStatus;
    
            // Atualiza o estado no JSON
            jsonObject.addProperty("portaGaragemAberta", portaGaragemStatus);
    
            // Escreve de volta no arquivo JSON
            try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Estado da Porta da Garagem atualizado: " + (portaGaragemStatus ? "aberta" : "fechada"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo JSON da Porta da Garagem: " + e.getMessage());
        }
    }

    private static void atualizarEstadoGeladeira() {
        Gson gson = new Gson();
    
        try (FileReader fileReader = new FileReader(JSON_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
    
            // Verifica se a chave "geladeiraLigada" existe no JSON
            boolean geladeiraStatus = jsonObject.has("geladeiraLigada") ? jsonObject.get("geladeiraLigada").getAsBoolean() : false;
    
            // Inverte o estado da geladeira
            geladeiraStatus = !geladeiraStatus;
    
            // Atualiza o estado no JSON
            jsonObject.addProperty("geladeiraLigada", geladeiraStatus);
    
            // Escreve de volta no arquivo JSON
            try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Estado da Geladeira atualizado: " + (geladeiraStatus ? "ligada" : "desligada"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo JSON da Geladeira: " + e.getMessage());
        }
    }

    private static void atualizarEstadoCortinas() {
        Gson gson = new Gson();
    
        try (FileReader fileReader = new FileReader(JSON_FILE_PATH)) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
    
            // Verifica se a chave "cortinasAbertas" existe no JSON
            boolean cortinasStatus = jsonObject.has("cortinasAbertas") ? jsonObject.get("cortinasAbertas").getAsBoolean() : false;
    
            // Inverte o estado das cortinas
            cortinasStatus = !cortinasStatus;
    
            // Atualiza o estado no JSON
            jsonObject.addProperty("cortinasAbertas", cortinasStatus);
    
            // Escreve de volta no arquivo JSON
            try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
                gson.toJson(jsonObject, fileWriter);
                System.out.println("Estado das Cortinas atualizado: " + (cortinasStatus ? "abertas" : "fechadas"));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo JSON das Cortinas: " + e.getMessage());
        }
    }

    private static String lerJSONArquivo(String filePath) throws IOException {
        Path filePathObj = Paths.get(filePath);
        if (Files.exists(filePathObj)) {
            return new String(Files.readAllBytes(filePathObj));
        }
        return null;
    }
}

