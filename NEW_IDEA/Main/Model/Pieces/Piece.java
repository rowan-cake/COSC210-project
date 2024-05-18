package NEW_IDEA.Main.Model.Pieces;

import NEW_IDEA.Main.Interfaces.Moveable;
import NEW_IDEA.Main.Model.Board;

/*
 *  This class is a piece. It is a the general sturcture of each specific type of peice that each player will have and have two different types
 *  of colors and a x and y cord on the board . 
 * 
 */
public abstract class Piece implements Moveable {
    
    //Attrributes
    boolean color; //true = white, false = black
    boolean alive;
    int xCord = 0;
    int yCord = 0; 
    String name;

    // for the GUI
    public int xMouse;
    public int yMouse;


    //Constuctor
    public Piece(int xp,int yp,boolean color,String n){
        this.xCord = xp;
        this.yCord = yp;
        this.color = color;
        this.name=n;
        //GUI stuff again
        this.xMouse=xMouse*64;
        this.yMouse=yMouse*64;
    }


    public Piece(boolean color){
        this.color = color;
    }


    //Getters+Setters
    public int getXcord() {
        return xCord;
    }
    public int getYcord() {
        return yCord;
    }
    public void setXcord(int x){
        this.xCord = x;
    }
    public void setYcord(int y){
        this.yCord = y;
    }

    public void getPos(){
        System.out.println("Pos is = "+getXcord()+","+getYcord());
    }
    public boolean getColor(){
        return color;
    }


    //Methods
    
    //Maybe make the move method here or something that makes it so pieces cant move through each other 



}
