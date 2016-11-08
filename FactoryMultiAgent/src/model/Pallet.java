/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dougl
 */
public class Pallet {

    //Lista de peças utilizadas
    private List<Piece> lstPieces = new ArrayList<>();

    //Máximo de caixas por pallet
    private int maxBox = 0;

    public List<Piece> getLstPieces() {
        return lstPieces;
    }

    public void setLstPieces(List<Piece> lstPieces) {
        this.lstPieces = lstPieces;
    }

    public int getMaxBox() {
        return maxBox;
    }

    public void setMaxBox(int maxBox) {
        this.maxBox = maxBox;
    }

    /**
     *
     * @param pMax - Capacidade máximo do pallet
     * @param pSize - Define o tamanho das peças do pallet
     */
    public Pallet(int pMax, Size pSize) {
        this.maxBox = pMax;
        AddListPieces(Size.large);
    }

    private void AddListPieces(Size pSize) {
        for (int i = 0; i < getMaxBox(); i++) {
            lstPieces.add(new Piece(pSize));
        }
    }
}
