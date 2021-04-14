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

        jLabel1.setText("V�nligen v�lj anv�ndare att ta bort");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(ValjAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ValjAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(185, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        String valtNamn = ValjAnvandare.getSelectedItem().toString();
        String anvandarId = app.getDataBaseConnection().fetchSingle("Select anvandar_id from anvandare where fornamn ='" + valtNamn + "'");
        app.getDataBaseConnection().delete("delete from anvandare where anvandar_id ='" + anvandarId + "'");
        JOptionPane.showMessageDialog(null, "Anv�ndaren har tagits bort!");
        updateInfo();
        
    }   
    
    catch (InfException e)
    {
     JOptionPane.showMessageDialog(null, "N�got blev fel, f�rs�k igen!");
     System.err.println(e);
    }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ValjAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValjAnvandareActionPerformed
       
    }//GEN-LAST:event_ValjAnvandareActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ValjAnvandare;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
