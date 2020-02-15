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
public class SKZaIspis {
    int id;
    String ime;
    int kolicina;
    String cijena;
    int ukosarici;

    public SKZaIspis(int id, String ime, int kolicina, String cijena, int ukosarici) {
        this.id = id;
        this.ime = ime;
        this.kolicina = kolicina;
        this.cijena = cijena;
        this.ukosarici = ukosarici;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    public int getUkosarici() {
        return ukosarici;
    }

    public void setUkosarici(int ukosarici) {
        this.ukosarici = ukosarici;
    }
    
}
