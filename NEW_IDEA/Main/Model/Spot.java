package NEW_IDEA.Main.Model;

import NEW_IDEA.Main.Model.Pieces.Piece;


/*
 *  This class is a "spot". It is a spot on the board that holds a x y cord and a piece. A bit abstract but is usefull for the board. 
 * 
 */


public class Spot { //This idea came from a website cuz i was mad confused

    
//Attributes 
public int x;
public int y;
public Piece p;

//Consturctors


public Spot(int x,int y){
    setP(null);
    setX(x);
    setY(y);
}

public Spot(int x,int y,Piece p){
    setP(p);
    setX(x);
    setY(y);
}


//Getters+Setters
//if theres a peice on the spot return true
public boolean isPieceThere(){
    if(getPiece()!=null){
        return true;
    }
    return false;
}



public Piece getPiece() {
    return p;
}
public int getX() {
    return x;
}
public int getY() {
    return y;
}
public void setP(Piece p) {
    this.p = p;
}
public void setX(int x) {
    this.x = x;
}
public void setY(int y) {
    this.y = y;
}

//Methods




    
}
