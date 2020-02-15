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
public class StavkaKosarice {
    int pid;
    int kol;

    public StavkaKosarice(int pid, int kol) {
        this.pid = pid;
        this.kol = kol;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }
    
    
}
