package app.CarStatus.Service;

import app.CarStatus.DTO.ClienteDTO;
import app.CarStatus.Mapper.ClienteMapper;
import app.CarStatus.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Transactional( rollbackFor = Exception.class )
    public ClienteDTO save(app.CarStatus.Entity.ClienteEntity pessoa ){
        app.CarStatus.Entity.ClienteEntity novaPessoa = salvarEEditar( pessoa );
        return ClienteMapper.converterParaDTO( novaPessoa );
    }

    public boolean validarTelefone(String telefone) {
        try {
            String apiKey = "8a70cf30fd6945c2b6b45f51bf7f7e18";
            String urlStr = "https://phonevalidation.abstractapi.com/v1/?api_key=" + apiKey + "&phone=" + telefone;

            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Analisar a resposta JSON
                String responseBody = response.toString();
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                boolean isValid = jsonNode.get("valid").asBoolean();
                return isValid;
            } else {
                // Lidar com o erro de resposta da API
                System.out.println("Erro na chamada da API. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            // Lidar com erros de conexão, etc.
            e.printStackTrace();
        }
        return false;
    }

    @Transactional( rollbackFor = Exception.class )
    public ClienteDTO editar(app.CarStatus.Entity.ClienteEntity pessoa, Long id ){
        pessoa.setId( id );
        app.CarStatus.Entity.ClienteEntity novaPessoa = salvarEEditar( pessoa );
        return ClienteMapper.converterParaDTO(novaPessoa);
    }

    public ClienteDTO buscarPorId(Long id ){
        return ClienteMapper.converterParaDTO( repository.findById( id ).get() );
    }

    public List<ClienteDTO> buscarTodos(){
        return ClienteMapper.converterListaParaDTO( repository.findAll() );
    }

    public app.CarStatus.Entity.ClienteEntity salvarEEditar(app.CarStatus.Entity.ClienteEntity pessoa ){
        return repository.save(pessoa);
    }

    public void deletarPorId( Long id ){
        repository.deleteById( id );
    }
}
