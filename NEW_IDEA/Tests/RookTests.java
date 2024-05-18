package NEW_IDEA.Tests;

import org.junit.jupiter.api.BeforeAll;

import NEW_IDEA.Main.Model.Pieces.Piece;
import NEW_IDEA.Main.Model.Pieces.Rook;

public class RookTests {

    @BeforeAll
    public void setUp(){
        Piece p1 = new Rook(true);
    }

}
