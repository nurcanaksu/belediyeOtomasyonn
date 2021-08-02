/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.SicilKaydi;
import java.util.List;
import model.SicilKaydiModel;

/**
 *
 * @author nurcan
 */
public class SicilKaydiController {
    private SicilKaydiModel model;

    public SicilKaydiModel getModel() {
         if (this.model == null) {
            this.model = new SicilKaydiModel();
        }
        return model;
    }

    public void setModel(SicilKaydiModel model) {
        this.model = model;
    }

   public void create( String ad, String soyad,String tc)
    {
        SicilKaydi sicilKaydi = new SicilKaydi(ad,soyad,tc);
        this.getModel().insert(sicilKaydi);
    }
    
    public List<SicilKaydi> getList()
    {
       return this.model.getList();
    }
    
    
}
