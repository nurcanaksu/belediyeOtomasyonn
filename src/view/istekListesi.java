/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.DBConnection;

public class istekListesi extends javax.swing.JFrame {

    public istekListesi() {
        initComponents();
        istekListesiGuncelleme();
    }

    int secilensatir;
    int satir;
    int asamakolonu;
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

    JLabel etiket;
    JLabel label;
    JLabel label2;
    JTextField text;
    JButton buton;

    String[] positions = {"İşleme Alındı", "Yapım Aşamasında", "Tamamlandı"};
    JComboBox combo = new JComboBox<String>(positions);

    JTable table;

    TableModel tablemodel;
    public void istekListesiGuncelleme() {
        int isteklistesi = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_listesii");
            while (rs.next()) {
                isteklistesi++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        /*İSTEK TİPLERİ */
        int[] isteklistedeistekid = new int[isteklistesi];
        int isteklistesatirsayisi = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_listesii ");
            while (rs.next()) {
                isteklistedeistekid[isteklistesatirsayisi] = Integer.valueOf(rs.getString("istek_tipi_id"));
                isteklistesatirsayisi++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        String[][] listele = new String[isteklistesatirsayisi][9];

        /*Sirayla*/
        int sirasayac = 0;
        int[] siralar = new int[isteklistesi];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from istek_listesii ");
            while (rst.next()) {
                siralar[sirasayac] = rst.getInt("id");
                sirasayac++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int saysiralar = 0;
        for (int k = 0; k < sirasayac; k++) {
            {
                listele[saysiralar][0] = String.valueOf(siralar[k]);
                saysiralar++;
            }
        }

        /*İSTEK TİPLERİ */
        int[] istektipilisteistekid = new int[isteklistesi];
        int istektipilistesatirsayisi = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_listesii");
            while (rs.next()) {
                istektipilisteistekid[istektipilistesatirsayisi] = Integer.valueOf(rs.getString("birimi_id"));
                istektipilistesatirsayisi++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int istektipilistesatirsayisii = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_tipleri");
            while (rs.next()) {
                istektipilistesatirsayisii++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int sayacistektipi = 0;
        int[] istektiplerii = new int[istektipilistesatirsayisii]; //birimler istek listesi kadar değil mal
        String[] istektipiadlari = new String[istektipilistesatirsayisii];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from istek_tipleri");
            while (rst.next()) {
                istektiplerii[sayacistektipi] = rst.getInt("istek_tipi_id");
                istektipiadlari[sayacistektipi] = rst.getString("istek_tipi");
                sayacistektipi++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int sayistektipi = 0;
        for (int k = 0; k < istektipilistesatirsayisi; k++) {
            for (int m = 0; m < sayacistektipi; m++) {
                if (istektipilisteistekid[k] == istektiplerii[m]) {
                    listele[sayistektipi][1] = istektipiadlari[m];
                    sayistektipi++;
                }
            }
        }

        /*İSTEK BİRİMİ KOLONU*/
        int[] birimlistebirimid = new int[isteklistesi];
        int birimlistesatirsayisi = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_listesii");
            while (rs.next()) {
                birimlistebirimid[birimlistesatirsayisi] = Integer.valueOf(rs.getString("birimi_id"));
                birimlistesatirsayisi++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int birimlistesatirsayisii = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from birimler");
            while (rs.next()) {
                birimlistesatirsayisii++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int sayac2 = 0;
        int[] birimler = new int[birimlistesatirsayisii]; //birimler istek listesi kadar değil mal
        String[] birimadlari = new String[birimlistesatirsayisii];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from birimler");
            while (rst.next()) {
                birimler[sayac2] = rst.getInt("birim_id");
                birimadlari[sayac2] = rst.getString("birim_adi");
                sayac2++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int say1 = 0;
        for (int k = 0; k < birimlistesatirsayisi; k++) {
            for (int m = 0; m < sayac2; m++) {
                if (birimlistebirimid[k] == birimler[m]) {
                    listele[say1][2] = birimadlari[m];
                    say1++;
                }
            }
        }

        /*MAHALLEEEEE*/
        int[] mahallelistemahalleid = new int[isteklistesi];
        int mahallelistesatirsayisi = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_listesii");
            while (rs.next()) {
                mahallelistemahalleid[mahallelistesatirsayisi] = Integer.valueOf(rs.getString("mahalle_id"));
                mahallelistesatirsayisi++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int mahallelistesatirsayisii = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from mahalleler");
            while (rs.next()) {
                mahallelistesatirsayisii++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int mah = 0;
        int[] mahalleler = new int[mahallelistesatirsayisii]; //birimler istek listesi kadar değil mal
        String[] mahalleadlari = new String[mahallelistesatirsayisii];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from mahalleler");
            while (rst.next()) {
                mahalleler[mah] = rst.getInt("mahalle_id");
                mahalleadlari[mah] = rst.getString("mahalle_adi");
                mah++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int mah1 = 0;
        for (int k = 0; k < mahallelistesatirsayisi; k++) {
            for (int m = 0; m < mah; m++) {
                if (mahallelistemahalleid[k] == mahalleler[m]) {
                    listele[mah1][3] = mahalleadlari[m];
                    mah1++;
                }
            }
        }
        //değişkenleri character varying yapılcak


        /*AÇIKLAMALAR*/
        int aciklamasayac = 0;
        String[] aciklamalar = new String[isteklistesi];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from istek_listesii");
            while (rst.next()) {
                aciklamalar[aciklamasayac] = rst.getString("aciklama");
                aciklamasayac++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int say3 = 0;
        for (int k = 0; k < mahallelistesatirsayisi; k++) {
            {
                listele[say3][4] = aciklamalar[k];
                say3++;
            }
        }

        /*TARİH KOLONU*/
        int tarihsayac = 0;
        Date[] tarihler = new Date[isteklistesi];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from istek_listesii ");
            while (rst.next()) {
                tarihler[tarihsayac] = rst.getDate("tarih");
                tarihsayac++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int say4 = 0;
        for (int k = 0; k < tarihsayac; k++) {
            {
                listele[say4][5] = String.valueOf(tarihler[k]);
                say4++;
            }
        }


        /*AŞAMA LİSTELE*/
        int[] asamalisteasamaid = new int[isteklistesi];
        int asamalistesatirsayisi = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from istek_listesii");
            while (rs.next()) {
                asamalisteasamaid[asamalistesatirsayisi] = Integer.valueOf(rs.getString("asama_id"));
                asamalistesatirsayisi++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int asamalistesatirsayisii = 0;
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rs = st.executeQuery("select * from yapimasamalari");
            while (rs.next()) {
                asamalistesatirsayisii++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int sayacasama = 0;
        int[] asamalar = new int[asamalistesatirsayisii];
        String[] asamaadlari = new String[asamalistesatirsayisii];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from yapimasamalari");
            while (rst.next()) {
                asamalar[sayacasama] = rst.getInt("asama_id");
                asamaadlari[sayacasama] = rst.getString("asama_adi");
                sayacasama++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int sayasama = 0;
        for (int k = 0; k < asamalistesatirsayisi; k++) {
            for (int m = 0; m < sayacasama; m++) {
                if (asamalisteasamaid[k] == asamalar[m]) {
                    listele[sayasama][6] = asamaadlari[m];
                    sayasama++;
                }
            }
        }

        /*Yaklaşık Maliyeti Kolonu*/
        int yaklasikmsayac = 0;
        int[] yaklasikmaliyetler = new int[isteklistesi];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from istek_listesii");
            while (rst.next()) {
                yaklasikmaliyetler[yaklasikmsayac] = rst.getInt("yaklasik_maliyet");
                yaklasikmsayac++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int say6 = 0;
        for (int k = 0; k < yaklasikmsayac; k++) {
            {
                listele[say6][7] = String.valueOf(yaklasikmaliyetler[k]);
                say6++;
            }
        }

        /*Toplam Maliyeti Kolonu*/
        int toplammsayac = 0;
        int[] toplammaliyetler = new int[isteklistesi];
        try {
            Statement st = this.getDb().connect().createStatement();
            ResultSet rst = st.executeQuery("select * from istek_listesii");
            while (rst.next()) {
                toplammaliyetler[toplammsayac] = rst.getInt("toplam_maliyet");
                toplammsayac++;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        int toplammaliyet=0;
        int say7 = 0;
        for (int k = 0; k < toplammsayac; k++) {
            {
                listele[say7][8] = String.valueOf(toplammaliyetler[k]);
                say7++;
                toplammaliyet= toplammaliyet+toplammaliyetler[k];
            }
           
        }

        String[] ilkdizi = new String[9];

        ilkdizi[0] = "Sıra";
        ilkdizi[1] = "İstek Tipi";
        ilkdizi[2] = "Birim";
        ilkdizi[3] = "Mahalle";
        ilkdizi[4] = "Açıklama";
        ilkdizi[5] = "Tarih";
        ilkdizi[6] = "Aşama";
        ilkdizi[7] = "Yaklaşık Maliyet";
        ilkdizi[8] = "Toplam Maliyet";

         tablemodel = new DefaultTableModel(listele, ilkdizi) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

            @Override //toplam maliyetin yazdığı tek kolonu yazdır burada..
            public void setValueAt(Object aValue, int row, int column) {
                super.setValueAt(aValue, row, column); //To change body of generated methods, choose Tools | Templates.
            }

        };

        table = new JTable(tablemodel);
        /*TableColumn col = table.getColumnModel().getColumn(6);
         col.setCellEditor(new DefaultCellEditor(combo));*/
        table.setModel(tablemodel);

        /*TABLE CSS*/
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        table.getTableHeader().setOpaque(true);
        table.getTableHeader().setBackground(new Color(32, 136, 203));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setRowHeight(30);
        table.setGridColor(Color.BLUE);
        table.setBackground(Color.WHITE);

        Container con = getContentPane();
        con.setLayout(null);
        etiket = new JLabel("-İSTEK LİSTESİ-");
        etiket.setBounds(450, 15, 600, 40);
        etiket.setFont(new Font("Segoe UI", Font.BOLD, 45));
        con.add(etiket);

        
        
        label= new JLabel("Toplam:");
        label.setBounds(1030,490,600,40);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        con.add(label);
        
        label2= new JLabel();
        String sum= String.valueOf(toplammaliyet);
        label2.setText(sum);
        label2.setBounds(1100,490,800,40);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        con.add(label2);
        
        
        
        
        
        
        //y eksenine uzaklık,x ye uzaklık,yatay uzunluğu, dikey uzunluğu
        table.setBounds(15, 100, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 100, 1200, 400);
        con.add(sp);
        this.pack();
        setContentPane(con);
        this.setSize(1520, 1000);

        
        
        
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSearch3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("İSTEK TİPİ FİLTRELE : ");

        jLabel2.setText("AŞAMA FİLTRELE :");

        txtSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch2KeyReleased(evt);
            }
        });

        jLabel3.setText("BİRİM FİLTRELE:");

        txtSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch2)
                    .addComponent(txtSearch3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 535, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
         String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) tablemodel);
        table.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch2KeyReleased
        String searchKey = txtSearch2.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) tablemodel);
        table.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearch2KeyReleased

    private void txtSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch3KeyReleased
       String searchKey = txtSearch3.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>((DefaultTableModel) tablemodel);
        table.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearch3KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    // End of variables declaration//GEN-END:variables
}
