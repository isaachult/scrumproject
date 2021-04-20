package scrumproj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfException;



/**
 *
 * @author krillenorden
 */
public class Motesbokning extends Page {

    /**
     * Creates new form MotesbokningAnvandare
     */
    public Motesbokning(Application app) {
        super(app);
        initComponents();
        
    }
    public void bookMeeting(){
        SimpleDateFormat datum = new SimpleDateFormat("yyyy-MM-dd");
        
    }
    @Override
    public void updateInfo() { 
    
        String fraga = "SELECT anvandar_id FROM anvandare";
        
      
        ArrayList<String> allaAnvandare = null;
            cboxAnvandare.removeAllItems();
            

        try {
            allaAnvandare = app.getDataBaseConnection().fetchColumn(fraga); // hämta alla användarnamn
            
           //En for loop som lägger in användarnas namn i en combobox för vare instans som uppstår.
            for (String id : allaAnvandare) {
                String forNamn = app.getDataBaseConnection().fetchSingle("SELECT fornamn FROM anvandare WHERE anvandar_id = '" + id + "'");
                String efterNamn = app.getDataBaseConnection().fetchSingle("SELECT efternamn FROM anvandare WHERE anvandar_id = '" + id + "'");
                String anvandarId = app.getDataBaseConnection().fetchSingle("SELECT anvandar_id FROM anvandare WHERE anvandar_id = '" + id + "'");
                String epost = app.getDataBaseConnection().fetchSingle("SELECT epost FROM anvandare WHERE anvandar_id = '" + id + "'" );
                cboxAnvandare.addItem(epost + " " + "NAMN: " + forNamn + " " + efterNamn);
            }
            
            
           

        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception ettUndantag) {
            JOptionPane.showMessageDialog(null, "Ett fel uppstod!");
            System.out.println("Internt felmeddelande" + ettUndantag.getMessage());
        }
    
        
        
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBesk = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtDatum = new javax.swing.JTextField();
        txtTid = new javax.swing.JTextField();
        cboxAnvandare = new javax.swing.JComboBox<>();

        jLabel1.setText("Boka Möten");

        txtBesk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBeskActionPerformed(evt);
            }
        });

        jButton1.setText("Tillbaka");

        jLabel2.setText("Mötesbeskrivning");

        jLabel3.setText("Datum");

        jLabel4.setText("Tid");

        jLabel5.setText("Lägg till en användare här");

        jButton2.setText("Boka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDatum.setText("yyyy-MM-dd");
        txtDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumActionPerformed(evt);
            }
        });

        txtTid.setText("00:00");
        txtTid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTidActionPerformed(evt);
            }
        });

        cboxAnvandare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(10, 10, 10))
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBesk)
                                    .addComponent(txtDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(txtTid, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboxAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBesk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(txtTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBeskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBeskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBeskActionPerformed

    private void txtDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumActionPerformed

    private void txtTidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTidActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        String beskrivning = txtBesk.getText();
        String datum = txtDatum.getText();
        String tid = txtTid.getText();
         String valtNamn = cboxAnvandare.getSelectedItem().toString();
            if (valtNamn.contains(" ")) {
                valtNamn = valtNamn.substring(0, valtNamn.indexOf(" "));
            }
              String motesId = app.getDataBaseConnection().getAutoIncrement("MOTEN", "MOTES_ID");
    if (motesId == null) {
        motesId = "1";
    }
            
            
        String anvandarId = app.getDataBaseConnection().fetchSingle("Select anvandar_id from anvandare where epost ='" + valtNamn + "'");
         app.getDataBaseConnection().fetchSingle("INSERT INTO MOTEN (BESKRIVNING, MOTES_ID, DATUM, TID) VALUES ('"+beskrivning+"', '"+motesId+"', '"+datum+"','"+tid+"')");
         app.getDataBaseConnection().fetchSingle("INSERT INTO BOKADE_MOTEN (MOTES_ID, ANVANDAR_ID) VALUES ('"+motesId+"','"+anvandarId+"')");
         JOptionPane.showMessageDialog(null, "Det nya mötet har skapats!");

      
        }
        
        catch(InfException e) {
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboxAnvandare;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtBesk;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtTid;
    // End of variables declaration//GEN-END:variables

}
