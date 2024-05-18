package NEW_IDEA.Main.Model;


import java.util.*;

import NEW_IDEA.Main.Model.Pieces.*;
/*
 *  This class is a board. It is a object that is a 8x8 grid of spots and is intizlized in a way that a chess game starts (has peices on firt two rows and last two rows in a specific order). 
 * 
 */
public class Board {
    // Atrributes 
    public final Spot[][] board = new Spot[8][8];

    //Consturctors
    public Board(){
        setBoard();
    }
    
    //Getters+Setters
        public Spot[][] getBoard(){
            return this.board;
        }

        public void setBoard(){
		// initialize white pieces 
		getBoard()[0][0] = new Spot(1, 1, new Rook(true)); 
		getBoard()[0][1] = new Spot(2, 1, new Knight(true)); 
		getBoard()[0][2] = new Spot(3, 1, new Bishop(true)); 
		getBoard()[0][3] = new Spot(4, 1, new Queen(true));
		getBoard()[0][4] = new Spot(5, 1, new King(true));
		getBoard()[0][5] = new Spot(6, 1, new Bishop(true));
		getBoard()[0][6] = new Spot(7, 1, new Knight(true));
		getBoard()[0][7] = new Spot(8, 1, new Rook(true));	

		getBoard()[1][0] = new Spot(1, 2, new Pawn(true)); 
		getBoard()[1][1] = new Spot(2, 2, new Pawn(true)); 
		getBoard()[1][2] = new Spot(3, 2, new Pawn(true));
		getBoard()[1][3] = new Spot(4, 2, new Pawn(true));
		getBoard()[1][4] = new Spot(5, 2, new Pawn(true));
		getBoard()[1][5] = new Spot(6, 2, new Pawn(true));
		getBoard()[1][6] = new Spot(7, 2, new Pawn(true));
		getBoard()[1][7] = new Spot(8, 2, new Pawn(true));

		// initialize black pieces 
		getBoard()[7][0] = new Spot(1, 8, new Rook(false)); 
		getBoard()[7][1] = new Spot(2, 8, new Knight(false)); 
		getBoard()[7][2] = new Spot(3, 8, new Bishop(false)); 
		getBoard()[7][3] = new Spot(4, 8, new Queen(false));
		getBoard()[7][4] = new Spot(5, 8, new King(false));
		getBoard()[7][5] = new Spot(6, 8, new Bishop(false));
		getBoard()[7][6] = new Spot(7, 8, new Knight(false));
		getBoard()[7][7] = new Spot(8, 8, new Rook(false));	


		getBoard()[6][0] = new Spot(1, 7, new Pawn(false)); 
		getBoard()[6][1] = new Spot(2, 7, new Pawn(false)); 
		getBoard()[6][2] = new Spot(3, 7, new Pawn(false));
		getBoard()[6][3] = new Spot(4, 7, new Pawn(false));
		getBoard()[6][4] = new Spot(5, 7, new Pawn(false));
		getBoard()[6][5] = new Spot(6, 7, new Pawn(false));
		getBoard()[6][6] = new Spot(7, 7, new Pawn(false));
		getBoard()[6][7] = new Spot(8, 7, new Pawn(false));
		// initialize remaining boxes without any piece 
		for (int i = 2; i < 6; i++) { 
			for (int j = 0; j < 8; j++) { 
				getBoard()[i][j] = new Spot(i, j, null); 
			}                                                                    
		}
	}

    
	//Requires: piece is not null 
    //Modiifies: this
    //Effects: Returns a arrayList of the pieces that are on the board of the passed type list should not greater then size 2 
	public List<Spot> getPieceOnBoard(Piece piece){
		List<Spot> list = new ArrayList<>(); // list to store the pieces and cords of the peices
		// for each spot in the board spot array check if spots.getPiece.getClass? == piece
		for (int i = 0; i<board.length;i++) {
			for (int j = 0; j < board[0].length; j++) {
				// if both of the pieces class is the same (eg. both rooks ) and if both peices color are the same (both white)
				// then add them to the list 
				if(board[i][j].getPiece()==null){
					continue;
				}
				if(board[i][j].getPiece().getClass()==piece.getClass() & board[i][j].getPiece().getColor()==piece.getColor()){
					list.add(board[i][j]);
				}
			}
			
		}
		return list;
	}

    //Methods 

	
    //Requires: piece is not null 
    //Modiifies: this
    //Effects: Moves the peice on the board to a new spot on the board user tells them too.
	public void updateBoard(Piece p){
		int x = p.getXcord();
		int y = p.getYcord();
		getBoard()[x][y] = new Spot(x, y, p); //change the old spot to this new spot
		

	}





}
