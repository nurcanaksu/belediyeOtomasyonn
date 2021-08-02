/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

public class Asama {

    private int asama_id;
    private String asama_adi;

    public Asama(int asama_id, String asama_adi) {
        this.asama_id = asama_id;
        this.asama_adi = asama_adi;
    }

    public Asama(String asama_adi) {
        this.asama_adi = asama_adi;
    }

    public int getAsama_id() {
        return asama_id;
    }

    public void setAsama_id(int asama_id) {
        this.asama_id = asama_id;
    }

    public String getAsama_adi() {
        return asama_adi;
    }

    public void setAsama_adi(String asama_adi) {
        this.asama_adi = asama_adi;
    }

    @Override
    public String toString() {
        return "Asama{" + "asama_adi=" + asama_adi + '}';
    }

}
