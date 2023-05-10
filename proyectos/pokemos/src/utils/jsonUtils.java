package utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Pokedex;
import models.Pokemon;

public class jsonUtils {
    

    public static Pokemon readPokemonFromJson(String relativePathFile)
    {
		Pokemon pokemon = null;
		try {
			
            // Create File
			File pokeFile = new File(relativePathFile);
			
			//create ObjectMapper instance
			ObjectMapper objectMapper = new ObjectMapper();
			
			//convert json string to object
			try {
				pokemon = objectMapper.readValue(pokeFile, Pokemon.class);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		catch (Exception e)
		{
			
		}
        return pokemon;
    }


	public static Pokedex readPokemonListFromJson(String relativePathFile)
	{
		File pokeFile = new File(relativePathFile);

		ObjectMapper objectMapper = new ObjectMapper();

		Pokedex pokeList = null;
		try {
            pokeList = objectMapper.readValue(pokeFile,  new TypeReference<Pokedex>(){});
        } catch (IOException e) {
            
            e.printStackTrace();
        }

		return pokeList;
	}


}
