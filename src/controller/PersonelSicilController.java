/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.PersonelSicilKaydi;
import java.util.List;
import model.PersonelSicilModel;

/**
 *
 * @author nurcan
 */
public class PersonelSicilController {

    private PersonelSicilModel model;

    public PersonelSicilModel getModel() {
        if (this.model == null) {
            this.model = new PersonelSicilModel();
        }
        return model;
    }

    public void setModel(PersonelSicilModel model) {
        this.model = model;
    }

    public void create(Integer id, String ad, String soyad, String tc, String unvan, String adres) {
        PersonelSicilKaydi personel = new PersonelSicilKaydi(id, ad, soyad, tc, unvan, adres);
        this.getModel().insert(personel);
    }

    public List<PersonelSicilKaydi> getList() {
        return this.model.getList();
    }

}
