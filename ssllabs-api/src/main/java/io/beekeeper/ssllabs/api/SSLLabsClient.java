package io.beekeeper.ssllabs.api;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class SSLLabsClient {

    public static String API_BASE_URL = "https://api.ssllabs.com/api/v2/";

    private String apiBaseUrl;

    public SSLLabsClient() {
        this(API_BASE_URL);
    }

    public SSLLabsClient(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public SSLLabsService getService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(apiBaseUrl)
                                                  .addConverterFactory(JacksonConverterFactory.create())
                                                  .build();
        return retrofit.create(SSLLabsService.class);
    }
}
