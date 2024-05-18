package NEW_IDEA.Main.Model.Pieces;


/*
 *  This class is a pawn. It is a type of peice that each player will have and have two different types
 *  of colors. 
 * 
 */
public class Pawn extends Piece {
    //Attributes 
    int moveNumber; //pawns can move two spaces or 1 if they have never moved before



    //Consturtors
    
public Pawn(int x , int y, boolean color){
    super(color);
    super.setXcord(x);
    super.setYcord(y);
}

    //GEtters+setters
    public int getMoveNumber(){
        return moveNumber;
    }  
    



    //methods


    
    //Requires: xNew and yNew are non zero and non negative and no same color peice ocupys that square
    //Modiifies: x cord and y cord
    //Effects: Moves the bishop to where the user tells them too, displays a message if spot is out of range.
    public void move(int x,int y){
        if(Math.abs(y-getYcord())<=2){ //the difference between where it is and where it is going to is less than or 2. 
            if(x == getXcord()){ //pawn can only move on the x=c line unless its attacking 
                setXcord(x); //x>2 case already handlened 
                setYcord(y);
            }else{
                System.out.println("Cant move there");
            }    
        }else if (y == getYcord()){ //pawn can only move on the y=c line unless its attacking 
            setXcord(getXcord()+1);
            setYcord(y);
        }
    }


}
