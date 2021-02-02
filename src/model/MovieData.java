/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MovieData {
    
    private ArrayList<Movie> moviesList; 
    private ArrayList<Observer> observers;
    private Movie currentMovie;
    private int index;

    public MovieData() {
        this.observers = new ArrayList();
        this.moviesList = new ArrayList();
        this.index = 0;
        this.load();
    }

    //Implemnatar con el image Loader
    private void load() {
        this.add(new Movie("Película1","1999","Terror","Imagen1","Actores",3));
        this.add(new Movie("Película2","1992","Terror","Imagen2","Actores2",2));
        this.add(new Movie("Película2","1992","Acción","Imagen2","Actores2",2));
        this.currentMovie = this.moviesList.get(0);
    }
    
    public void add(Movie movie){
        this.moviesList.add(movie);
    }
    
    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }
    
    public Movie getCurrentMovie() {
        return currentMovie;
    }
    
    //Commands
    public void reload(){
        this.changeStatus();
    }
    
    public void next(){
        if(this.index == this.moviesList.size()-1){
            this.index = 0;
        } else {
            this.index = this.index+1;
        }
        this.currentMovie = this.moviesList.get(index);
        this.changeStatus();
    }

    public void prev(){
        if(this.index == 0){
            this.index = this.moviesList.size()-1;
        } else {
            this.index = this.index-1;
        }
        this.currentMovie = this.moviesList.get(index);
        this.changeStatus();
    }

    @Override
    public String toString() {
        String res="";
        for (Movie movie : moviesList) {
            res+="\n"+movie.toString();
        }
        return res;
    }
    
    public void registerObservers(Observer obs){
        this.observers.add(obs);
    }
 
    private void changeStatus(){
        for (Observer observer : this.observers) {
            observer.change();
        }
    }
    
    public static interface Observer{
        void change();
    }
    
}
