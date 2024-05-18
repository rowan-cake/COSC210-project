package NEW_IDEA.Main.Model.Pieces;

/*
 *  This class is a bishop. It is a type of peice that each player will have and have two different types
 *  of colors. 
 * 
 */


public class Bishop extends Piece{

//Attributes 




//Consturctors

    


public Bishop(int x, int y, boolean color){
    super(color);
    setXcord(x);
    setYcord(y);
}


//Getters+Setters



    

    //methods 
    

    //Requires: xNew and yNew are non zero and non negative and no same color peice ocupys that square
    //Modiifies: x cord and y cord
    //Effects: Moves the bishop to where the user tells them too, displays a message if spot is out of range.
    public void move(int xNew , int yNew ){
        //THey can only move to places that have a slope = |1| from it (current cord i.e (1,1) -> (2,2) is valid)
        double m = (yNew-getYcord())/(xNew-getXcord()); //Slope formula
        if(Math.abs(m)==1){
            setXcord(xNew);
            setYcord(yNew); 
        }else{
            System.out.println("Cant move there");
        }

    }
    
}
