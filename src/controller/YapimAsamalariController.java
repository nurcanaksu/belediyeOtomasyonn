/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Asama;
import java.util.List;
import model.AsamaModel;

/**
 *
 * @author nurcan
 */
public class YapimAsamalariController {
    private AsamaModel model;

    public AsamaModel getModel() {
        if (this.model == null) {
            this.model = new AsamaModel();
        }
        return model;
    }

    public void setModel(AsamaModel model) {
        this.model = model;
    }
    
    
     public void create( String asama_adi)
    {
        Asama asamalar = new Asama(asama_adi);
        this.getModel().insert(asamalar);
    }
    
    public List<Asama> getList()
    {
       return this.model.getList();
    }
    
}
