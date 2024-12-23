package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

@Getter
@Setter
class PokemonApiResponse {
    private int count;
    private String next;
    private String previous;
    private List<PokemonResult> results;
}

@Getter
@Setter
class PokemonResult {
    private String name;
    private String url;
}

public class APIFetcher {  // Removed extends CompletableFuture<List<String>>

    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public APIFetcher() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public CompletableFuture<List<String>> getPokemonNamesAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);  // Wrapped in try-catch inside supplyAsync

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(API_URL))
                        .GET()
                        .build();

                return request;
            } catch (InterruptedException e) {
                throw new CompletionException(e);
            }
        }).thenCompose(request ->
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenApply(this::parseResponse)
                        .thenApply(response -> response.getResults().stream()
                                .map(PokemonResult::getName)
                                .collect(Collectors.toList()))
        );
    }

    private PokemonApiResponse parseResponse(String json) {
        try {
            return objectMapper.readValue(json, PokemonApiResponse.class);
        } catch (JsonProcessingException e) {
            throw new CompletionException("Failed to parse JSON", e);
        }
    }
}