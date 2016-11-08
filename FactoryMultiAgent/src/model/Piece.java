
package model;

/**
 *
 * @author dougl
 */
public class Piece {
    
    //Tamanho da peça
    private Size oSize;

    Piece(Size pSize) {
        this.oSize = pSize;
    }

    public Size getoSize() {
        return oSize;
    }

    public void setoSize(Size oSize) {
        this.oSize = oSize;
    }
}
