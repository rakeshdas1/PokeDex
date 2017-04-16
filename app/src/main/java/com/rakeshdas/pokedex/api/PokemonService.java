package com.rakeshdas.pokedex.api;

import com.rakeshdas.pokedex.model.Pokemon;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Rakesh Das on 015 Apr 15 2017.
 */

public interface PokemonService {
    @GET("api/v2/pokemon/{id}/")
    Call<Pokemon> getPokemonDetails(
            @Path("id") int id
    );

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
