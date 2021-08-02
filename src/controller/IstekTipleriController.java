/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.IstekTipleri;
import java.util.List;
import model.IstekTipleriModel;

/**
 *
 * @author nurcan
 */
public class IstekTipleriController {

    private IstekTipleriModel model;

    public IstekTipleriModel getModel() {
        if (this.model == null) {
            this.model = new IstekTipleriModel();
        }
        return model;
    }

    public void setModel(IstekTipleriModel model) {
        this.model = model;
    }

    public void create(String istek_tipi)
    {
        IstekTipleri istekTipleri = new IstekTipleri(istek_tipi);
        this.getModel().insert(istekTipleri);
    }
    
    public List<IstekTipleri> getList()
    {
       return this.model.getList();
    }
}
