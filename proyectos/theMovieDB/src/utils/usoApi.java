package utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.ListaActores;
import models.ListaPeliculas;

public class usoApi {
    
        // Clave de la API Key:
        // 6fde46fa6eaf4001e82d718976f8f6b5

        // Token de acceso de lectura a la API:
        // eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2ZmRlNDZmYTZlYWY0MDAxZTgyZDcxODk3NmY4ZjZiNSIsInN1YiI6IjY0NzljYWZhY2FlZjJkMDBmY2U0ZWQwZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.-Ctm41wwORvbc1nY4it_ZJ5Jk22-tvWsi1JtneXJYzk
        
        // Ejemplo busqueda por nombre:
        // INGLES  https://api.themoviedb.org/3/search/movie?api_key=6fde46fa6eaf4001e82d718976f8f6b5&include_adult=false&language=en-US&page=1&query=torrente
        // ESPAÑOL  https://api.themoviedb.org/3/search/movie?api_key=6fde46fa6eaf4001e82d718976f8f6b5&include_adult=false&language=es-ES&page=1&query=torrente
        
        // Ejemplo busqueda por actor:
        // INGLES  https://api.themoviedb.org/3/search/person?api_key=6fde46fa6eaf4001e82d718976f8f6b5&query=pitt&include_adult=false&language=en-US&page=1
        // ESPAÑOL  https://api.themoviedb.org/3/search/person?api_key=6fde46fa6eaf4001e82d718976f8f6b5&query=pitt&include_adult=false&language=es-ES&page=1


        // buscaPeli + IDIOMA + patronBusquedaPeli + consulta
        final static String buscaPeli = "https://api.themoviedb.org/3/search/movie?api_key=6fde46fa6eaf4001e82d718976f8f6b5&include_adult=false";
        final static String patronBusquedaPeli = "&page=1&query=";
        final static String ingles = "&language=en-US";
        final static String español = "&language=es-ES";
        // buscaActor + consulta + patron1Actor + IDIOMA + patron2Actor
        final static String buscaActor = "https://api.themoviedb.org/3/search/person?api_key=6fde46fa6eaf4001e82d718976f8f6b5&query=";
        final static String patron1Actor = "&include_adult=false";
        final static String patron2Actor = "&page=1";


        public static ListaActores leerActoresFromTMDB(String consulta)
        {
            ListaActores actores = new ListaActores();
    
            try {
                
                URL url = new URL(buscaActor + consulta + patron1Actor + español + patron2Actor);
    
                URLConnection connection = url.openConnection();
    
                InputStream stream =  new BufferedInputStream(connection.getInputStream());
    
                ObjectMapper mapper = new ObjectMapper();
    
                actores = mapper.readValue(stream, ListaActores.class);
    
            } catch (Exception e) {
                System.out.println("Error al leer actores y/o directores desde TMDB");
            }
    
            return actores;
        }


        public static ListaPeliculas leerPeliculasFromTMDB(String consulta)
        {
            ListaPeliculas peliculas = new ListaPeliculas();
    
            try {
                
                URL url = new URL(buscaPeli + español + patronBusquedaPeli + consulta);
    
                URLConnection connection = url.openConnection();
    
                InputStream stream =  new BufferedInputStream(connection.getInputStream());
    
                ObjectMapper mapper = new ObjectMapper();
    
                peliculas = mapper.readValue(stream, ListaPeliculas.class);
    
            } catch (Exception e) {
                System.out.println("Error al leer peliculas desde TMDB");
            }
    
            return peliculas;
        }


}
