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
public class Povijest {
    int idpro;
    String imepro;
    int kol;
    String cijena;
    String datum;
    String nacin;

    public Povijest(int idpro, String imepro, int kol, String cijena, String datum, String nacin) {
        this.idpro = idpro;
        this.imepro = imepro;
        this.kol = kol;
        this.cijena = cijena;
        this.datum = datum;
        this.nacin = nacin;
    }

    public String getNacin() {
        return nacin;
    }

    public void setNacin(String nacin) {
        this.nacin = nacin;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getImepro() {
        return imepro;
    }

    public void setImepro(String imepro) {
        this.imepro = imepro;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
    
}
