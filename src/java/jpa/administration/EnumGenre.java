/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.administration;

/**
 *
 * @author AHISSOU Florent
 */
public enum EnumGenre {
    M("Masculin"),
    F("Féminin");
   
    private final String label;

    private EnumGenre(String label) {
        this.label = label;
    }

    public static EnumGenre getM() {
        return M;
    }

    public static EnumGenre getF() {
        return F;
    }

    public String getLabel() {
        return label;
    }

    
    
}
