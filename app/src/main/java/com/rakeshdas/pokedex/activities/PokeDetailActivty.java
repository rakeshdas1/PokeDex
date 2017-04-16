package com.rakeshdas.pokedex.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.rakeshdas.pokedex.R;
import com.rakeshdas.pokedex.api.PokemonService;
import com.rakeshdas.pokedex.model.Pokemon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeDetailActivty extends AppCompatActivity {
    private static final String TAG = PokeDetailActivty.class.getSimpleName();
    private TextView pokeNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_detail_activty);
        pokeNameTV = (TextView) findViewById(R.id.pokeNameTV);
        Intent intent = getIntent();
        String pokeName = intent.getStringExtra("pokeName");
        PokemonService pokemonService = PokemonService.retrofit.create(PokemonService.class);
        Call<Pokemon> call = pokemonService.getPokemonDetails(1);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Log.d(TAG, "onResponse: " + response.body().getName());
                pokeNameTV.setText("Name: " + response.body().getName().substring(0, 1).toUpperCase() + response.body().getName().substring(1, response.body().getName().length()) + "\n Weight: " + response.body().getWeight() + "\n ID: " + response.body().getId());

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString(), t);

            }
        });

        pokeNameTV.setText(pokeName);

    }
}
        /*call.(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Log.d(TAG, "onResponse: " + response.body());
                Log.d(TAG, "onResponse: " + response.raw().request().url().toString());

            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString(), t);

            }
        });*/
