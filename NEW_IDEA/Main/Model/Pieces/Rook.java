package NEW_IDEA.Main.Model.Pieces;
/*
 *  This class is a rook. It is a type of peice that each player will have and have two different types
 *  of colors. 
 * 
 */
public class Rook extends Piece{


//Attributes 

//Consturctors
public Rook(int x,int y,boolean color){
    super(color);
    super.setXcord(x);
    super.setYcord(y);
}


//Getters+Setters

//Methods



    //Requires: xNew and yNew are non zero and non negative and no same color peice ocupys that square
    //Modiifies: x cord and y cord
    //Effects: Moves the bishop to where the user tells them too, displays a message if spot is out of range.
    public void move(int x, int y) {
        //rooks can only move on the y=c and the x=c line
        if(getYcord()==y||getXcord()==x){  
            setXcord(x); //this might not work idk
            setYcord(y);
        }
    }



    

}
