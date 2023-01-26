package Daniela.ComexApp.Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import service.PDFContactosImpl;
import service.PDFOperacionesImpl;
import service.PDFProduccionImpl;
import service.ReportesEstadisticasExportacionesImpl;
import service.ReportesEstadisticasGeneralesImpl;

/**
 *
 * @author Daniela
 */
public class Informes extends javax.swing.JFrame {

     String usuario = "", rol = "", nombreCompleto = "";
    /**
     * Creates new form Informes
     */
    public Informes() {
        initComponents();
        
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        
        usuario = paginaPrincipal.usuario;
        nombreCompleto = paginaPrincipal.nombreCompleto;
      
        
        setTitle("Informes y reportes - " + usuario + " - sistema ComexApp");    
    }

    // icono
    public Image getLogo(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/loguito1.png"));
        return retValue;   
    }
    
    PDFContactosImpl pdfContactos = new PDFContactosImpl();
    PDFProduccionImpl pdfProduccion = new PDFProduccionImpl();
    PDFOperacionesImpl pdfOperaciones = new PDFOperacionesImpl();
    
    

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
        jMonthChooser = new com.toedter.calendar.JMonthChooser();
        jYearChooser = new com.toedter.calendar.JYearChooser();
        jDayChooser = new com.toedter.calendar.JDayChooser();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuInformes = new javax.swing.JMenu();
        jMenuContactos = new javax.swing.JMenu();
        jMenuItemTodos = new javax.swing.JMenuItem();
        jMenuItemExportadores = new javax.swing.JMenuItem();
        jMenuItemImportadores = new javax.swing.JMenuItem();
        jMenuItemDespachantes = new javax.swing.JMenuItem();
        jMenuItemTransporte = new javax.swing.JMenuItem();
        jMenuItemAgenda = new javax.swing.JMenuItem();
        jMenuProduccion = new javax.swing.JMenu();
        jMenuItemTodo = new javax.swing.JMenuItem();
        jMenuItemStock = new javax.swing.JMenuItem();
        jMenuItemSuministros = new javax.swing.JMenuItem();
        jMenuOperaciones = new javax.swing.JMenu();
        jMenuItemTodas = new javax.swing.JMenuItem();
        jMenuItemInternacionales = new javax.swing.JMenuItem();
        jMenuItemNacionales = new javax.swing.JMenuItem();
        jMenuInformePersonalizado = new javax.swing.JMenu();
        jMenuItemPers = new javax.swing.JMenuItem();
        jMenuReportesYEstadisticas = new javax.swing.JMenu();
        jMenuReportes = new javax.swing.JMenu();
        jMenuItemTodos1 = new javax.swing.JMenuItem();
        jMenuItemExportadores1 = new javax.swing.JMenuItem();
        jMenuEstadisticas = new javax.swing.JMenu();
        jMenuItemOpsInt = new javax.swing.JMenuItem();
        jMenuItemOpsNac = new javax.swing.JMenuItem();
        jMenuDocumentos = new javax.swing.JMenu();
        jMenuDocumentacion = new javax.swing.JMenu();
        jMenuItemSubir = new javax.swing.JMenuItem();
        jMenuItemBuscar = new javax.swing.JMenuItem();

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
        jPanel1.add(jButtonVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 94, -1));

        jMonthChooser.setBackground(new java.awt.Color(0, 0, 153));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        jMonthChooser.setBorder(dropShadowBorder1);
        jPanel1.add(jMonthChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        jYearChooser.setBorder(dropShadowBorder2);
        jPanel1.add(jYearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));
        jPanel1.add(jDayChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 880));

        jMenuBar.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar.setForeground(new java.awt.Color(0, 0, 153));

        jMenuInformes.setBackground(new java.awt.Color(204, 204, 204));
        jMenuInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf.png"))); // NOI18N
        jMenuInformes.setText("Informes");
        jMenuInformes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuContactos.setForeground(new java.awt.Color(0, 0, 153));
        jMenuContactos.setText("Contactos");
        jMenuContactos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemTodos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemTodos.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemTodos.setText("Todos");
        jMenuItemTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTodosActionPerformed(evt);
            }
        });
        jMenuContactos.add(jMenuItemTodos);

        jMenuItemExportadores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemExportadores.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemExportadores.setText("Exportadores");
        jMenuItemExportadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportadoresActionPerformed(evt);
            }
        });
        jMenuContactos.add(jMenuItemExportadores);

        jMenuItemImportadores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemImportadores.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemImportadores.setText("Importadores");
        jMenuItemImportadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportadoresActionPerformed(evt);
            }
        });
        jMenuContactos.add(jMenuItemImportadores);

        jMenuItemDespachantes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemDespachantes.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemDespachantes.setText("Despachantes");
        jMenuItemDespachantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDespachantesActionPerformed(evt);
            }
        });
        jMenuContactos.add(jMenuItemDespachantes);

        jMenuItemTransporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemTransporte.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemTransporte.setText("Marítimas y aereo");
        jMenuItemTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransporteActionPerformed(evt);
            }
        });
        jMenuContactos.add(jMenuItemTransporte);

        jMenuItemAgenda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemAgenda.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemAgenda.setText("Contactos personales");
        jMenuItemAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgendaActionPerformed(evt);
            }
        });
        jMenuContactos.add(jMenuItemAgenda);

        jMenuInformes.add(jMenuContactos);

        jMenuProduccion.setForeground(new java.awt.Color(0, 0, 153));
        jMenuProduccion.setText("Producción");
        jMenuProduccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemTodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemTodo.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemTodo.setText("Todo");
        jMenuItemTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTodoActionPerformed(evt);
            }
        });
        jMenuProduccion.add(jMenuItemTodo);

        jMenuItemStock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemStock.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemStock.setText("Stock");
        jMenuItemStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStockActionPerformed(evt);
            }
        });
        jMenuProduccion.add(jMenuItemStock);

        jMenuItemSuministros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemSuministros.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemSuministros.setText("Suministros");
        jMenuItemSuministros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSuministrosActionPerformed(evt);
            }
        });
        jMenuProduccion.add(jMenuItemSuministros);

        jMenuInformes.add(jMenuProduccion);

        jMenuOperaciones.setForeground(new java.awt.Color(0, 0, 153));
        jMenuOperaciones.setText("Operaciones");
        jMenuOperaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemTodas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemTodas.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemTodas.setText("Todas");
        jMenuItemTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTodasActionPerformed(evt);
            }
        });
        jMenuOperaciones.add(jMenuItemTodas);

        jMenuItemInternacionales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemInternacionales.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemInternacionales.setText("Internacionales");
        jMenuItemInternacionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInternacionalesActionPerformed(evt);
            }
        });
        jMenuOperaciones.add(jMenuItemInternacionales);

        jMenuItemNacionales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemNacionales.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemNacionales.setText("Nacionales");
        jMenuItemNacionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNacionalesActionPerformed(evt);
            }
        });
        jMenuOperaciones.add(jMenuItemNacionales);

        jMenuInformes.add(jMenuOperaciones);

        jMenuInformePersonalizado.setForeground(new java.awt.Color(0, 0, 153));
        jMenuInformePersonalizado.setText("Informes personalizados");
        jMenuInformePersonalizado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemPers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemPers.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemPers.setText("Personalizar");
        jMenuItemPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPersActionPerformed(evt);
            }
        });
        jMenuInformePersonalizado.add(jMenuItemPers);

        jMenuInformes.add(jMenuInformePersonalizado);

        jMenuBar.add(jMenuInformes);

        jMenuReportesYEstadisticas.setBackground(new java.awt.Color(204, 204, 204));
        jMenuReportesYEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        jMenuReportesYEstadisticas.setText("Reportes y estadísticas");
        jMenuReportesYEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuReportes.setForeground(new java.awt.Color(0, 0, 153));
        jMenuReportes.setText("Reportes ");
        jMenuReportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemTodos1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemTodos1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemTodos1.setText("Exportaciones");
        jMenuItemTodos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTodos1ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItemTodos1);

        jMenuItemExportadores1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemExportadores1.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemExportadores1.setText("Importaciones");
        jMenuItemExportadores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportadores1ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItemExportadores1);

        jMenuReportesYEstadisticas.add(jMenuReportes);

        jMenuEstadisticas.setForeground(new java.awt.Color(0, 0, 153));
        jMenuEstadisticas.setText("Estadísticas");
        jMenuEstadisticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemOpsInt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemOpsInt.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemOpsInt.setText("Operaciones internacionales");
        jMenuItemOpsInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpsIntActionPerformed(evt);
            }
        });
        jMenuEstadisticas.add(jMenuItemOpsInt);

        jMenuItemOpsNac.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemOpsNac.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemOpsNac.setText("Operaciones nacionales");
        jMenuItemOpsNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpsNacActionPerformed(evt);
            }
        });
        jMenuEstadisticas.add(jMenuItemOpsNac);

        jMenuReportesYEstadisticas.add(jMenuEstadisticas);

        jMenuBar.add(jMenuReportesYEstadisticas);

        jMenuDocumentos.setBackground(new java.awt.Color(204, 204, 204));
        jMenuDocumentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doc.png"))); // NOI18N
        jMenuDocumentos.setText("Documentos");
        jMenuDocumentos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuDocumentacion.setForeground(new java.awt.Color(0, 0, 153));
        jMenuDocumentacion.setText("Documentación");
        jMenuDocumentacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemSubir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemSubir.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemSubir.setText("Subir");
        jMenuItemSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSubirActionPerformed(evt);
            }
        });
        jMenuDocumentacion.add(jMenuItemSubir);

        jMenuItemBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemBuscar.setForeground(new java.awt.Color(0, 0, 153));
        jMenuItemBuscar.setText("Buscar");
        jMenuItemBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBuscarActionPerformed(evt);
            }
        });
        jMenuDocumentacion.add(jMenuItemBuscar);

        jMenuDocumentos.add(jMenuDocumentacion);

        jMenuBar.add(jMenuDocumentos);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver2ActionPerformed

        PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
        paginaPrincipal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonVolver2ActionPerformed

    private void jMenuItemTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTodosActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfContactos.pdfTodosLosContactos(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemTodosActionPerformed

    private void jMenuItemExportadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportadoresActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfContactos.pdfExportadores(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemExportadoresActionPerformed

    private void jMenuItemImportadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportadoresActionPerformed
       
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfContactos.pdfImportadores(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemImportadoresActionPerformed

    private void jMenuItemDespachantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDespachantesActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfContactos.pdfDespachantes(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemDespachantesActionPerformed

    private void jMenuItemTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransporteActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfContactos.pdfMaritimasAereo(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemTransporteActionPerformed

    private void jMenuItemAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgendaActionPerformed
       
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfContactos.pdfAgendaPersonal(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemAgendaActionPerformed

    private void jMenuItemStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStockActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfProduccion.pdfStock(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemStockActionPerformed

    private void jMenuItemTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTodoActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfProduccion.pdfTodoDeProduccion(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemTodoActionPerformed

    private void jMenuItemSuministrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSuministrosActionPerformed
       
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfProduccion.pdfSuministros(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemSuministrosActionPerformed

    private void jMenuItemTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTodasActionPerformed
       
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfOperaciones.pdfTodasLasOperaciones(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemTodasActionPerformed

    private void jMenuItemInternacionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInternacionalesActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfOperaciones.pdfOperacionesInternacionales(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemInternacionalesActionPerformed

    private void jMenuItemNacionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNacionalesActionPerformed
        
        String dia = String.valueOf(jDayChooser.getDay());
        String mes = String.valueOf(jMonthChooser.getMonth() + 1);
        String año = String.valueOf(jYearChooser.getYear());
        
        pdfOperaciones.pdfOperacionesNacionales(usuario, nombreCompleto, dia, mes, año);
        
    }//GEN-LAST:event_jMenuItemNacionalesActionPerformed

    private void jMenuItemTodos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTodos1ActionPerformed
        
        ReportesEstadisticasExportacionesImpl expos = new ReportesEstadisticasExportacionesImpl();
        int exposTotales = expos.cantidadDeOperacionesDeExportacionTotales();
        JOptionPane.showMessageDialog(null, exposTotales + " exportaciones fueron "
                + "registradas en ComexApp");
        
    }//GEN-LAST:event_jMenuItemTodos1ActionPerformed

    private void jMenuItemExportadores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportadores1ActionPerformed
       
        ReportesEstadisticasGeneralesImpl total = new ReportesEstadisticasGeneralesImpl();
        int totalOps = total.cantidadDeOperacionesInternacionalesRegistradas();
        JOptionPane.showMessageDialog(null, totalOps + " operaciones totales fueron "
                + "registradas en el sistema de ComexApp");
        
    }//GEN-LAST:event_jMenuItemExportadores1ActionPerformed

    private void jMenuItemOpsIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpsIntActionPerformed
       
        EstadisticasGeneralesOperaciones estats = new EstadisticasGeneralesOperaciones();
        estats.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemOpsIntActionPerformed

    private void jMenuItemOpsNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpsNacActionPerformed
        
        EstadisticasGeneralesOperacionesNacionales estatsNac = new EstadisticasGeneralesOperacionesNacionales();
        estatsNac.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemOpsNacActionPerformed

    private void jMenuItemPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPersActionPerformed
        
        InformesPersonalizados informesPersonalizados = new InformesPersonalizados();
        informesPersonalizados.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemPersActionPerformed

    private void jMenuItemSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSubirActionPerformed
        
        CargarDocumento cargarDoc = new CargarDocumento();
        cargarDoc.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jMenuItemSubirActionPerformed

    private void jMenuItemBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver2;
    private com.toedter.calendar.JDayChooser jDayChooser;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuContactos;
    private javax.swing.JMenu jMenuDocumentacion;
    private javax.swing.JMenu jMenuDocumentos;
    private javax.swing.JMenu jMenuEstadisticas;
    private javax.swing.JMenu jMenuInformePersonalizado;
    private javax.swing.JMenu jMenuInformes;
    private javax.swing.JMenuItem jMenuItemAgenda;
    private javax.swing.JMenuItem jMenuItemBuscar;
    private javax.swing.JMenuItem jMenuItemDespachantes;
    private javax.swing.JMenuItem jMenuItemExportadores;
    private javax.swing.JMenuItem jMenuItemExportadores1;
    private javax.swing.JMenuItem jMenuItemImportadores;
    private javax.swing.JMenuItem jMenuItemInternacionales;
    private javax.swing.JMenuItem jMenuItemNacionales;
    private javax.swing.JMenuItem jMenuItemOpsInt;
    private javax.swing.JMenuItem jMenuItemOpsNac;
    private javax.swing.JMenuItem jMenuItemPers;
    private javax.swing.JMenuItem jMenuItemStock;
    private javax.swing.JMenuItem jMenuItemSubir;
    private javax.swing.JMenuItem jMenuItemSuministros;
    private javax.swing.JMenuItem jMenuItemTodas;
    private javax.swing.JMenuItem jMenuItemTodo;
    private javax.swing.JMenuItem jMenuItemTodos;
    private javax.swing.JMenuItem jMenuItemTodos1;
    private javax.swing.JMenuItem jMenuItemTransporte;
    private javax.swing.JMenu jMenuOperaciones;
    private javax.swing.JMenu jMenuProduccion;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenu jMenuReportesYEstadisticas;
    private com.toedter.calendar.JMonthChooser jMonthChooser;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JYearChooser jYearChooser;
    // End of variables declaration//GEN-END:variables
}
