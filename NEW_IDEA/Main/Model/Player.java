package NEW_IDEA.Main.Model;

import java.util.List;
import java.util.Scanner;

import NEW_IDEA.Exceptions.*;
import NEW_IDEA.Main.Model.Pieces.*;


/*
 *  This class is a player. It has a set of pieces that are specific to the player. A name and a color are attribuites aswell. Main actions are picking the piece to move and making the move (both methods). 
 *    
 *  
 * 
 */
public class Player {
Scanner in = new Scanner(System.in);
//Attributes 
String name;
Piece[] pieces;
boolean color; //true=white,false=black
List<Spot> piecesList;


//Consturctors
public Player(String name,boolean color){
    setColor(color);
    setName(name);
    if(color ==true){ // if they are white peices
    pieces = new Piece[] {
        new Rook(0,7,color),
        new Knight(1,7,color),
        new Bishop(2,7,color),
        new Queen(3,7,color),
        new King(4,7,color),
        new Bishop(5,7,color),
        new Knight(6,7,color),
        new Rook(7,7,color),
        new Pawn(0,6,color),
        new Pawn(1,6,color),
        new Pawn(2,6,color),
        new Pawn(3,6,color),
        new Pawn(4,6,color),
        new Pawn(5,6,color),
        new Pawn(6,6,color),
        new Pawn(7,6,color)} ; //hard coded but needed to be done i think
    }else{
        pieces = new Piece[]{
        new Rook(7,0,color),
        new Knight(6,0,color),
        new Bishop(5,0,color),
        new Queen(4,0,color),
        new King(3,0,color),
        new Bishop(2,0,color),
        new Knight(1,0,color),
        new Rook(0,0,color),
        new Pawn(0,1,color),
        new Pawn(1,1,color),
        new Pawn(2,1,color),
        new Pawn(3,1,color),
        new Pawn(4,1,color),
        new Pawn(5,1,color),
        new Pawn(6,1,color),
        new Pawn(7,1,color)};
}
}


//Getters+Setters
public String getName() {
    return name;
}

public String getColor() {
    String StringColor = color?"White":"Black";
    return StringColor;
}


public void setColor(boolean color) {
    this.color = color;
}

public void setName(String name){
    this.name = name;
}

public Piece[] getPieces() {
    return pieces;
}


//Methods




//Requires: nothing
//Modiifies: nothing
//Effects: returns a array of size two of numbers from 1-6. (to model two dice rolls)
public int[] rollDices(){
    //random number from 1-6
    int[] rolls = new int[2];
    rolls[0] = (int)(1+Math.random()*6);
    rolls[1] = (int)(1+Math.random()*6);
    return rolls;

}


//Requires: board to be instaided 
//Modiifies: nothing
//Effects: Asigns a piece to each number rollable in the two dice rolls. Then prints a message where the user can pick between the two peices they rolled. (If rolled doubles then any peiece is pickable,).
public Spot pieceToMove(Board b) throws Exception{

    //Roll the dices and then check in the array to see what the values are. 
    int[] rolls = rollDices();
    for (Integer i : rolls) {
        if(rolls[0]==rolls[1]){
            System.out.println("YOU ROLLED DOUBLES PICK WHATEVER YOU WANT TO MOVE");
        }else{
            switch (i) {
                case 1: System.out.printf("You can move a pawn");break;
                case 2: System.out.printf("You can move a horse");break;
                case 3: System.out.printf("You can move a bishop");break;
                case 4: System.out.printf("You can move a rook");break;
                case 5: System.out.printf("You can move a queen");break;
                case 6: System.out.printf("You can move a king"); break;
                default: System.out.println("Error");
                    }
                    System.out.print(" , ");
        }
    }
        //TODO if none of these pieces can move than return some message saying that they cant move and none of the code run
            System.out.println("Pick which one out the two you want (1-6)");
            int choice = in.nextInt();
            
            /*Now the user picked a piece so therefore it should go fetch the instance of
             the peices that are still alive and of the same color as the player.
            */
            switch (choice) {
            case 1: piecesList = b.getPieceOnBoard(new Pawn(choice, choice, this.color)); break;
            case 2: piecesList = b.getPieceOnBoard(new Knight(choice, choice, this.color)); break;
            case 3: piecesList = b.getPieceOnBoard(new Bishop(choice, choice, this.color)); break;
            case 4: piecesList = b.getPieceOnBoard(new Rook(choice, choice, this.color)); break;
            case 5: piecesList = b.getPieceOnBoard(new Queen(choice, choice, this.color)); break;
            case 6: piecesList = b.getPieceOnBoard(new King(choice, choice, this.color)); break;
            default: throw new Exception();
        } 
        boolean running = false;
        while(!running){ 
        try{
        System.out.println("Now pick which version of that piece (Starting at 0)"); 
        for (Spot p: piecesList) {
            System.out.println("Postion = "+p.getX()+","+ p.getY());    
        }
        running = true;
    }catch(Exception e){
        System.out.println("Cant pick that peice");
    }
    }
    return piecesList.get(in.nextInt());       
}



    
    //Requires: Board to be instaiateed
    //Modiifies: Board
    //Effects: This is where the player moves the peice to where they want on the board. Acceptes user input within the method.  
    public void gameMove(Board b) throws Exception{
        Spot oldSpot = pieceToMove(b);
        Piece piece = pieceToMove(b).getPiece(); // take the spot(piece) that the user picked above and store it 
        System.out.println("Enter your move(number(enter)number(enter))");
        int x = in.nextInt(); // the move they want to make
        int y = in.nextInt(); // the move they want to make 
        
        System.out.println("Was at "+ oldSpot.getX()+","+oldSpot.getY());
        b.getBoard()[x][y].setP(piece); // this moves the peice
        System.out.println("Now at "+x+","+y);
    }


    

    

}


    

