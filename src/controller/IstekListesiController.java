/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.IstekListesi;
import java.util.Date;
import java.util.List;
import model.IstekListesiModel;

/**
 *
 * @author nurcan
 */
public class IstekListesiController {

    private IstekListesiModel model;

    public IstekListesiModel getModel() {
        if (this.model == null) {
            this.model = new IstekListesiModel();
        }
        return model;
    }

    public void setModel(IstekListesiModel model) {
        this.model = model;
    }

    public void create(String istek_tipi_id, String birimi_id, String mahalle_id, String aciklama, Date date, String asama_id) {
        IstekListesi isteklistesi = new IstekListesi(istek_tipi_id, birimi_id, mahalle_id, aciklama, date, asama_id);
        this.getModel().insert(isteklistesi);
    }

    public List<IstekListesi> getList() {
        return this.model.getList();
    }
}
