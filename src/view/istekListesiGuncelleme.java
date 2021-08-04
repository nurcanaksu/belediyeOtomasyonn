
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import model.DBConnection;

public class istekListesiGuncelleme extends javax.swing.JFrame {

    public istekListesiGuncelleme() {
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
    JTextField text;
    JButton buton;

    String[] positions = {"İşleme Alındı", "Yapım Aşamasında", "Tamamlandı"};
    JComboBox combo = new JComboBox<String>(positions);

    JTable table;

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
        int[] istektiplerii = new int[istektipilistesatirsayisii];
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
        int[] birimler = new int[birimlistesatirsayisii];
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
        int[] mahalleler = new int[mahallelistesatirsayisii];
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

        int say7 = 0;
        for (int k = 0; k < toplammsayac; k++) {
            {
                if (listele[say7][6].equals("Tamamlandı")) {
                    listele[say7][8] = String.valueOf(toplammaliyetler[k]);

                } else {
                    listele[say7][8] = "Tamamlanmadı";
                }

                say7++;
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

        TableModel tablemodel = new DefaultTableModel(listele, ilkdizi) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column != 6) {
                    return false;
                } else {
                    return true;
                }
            }
        };

        table = new JTable(tablemodel);
        TableColumn col = table.getColumnModel().getColumn(6);
        col.setCellEditor(new DefaultCellEditor(combo));
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
        etiket = new JLabel("Değişiklikleri kaydetmek için Güncelle butonuna basınız..");
        etiket.setBounds(80, 15, 600, 40);
        con.add(etiket);

        //x eksenine uzaklık,y ye uzaklık,yatay uzunluğu, dikey uzunluğu
        table.setBounds(15, 100, 700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 100, 1200, 600);
        con.add(sp);
        this.pack();
        setContentPane(con);
        this.setSize(1500, 1000);

        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guncelle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        guncelle.setText("GÜNCELLE");
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed
        int secilensatir = table.getSelectedRow(); //0 dan başlyor satır ve sütunlar.

        String veri = (String) table.getValueAt(secilensatir, 0);

        try {
            Statement st = this.db.connect().createStatement();
            st.executeUpdate("update istek_listesii set asama_id='" + (combo.getSelectedIndex() + 1) + "'where id=" + veri);

        } catch (SQLException ex) {
            ex.getMessage();
        }


    }//GEN-LAST:event_guncelleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guncelle;
    // End of variables declaration//GEN-END:variables

}
