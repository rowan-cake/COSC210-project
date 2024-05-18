package NEW_IDEA.Main.UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import NEW_IDEA.Main.Model.Pieces.*;
import NEW_IDEA.Main.Model.Board;
import NEW_IDEA.Main.Model.Player;

/*
 *  This class is what runs the game and combines all the elements in the model to fit the real life game of chess. Has a board and a array of two players and a boolean called playing. 
 *  It alertenates player moves on after each turn until a king is caputured. It also keeps a log of the game moves so you can leave the game and come back to it. 
 * 
 * 
 */


public class Game {
Scanner in = new Scanner(System.in);

//Attributes 
Board board;
Player[] players;
Boolean playing;


//Consturctors
public Game() throws Exception{
    
    board = new Board(); 
    players = new Player[2]; 
    
    System.out.println("Player 1 enter your name and color(true=white,false=black)"); 
    String name = in.nextLine();
    boolean color = in.nextBoolean();
    players[0] = addNewPlayer(name, color);
    
    in.nextLine(); //read away empty string

    System.out.println("Player 2 enter your name and color(true=white,false=black)");
    name = in.nextLine();
    color = in.nextBoolean();
    players[1] = addNewPlayer(name, color);
    startGame();
    in.close();

}


//Getters+Setters
public Board getBoard() {
    return board;
}

public Player[] getPlayers() {
    return players;
}
public void setPlaying(Boolean playing) {
    this.playing = playing;
}
public Boolean getPlaying() {
    return playing;
}


//Methods    
public Player addNewPlayer(String name , boolean color){
    Player p1 = new Player(name, color);
    return p1;
}

//EFFECTS: Runs the game until a king is dead 1
//MODIFIES: nothing
//REQUIRES: nothing
public void startGame() throws Exception{
    setPlaying(true);
    System.out.println("Starting game \n -------------------------------------");
    getPlayers()[0] = findWhitePlayer(getPlayers()); //make first player in array = to the white player 
    
    while (getPlaying()) { //back and forth until stop 
        System.out.println("Whites turn :");
        getPlayers()[0].gameMove(getBoard()); //whites move
        System.out.println("Blacks turn :");
        getPlayers()[1].gameMove(getBoard()); //blacks move
    }
}

//EFFECTS: goes and finds the "white" player   
//MODIFIES: nothing
//REQUIRES: Player[] is a array of players
public Player findWhitePlayer(Player[] players){
    for (Player p : players) {
        if(p.getColor()=="White"){
            return p;
        }
    }
    return null;
}


//EFFECTS:
//MODIFIES: 
//REQUIRES: 
public void saveGame(String s ){
    

}

//EFFECTS:
//MODIFIES: 
//REQUIRES: 
public void loadGame(String s ){

}



}
