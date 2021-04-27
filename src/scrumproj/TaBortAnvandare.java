/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproj;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import oru.inf.InfException;

public class TaBortAnvandare extends Page {

    public TaBortAnvandare (Application app) {
        super(app);
        initComponents();
    }

    @Override
    public void updateInfo() { 
        andradInfo.setText("");
     String fraga = "Select fornamn from anvandare";
     

        ArrayList<String> allaAnvandarNamn;
         ValjAnvandare.removeAllItems();
        

        try {
            allaAnvandarNamn = app.getDataBaseConnection().fetchColumn(fraga);
//En for loop som l�gger in anv�ndarnas namn f�r vare instans som uppst�r.
            for (String namn : allaAnvandarNamn) {
                ValjAnvandare.addItem(namn);
                
                
        
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception ettUndantag) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod!");
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

        jLabel1 = new javax.swing.JLabel();
        ValjAnvandare = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        andradInfo = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(640, 640));
        setMinimumSize(new java.awt.Dimension(640, 640));

        jLabel1.setText("V�nligen v�lj en anv�ndare att ta bort");

        ValjAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValjAnvandareActionPerformed(evt);
            }
        });

        jButton1.setText("Ta bort anv�ndare");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        andradInfo.setText("jLabel2");

        jButton2.setText("Tillbaka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(ValjAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(andradInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ValjAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(andradInfo)
                .addContainerGap(336, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        String valtNamn = ValjAnvandare.getSelectedItem().toString();
        String anvandarId = app.getDataBaseConnection().fetchSingle("Select anvandar_id from anvandare where fornamn ='" + valtNamn + "'");
        app.getDataBaseConnection().delete("delete from prenumeration_kategori where anvandar_id ='" + anvandarId + "'");
        app.getDataBaseConnection().delete("delete from prenumeration_profil where anvandar_id ='" + anvandarId + "'");
        app.getDataBaseConnection().delete("delete from skickad_notis where anvandar_id ='" + anvandarId + "'");
        app.getDataBaseConnection().delete("delete from bokade_moten where anvandar_id ='" + anvandarId + "'");
        app.getDataBaseConnection().delete("delete from anvandare where anvandar_id ='"+ anvandarId + "'");
        updateInfo();
        andradInfo.setText ("Anv�ndaren har tagits bort!");
    }   
    
    catch (InfException e)
    {
     JOptionPane.showMessageDialog(null, "N�got blev fel, f�rs�k igen!");
     System.err.println(e);
    }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ValjAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValjAnvandareActionPerformed
       
    }//GEN-LAST:event_ValjAnvandareActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     app.selectPage(app.getPreviousPage());
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ValjAnvandare;
    private javax.swing.JLabel andradInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
