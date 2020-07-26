import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ContadorDeVotos {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Integer> mapaDeResultados;

    public static void main(String[] args) {
        System.out.println("Contador de votos");
        try {
            String caminhoDoArquivoDeUrnas = obterDados("Entre com o caminho do arquivo de urnas:");
            mapaDeResultados = new MapeadorDeResultados(caminhoDoArquivoDeUrnas).mapear();
        } catch (IOException e) {
            System.out.println("Erro: "+e.getMessage());
        }
            imprimirResultados();
        }

        private static void imprimirResultados () {
            System.out.println("*Resultados da votação");
            for (String candidato : mapaDeResultados.keySet()) {
                System.out.println(candidato + ": " + mapaDeResultados.get(candidato));
            }
        }

        private static String obterDados (String mensagemAoUsuario){
            System.out.println(mensagemAoUsuario);
            return scanner.nextLine();
        }
    }
