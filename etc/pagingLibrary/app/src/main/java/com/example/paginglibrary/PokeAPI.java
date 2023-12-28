package com.example.paginglibrary;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeAPI<pokeAPI> {
    @GET("pokemon/")
    Call<Response> listPokemons();

    @GET("pokemon/")
    Call<Response> listPokemons(@Query("offset") String offset, @Query("limit") String limit);

}
