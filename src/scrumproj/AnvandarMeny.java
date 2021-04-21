/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproj;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfException;


public class AnvandarMeny extends Page {

    public AnvandarMeny (Application app) {
        super(app);
        initComponents();
    }

    @Override
    public void updateInfo() { 
        try {
            int inloggadId = app.getCurrentUser();
            String namn = app.getDataBaseConnection().fetchSingle("SELECT FORNAMN FROM ANVANDARE WHERE ANVANDAR_ID= '" + inloggadId + "'"); 
            txtProfile.setText("V�lkommen" + " " +namn+ "!");
        
           
            
            ArrayList<String> allaNotiser = app.getDataBaseConnection().fetchColumn("SELECT NOTIS_BESKRIVNING FROM NOTISER JOIN SKICKAD_NOTIS ON NOTISER.NOTIS_ID = SKICKAD_NOTIS.NOTIS_ID WHERE ANVANDAR_ID = " + inloggadId);
            boxNotiser.removeAllItems();
            boxNotiser.addItem("V�lj notis");
            
            
            if(allaNotiser != null) {
                for (String notiser : allaNotiser) {      
                    boxNotiser.addItem(notiser);
                }
            }
        } catch(InfException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void updateNotificationText () {
        try {
        String notificationText = boxNotiser.getSelectedItem().toString();
        txtNotification.setText(notificationText); 
        } catch (NullPointerException e) {
            System.out.println("Finns inga notiser att visa");
            System.err.println(e.getMessage());
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

        txtProfile = new javax.swing.JLabel();
        btnInformellBlogg = new javax.swing.JButton();
        btnFormellBlogg = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnKalender = new javax.swing.JButton();
        btnKontouppgifter = new javax.swing.JButton();
        boxNotiser = new javax.swing.JComboBox<>();
        lblNotiser = new javax.swing.JLabel();
        btnDltNotification = new javax.swing.JButton();
        txtNotification = new javax.swing.JLabel();
        btnSubscriptions = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(640, 640));
        setMinimumSize(new java.awt.Dimension(640, 640));

        btnInformellBlogg.setText("Informell Blogg");
        btnInformellBlogg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformellBloggActionPerformed(evt);
            }
        });

        btnFormellBlogg.setText("Formell Blogg");
        btnFormellBlogg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormellBloggActionPerformed(evt);
            }
        });

        btnLogout.setText("Logga ut");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnKalender.setText("Kalender");

        btnKontouppgifter.setText("�ndra kontouppgifter");
        btnKontouppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKontouppgifterActionPerformed(evt);
            }
        });

        boxNotiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNotiserActionPerformed(evt);
            }
        });

        lblNotiser.setText("Notiser");

        btnDltNotification.setText("Ta bort notis");
        btnDltNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDltNotificationActionPerformed(evt);
            }
        });

        btnSubscriptions.setText("Prenumerationer");
        btnSubscriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscriptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(txtProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNotiser)
                            .addComponent(btnDltNotification)
                            .addComponent(boxNotiser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFormellBlogg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKalender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInformellBlogg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKontouppgifter, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(btnSubscriptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout))
                .addGap(36, 36, 36)
                .addComponent(btnKalender)
                .addGap(18, 18, 18)
                .addComponent(btnFormellBlogg)
                .addGap(18, 18, 18)
                .addComponent(btnInformellBlogg)
                .addGap(18, 18, 18)
                .addComponent(btnSubscriptions)
                .addGap(18, 18, 18)
                .addComponent(btnKontouppgifter)
                .addGap(135, 135, 135)
                .addComponent(lblNotiser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxNotiser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDltNotification)
                .addContainerGap(127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInformellBloggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformellBloggActionPerformed
        app.selectPage(7);
    }//GEN-LAST:event_btnInformellBloggActionPerformed

    private void btnFormellBloggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormellBloggActionPerformed
        app.selectPage(9);
    }//GEN-LAST:event_btnFormellBloggActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        app.logOut();
        app.selectPage(0);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnKontouppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKontouppgifterActionPerformed
        app.selectPage(10);
    }//GEN-LAST:event_btnKontouppgifterActionPerformed

    private void btnDltNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDltNotificationActionPerformed
        try {
            
            String valdNotis = boxNotiser.getSelectedItem().toString();
            //String idToRemove = app.getDataBaseConnection().fetchSingle("SELECT NOTIS_ID FROM NOTISER WHERE NOTIS_BESKRIVNING = '" + valdNotis + "'");
            String idToRemove = app.getDataBaseConnection().fetchSingle("Select notiser.notis_id from notiser join skickad_notis on notiser.notis_id = skickad_notis.notis_id where anvandar_id = " + app.getCurrentUser() + "  and notis_beskrivning = '" + valdNotis + "'");
            if (idToRemove == null) {
                return;
                
            }   else {
                    
                    app.getDataBaseConnection().delete("DELETE FROM SKICKAD_NOTIS WHERE NOTIS_ID = " + idToRemove);
                    
        
                    updateInfo();
            }
        } catch (InfException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDltNotificationActionPerformed

    private void boxNotiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNotiserActionPerformed
        updateNotificationText();
    }//GEN-LAST:event_boxNotiserActionPerformed

    private void btnSubscriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscriptionsActionPerformed
        app.selectPage(16);
    }//GEN-LAST:event_btnSubscriptionsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxNotiser;
    private javax.swing.JButton btnDltNotification;
    private javax.swing.JButton btnFormellBlogg;
    private javax.swing.JButton btnInformellBlogg;
    private javax.swing.JButton btnKalender;
    private javax.swing.JButton btnKontouppgifter;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSubscriptions;
    private javax.swing.JLabel lblNotiser;
    private javax.swing.JLabel txtNotification;
    private javax.swing.JLabel txtProfile;
    // End of variables declaration//GEN-END:variables
}
