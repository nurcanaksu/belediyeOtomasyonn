/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.DBConnection;

/**
 *
 * @author nurcan
 */
public class istekFormu extends javax.swing.JFrame {

    DateFormat sdf = new SimpleDateFormat("dd/MM/YYYY ");
    Date tarih = new Date();

    public istekFormu() {
        initComponents();
        MahalleListele();
        IstekListesi();
        IstekTipleri();
        Asamalar();
    }

    public istekFormu(String gonderilen) {
        initComponents();
        kullanicilabel.setText(gonderilen);
        tarihlbl.setText(sdf.format(tarih));
    }

    private DBConnection db;

    public DBConnection getDb() {

        if (db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public void setDb(DBConnection connection) {
        this.db = connection;
    }

    public void MahalleListele() {
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select mahalle_adi from mahalleler order by mahalle_adi ASC");
            while (rs.next()) {
                String name = rs.getString("mahalle_adi");
                mahalle.addItem(" ");
                mahalle.addItem(name);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void IstekListesi() {
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select birim_adi from birimler order by birim_adi ASC");
            while (rs.next()) {
                String istekadi = rs.getString("birim_adi");
                istekbirimi.addItem(" ");
                istekbirimi.addItem(istekadi);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void IstekTipleri() {
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select istek_tipi from istek_tipleri order by istek_tipi ASC");
            while (rs.next()) {
                String istektipii = rs.getString("istek_tipi");
                istektipi.addItem(" ");
                istektipi.addItem(istektipii);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void Asamalar() {
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select asama_adi from yapimasamalari order by asama_adi ASC");
            while (rs.next()) {
                String asamaa = rs.getString("asama_adi");
                asama.addItem(" ");
                asama.addItem(asamaa);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void secilenKullanici() {
        //en son gelen veriyi ekrana yansıt.
        String ad;
        String soyad;
        String tc;
        String tel;
        String unvani;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select ad,soyad,tc,tel,unvan from secilenkullanici");
            while (rs.next()) {
                ad = rs.getString("ad");
                soyad = rs.getString("soyad");
                tc = rs.getString("tc");
                tel = rs.getString("tel");
                unvani = rs.getString("unvan");

                adi.setText(ad);
                soyadi.setText(soyad);
                tcno.setText(tc);
                telno.setText(tel);
                unvan.setText(unvani);

            }
        } catch (Exception e) {
            e.getMessage();

        }

        tarihlbl.setText(sdf.format(tarih));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        popupMenu3 = new java.awt.PopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        istektipi = new javax.swing.JComboBox();
        istekbirimi = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        aciklama = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        tarihlbl = new javax.swing.JLabel();
        adi = new javax.swing.JTextField();
        soyadi = new javax.swing.JTextField();
        tcno = new javax.swing.JTextField();
        sicilkaydibtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        mahalle = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        istekgonderbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        asama = new javax.swing.JComboBox();
        kullanici = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        unvan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        telno = new javax.swing.JTextField();
        kullanicilabel = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        popupMenu3.setLabel("popupMenu3");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Adınız:");

        jLabel2.setText("Soy-Adınız:");

        jLabel3.setText("T.C.:");

        jLabel4.setText("İstek Tipi:");

        jLabel5.setText("İstek Birimi:");

        aciklama.setColumns(20);
        aciklama.setRows(5);
        jScrollPane2.setViewportView(aciklama);

        jLabel7.setText("TARİH:");

        adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adiActionPerformed(evt);
            }
        });

        sicilkaydibtn.setText("Sicil Kaydı");
        sicilkaydibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sicilkaydibtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Mahalle:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("İSTEK OLUŞTURMA FORMU");

        jLabel10.setText("Açıklama:");

        istekgonderbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        istekgonderbtn.setText("Gönder");
        istekgonderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                istekgonderbtnActionPerformed(evt);
            }
        });

        jLabel6.setText("İşlem Aşaması:");

        kullanici.setText("KULLANICI ADI");
        kullanici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kullaniciActionPerformed(evt);
            }
        });

        jLabel11.setText("Unvan:");

        jLabel12.setText("Telefon No:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(soyadi, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unvan, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sicilkaydibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adi, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(tcno, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tarihlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(telno, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mahalle, javax.swing.GroupLayout.Alignment.LEADING, 0, 241, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(asama, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(istektipi, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(istekbirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(istekgonderbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(kullanici, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kullanicilabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kullanicilabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kullanici, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tarihlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sicilkaydibtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soyadi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unvan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telno, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(istektipi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mahalle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(istekbirimi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(asama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(48, 48, 48)
                .addComponent(istekgonderbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adiActionPerformed

    }//GEN-LAST:event_adiActionPerformed

    private void sicilkaydibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sicilkaydibtnActionPerformed
        sicil_kaydi s = new sicil_kaydi();
        s.setVisible(true);

    }//GEN-LAST:event_sicilkaydibtnActionPerformed

    private void istekgonderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_istekgonderbtnActionPerformed

        int istektipisayac = 0;
        int istektipiid;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_tipleri"); //id yi de iste onu yazdır

            while (rs.next()) {
                String istektipii = rs.getString("istek_tipi");
                istektipiid = rs.getInt("istek_tipi_id");
                if (istektipi.getSelectedItem().toString().equals(istektipii)) {
                    istektipisayac = istektipiid;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int istekbirimisayac = 0;
        int istekbirimiid;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select* from birimler");
            while (rs.next()) {
                String istekadi = rs.getString("birim_adi");
                istekbirimiid = rs.getInt("birim_id");
                if (istekbirimi.getSelectedItem().toString().equals(istekadi)) {
                    istekbirimisayac = istekbirimiid;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int mahallesayac = 0;
        int mahalleid;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from mahalleler ");
            while (rs.next()) {
                String mahalleadi = rs.getString("mahalle_adi");
                mahalleid = rs.getInt("mahalle_id");
                if (mahalle.getSelectedItem().toString().equals(mahalleadi)) {
                    mahallesayac = mahalleid;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int asamasayac = 0;
        int asamaid;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from yapimasamalari ");
            while (rs.next()) {
                String asamaadi = rs.getString("asama_adi");
                asamaid = rs.getInt("asama_id");
                if (asama.getSelectedItem().toString().equals(asamaadi)) {
                    asamasayac = asamaid;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        String tc;
        int kullanicidsi;
        int id = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici_sicil_tablosu");
            while (rs.next()) {
                tc = rs.getString("tc");
                if (tcno.getText().equals(tc)) {
                    kullanicidsi = rs.getInt("kullanici_id");
                    id = kullanicidsi;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }

        /*Sisteme istek giren kişinin id si ni istek listesine ekleyen kod parçası*/
        String ad = null;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from songirislerkullanici");
            while (rst.next()) {
                ad = rst.getString("adi");
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int gonderenid = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from kullanicilar");
            while (rst.next()) {
                if (rst.getString("kullanici_adi").equals(ad)) {
                    gonderenid = rst.getInt("kullanici_id");
                }

            }
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            Statement st = this.getDb().connect().createStatement();
            st.executeUpdate("insert into istek_listesii(kullanici_id,istek_tipi_id,birimi_id,mahalle_id,aciklama,tarih, asama_id,gonderen_kisi_id ) values ('"
                    + id + "','"
                    + istektipisayac + "','"
                    + istekbirimisayac + "','"
                    + mahallesayac + "','"
                    + aciklama.getText() + "','"
                    + tarihlbl.getText() + "','"
                    + asamasayac + "','"
                    + gonderenid
                    + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_istekgonderbtnActionPerformed

    private void kullaniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kullaniciActionPerformed
        
         String ad = null;
         try {
         Statement st = this.getDb().connect().createStatement();
         ResultSet rst = st.executeQuery("select * from songirislerkullanici");
         while (rst.next()) {
         ad=rst.getString("adi");
         }
         } catch (Exception e) {
         e.getMessage();
         }
         kullanici.setText(ad);
         kullanicilabel.setText(ad);
    }//GEN-LAST:event_kullaniciActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea aciklama;
    private javax.swing.JTextField adi;
    private javax.swing.JComboBox asama;
    private javax.swing.JComboBox istekbirimi;
    private javax.swing.JButton istekgonderbtn;
    private javax.swing.JComboBox istektipi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kullanici;
    private javax.swing.JLabel kullanicilabel;
    private javax.swing.JComboBox mahalle;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private java.awt.PopupMenu popupMenu3;
    private javax.swing.JButton sicilkaydibtn;
    private javax.swing.JTextField soyadi;
    private javax.swing.JLabel tarihlbl;
    private javax.swing.JTextField tcno;
    private javax.swing.JTextField telno;
    private javax.swing.JTextField unvan;
    // End of variables declaration//GEN-END:variables

}
