package airlines;


import airlines.views.AirlineView;
import airlines.views.LocalView;
import airlines.views.ScheduleView;

public class View extends javax.swing.JFrame {

    public View() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        airlinesButton = new javax.swing.JButton();
        schedulesButton = new javax.swing.JButton();
        localsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Выберите таблицу");
        setBackground(new java.awt.Color(255, 255, 204));
        setResizable(false);

        buttonPanel.setToolTipText("");

        airlinesButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        airlinesButton.setText("Список авиакомпаний");
        airlinesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlinesButtonActionPerformed(evt);
            }
        });

        schedulesButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        schedulesButton.setText("Расписание самолетов");
        schedulesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schedulesButtonActionPerformed(evt);
            }
        });

        localsButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        localsButton.setText("Список населенных пунктов");
        localsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(airlinesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(schedulesButton)
                .addGap(142, 142, 142))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airlinesButton)
                    .addComponent(localsButton)
                    .addComponent(schedulesButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void airlinesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlinesButtonActionPerformed
        //this.setVisible(false);
        AirlineView airlines = new AirlineView();
        airlines.setVisible(true);
    }//GEN-LAST:event_airlinesButtonActionPerformed

    private void localsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localsButtonActionPerformed
        //this.setVisible(false);
        LocalView locals = new LocalView();
        locals.setVisible(true);
    }//GEN-LAST:event_localsButtonActionPerformed

    private void schedulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schedulesButtonActionPerformed
        //this.setVisible(false);
        ScheduleView schedules = new ScheduleView();
        schedules.setVisible(true);
    }//GEN-LAST:event_schedulesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton airlinesButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton localsButton;
    private javax.swing.JButton schedulesButton;
    // End of variables declaration//GEN-END:variables
}
