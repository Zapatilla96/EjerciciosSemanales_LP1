package vistas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import clases.FondoPanel;

public class ViewPrincipal extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel(); //instancia de fondo panel

    /**
     * Creates new form Principal
     */
    public ViewPrincipal() {
        initComponents();
        inicializar();
    }

    public final void inicializar() {

        setTitle("Sistema de Gestión de Datos");
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(fondo); //fondo panel para Content Pane
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuPersonal = new javax.swing.JMenu();
        jmenuGPersonal = new javax.swing.JMenuItem();
        jmenuProductos = new javax.swing.JMenu();
        jmenuGProductos = new javax.swing.JMenuItem();
        jmenuAcercade = new javax.swing.JMenu();
        jmenuDev = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jmenuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pergest.png"))); // NOI18N
        jmenuPersonal.setText("Personal");
        jmenuPersonal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jmenuGPersonal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmenuGPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/personal.png"))); // NOI18N
        jmenuGPersonal.setLabel("Gestionar Personal");
        jmenuGPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuGPersonalActionPerformed(evt);
            }
        });
        jmenuPersonal.add(jmenuGPersonal);

        jMenuBar1.add(jmenuPersonal);

        jmenuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/progest.png"))); // NOI18N
        jmenuProductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmenuProductos.setLabel("Productos");

        jmenuGProductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmenuGProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/products.png"))); // NOI18N
        jmenuGProductos.setLabel("Gestionar Productos");
        jmenuGProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuGProductosActionPerformed(evt);
            }
        });
        jmenuProductos.add(jmenuGProductos);

        jMenuBar1.add(jmenuProductos);

        jmenuAcercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        jmenuAcercade.setText("Acerca de");
        jmenuAcercade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jmenuDev.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmenuDev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dev.png"))); // NOI18N
        jmenuDev.setText("Diseño y Desarrollo");
        jmenuDev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuDevActionPerformed(evt);
            }
        });
        jmenuAcercade.add(jmenuDev);

        jMenuBar1.add(jmenuAcercade);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuGPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuGPersonalActionPerformed
        ViewGestionarPersonal gp;
        try {
            gp = new ViewGestionarPersonal();
            gp.setLocationRelativeTo(null);
            gp.setVisible(true);
            gp.setTitle(("gestión de Personal").toUpperCase());
            gp.setDefaultCloseOperation(0);
        } catch (IOException ex) {
            Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jmenuGPersonalActionPerformed

    private void jmenuGProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuGProductosActionPerformed
        ViewGestionarProductos gpro = new ViewGestionarProductos();
        gpro.setLocationRelativeTo(null);
        gpro.setVisible(true);
        gpro.setTitle(("Gestión de Productos").toUpperCase());
        gpro.setDefaultCloseOperation(0);
    }//GEN-LAST:event_jmenuGProductosActionPerformed

    private void jmenuDevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuDevActionPerformed
        ViewAcercaDe ad = new ViewAcercaDe();
        ad.setLocationRelativeTo(null);
        ad.setVisible(true);
    }//GEN-LAST:event_jmenuDevActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "En realidad desea realizar cerrar la aplicacion", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jmenuAcercade;
    private javax.swing.JMenuItem jmenuDev;
    private javax.swing.JMenuItem jmenuGPersonal;
    private javax.swing.JMenuItem jmenuGProductos;
    private javax.swing.JMenu jmenuPersonal;
    private javax.swing.JMenu jmenuProductos;
    // End of variables declaration//GEN-END:variables
}
