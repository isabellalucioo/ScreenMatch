package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o filme que quer buscar:");
        var busca = scanner.nextLine();
        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=38384bf6";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

        HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(tituloOmdb);
        Titulo meuTitulo = new Titulo(tituloOmdb);
        System.out.println("Titulo já convertidoAA");
        System.out.println(meuTitulo);



    }
}
