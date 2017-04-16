package com.rakeshdas.pokedex.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rakesh Das on 015 Apr 15 2017.
 */

public class Pokemon {
    @SerializedName("name")
    public String name;
    @SerializedName("weight")
    public int weight;


    @SerializedName("id")
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
