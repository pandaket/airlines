/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.queries;

/**
 *
 * @author Екатерина
 */
public class Quiery1 extends javax.swing.JFrame {

    /**
     * Creates new form Quiery1
     */
    public Quiery1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        airPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("airPU").createEntityManager();
        quiery1_1Query = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT q FROM Quiery1_1 q");
        quiery1_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : quiery1_1Query.getResultList();
        quiery1_1Query1 = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT q FROM Quiery1_1 q");
        quiery1_1List1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : quiery1_1Query1.getResultList();
        quiery1_1Query2 = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT q FROM Quiery1_1 q");
        quiery1_1List2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : quiery1_1Query2.getResultList();
        quiery1_1Query3 = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT q FROM Quiery1_1 q");
        quiery1_1List3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : quiery1_1Query3.getResultList();
        quiery1_1Query4 = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT q FROM Quiery1_1 q");
        quiery1_1List4 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : quiery1_1Query4.getResultList();
        firstQuery = java.beans.Beans.isDesignTime() ? null : airPUEntityManager.createQuery("SELECT f FROM First f");
        firstList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : firstQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, firstList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dep}"));
        columnBinding.setColumnName("Пункт отправления");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${air}"));
        columnBinding.setColumnName("Авиакомпания");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Quiery1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiery1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiery1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiery1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiery1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager airPUEntityManager;
    private java.util.List<airlines.queries.First> firstList;
    private javax.persistence.Query firstQuery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<airlines.queries.Quiery1_1> quiery1_1List;
    private java.util.List<airlines.queries.Quiery1_1> quiery1_1List1;
    private java.util.List<airlines.queries.Quiery1_1> quiery1_1List2;
    private java.util.List<airlines.queries.Quiery1_1> quiery1_1List3;
    private java.util.List<airlines.queries.Quiery1_1> quiery1_1List4;
    private javax.persistence.Query quiery1_1Query;
    private javax.persistence.Query quiery1_1Query1;
    private javax.persistence.Query quiery1_1Query2;
    private javax.persistence.Query quiery1_1Query3;
    private javax.persistence.Query quiery1_1Query4;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
