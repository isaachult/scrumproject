package scrumproj;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

import oru.inf.InfException;

public class HanteraPrenumerationer extends Page {


    public HanteraPrenumerationer(Application app) {
        super(app);
        initComponents();
    }
    
    @Override
    public void updateInfo() { 
        
        try {
            
        String namn = app.getDataBaseConnection().fetchSingle("SELECT FORNAMN FROM ANVANDARE WHERE ANVANDAR_ID= '" + app.getCurrentUser() + "'"); 
            lblName.setText("V�lkommen" + " " +namn+ "!");
            
        }   catch (InfException e) {
            System.err.println(e.getMessage()); 
        }
            
            DefaultListModel kategoriModel = new DefaultListModel();
            DefaultListModel anvandarModel = new DefaultListModel();
            
            kategoriModel.removeAllElements();
            anvandarModel.removeAllElements();
            listKategorier.setModel(kategoriModel);
            listAnvandare.setModel(anvandarModel);
            
            try {
            ArrayList<String> allaKategoriPrenumerationer = app.getDataBaseConnection().fetchColumn("SELECT KATEGORINAMN FROM KATEGORIER JOIN PRENUMERATION_KATEGORI ON KATEGORIER.KATEGORI_ID = PRENUMERATION_KATEGORI.KATEGORI_ID WHERE ANVANDAR_ID = " + app.getCurrentUser());
            
                for (String kategorier : allaKategoriPrenumerationer) {
                    kategoriModel.addElement(kategorier);
                    listKategorier.setModel(kategoriModel);
                }
            } catch (InfException e) {
                System.err.println(e.getMessage()); 
            } catch (NullPointerException npe) {
                System.err.println(npe.getMessage());
            }
            try {
            ArrayList<String> allaAnvandarPrenumerationer = app.getDataBaseConnection().fetchColumn("SELECT FORNAMN FROM ANVANDARE JOIN PRENUMERATION_PROFIL ON ANVANDARE.ANVANDAR_ID = PRENUMERATION_PROFIL.PROFIL_ID WHERE PRENUMERATION_PROFIL.ANVANDAR_ID = " + app.getCurrentUser());
                for (String anvandare : allaAnvandarPrenumerationer) {
                    anvandarModel.addElement(anvandare);
                    listAnvandare.setModel(anvandarModel);
                }
            } catch (InfException e) {
                System.err.println(e.getMessage()); 
            } catch (NullPointerException npe) {
                System.err.println(npe.getMessage());
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

        listCategory = new javax.swing.JScrollPane();
        listKategorier = new javax.swing.JList<>();
        lblName = new javax.swing.JLabel();
        lblYourSubscriptions = new javax.swing.JLabel();
        listUser = new javax.swing.JScrollPane();
        listAnvandare = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnRemoveCategory = new javax.swing.JButton();
        btnRemoveProfile = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(640, 640));
        setMinimumSize(new java.awt.Dimension(640, 640));

        listCategory.setViewportView(listKategorier);

        lblName.setText("txtNamn");

        lblYourSubscriptions.setText("Dina Prenumerationer:");

        listUser.setViewportView(listAnvandare);

        jLabel2.setText("Kategorier");

        jLabel3.setText("Anv�ndare");

        btnBack.setText("Tillbaka");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRemoveCategory.setText("Avsluta prenumeration");
        btnRemoveCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCategoryActionPerformed(evt);
            }
        });

        btnRemoveProfile.setText("Avsluta prenumeration");
        btnRemoveProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(listCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveCategory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnRemoveProfile)
                    .addComponent(listUser, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblYourSubscriptions)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYourSubscriptions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listUser, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(listCategory))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveCategory)
                    .addComponent(btnRemoveProfile))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        app.selectPage(app.getPreviousPage());
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCategoryActionPerformed
        
        try {
        String chosenSubscription = listKategorier.getSelectedValue();
        System.out.println(chosenSubscription);
        String subscriptionToRemove = app.getDataBaseConnection().fetchSingle("select kategorier.kategori_id from kategorier join prenumeration_kategori on kategorier.kategori_id = prenumeration_kategori.kategori_id where anvandar_id = " + app.getCurrentUser() + " and kategorinamn = '" + chosenSubscription + "'");
        
        if (subscriptionToRemove == null) {
                return;
                
            }   else {
            app.getDataBaseConnection().delete("DELETE FROM PRENUMERATION_KATEGORI WHERE KATEGORI_ID = " + subscriptionToRemove + " and ANVANDAR_ID = " + app.getCurrentUser());
                    
        
                    updateInfo();
        }
        
        
        } catch (InfException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnRemoveCategoryActionPerformed

    private void btnRemoveProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProfileActionPerformed
         try {
        String chosenSubscription = listAnvandare.getSelectedValue();
        System.out.println(chosenSubscription);
        String subscriptionToRemove = app.getDataBaseConnection().fetchSingle("select anvandare.anvandar_id from anvandare join prenumeration_profil on anvandare.anvandar_id = prenumeration_profil.profil_id where prenumeration_profil.anvandar_id = " + app.getCurrentUser() + " and fornamn = '" + chosenSubscription + "'");
        
        if (subscriptionToRemove == null) {
                return;
                
            }   else {
            app.getDataBaseConnection().delete("DELETE FROM PRENUMERATION_PROFIL WHERE PROFIL_ID = " + subscriptionToRemove + " and ANVANDAR_ID = " + app.getCurrentUser());
                    
        
                    updateInfo();
        }
        
        
        } catch (InfException e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnRemoveProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveCategory;
    private javax.swing.JButton btnRemoveProfile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblYourSubscriptions;
    private javax.swing.JList<String> listAnvandare;
    private javax.swing.JScrollPane listCategory;
    private javax.swing.JList<String> listKategorier;
    private javax.swing.JScrollPane listUser;
    // End of variables declaration//GEN-END:variables
}