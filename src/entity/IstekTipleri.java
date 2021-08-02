/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author nurcan
 */
public class IstekTipleri {

    private int id;
    private String istek_tipi;

    public IstekTipleri(int id, String istek_tipi) {
        this.id = id;
        this.istek_tipi = istek_tipi;
    }

    public IstekTipleri(String istek_tipi) {
        this.istek_tipi = istek_tipi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIstek_tipi() {
        return istek_tipi;
    }

    public void setIstek_tipi(String istek_tipi) {
        this.istek_tipi = istek_tipi;
    }

    @Override
    public String toString() {
        return "IstekTipleri{" + "istek_tipi=" + istek_tipi + '}';
    }
}
