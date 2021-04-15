/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproj;

import javax.swing.JOptionPane;
import oru.inf.InfException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author jacke
 */
public class PubliceraInlagg extends Page {
 


    /**
     * Creates new form PubliceraInlagg
     */
    public PubliceraInlagg(Application app)
    {
        super(app);
        initComponents();
    }
     


    @Override
    public void updateInfo(){
    try {
        
        
    }
    
    catch(InfException e) {
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        inlaggTxtArea = new javax.swing.JTextArea();
        btnBifoga = new javax.swing.JButton();
        btnPublicera = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        inlaggList = new javax.swing.JList<>();

        inlaggTxtArea.setColumns(20);
        inlaggTxtArea.setRows(5);
        jScrollPane1.setViewportView(inlaggTxtArea);

        btnBifoga.setText("Bifoga fil");

        btnPublicera.setText("Publicera");
        btnPublicera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPubliceraActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");

        jLabel1.setText("Inl�gg");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane3.setViewportView(inlaggList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnTillbaka)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPublicera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBifoga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBifoga)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPublicera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPubliceraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPubliceraActionPerformed
            try{
            
        String txt = inlaggTxtArea.getText();
       
        String p = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(p);
         String date = simpleDateFormat.format(new Date());
         int anvandarId = app.getCurrentUser();
         String namn = app.getDataBaseConnection().fetchSingle("SELECT FORNAMN FROM ANVANDARE WHERE ANVANDAR_ID= '" + anvandarId + "'");
       
        String inlaggId = app.getDataBaseConnection().getAutoIncrement("INFORMELLBLOGG", "INLAGG_ID");
        if (inlaggId == null) {
        inlaggId = "1";
    }
        //String dbStatment= ("INSERT INTO INFORMELLBLOGG VALUES ('" + date + "', '" + txt + "', '" + inkrementera+ "','" +  Id + "');");2
        String dbStatment = app.getDataBaseConnection().fetchSingle("INSERT INTO INFORMELLBLOGG (ANVANDARE, INLAGG_ID, TIDSTAMPEL, INLAGG) VALUES ('"+namn+"', '"+inlaggId+"', '"+date+"', '"+txt+"')");
        JOptionPane.showMessageDialog(null,"Inl�gg publicerat");
        
       
}
    
         catch(InfException e){
        JOptionPane.showMessageDialog(null, "N�got �r fel");
         System.err.println(e);
}
            
                
               
       
        
        
        
                                              

    }//GEN-LAST:event_btnPubliceraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBifoga;
    private javax.swing.JButton btnPublicera;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JList<String> inlaggList;
    private javax.swing.JTextArea inlaggTxtArea;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}