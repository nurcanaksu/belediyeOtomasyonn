/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belediyeyonetimsistemi;

import view.istekListesiGuncelleme;
import view.girisEkranlari;
import view.istekListesi;
/**
 *
 * @author nurcan
 */
public class BelediyeYonetimSistemi {

    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new girisEkranlari().setVisible(true);
            }
        });

        /*java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new NewJFrame().setVisible(true);
         }
         });*/
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new istekListesiGuncelleme().setVisible(true);
            }
        }); */
        
      
    }
}
