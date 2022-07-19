import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer conexao http e guardar o BODY do IMdp em uma string
    String url = "https://alura-filmes.herokuapp.com/conteudos"; //grava a url de acesso externo em uma string
    URI endereco = URI.create(url); //cria uma URI para trata-la localmente
    var cliente = HttpClient.newHttpClient(); //cria um cliente para fazer um request
    var request = HttpRequest.newBuilder(endereco).GET().build(); //
    HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString()); 
    String body = response.body() ;

    var parser = new JsonParser();
    List<Map<String, String>> listaDeFilmes = parser.parse(body); //trata a lista de filmes em JSON e retorna uma lista de mapas com os filmes

    //exibir dados
    for (Map<String,String> filmes : listaDeFilmes) {
        System.out.println(filmes.get("title"));
        System.out.println(filmes.get("image"));
        System.out.println(filmes.get("imDbRating"));
        System.out.println();
    }
    

    }
}
