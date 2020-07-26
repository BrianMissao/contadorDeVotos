import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapeadorDeResultados {
    private String arquivoDeVotos;

    public MapeadorDeResultados(String arquivoDeVotos) {
        this.arquivoDeVotos = arquivoDeVotos;
    }

    public Map<String, Integer> mapear() throws IOException {
        Map<String, Integer> mapaDeCandidatosENumeroDeVotos = new LinkedHashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.arquivoDeVotos));
        int campoDoNome = 0;
        int campoDaQuantidadeDeVotos = 1;
        String linhaDoArquivoDeUrnasSendoLida = bufferedReader.readLine();
        while (linhaDoArquivoDeUrnasSendoLida != null) {
            String[] registroDoCandidato = linhaDoArquivoDeUrnasSendoLida.split(",");
            if (mapaDeCandidatosENumeroDeVotos.containsKey(registroDoCandidato[campoDoNome])) {
                Integer quantidadeDeVotosJaComputadaParaEsteCandidato = mapaDeCandidatosENumeroDeVotos.get(registroDoCandidato[campoDoNome]);
                mapaDeCandidatosENumeroDeVotos.put(registroDoCandidato[campoDoNome], Integer.valueOf(registroDoCandidato[campoDaQuantidadeDeVotos])+quantidadeDeVotosJaComputadaParaEsteCandidato);
            } else {
                mapaDeCandidatosENumeroDeVotos.put(registroDoCandidato[campoDoNome], Integer.valueOf(registroDoCandidato[campoDaQuantidadeDeVotos]));
            }
            linhaDoArquivoDeUrnasSendoLida = bufferedReader.readLine();
        }
        return mapaDeCandidatosENumeroDeVotos;
    }
}
