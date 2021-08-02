/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Mahalle;
import java.util.List;
import model.MahalleModel;

/**
 *
 * @author nurcan
 */
public class MahalleController {
    
    private MahalleModel model;
    
     public MahalleModel getMahallemodel() {
        if (this.model == null) {
            this.model = new MahalleModel();
        }
        return model;
    }

    public void setMahallemodel(MahalleModel mahallemodel) {
        this.model = mahallemodel;
    }

    public void create(String mahalle_adi) {
        Mahalle mahalle = new Mahalle(mahalle_adi);
        this.getMahallemodel().insert(mahalle);
    }

    public List<Mahalle> getList() {
        return this.model.getList();
    }
}
