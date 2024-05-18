package NEW_IDEA.Main.UI.GUI;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import NEW_IDEA.Main.Model.Player;
import NEW_IDEA.Main.Model.Pieces.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChessGame{
    static ArrayList<Piece> ps; //all peices on the board
    static Piece selectedPiece;
    public static void main(String[] args) throws IOException{

        // set up the pieces 
        Player p1 = new Player("white player", true);
        Player p2 = new Player("bhite player", false);
        ps = new ArrayList<>(); 


        
        // add it to the array 
        for (Piece piece : p1.getPieces()) {
            ps.add(piece);
        }
         for (Piece piece : p2.getPieces()) {
            ps.add(piece);
        }


        // GUI STUFF
        JFrame frame = new JFrame();
        frame.setBounds(10,10,512,512);
        frame.setUndecorated(true);
        Image[] peicesImage = cutImages(new File("chess.png"));

        // no idea that you could do this!
        JPanel pn  = new JPanel(){
       // this paints the frame
       // REQUIRES: nothing
       // EFFECTS: this painnts the board and the peices to there default values 
       // MODIFIES: graphics
       @Override
       public void paint(Graphics g){
            boolean white = true;
            for(int i = 0; i<8;i++){
                for(int j = 0; j<8; j++){
                    if(white){
                        g.setColor(new Color(235,235, 208));
                    } else{
                        g.setColor(new Color(119, 148, 85));
                    }
                    g.fillRect(i*64,j*64,64,64);
                    white=!white;
                }
                white=!white;
            }
            for (Piece p : ps){ // to pick which image in the imagine array
                int ind = 0;
                if(p instanceof King){
                    ind = 0;
                } if(p instanceof Queen){
                    ind = 1;
                } if(p instanceof Bishop){
                    ind = 2;
                } if(p instanceof Knight){
                    ind = 3;
                } if(p instanceof Rook){
                    ind = 4;
                } if(p instanceof Pawn){
                    ind = 5;
                } if(p.getColor()!=true){
                    ind +=6;
                }
                g.drawImage(peicesImage[ind],p.getXcord()*64 ,p.getYcord()*64, this); //drawing the peices
                
            }
        }
     };    

        //Mouse listener
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
         
            }

            //REQUIRES: mouse is on the gui board
            //EFFECTS: this prrints to the console the color of the peice and then it also grabs the x and y of the mouse and calls the getPiece method.   
            //MODIFIES: nothing
            @Override
            public void mousePressed(MouseEvent e) {
               System.out.println(getPiece(e.getX(), e.getY()).getColor()? "white":"black");
               selectedPiece = getPiece(e.getX(), e.getY());
               frame.repaint();
            }

            //REQUIRES: mouse is on the gui board
            //EFFECTS: this now moves that peice in the game and on the board to where you realease the mouse  
            //MODIFIES: peieces x and y game postion 
            @Override
            public void mouseReleased(MouseEvent e) {
                //based on what type of peice it is it can eitehr move there or not
                //cast it as that type if it is a instaneof that !
                if(selectedPiece instanceof Rook){
                    Rook rook = (Rook) selectedPiece;
                    rook.move(e.getX()/64, e.getY()/64); //grabs the mouse cord
                    frame.repaint();
                }else if (selectedPiece instanceof Pawn){
                    Pawn pawn = (Pawn) selectedPiece;
                    pawn.move(e.getX()/64, e.getY()/64); //grabs the mouse cord
                    frame.repaint();
                }else if (selectedPiece instanceof Queen){
                    Queen queen = (Queen) selectedPiece;
                    queen.move(e.getX()/64, e.getY()/64); //grabs the mouse cord
                    frame.repaint();
                }else if (selectedPiece instanceof King){
                    King king = (King) selectedPiece;
                    king.move(e.getX()/64, e.getY()/64); //grabs the mouse cord
                    frame.repaint();
                }else if (selectedPiece instanceof Knight){
                    Knight knight = (Knight) selectedPiece;
                    knight.move(e.getX()/64, e.getY()/64); //grabs the mouse cord
                    frame.repaint();
                }else if (selectedPiece instanceof Bishop){
                    Bishop bishop = (Bishop) selectedPiece;     
                    bishop.move(e.getX()/64, e.getY()/64); //grabs the mouse cord
                    frame.repaint();               
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
     
            }

            @Override
            public void mouseExited(MouseEvent e) {
              
            }
            
        });

        //Mouse motionnlisten
        frame.addMouseMotionListener(new MouseMotionListener() {
           
           // this is gonna redraw the moving of the peice i think 
            //REQUIRES: mouse is on the gui board
            //EFFECTS: this listens to where the mouse is and updates thte peice on where you move it too
            //MODIFIES: piece's mouse postion 
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedPiece!=null){
                    selectedPiece.xMouse = e.getX()-32; // this repaintst the mvement 
                    selectedPiece.yMouse = e.getY()-32;
                    frame.repaint();
                }
            }
            @Override
            public void mouseMoved(MouseEvent e) {
            
            }
        });

        //MORE GUI STUFF  
        frame.add(pn);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    // This cuts the images of the peices from a photo i have of them 
    //REQUIRES: noting
    //EFFECTS: should cut all the pieces out of the picture with all of them and store them all as there own mini immage in a array.
    //MODIFIES: nothing
    public static Image[] cutImages(File f) throws IOException{
        Image[] imgs = new Image[12];
        BufferedImage all = ImageIO.read(f);
        int index = 0;
        for (int i = 0; i < 400; i+=200) {
            for (int j = 0; j < 1200; j+=200) {
                imgs[index] = all.getSubimage(j, i, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                index++;
            }
        }
        return imgs;
    }

    //REQUIRES: ypu click on the Swing GUI popup board
    //EFFECTS: returns the peice that is clicked on 
    //MODIFIES: nothing
    public static Piece getPiece(int x, int y){
        int xp = x/64;
        int yp = y/64;

        for (Piece p : ps) {
            if(p.getXcord()==xp&&p.getYcord()==yp){
                return p;
            }
        }
        return null;
    }

 }
