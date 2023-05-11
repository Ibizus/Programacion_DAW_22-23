import models.Pokedex;
import utils.jsonUtils;

public class App {
    public static void main(String[] args) throws Exception {
        

        Pokedex pokedex = jsonUtils.readPokemonListFromJson("src/resources/pokemon.json");

        System.out.println(pokedex);

        

    }
}
