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
public class Proizvod {
    int id;
    String ime;
    int idkat;
    int kolicina;
    double cijena;
    String proizvodac;
    String model;
    String cijenaispis;

    public Proizvod(int id, String ime, int idkat, int kolicina, double cijena, String proizvodac, String model, String cijenaispis) {
        this.id = id;
        this.ime = ime;
        this.idkat = idkat;
        this.kolicina = kolicina;
        this.cijena = cijena;
        this.proizvodac = proizvodac;
        this.model = model;
        this.cijenaispis = cijenaispis;
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

    public int getIdkat() {
        return idkat;
    }

    public void setIdkat(int idkat) {
        this.idkat = idkat;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getProizvodac() {
        return proizvodac;
    }

    public void setProizvodac(String proizvodac) {
        this.proizvodac = proizvodac;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCijenaispis() {
        return cijenaispis;
    }

    public void setCijenaispis(String cijenaispis) {
        this.cijenaispis = cijenaispis;
    }
    
    
    
}