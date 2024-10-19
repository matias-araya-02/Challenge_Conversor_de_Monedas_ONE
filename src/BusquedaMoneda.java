import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusquedaMoneda {

    public final String apiKey;

    public BusquedaMoneda(String apiKey) {
        this.apiKey = apiKey;
    }

    public double obtenerTasaDeCambio(String monedaBase, String monedaDestino) throws IOException, InterruptedException {

        URI direccion = URI.create(String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, monedaBase));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            MonedaOmdb respuesta = new Gson().fromJson(response.body(), MonedaOmdb.class);

            if (respuesta.conversion_rates().containsKey(monedaDestino)) {
                return respuesta.conversion_rates().get(monedaDestino);
            }else {
                throw new RuntimeException("No se puede obtener la tasa de cambio para "+ monedaDestino);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al obtener la tasa de cambio" + e.getMessage());
        }
    }
}
