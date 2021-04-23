package scrumproj;

import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author krillenorden
 */
public class Inloggning extends Page {

    public Inloggning(Application app) {
        super(app);
        initComponents();
    }
    @Override
    public void updateInfo() { }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        textEpost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoggaIn = new javax.swing.JButton();
        textLosenord = new javax.swing.JPasswordField();
        Besokare = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(640, 640));
        setMinimumSize(new java.awt.Dimension(640, 640));
        setPreferredSize(new java.awt.Dimension(640, 640));
        setRequestFocusEnabled(false);

        textEpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEpostActionPerformed(evt);
            }
        });

        jLabel1.setText("E-post");

        jLabel2.setText("Lösenord");

        LoggaIn.setText("Logga in");
        LoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoggaInActionPerformed(evt);
            }
        });

        textLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLosenordActionPerformed(evt);
            }
        });

        Besokare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Användare", "Admin" }));
        Besokare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BesokareActionPerformed(evt);
            }
        });

        jLabel3.setText("Logga in som:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/scrumproj/novahuset-720.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(LoggaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textEpost, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Besokare, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(220, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Besokare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(LoggaIn)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void textEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEpostActionPerformed
        // Tom
    }//GEN-LAST:event_textEpostActionPerformed

    private void LoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoggaInActionPerformed
     if (!Validering.tfHarVarde(textEpost) || !Validering.passwordHarVarde(textLosenord)) {
            JOptionPane.showMessageDialog(null, "Du måste skriva in både ditt namn och lösenord");
            return; }
    

                String epost = textEpost.getText();
                String losenord = new String(textLosenord.getPassword());
                
                switch (Besokare.getSelectedIndex()) {
            case 0:
            {
                // Användare är valt
                try {

                    String correctPassword = app.getDataBaseConnection().fetchSingle("SELECT LOSENORD FROM ANVANDARE WHERE EPOST = '" + epost + "'");

                    if (losenord.equals(correctPassword)) {
                        String id = app.getDataBaseConnection().fetchSingle("SELECT ANVANDAR_ID FROM ANVANDARE WHERE EPOST = '" + epost + "'");
                        app.logInUser(Integer.parseInt(id));
                        app.selectPage(4);
                        resetComponents();
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Namnet eller lösenordet är fel, försök igen.");
                    }
                } catch(InfException e) {
                    System.err.println("Error message:" + e.getMessage());
                }
                break;
            }
            
                
                case 1:
               {
                // Admin
                try {
                    String adminstatus = app.getDataBaseConnection().fetchSingle("SELECT ADMINSTATUS FROM ANVANDARE WHERE EPOST = '" + epost + "'");
                    String correctPassword = app.getDataBaseConnection().fetchSingle("SELECT LOSENORD FROM ANVANDARE WHERE EPOST = '" + epost + "'");

                    if (losenord.equals(correctPassword) && adminstatus.equals("J")) {
                        String id = app.getDataBaseConnection().fetchSingle("SELECT ANVANDAR_ID FROM ANVANDARE WHERE EPOST = '" + epost + "'");
                        app.logInUser(Integer.parseInt(id));
                        app.selectPage(1);
                        resetComponents();
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Namnet eller lösenordet är fel, försök igen.");
                    }
                } catch(InfException e) {
                    System.err.println("Error message:" + e.getMessage());
                }
                break;}
                }
                }
            
                private void resetComponents() {
                textEpost.setText("");
                textLosenord.setText("");
                Besokare.setSelectedIndex(0);
    
        
    }//GEN-LAST:event_LoggaInActionPerformed

    private void textLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLosenordActionPerformed

    private void BesokareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BesokareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BesokareActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Besokare;
    private javax.swing.JButton LoggaIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textEpost;
    private javax.swing.JPasswordField textLosenord;
    // End of variables declaration//GEN-END:variables
}
