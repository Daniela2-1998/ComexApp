package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import service.ArchivosPersonalesImpl;
import service.PDFContactosImpl;
import service.PDFOperacionesImpl;
import service.PDFProduccionImpl;
import service.ReportesEstadisticasExportacionesImpl;
import service.ReportesEstadisticasGeneralesImpl;

/**
 *
 * @author Daniela
 */
public class CargarDocumento extends javax.swing.JFrame {

     String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form CargarDocumento
     */
    public CargarDocumento() {
        initComponents();
        
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
        
        setTitle("Cargar documento - " + usuario + " - sistema ComexApp");  
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    ArchivosPersonalesImpl archivosPers = new ArchivosPersonalesImpl();
    
    
    
    public void cargaArchivos(){
        Scanner entrada = null;
        try {
 
            String ruta = jFileChooser.getSelectedFile().getAbsolutePath();
            File archivo = new File(ruta);
            entrada = new Scanner(archivo);
            FileInputStream fis = new FileInputStream(archivo);
            FileFilter filtro = new FileNameExtensionFilter("Archivos (.pdf)", "pdf"); 
            jFileChooser.setFileFilter(filtro);
           
            while(entrada.hasNext()){
                System.out.println(entrada.nextLine());
            }
            
            //if(jFileChooser.accept(archivo)){
                int ID = Integer.parseInt(textID.getText().trim());
                LocalDate fechaActual = LocalDate.now();
                String fecha = String.valueOf(fechaActual);
                String nombre = textNombre.getText().trim();
                
                archivosPers.subidaArchivos(ID, fis, archivo, fecha, nombre);
           // }
            
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("No se eligio ningun archivo");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if(entrada != null){
                entrada.close();
            }
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

        jPanel1 = new javax.swing.JPanel();
        jButtonVolver2 = new javax.swing.JButton();
        jFileChooser = new javax.swing.JFileChooser();
        jButtonSubir = new javax.swing.JButton();
        textNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getLogo());
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVolver2.setBackground(new java.awt.Color(0, 0, 153));
        jButtonVolver2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonVolver2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver2.setText("Volver");
        jButtonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 94, -1));

        jFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooser.setCurrentDirectory(new java.io.File("C:\\Documents"));
        jFileChooser.setDialogTitle("Elige un documento para cargar");
        jFileChooser.setFileHidingEnabled(true);
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jFileChooser.setBorder(dropShadowBorder1);
        jPanel1.add(jFileChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 680, -1));

        jButtonSubir.setBackground(new java.awt.Color(0, 0, 153));
        jButtonSubir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSubir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSubir.setText("Subir archivo");
        jButtonSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSubir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 170, -1));

        textNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textNombre.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 110, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Nombre archivo:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("N° archivo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        textID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textID.setForeground(new java.awt.Color(0, 0, 153));
        jPanel1.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver2ActionPerformed

        Informes informes = new Informes();
        informes.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolver2ActionPerformed

    private void jButtonSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubirActionPerformed
        
        cargaArchivos();
        
    }//GEN-LAST:event_jButtonSubirActionPerformed

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
            java.util.logging.Logger.getLogger(CargarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarDocumento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CargarDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSubir;
    private javax.swing.JButton jButtonVolver2;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
