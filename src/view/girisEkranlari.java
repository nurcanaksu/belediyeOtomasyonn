/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author nurcan
 */
public class girisEkranlari extends javax.swing.JFrame {

    /**
     * Creates new form girisEkranlari
     */
    public girisEkranlari() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kullanicibtn = new javax.swing.JButton();
        personelbtn = new javax.swing.JButton();
        baskanbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kullanicibtn.setText("Kullanıcı Giriş");
        kullanicibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullanicibtnActionPerformed(evt);
            }
        });

        personelbtn.setText("Personel Giriş");
        personelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personelbtnActionPerformed(evt);
            }
        });

        baskanbtn.setText("Başkan Giriş");
        baskanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baskanbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(personelbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(kullanicibtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baskanbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(kullanicibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(personelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(baskanbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kullanicibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullanicibtnActionPerformed
      kullaniciGiris kullanici = new kullaniciGiris();
      kullanici.setVisible(true);
    }//GEN-LAST:event_kullanicibtnActionPerformed

    private void personelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personelbtnActionPerformed
       personelGiris personel = new personelGiris();
       personel.setVisible(true);
    }//GEN-LAST:event_personelbtnActionPerformed

    private void baskanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baskanbtnActionPerformed
        baskanGiris baskan = new baskanGiris();
       baskan.setVisible(true);
    }//GEN-LAST:event_baskanbtnActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baskanbtn;
    private javax.swing.JButton kullanicibtn;
    private javax.swing.JButton personelbtn;
    // End of variables declaration//GEN-END:variables
}
