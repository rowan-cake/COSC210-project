package NEW_IDEA.Main.Model.Pieces;
/*
 *  This class is a knight. It is a type of peice that each player will have and have two different types
 *  of colors. 
 * 
 */
public class Knight extends Piece {
//Attributes 




//Consturctors

public Knight( int x  , int y, boolean color){
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
        //the knight moves |sqrt(5)| squares at a time 
        double radicand = Math.pow((x-getXcord()),2)+Math.pow((y-getYcord()),2);
        double c = Math.sqrt(radicand);
        if(c==Math.sqrt(5)){
            setXcord(x);
            setYcord(y);
        }
    }


}
