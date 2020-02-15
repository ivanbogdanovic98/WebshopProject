package modeli;

public class Prijavljen {
    int id;
    String ime;
    int uloga;

    public Prijavljen(int id, String ime, int uloga) {
        this.id = id;
        this.ime = ime;
        this.uloga = uloga;
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

    public int getUloga() {
        return uloga;
    }

    public void setUloga(int uloga) {
        this.uloga = uloga;
    }
    
}
