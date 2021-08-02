/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Birimler;
import java.util.List;
import model.BirimlerModel;

/**
 *
 * @author nurcan
 */
public class BirimlerController {
    private BirimlerModel model;

    public BirimlerModel getModel() {
       if (this.model == null) {
            this.model = new BirimlerModel();
        }
        return model;
    }

    public void setModel(BirimlerModel model) {
        this.model = model;
    }
    
    public void create(String istek_adi) {
        Birimler istekListesi = new Birimler(istek_adi);
        this.getModel().insert(istekListesi);
    }
    
    public List<Birimler> getList()
    {
        return this.model.getList();
    }
}
