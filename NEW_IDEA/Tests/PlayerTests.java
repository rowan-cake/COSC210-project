package NEW_IDEA.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.*;

import NEW_IDEA.Exceptions.PieceNotPickable;

import NEW_IDEA.Main.Model.Board;
import NEW_IDEA.Main.Model.Player;

public class PlayerTests {

Player p1 = new Player("Player",true);
Board b1 = new Board(); //to test this method I need a board too;


    @Test
    public void PieceNotRolledTest() throws Exception{
        p1.gameMove(b1);
    }

     @Test 
     public void rollDiecesArentMoreThanSix(){
        for (int i = 0; i < 1000; i++) {
            if(p1.rollDices()[0]>6||p1.rollDices()[1]>6){
                assertFalse(true);
            }    
        } 
        
     }

     @Test
    public void gameMoveWorks(){
        //to do later    
    }

    public void pieceToMove(){
        // to do later
    }


}
