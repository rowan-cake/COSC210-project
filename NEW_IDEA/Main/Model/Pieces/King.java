package NEW_IDEA.Main.Model.Pieces;


/*
 *  This class is a king. It is a type of peice that each player will have and have two different types
 *  of colors. 
 * 
 */

public class King extends Piece {

//Attributes 




//Consturctors

public King(int x,int y,boolean color){
    super(color);
        super.xCord = x;
        super.yCord = y;
}


//Getters+Setters

//Methods
    
    //Requires: xNew and yNew are non zero and non negative and no same color peice ocupys that square
    //Modiifies: x cord and y cord
    //Effects: Moves the bishop to where the user tells them too, displays a message if spot is out of range. 
    public void move(int x, int y) {
       //king can only move 1 square at a time , and it cant move if it puts itself in check 
        if(getXcord()+1 ==x || getYcord()+1==y){
            setXcord(x);
            setYcord(y);
        }


    }

        


}
