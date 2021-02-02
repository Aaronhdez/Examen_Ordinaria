/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mock;

import java.util.ArrayList;
import model.Movie;
import view.MoviesLoader;

/**
 *
 * @author Usuario
 */
public class MoviesMockLoader implements MoviesLoader{

    @Override
    public ArrayList<Movie> load() {
        ArrayList<Movie> res = new ArrayList();
        res.add(new Movie("Película1","1999","Terror","Imagen1","Actores",3));
        res.add(new Movie("Película2","1992","Terror","Imagen2","Actores2",2));
        res.add(new Movie("Película3","1992","Acción","Imagen3","Actores3",4));
        res.add(new Movie("Película4","1995","Drama","Imagen3","Actores3",7));
        res.add(new Movie("Película5","1995","Drama","Imagen3","Actores3",8));
        return res;
    }
    
}
