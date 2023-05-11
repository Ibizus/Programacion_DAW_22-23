import java.util.ArrayList;
import java.util.List;

import models.Evolution;
import models.Pokedex;
import models.Pokemon;
import utils.JsonUtils;

public class App {
    public static void main(String[] args) throws Exception {
        


        // ANTES DE EMPEZAR A ESCRIBIR EN EL FICHERO TENGO QUE VER SI EXISTE Y BORRARLO PARA NO REPETIR LAS SALIDAS GUARDADAS:
        JsonUtils.deleteFile("src/resources/consultasPokemon.txt");


        // Extraigo la Pokedex del json:
        Pokedex pokedex = JsonUtils.readPokemonListFromJson("src/resources/pokemon.json");


        // Los 5 ultimos Pokemons según el listado:
        List<Pokemon> cincoUltimos = pokedex.getTheXFromEnd(5);
        String output1 = "\nLos 5 ultimos Pokemons según el listado:\n" + cincoUltimos.toString() + "\n";
        JsonUtils.writeIntoTextFile(output1);


        // Datos de Pikachu:
        Pokemon buscado = pokedex.findPokemonByName("Pikachu");
        String output2 = "\nResultados de la búsqueda por \"Pikachu\":\n" + buscado.toString() + "\n";
        JsonUtils.writeIntoTextFile(output2);


        // Evolución de Charmander:
        Evolution[] searchedEvolution = pokedex.findEvolutionByName("Charmander");
        String output3 = "\nEvolución de \"Charmander\":\n" + searchedEvolution.toString() + "\n";
        JsonUtils.writeIntoTextFile(output3);


        // Pokemons de tipo fire:
        ArrayList<String> tipoBuscado = new ArrayList<>();
        tipoBuscado.add("Fire");
        ArrayList<Pokemon> tipoFire = pokedex.findPokemonsByType(tipoBuscado);
        String output4 = "\nPokemons de tipo \"Fire\":\n" + tipoFire.toString() + "\n";
        JsonUtils.writeIntoTextFile(output4);


        // Pokemons con debilidad water o electric:
        ArrayList<String> weakBuscado = new ArrayList<>();
        weakBuscado.add("Water");
        weakBuscado.add("Electric");
        ArrayList<Pokemon> weakWaterOrElectric = pokedex.findPokemonsByWeeknesses(weakBuscado);
        String output5 = "\nPokemons con debilidad \"Water\" o \"Electric\":" + weakWaterOrElectric.toString() + "\n";
        JsonUtils.writeIntoTextFile(output5);


        // Pokemon con mas debilidades:
        Pokemon weakest = pokedex.weakestPokemon();
        String output6 = "\nResultados de la búsqueda del pokemon con más debilidades:\n" + weakest.toString() + "\n";
        JsonUtils.writeIntoTextFile(output6);


        // Pokemon más alto:
        Pokemon highest = pokedex.highestPokemon();
        String output7 = "\nResultados del pokemon con más debilidades:\n" + highest.toString() + "\n";
        JsonUtils.writeIntoTextFile(output7);
    }
}


