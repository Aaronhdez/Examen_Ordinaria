/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.mock;

import control.Command;
import control.NextCommand;
import control.PrevCommand;
import control.ReloadCommand;
import java.util.HashMap;
import model.MovieData;
import view.MoviesDisplay;

/**
 *
 * @author Usuario
 */
public class MovieMockFrame {

    private MoviesDisplay movieMockPanel;
    private MoviesDisplay currentMovieMockPanel;
    private MovieData moviesList;
    private HashMap<String,Command> commands;
    
    public MovieMockFrame() {
        this.execute();
    }

    private void execute() {
        this.currentMovieMockPanel = new CurrentMovieMockPanel();
        this.movieMockPanel = new MovieMockPanel();
        this.moviesList = new MovieData();
        this.initLogic();
        this.commands.get("r").execute();
    }

    private void initLogic() {
        this.moviesList.registerObservers(currentMovieMockPanel);
        this.currentMovieMockPanel.display(moviesList);
        this.moviesList.registerObservers(movieMockPanel);
        this.movieMockPanel.display(moviesList);
        this.createComands();
    }

    private void createComands() {
        this.commands = new HashMap();
        this.commands.put("r", new ReloadCommand(this.moviesList));
        this.commands.put("n", new NextCommand(this.moviesList));
        this.commands.put("p", new PrevCommand(this.moviesList));
    }
    
}
