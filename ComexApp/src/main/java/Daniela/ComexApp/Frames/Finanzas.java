package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import service.ContenedoresImpl;
import service.GastosImpl;

/**
 *
 * @author Daniela
 */
public class Finanzas extends javax.swing.JFrame {

     String usuario = "", nombreCompleto = "";
    /**
     * Creates new form Finanzas 
     */
    public Finanzas() {
        initComponents();
        
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Menú de administración de dinero - " + usuario + " - sistema ComexApp");     
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonVolver2 = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuInt = new javax.swing.JMenu();
        jMenuItemGestion = new javax.swing.JMenuItem();
        jMenuItemIngreso = new javax.swing.JMenuItem();
        jMenuItemDarDeBaja = new javax.swing.JMenuItem();
        jMenuNac = new javax.swing.JMenu();
        jMenuItemGestion1 = new javax.swing.JMenuItem();
        jMenuItemIngreso1 = new javax.swing.JMenuItem();
        jMenuItemDarDeBaja1 = new javax.swing.JMenuItem();
        jMenuItemCompradoresVendedores = new javax.swing.JMenuItem();
        jMenuCont = new javax.swing.JMenu();
        jMenuItemGestionC = new javax.swing.JMenuItem();
        jMenuItemIngresoC = new javax.swing.JMenuItem();
        jMenuItemDarDeBajaC = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonVolver2.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolver2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver2.setText("Volver");
        jButtonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jButtonVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jButtonVolver2)
                .addContainerGap(630, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 880));

        jMenuBar.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar.setForeground(new java.awt.Color(0, 0, 153));

        jMenuInt.setBackground(new java.awt.Color(204, 204, 204));
        jMenuInt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/international.png"))); // NOI18N
        jMenuInt.setText("Gastos");
        jMenuInt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemGestion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemGestion.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemGestion.setText("Gestión de gastos");
        jMenuItemGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionActionPerformed(evt);
            }
        });
        jMenuInt.add(jMenuItemGestion);

        jMenuItemIngreso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemIngreso.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemIngreso.setText("Ingresar nuevo gasto");
        jMenuItemIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIngresoActionPerformed(evt);
            }
        });
        jMenuInt.add(jMenuItemIngreso);

        jMenuItemDarDeBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemDarDeBaja.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemDarDeBaja.setText("Eliminar gasto registrado");
        jMenuItemDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDarDeBajaActionPerformed(evt);
            }
        });
        jMenuInt.add(jMenuItemDarDeBaja);

        jMenuBar.add(jMenuInt);

        jMenuNac.setBackground(new java.awt.Color(204, 204, 204));
        jMenuNac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/national.png"))); // NOI18N
        jMenuNac.setText("Costos");
        jMenuNac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemGestion1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemGestion1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemGestion1.setText("Gestión de operaciones nacionales");
        jMenuItemGestion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestion1ActionPerformed(evt);
            }
        });
        jMenuNac.add(jMenuItemGestion1);

        jMenuItemIngreso1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemIngreso1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemIngreso1.setText("Ingresar nuevas operaciones al sistema");
        jMenuItemIngreso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIngreso1ActionPerformed(evt);
            }
        });
        jMenuNac.add(jMenuItemIngreso1);

        jMenuItemDarDeBaja1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemDarDeBaja1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemDarDeBaja1.setText("Eliminar operación del sistema");
        jMenuItemDarDeBaja1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDarDeBaja1ActionPerformed(evt);
            }
        });
        jMenuNac.add(jMenuItemDarDeBaja1);

        jMenuItemCompradoresVendedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemCompradoresVendedores.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemCompradoresVendedores.setText("Compradores y vendedores");
        jMenuItemCompradoresVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCompradoresVendedoresActionPerformed(evt);
            }
        });
        jMenuNac.add(jMenuItemCompradoresVendedores);

        jMenuBar.add(jMenuNac);

        jMenuCont.setBackground(new java.awt.Color(204, 204, 204));
        jMenuCont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contenedor1.png"))); // NOI18N
        jMenuCont.setText("Pricing y costing");
        jMenuCont.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemGestionC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemGestionC.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemGestionC.setText("Gestionar contenedores");
        jMenuItemGestionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGestionCActionPerformed(evt);
            }
        });
        jMenuCont.add(jMenuItemGestionC);

        jMenuItemIngresoC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemIngresoC.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemIngresoC.setText("Ingresar nuevo contenedor al sistema");
        jMenuItemIngresoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIngresoCActionPerformed(evt);
            }
        });
        jMenuCont.add(jMenuItemIngresoC);

        jMenuItemDarDeBajaC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemDarDeBajaC.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemDarDeBajaC.setText("Eliminar contenedor del sistema");
        jMenuItemDarDeBajaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDarDeBajaCActionPerformed(evt);
            }
        });
        jMenuCont.add(jMenuItemDarDeBajaC);

        jMenuBar.add(jMenuCont);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionActionPerformed

        
        
    }//GEN-LAST:event_jMenuItemGestionActionPerformed

    private void jMenuItemIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIngresoActionPerformed

      IngresarGasto ingresarGasto = new IngresarGasto();
      ingresarGasto.setVisible(true);
      this.dispose();
        
    }//GEN-LAST:event_jMenuItemIngresoActionPerformed

    private void jButtonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver2ActionPerformed

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolver2ActionPerformed

    private void jMenuItemDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDarDeBajaActionPerformed

      
    }//GEN-LAST:event_jMenuItemDarDeBajaActionPerformed

    private void jMenuItemGestion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestion1ActionPerformed
  
        
    }//GEN-LAST:event_jMenuItemGestion1ActionPerformed

    private void jMenuItemIngreso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIngreso1ActionPerformed
      
        
    }//GEN-LAST:event_jMenuItemIngreso1ActionPerformed

    private void jMenuItemDarDeBaja1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDarDeBaja1ActionPerformed
        
 
        
    }//GEN-LAST:event_jMenuItemDarDeBaja1ActionPerformed

    private void jMenuItemGestionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGestionCActionPerformed
        

        
    }//GEN-LAST:event_jMenuItemGestionCActionPerformed

    private void jMenuItemIngresoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIngresoCActionPerformed
        

        
    }//GEN-LAST:event_jMenuItemIngresoCActionPerformed

    private void jMenuItemDarDeBajaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDarDeBajaCActionPerformed


        
    }//GEN-LAST:event_jMenuItemDarDeBajaCActionPerformed

    private void jMenuItemCompradoresVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCompradoresVendedoresActionPerformed

        
    }//GEN-LAST:event_jMenuItemCompradoresVendedoresActionPerformed
 
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
            java.util.logging.Logger.getLogger(Finanzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Finanzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Finanzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Finanzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Finanzas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuCont;
    private javax.swing.JMenu jMenuInt;
    private javax.swing.JMenuItem jMenuItemCompradoresVendedores;
    private javax.swing.JMenuItem jMenuItemDarDeBaja;
    private javax.swing.JMenuItem jMenuItemDarDeBaja1;
    private javax.swing.JMenuItem jMenuItemDarDeBajaC;
    private javax.swing.JMenuItem jMenuItemGestion;
    private javax.swing.JMenuItem jMenuItemGestion1;
    private javax.swing.JMenuItem jMenuItemGestionC;
    private javax.swing.JMenuItem jMenuItemIngreso;
    private javax.swing.JMenuItem jMenuItemIngreso1;
    private javax.swing.JMenuItem jMenuItemIngresoC;
    private javax.swing.JMenu jMenuNac;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}