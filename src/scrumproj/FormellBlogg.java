package scrumproj;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import oru.inf.InfException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class FormellBlogg extends Page {

    public FormellBlogg(Application app) {
        super(app);
        initComponents();
    }

    @Override
    public void updateInfo() {

        try {
            ArrayList<String> allaKategorier;
            cboxKategori.removeAllItems();
            String fraga = "SELECT KATEGORINAMN FROM KATEGORIER";

            allaKategorier = app.getDataBaseConnection().fetchColumn(fraga);

            for (String id : allaKategorier) {

                cboxKategori.addItem(id);
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�got �r fel");
            System.err.println(e);
        }

        try {
            ArrayList<HashMap<String, String>> allaRader;

            DefaultTableModel table = new DefaultTableModel(new Object[]{"Anv�ndare", "Inl�gg", "Datum", "Inl�ggId", "Fil", "Kategori"}, 0);

            allaRader = app.getDataBaseConnection().fetchRows("SELECT INLAGG_ID, EPOST, INLAGG, DATUM, PATH, KATEGORI FROM FORMELBLOGG");
            if (allaRader == null) {
                table.addRow(new Object[]{null, null, null, null});
            } else {
                for (HashMap<String, String> rad : allaRader) {
                    String inlagg_id = rad.get("INLAGG_ID");
                    String epost = rad.get("EPOST");
                    String inlagg = rad.get("INLAGG");
                    String datum = rad.get("DATUM");
                    String path = rad.get("PATH");
                    String kat = rad.get("KATEGORI");

                    //S�tter in anvandare + inlagg + datum  i tabellen mha addRow()
                    table.addRow(new Object[]{epost, inlagg, datum, inlagg_id, path, kat});

                }
            }

            //S�ger att tblInlagg ska anv�nda sig av den modellen vi skapade ovan
            tblInlagg.setModel(table);

            //S�tter defaultEditor till Object.class, null f�r att data i tabellen inte ska kunna redigeras, men kunna selekteras.
            tblInlagg.setDefaultEditor(Object.class, null);
            //St�nger av m�jligheten att �ndra kolumnordningen.
            tblInlagg.getTableHeader().setReorderingAllowed(false);

            //S�tter bredden p� kolumnen som inneh�ller ID till 0px.
            //Vi vill inte att ID ska visas i listan men vill eventueltl kunna anv�nda IDt 
            tblInlagg.getColumnModel().getColumn(3).setMinWidth(0);
            tblInlagg.getColumnModel().getColumn(3).setMaxWidth(0);
            tblInlagg.getColumnModel().getColumn(3).setWidth(0);
            tblInlagg.getColumnModel().getColumn(1).setWidth(10);
            // tblInlagg.getColumnModel().getColumn(1).setWidth(3);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�got �r fel");
            System.err.println(e);

        }
        ArrayList<String> allaInlagg;
        cboxInlaggen.removeAllItems();

        try {

            String fraga = "SELECT INLAGG_ID FROM FORMELBLOGG";

            allaInlagg = app.getDataBaseConnection().fetchColumn(fraga); // h�mta alla inl�gg

            //En for loop som l�gger in datan i en combobox f�r vare instans som uppst�r.
            for (String id : allaInlagg) {

                String inlagg = app.getDataBaseConnection().fetchSingle("SELECT INLAGG FROM FORMELBLOGG WHERE INLAGG_ID = '" + id + "'");
                cboxInlaggen.addItem(inlagg);
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception ettUndantag) {
            lblKategorin.setText("Det finns inga inl�gg!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPublicera = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInlagg = new javax.swing.JTable();
        cboxKategori = new javax.swing.JComboBox<>();
        lblKategori = new javax.swing.JLabel();
        btnKommentera = new javax.swing.JButton();
        lblKat = new javax.swing.JLabel();
        cboxInlaggen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblKategorin = new javax.swing.JLabel();
        txtFaltInlagg = new javax.swing.JTextField();
        btnHamntaKommentarer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKommentarer = new javax.swing.JTable();
        txtInlagg = new javax.swing.JTextField();
        btnHamta = new javax.swing.JButton();
        btnBekrafta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLaggTIllKategori = new javax.swing.JButton();
        btnTaBortInlagg = new javax.swing.JButton();
        btnBifoga = new javax.swing.JButton();
        txtFieldPath = new javax.swing.JTextField();

        btnPublicera.setText("Publicera inl�gg");
        btnPublicera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPubliceraActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        jButton3.setText("Profil");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblInlagg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblInlagg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblInlagg.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblInlagg.setCellSelectionEnabled(true);
        tblInlagg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblInlagg.setEditingColumn(0);
        tblInlagg.setEditingRow(0);
        tblInlagg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInlaggMouseClicked(evt);
            }
        });
        tblInlagg.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblInlaggPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblInlagg);

        cboxKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKommentera.setText("Kommentera valt inl�gg");
        btnKommentera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKommenteraActionPerformed(evt);
            }
        });

        lblKat.setText("V�lj kategori:");

        cboxInlaggen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboxInlaggen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxInlaggenActionPerformed(evt);
            }
        });

        jLabel2.setText("V�lj inl�gg:");

        btnHamntaKommentarer.setText("H�mta kommentarer");
        btnHamntaKommentarer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamntaKommentarerActionPerformed(evt);
            }
        });

        tblKommentarer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblKommentarer);

        btnHamta.setText("H�mta inl�gg");
        btnHamta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHamtaActionPerformed(evt);
            }
        });

        btnBekrafta.setText("Spara");
        btnBekrafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBekraftaActionPerformed(evt);
            }
        });

        jLabel1.setText("Redigera inl�gg:");

        btnLaggTIllKategori.setText("L�gg till ny kategori");
        btnLaggTIllKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTIllKategoriActionPerformed(evt);
            }
        });

        btnTaBortInlagg.setText("Ta bort inl�gg");
        btnTaBortInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortInlaggActionPerformed(evt);
            }
        });

        btnBifoga.setText("Bifoga bild");
        btnBifoga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBifogaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnTillbaka))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaBortInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKategorin, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addComponent(txtInlagg, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnHamta)
                                .addComponent(btnBekrafta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLaggTIllKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnBifoga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboxKategori, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE)
                                .addComponent(cboxInlaggen, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFaltInlagg)
                                .addComponent(btnPublicera, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                .addComponent(btnHamntaKommentarer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnKommentera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblKat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)))
                        .addGap(0, 242, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btnTillbaka))
                .addGap(2, 2, 2)
                .addComponent(txtFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxInlaggen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFaltInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnBifoga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPublicera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKommentera)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lblKategori))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHamntaKommentarer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLaggTIllKategori))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnTaBortInlagg)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 495, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHamta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKategorin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBekrafta)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnPubliceraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPubliceraActionPerformed

        try {

            String txt = txtFaltInlagg.getText();
            String kat = cboxKategori.getSelectedItem().toString();
            String path = txtFieldPath.getText();

            if (path.equals("")){
                path = "Ingen fil";
            }

           

            String p = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(p);
            String date = simpleDateFormat.format(new Date());
            int anvandarId = app.getCurrentUser();
            String namn = app.getDataBaseConnection().fetchSingle("SELECT EPOST FROM ANVANDARE WHERE ANVANDAR_ID= '" + anvandarId + "'");

            String inlaggId = app.getDataBaseConnection().getAutoIncrement("FORMELBLOGG", "INLAGG_ID");
            if (inlaggId == null) {
                inlaggId = "1";
            }
            if (kat.isBlank()) {

                lblKat.setText("Du m�ste v�lja en kategori!");
            }
            if (!Validering.tfHarVarde(txtFaltInlagg)) {

                lblKategori.setText("V�nligen l�mna inte rutan tom.");
            }

            if (Validering.tfHarVarde(txtFaltInlagg)) {
                String dbStatment = app.getDataBaseConnection().fetchSingle("INSERT INTO FORMELBLOGG (EPOST, INLAGG_ID, INLAGG, DATUM, KATEGORI, PATH) VALUES ('" + namn + "', '" + inlaggId + "', '" + txt + "', '" + date + "', '" + kat + "', '" + path + "');");
                txtFaltInlagg.setText(null);
                lblKategorin.setText("Inl�gg publicerat");
                updateInfo();

            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�got �r fel");
            System.err.println(e);
        }
    }//GEN-LAST:event_btnPubliceraActionPerformed


    private void tblInlaggPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblInlaggPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tblInlaggPropertyChange

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        app.selectPage(4);
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboxInlaggenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxInlaggenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxInlaggenActionPerformed

    private void btnKommenteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKommenteraActionPerformed

        if (cboxInlaggen.getItemCount() == 0) {
            lblKategorin.setText("V�lj ett inl�gg att kommentera!");
        } else {
            try {
                String valtInlagg = cboxInlaggen.getSelectedItem().toString();
                String inlaggId = app.getDataBaseConnection().fetchSingle("SELECT INLAGG_ID FROM FORMELBLOGG WHERE INLAGG ='" + valtInlagg + "'");
                String nyKommentar = txtFaltInlagg.getText();
                String p = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(p);
                String datum = simpleDateFormat.format(new Date());
                int anvandarId = app.getCurrentUser();
                String namn = app.getDataBaseConnection().fetchSingle("SELECT EPOST FROM ANVANDARE WHERE ANVANDAR_ID= '" + anvandarId + "'");
                String kommentarsId = app.getDataBaseConnection().getAutoIncrement("KOMMENTAR", "KOMMENTAR_ID");
                if (kommentarsId == null) {
                    kommentarsId = "1";
                }

                if (!Validering.tfHarVarde(txtFaltInlagg)) {
                    lblKategorin.setText("V�nligen l�mna inte rutan tom.");
                }
                if (Validering.tfHarVarde(txtFaltInlagg)) {
                    String strangen = app.getDataBaseConnection().fetchSingle("INSERT INTO KOMMENTAR (KOMMENTAR_ID, KOMMENTAR, DATUM, INLAGG_ID, EPOST) VALUES ('" + kommentarsId + "', '" + nyKommentar + "', '" + datum + "', '" + inlaggId + "','" + namn + "');");
                    lblKategorin.setText("Kommenteringen lyckades!");
                    txtFaltInlagg.setText(null);
                }
               
            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�got blev ju fan fel, f�rs�k igen!");
                System.err.println(e);
            }
        }


    }//GEN-LAST:event_btnKommenteraActionPerformed

    private void btnHamntaKommentarerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamntaKommentarerActionPerformed

        try {
            ArrayList<HashMap<String, String>> allaKommentarer;
            
            String inlagget = cboxInlaggen.getSelectedItem().toString();
            String inlagg = app.getDataBaseConnection().fetchSingle("SELECT INLAGG_ID FROM FORMELBLOGG WHERE INLAGG = '" + inlagget + "'");

            DefaultTableModel table = new DefaultTableModel(new Object[]{"Anv�ndare", "Kommentar", "Datum"}, 0);

            allaKommentarer = app.getDataBaseConnection().fetchRows("SELECT KOMMENTAR, EPOST, DATUM FROM KOMMENTAR WHERE INLAGG_ID = '" + inlagg + "'");
            if (allaKommentarer == null) {
                table.addRow(new Object[]{null, null, null});
            } else {
                for (HashMap<String, String> rad : allaKommentarer) {
                    String anvandare = rad.get("EPOST");
                    String kommentar = rad.get("KOMMENTAR");
                    String datum = rad.get("DATUM");

                    //S�tter in anvandare + inlagg + datum  i tabellen mha addRow()
                    table.addRow(new Object[]{anvandare, kommentar, datum});
                }
            }
            //S�ger att tblInlagg ska anv�nda sig av den modellen vi skapade ovan
            tblKommentarer.setModel(table);

            //S�tter defaultEditor till Object.class, null f�r att data i tabellen inte ska kunna redigeras, men kunna selekteras.
            tblKommentarer.setDefaultEditor(Object.class, null);
            //St�nger av m�jligheten att �ndra kolumnordningen.
            tblKommentarer.getTableHeader().setReorderingAllowed(false);

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�got �r fel");
            System.err.println(e);

        }
    }//GEN-LAST:event_btnHamntaKommentarerActionPerformed

    private void btnBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBekraftaActionPerformed
        if (cboxInlaggen.getItemCount() == 0) {
            lblKategori.setText("V�lj ett inl�gg!");
        } else {
        try {
            String valtInlagg = cboxInlaggen.getSelectedItem().toString();
            String inlaggId = app.getDataBaseConnection().fetchSingle("SELECT INLAGG_ID FROM FORMELBLOGG WHERE INLAGG ='" + valtInlagg + "'");
            String nyttInlagg = txtInlagg.getText();

             if (Validering.tfIsTomt(txtInlagg)) {
                    lblKategori.setText("V�nligen l�mna inte rutan tom.");
                }
           
             if (!Validering.tfIsTomt(txtInlagg)) {
                app.getDataBaseConnection().update("UPDATE FORMELBLOGG SET INLAGG = '" + nyttInlagg + "' WHERE INLAGG_ID = " + inlaggId + "");
                lblKategori.setText("Uppdatering av inl�gget lyckades!");
            
            }

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�got blev fel, f�rs�k igen!");
            System.err.println(e);
        }
        }
        updateInfo();
    }//GEN-LAST:event_btnBekraftaActionPerformed

    private void btnHamtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHamtaActionPerformed
        if (cboxInlaggen.getItemCount() == 0) {
            lblKategori.setText("V�lj ett inl�gg!");
        } else {
            try {

                String valtInlagg = cboxInlaggen.getSelectedItem().toString();
                String inlaggId = app.getDataBaseConnection().fetchSingle("SELECT INLAGG_ID FROM FORMELBLOGG WHERE INLAGG = '" + valtInlagg + "'");
                txtInlagg.setText(app.getDataBaseConnection().fetchSingle("SELECT INLAGG FROM FORMELBLOGG WHERE INLAGG_ID = '" + inlaggId + "'"));

            } catch (InfException e) {
                JOptionPane.showMessageDialog(null, "N�got blev fel, f�rs�k igen!");
                System.err.println(e);
            }


        }
    }//GEN-LAST:event_btnHamtaActionPerformed

    private void btnLaggTIllKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTIllKategoriActionPerformed
         try {
         String kategorinamn = txtFaltInlagg.getText();
         String id = app.getDataBaseConnection().getAutoIncrement("KATEGORIER", "KATEGORI_ID");
    if (id == null) {
        id = "1";
    }
     String svar = app.getDataBaseConnection().fetchSingle("INSERT INTO KATEGORIER(KATEGORINAMN, KATEGORI_ID) VALUES ('"+kategorinamn+"','"+id+"')");
         lblKategorin.setText("Den nya kategorin har lagts till!");
          txtFaltInlagg.setText(null);
          updateInfo();
     }
     
     catch(InfException e) {
     JOptionPane.showMessageDialog(null, "N�got blev fel, f�rs�k igen!");
     System.err.println(e);
         
     }
    }//GEN-LAST:event_btnLaggTIllKategoriActionPerformed

    private void btnTaBortInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortInlaggActionPerformed

         if(tblInlagg.getSelectedColumn() == 1)
        {
        try{        
         int row = tblInlagg.getSelectedRow();
         String text = tblInlagg.getModel().getValueAt(row, 1).toString();
       
        
         int id = Integer.parseInt(app.getDataBaseConnection().fetchSingle("SELECT INLAGG_ID FROM FORMELBLOGG WHERE INLAGG='"+text+"'"));
         app.getDataBaseConnection().delete("DELETE FROM FORMELBLOGG WHERE INLAGG_ID="+ id);
         JOptionPane.showMessageDialog(null, "Inl�gg raderat");
         updateInfo(); 
         } 
        
        
         catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�got �r fel");
        }
        }
         

    }//GEN-LAST:event_btnTaBortInlaggActionPerformed

    private void btnBifogaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBifogaActionPerformed
       JFileChooser fil = new JFileChooser();
      fil.showOpenDialog(this);
      File f = fil.getSelectedFile();
      if(f != null){
      
      txtFieldPath.setText(f.getAbsolutePath());
      }

    }//GEN-LAST:event_btnBifogaActionPerformed

    private void tblInlaggMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInlaggMouseClicked
        if(tblInlagg.getSelectedColumn() == 4)
        {
        
        int row = tblInlagg.getSelectedRow();
        String value = (tblInlagg.getModel().getValueAt(row,4).toString());
        try{
            
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " +value);
       } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "N�got �r fel");
        }
        }else{
        
        }

    }//GEN-LAST:event_tblInlaggMouseClicked
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBekrafta;
    private javax.swing.JButton btnBifoga;
    private javax.swing.JButton btnHamntaKommentarer;
    private javax.swing.JButton btnHamta;
    private javax.swing.JButton btnKommentera;
    private javax.swing.JButton btnLaggTIllKategori;
    private javax.swing.JButton btnPublicera;
    private javax.swing.JButton btnTaBortInlagg;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JComboBox<String> cboxInlaggen;
    private javax.swing.JComboBox<String> cboxKategori;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblKat;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblKategorin;
    private javax.swing.JTable tblInlagg;
    private javax.swing.JTable tblKommentarer;
    private javax.swing.JTextField txtFaltInlagg;
    private javax.swing.JTextField txtFieldPath;
    private javax.swing.JTextField txtInlagg;
    // End of variables declaration//GEN-END:variables
}
