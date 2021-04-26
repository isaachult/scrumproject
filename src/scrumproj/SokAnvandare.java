/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproj;

import javax.swing.JOptionPane;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alryd
 */
public class SokAnvandare extends Page {

    String valdAnvandare;
    String anvandarId;
    //DefaultTableModel table;
    
    
    public SokAnvandare(Application app) {
        super(app);
        initComponents();
        jLabel1.setText("");
        lblBlogg.setText("");
        
    }
    
    @Override
    public void updateInfo() { 
    
        String fraga = "SELECT anvandar_id FROM anvandare";
        //jLabel1.setText(valdAnvandare + "s blogg");
        

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(btnFormell);
        buttonGroup.add(btnInformell);
        
        //btnFormell.setSelected(true);
        
        
        
        
        ArrayList<String> allaAnvandare;
            cboxAnvandare.removeAllItems();
            
            

        try {
            allaAnvandare = app.getDataBaseConnection().fetchColumn(fraga); // h�mta alla anv�ndarid
            
            //En for loop som l�gger in anv�ndarnas namn i en combobox f�r vare instans som uppst�r.
            for (String id : allaAnvandare) {
                String forNamn = app.getDataBaseConnection().fetchSingle("SELECT fornamn FROM anvandare WHERE anvandar_id = '" + id + "'");
                String efterNamn = app.getDataBaseConnection().fetchSingle("SELECT efternamn FROM anvandare WHERE anvandar_id = '" + id + "'");
                String epost = app.getDataBaseConnection().fetchSingle("SELECT epost FROM anvandare WHERE anvandar_id = '" + id + "'");
                
                //cboxAnvandare.addItem(epost + " " + forNamn + " " + efterNamn);
                cboxAnvandare.addItem(epost + " " + forNamn + " " + efterNamn);
            }
           

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception ettUndantag) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
        
        
        if (btnFormell.isSelected())
        {
        try {
            lblBlogg.setText("");
            ArrayList<HashMap<String, String>> allaRader;

            DefaultTableModel table = new DefaultTableModel(new Object[]{"Anv�ndare", "Inl�gg", "Datum", "Inl�ggId", "Fil", "Kategori"}, 0);

            allaRader = app.getDataBaseConnection().fetchRows("SELECT INLAGG_ID, EPOST, INLAGG, DATUM, PATH, KATEGORI FROM FORMELBLOGG WHERE EPOST = '" + valdAnvandare + "'");
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
         
        }
        else if (btnInformell.isSelected())
        {
            try {
                lblBlogg.setText("");
            ArrayList<HashMap<String, String>> allaRader;

            DefaultTableModel table = new DefaultTableModel(new Object[]{"Anv�ndare", "Inl�gg", "Datum", "Inl�ggId", "Fil", "Kategori"}, 0);

            allaRader = app.getDataBaseConnection().fetchRows("SELECT INLAGG_ID, EPOST, INLAGG, DATUM, PATH, KATEGORI FROM INFORMELLBLOGG WHERE EPOST = '" + valdAnvandare + "'");
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
        }
        else
        {
            //JOptionPane.showMessageDialog(null, "Du m�ste v�lja vilken typ av blogg du vill se");
            lblBlogg.setText("Du m�ste v�lja vilken typ av blogg du vill se");
            return;
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

        cboxAnvandare = new javax.swing.JComboBox<>();
        btnSok = new javax.swing.JButton();
        lblValjAnvandare = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInlagg = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnFormell = new javax.swing.JRadioButton();
        btnInformell = new javax.swing.JRadioButton();
        lblBlogg = new javax.swing.JLabel();

        cboxAnvandare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSok.setText("S�k");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        lblValjAnvandare.setText("V�lj anv�ndare");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tblInlagg);

        jLabel1.setText("jLabel1");

        btnFormell.setText("Formell blogg");

        btnInformell.setText("Informell blogg");

        lblBlogg.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTillbaka)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSok, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValjAnvandare)
                            .addComponent(btnFormell)
                            .addComponent(btnInformell)
                            .addComponent(lblBlogg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblValjAnvandare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFormell)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInformell)
                        .addGap(11, 11, 11)
                        .addComponent(btnSok)
                        .addGap(18, 18, 18)
                        .addComponent(lblBlogg))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addComponent(btnTillbaka)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
        
        try {
            String s = cboxAnvandare.getSelectedItem().toString();
            if (s.contains(" ")) {
                valdAnvandare = s.substring(0, s.indexOf(" "));
            }
            String fornamn = app.getDataBaseConnection().fetchSingle("SELECT fornamn FROM anvandare WHERE epost = '" + valdAnvandare + "'");
            String efternamn = app.getDataBaseConnection().fetchSingle("SELECT efternamn FROM anvandare WHERE epost = '" + valdAnvandare + "'");
            if (btnFormell.isSelected()) {
                jLabel1.setText(fornamn + " " + efternamn + "s formella blogg");

            } else if (btnInformell.isSelected()) {
                jLabel1.setText(fornamn + " " + efternamn + "s informella blogg");
            }
            updateInfo();
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "N�got �r fel");
            System.err.println(e);
        }
        
        
        
        /*
           try {
             valdAnvandare = cboxAnvandare.getSelectedItem().toString();
            //if (valdAnvandare.contains(" ")) {
                //valdAnvandare = valdAnvandare.substring(0, valdAnvandare.indexOf(" "));
            //}
           

             //anvandarId = Integer.parseInt( app.getDataBaseConnection().fetchSingle("SELECT anvandar_id FROM anvandare WHERE fornamn = '" + valdAnvandare + "'"));
             updateInfo();
            //app.selectPage();
            System.out.println(valdAnvandare + "    " + anvandarId);
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception ettUndantag) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
 */

            
        
            
  
        
    }//GEN-LAST:event_btnSokActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed

        app.selectPage(app.getPreviousPage());
    }//GEN-LAST:event_btnTillbakaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnFormell;
    private javax.swing.JRadioButton btnInformell;
    private javax.swing.JButton btnSok;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JComboBox<String> cboxAnvandare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBlogg;
    private javax.swing.JLabel lblValjAnvandare;
    private javax.swing.JTable tblInlagg;
    // End of variables declaration//GEN-END:variables
}

