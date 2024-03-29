package Daniela.ComexApp.Frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import service.ReportesEstadisticasCompraImpl;
import service.ReportesEstadisticasExportacionesImpl;
import service.ReportesEstadisticasGeneralesImpl;
import service.ReportesEstadisticasImportacionesImpl;
import service.ReportesEstadisticasVentaLocalImpl;

/**
 *
 * @author Daniela
 */
public class EstadisticasGeneralesOperacionesNacionales extends javax.swing.JFrame {

     String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form EstadisticasGeneralesOperaciones
     */
    public EstadisticasGeneralesOperacionesNacionales() {
        initComponents();
        
        setSize(1000, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Estadísticas de operaciones nacionales - " + usuario + " - sistema ComexApp");
        repaint();    
        
        jLabelVentas.setText("Ventas: " + cantidadVentas);
        jLabelCompras.setText("Compras: " + cantidadCompras);
        jLabelTotal.setText("Total operaciones: " + totalOpsNac);
        
        jLabelEmpresaVentas.setText("Mayores ventas a: " + mayorComprador);
        jLabelEmpresaCompras.setText("Mayores compras a: " + mayorVendedor);
        jLabelProductosMasVendido.setText("Producto más vendido: " + productoMasVendido);
        jLabelProductosMasComprado.setText("Producto más comprado: " + productoMasComprado);
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    ReportesEstadisticasVentaLocalImpl reportesVenta = new ReportesEstadisticasVentaLocalImpl();
    int cantidadVentas = reportesVenta.cantidadDeOperacionesDeVentaTotales();
    String mayorComprador = reportesVenta.compradorMasRepetido();
    String productoMasVendido = reportesVenta.productoMasVendido();
    
    ReportesEstadisticasCompraImpl reportesCompra = new ReportesEstadisticasCompraImpl();
    int cantidadCompras = reportesCompra.cantidadDeOperacionesDeCompraTotales();
    String mayorVendedor = reportesCompra.vendedorMasRepetido();
    String productoMasComprado = reportesCompra.productoMasComprado();
    
    ReportesEstadisticasGeneralesImpl reportesGenerales = new ReportesEstadisticasGeneralesImpl();
    int totalOpsNac = reportesGenerales.cantidadDeOperacionesNacionalesRegistradas();
  

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
        jLabelTitulo = new javax.swing.JLabel();
        jLabelVentas = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelCompras = new javax.swing.JLabel();
        jLabelEmpresaVentas = new javax.swing.JLabel();
        jLabelEmpresaCompras = new javax.swing.JLabel();
        jLabelProductosMasVendido = new javax.swing.JLabel();
        jLabelProductosMasComprado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVolver2.setBackground(new java.awt.Color(102, 102, 102));
        jButtonVolver2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver2.setText("Volver");
        jButtonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 680, 94, -1));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Operaciones nacionales");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabelVentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelVentas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cubo.png"))); // NOI18N
        jLabelVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 200, 200));

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cubo.png"))); // NOI18N
        jLabelTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        jLabelCompras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCompras.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cubo.png"))); // NOI18N
        jLabelCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        jLabelEmpresaVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresaVentas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresaVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrito.png"))); // NOI18N
        jLabelEmpresaVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelEmpresaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 80));

        jLabelEmpresaCompras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmpresaCompras.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmpresaCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrito.png"))); // NOI18N
        jLabelEmpresaCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelEmpresaCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, 250, 80));

        jLabelProductosMasVendido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductosMasVendido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductosMasVendido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rectangulo.png"))); // NOI18N
        jLabelProductosMasVendido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelProductosMasVendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, 80));

        jLabelProductosMasComprado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProductosMasComprado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProductosMasComprado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rectangulo.png"))); // NOI18N
        jLabelProductosMasComprado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelProductosMasComprado, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, -1, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1500, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver2ActionPerformed

        Informes informes = new Informes();
        informes.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolver2ActionPerformed

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
            java.util.logging.Logger.getLogger(EstadisticasGeneralesOperacionesNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadisticasGeneralesOperacionesNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadisticasGeneralesOperacionesNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadisticasGeneralesOperacionesNacionales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadisticasGeneralesOperacionesNacionales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver2;
    private javax.swing.JLabel jLabelCompras;
    private javax.swing.JLabel jLabelEmpresaCompras;
    private javax.swing.JLabel jLabelEmpresaVentas;
    private javax.swing.JLabel jLabelProductosMasComprado;
    private javax.swing.JLabel jLabelProductosMasVendido;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelVentas;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


    public int OperacionMasNumerosa (int cantidadVentas, int cantidadCompras){
       
        int operacionMasRepetida = 0;
        
        if(cantidadVentas > cantidadCompras){
            return cantidadVentas;
        } else if (cantidadCompras > cantidadVentas){
            return cantidadCompras;
        }
        return operacionMasRepetida;
    }
     
    int operacionMasRepetida = OperacionMasNumerosa(cantidadVentas, cantidadCompras);
    
  @Override
    public void paint(Graphics g){
        super.paint(g);

        int largoVentas = cantidadVentas * 400 / operacionMasRepetida;
        int largoCompras = cantidadCompras * 400 / operacionMasRepetida;
        
        g.setColor(new Color(255, 255, 255));
        g.fillRect(100, 80, largoVentas, 40);
        g.drawString("Ventas registradas: " + cantidadVentas, 100, 70);
        
        g.setColor(new Color(204,204,204));
        g.fillRect(100, 150, largoCompras, 40);
        g.drawString("Compras registras: " + cantidadCompras , 100, 145);
        
    }


}
