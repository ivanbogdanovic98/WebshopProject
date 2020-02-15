/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

/**
 *
 * @author Programer10
 */
public class PovijestAdmin extends Povijest {    
   int idkup;
   String imekup;

    public PovijestAdmin(int idkup, String imekup, int idpro, String imepro, int kol, String cijena, String datum, String nacin) {
        super(idpro, imepro, kol, cijena, datum, nacin);
        this.idkup = idkup;
        this.imekup = imekup;
    }

 
    public int getIdkup() {
        return idkup;
    }

    public void setIdkup(int idkup) {
        this.idkup = idkup;
    }

    public String getImekup() {
        return imekup;
    }

    public void setImekup(String imekup) {
        this.imekup = imekup;
    }
 
   
    
}
