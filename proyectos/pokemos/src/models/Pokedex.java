package models;

import java.util.ArrayList;

public class Pokedex {
    
    // ATRIBUTOS:
    private ArrayList<Pokemon> pokemon;

    // CONTRUCTOR:
    public Pokedex(){
        
    }

    // METHODS:
    @Override
    public String toString() {
        return "Pokedex [pokemon=" + pokemon + "]";
    }

    // GETTERS & SETTERS: 
    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
