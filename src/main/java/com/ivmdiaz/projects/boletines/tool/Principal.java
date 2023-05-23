/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.ProtectionPolicy;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.ivmdiaz.projects.boletines.tool.modelo.Estudiante;

/**
 *
 * @author idiaz@cx.local
 */
public class Principal extends javax.swing.JFrame {

    private File archivoPdf;
    private File archivoCorreos;
    private Map<Estudiante, PDDocument> lstBoletines;

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        jButtonDividirBoletines = new javax.swing.JButton();
        jCheckBoxCifrado = new javax.swing.JCheckBox();
        jButtonEnviarBoletines = new javax.swing.JButton();
        jButtonCargarArchivo = new javax.swing.JButton();
        jScrollPaneTextResultado = new javax.swing.JScrollPane();
        txaResultado = new javax.swing.JTextArea();
        jButtonCargarArchivoConfiguracion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 650));

        jButtonDividirBoletines.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jButtonDividirBoletines.setText("Descargar Boletines");
        jButtonDividirBoletines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDividirBoletinesActionPerformed(evt);
            }
        });

        jCheckBoxCifrado.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jCheckBoxCifrado.setText("Agregar contraseña ");
        jCheckBoxCifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCifradoActionPerformed(evt);
            }
        });

        jButtonEnviarBoletines.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jButtonEnviarBoletines.setText("Enviar Boletines");
        jButtonEnviarBoletines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarBoletinesActionPerformed(evt);
            }
        });

        jButtonCargarArchivo.setText("Cargar boletín unificado");
        jButtonCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarArchivoActionPerformed(evt);
            }
        });

        txaResultado.setColumns(20);
        txaResultado.setRows(5);
        jScrollPaneTextResultado.setViewportView(txaResultado);

        jButtonCargarArchivoConfiguracion.setText("Cargar configuracion correos");
        jButtonCargarArchivoConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarArchivoConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonDividirBoletines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEnviarBoletines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBoxCifrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCargarArchivo)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCargarArchivoConfiguracion))
                            .addComponent(jScrollPaneTextResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCargarArchivo)
                    .addComponent(jButtonCargarArchivoConfiguracion))
                .addGap(24, 24, 24)
                .addComponent(jScrollPaneTextResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jCheckBoxCifrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDividirBoletines)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnviarBoletines)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDividirBoletinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDividirBoletinesActionPerformed

        try {
            if (lstBoletines != null && !lstBoletines.isEmpty()) {
                final JFileChooser f = new JFileChooser();
                f.setFileSelectionMode(1);
                f.showSaveDialog(null);
                final File carpeta = new File(f.getSelectedFile().getAbsolutePath() + "/" + archivoPdf.getName().replaceAll(".pdf", ""));
                carpeta.mkdirs();
                System.out.println(carpeta);
                for (final Map.Entry<Estudiante, PDDocument> entry : lstBoletines.entrySet()) {
                    final Estudiante estudiante = entry.getKey();
                    final PDDocument pdf = entry.getValue();
                    final AccessPermission ap = new AccessPermission();
                    ap.setCanPrint(false);
                    ap.setCanExtractContent(false);
                    final StandardProtectionPolicy spp = new StandardProtectionPolicy(estudiante.getNiup(),
                            estudiante.getNiup(), ap);
                    if (this.jCheckBoxCifrado.isSelected()) {
                        spp.setEncryptionKeyLength(128);
                        spp.setPermissions(ap);
                        pdf.protect((ProtectionPolicy) spp);
                    }
                    final File pdfFile = new File(carpeta.getAbsolutePath() + "/" + estudiante.toString() + ".pdf");
                    pdf.save(pdfFile);
                    pdf.close();
                }
                JOptionPane.showMessageDialog(this, "Se han dividido los boletines correctamente: [" + lstBoletines.size() + "]", "Boletines partidos", 1);
            } else {
                JOptionPane.showMessageDialog(this, "Error. Debe cargar un archivo PDF con boletines", "Error", 0);
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error no se pudo generar los boletines", "Error", 0);
        }
    }//GEN-LAST:event_jButtonDividirBoletinesActionPerformed

    private void jCheckBoxCifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCifradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxCifradoActionPerformed

    private void jButtonEnviarBoletinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarBoletinesActionPerformed

        try {
            if (lstBoletines != null && !lstBoletines.isEmpty()) {

            } else {
                JOptionPane.showMessageDialog(this, "Error. Debe cargar un archivo PDF con boletines", "Error", 0);
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error no se pudo enviar los boletines", "Error", 0);
        }

    }//GEN-LAST:event_jButtonEnviarBoletinesActionPerformed

    private void jButtonCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarArchivoActionPerformed
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", new String[]{"pdf"}));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        final int result = fileChooser.showOpenDialog(this);
        if (result == 0) {
            try {
                final File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                this.archivoPdf = selectedFile;
                this.procesarPdf();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error no se pudo cargar el archivo", "Error", 0);
            }
        }
    }//GEN-LAST:event_jButtonCargarArchivoActionPerformed

    private void jButtonCargarArchivoConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarArchivoConfiguracionActionPerformed

        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", new String[]{"pdf"}));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        final int result = fileChooser.showOpenDialog(this);
        if (result == 0) {
            try {
                final File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                this.archivoCorreos = selectedFile;
                this.procesarArchivoCorreosExcel();
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error no se pudo cargar el archivo", "Error", 0);
            }
        }
    }//GEN-LAST:event_jButtonCargarArchivoConfiguracionActionPerformed

    public void procesarPdf() throws IOException {

        if (this.archivoPdf != null && this.archivoPdf.exists()) {

            this.txaResultado.setText("");
            this.lstBoletines = new HashMap<>();
            final PDDocument document = Loader.loadPDF(this.archivoPdf);
            final Splitter splitter = new Splitter();
            final List<PDDocument> pages = (List<PDDocument>) splitter.split(document);
            final Iterator<PDDocument> iterator = pages.listIterator();
            final Map<Estudiante, List<PDDocument>> mapPaginas = new HashMap<>();

            while (iterator.hasNext()) {
                final PDDocument paginaPdf = iterator.next();
                this.procesarPaginaPdf(paginaPdf, mapPaginas);
            }

            this.construirBoletines(mapPaginas);
            this.actualizarEspacioTrabajo();

        }
    }

    public void procesarPaginaPdf(PDDocument paginaPdf,
            Map<Estudiante, List<PDDocument>> mapPaginas) throws IOException {

        final PDFTextStripper stripper = new PDFTextStripper();
        final String text = stripper.getText(paginaPdf);
        final String[] textoDividido = text.split("\\r?\\n");
        String linea_anterior = "";

        String flagIdentificador = null;
        String flagNombre = null;

        if (!paginaPdf.isEncrypted()) {
            for (int i = 0; i < textoDividido.length; ++i) {
                final String linea = textoDividido[i];
                if (i > 0) {
                    linea_anterior = textoDividido[i - 1];
                }
                if (linea.contains("NUIP.") || linea.contains("NIP.") || linea.contains("CE.") || linea.contains("SED.")) {
                    if (flagIdentificador == null) {
                        flagIdentificador = this.obtenerIdentificacion(linea);
                    } else if (!flagIdentificador.equals(this.obtenerIdentificacion(linea))) {
                        flagIdentificador = this.obtenerIdentificacion(linea);
                    }
                } else if (linea_anterior.trim().startsWith("P\u00e1gina")) {
                    flagNombre = this.obtenerNombre(linea);
                }
            }
            this.putEstudianteInMapEstudiantes(mapPaginas, flagIdentificador, flagNombre, paginaPdf);
        }
    }

    public String obtenerIdentificacion(String linea) {
        String niup = linea.trim().replaceAll("\\D+", "");
        return niup;
    }

    public String obtenerNombre(String linea) {
        String nombre = linea.trim();
        return nombre;
    }

    public void putEstudianteInMapEstudiantes(final Map<Estudiante, List<PDDocument>> map, final String niup, final String nombre, final PDDocument value) {
        final boolean encontro = false;
        for (final Map.Entry<Estudiante, List<PDDocument>> entry : map.entrySet()) {
            final Estudiante key = entry.getKey();
            if (key.getNiup() != null && key.getNiup().equals(niup)) {
                entry.getValue().add(value);
                return;
            }
        }
        if (!encontro) {
            final List<PDDocument> list = new ArrayList<PDDocument>();
            list.add(value);
            final Estudiante estudiante = new Estudiante(niup, nombre);
            map.put(estudiante, list);
        }
    }

    public void construirBoletines(Map<Estudiante, List<PDDocument>> mapPaginas) throws IOException {

        for (final Map.Entry<Estudiante, List<PDDocument>> entry : mapPaginas.entrySet()) {
            final Estudiante estudiante = entry.getKey();
            final List<PDDocument> paginas = entry.getValue();
            PDDocument destino = null;
            for (int i = 0; i < paginas.size(); ++i) {
                if (i == 0) {
                    destino = paginas.get(i);
                } else {
                    final PDFMergerUtility PDFmerger = new PDFMergerUtility();
                    PDFmerger.appendDocument(destino, (PDDocument) paginas.get(i));
                }
            }
            this.lstBoletines.put(estudiante, destino);
        }
    }
    
    public void actualizarEspacioTrabajo() {

        for (final Map.Entry<Estudiante, PDDocument> entry : lstBoletines.entrySet()) {
            this.txaResultado.append(entry.getKey().toString() + "\n");
        }
    }

    public void procesarArchivoCorreosExcel() throws FileNotFoundException, IOException {

        FileInputStream excelFile = new FileInputStream(this.archivoCorreos);

        final Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        DataFormatter formatter = new DataFormatter();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();

            Cell cellNiup = currentRow.getCell(3);
            Cell cellCorreoPersonal = currentRow.getCell(8);
            Cell cellCorreoInstitucional = currentRow.getCell(9);

            if (cellNiup == null) {
                break;
            }
            
            asignarCorreoEstudiante(
                    formatter.formatCellValue(cellCorreoPersonal).replaceAll("\\.", ""), 
                    formatter.formatCellValue(cellCorreoPersonal), 
                    formatter.formatCellValue(cellCorreoInstitucional));

        }
        
        this.actualizarEspacioTrabajo();

    }

    public void asignarCorreoEstudiante(final String niup, final String correoPersonal, final String correoInstitucional) {
        
        /*
        lstBoletines.entrySet().stream()
                .filter(item -> item.getKey().getNiup().equals(niup)).findFirst()
                .ifPresent(entry -> {
                    entry.getKey().setPersonalEmail(correoPersonal);
                    entry.getKey().setCompanyEmail(correoInstitucional);

        });
        */
    }
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCargarArchivo;
    private javax.swing.JButton jButtonCargarArchivoConfiguracion;
    private javax.swing.JButton jButtonDividirBoletines;
    private javax.swing.JButton jButtonEnviarBoletines;
    private javax.swing.JCheckBox jCheckBoxCifrado;
    private javax.swing.JScrollPane jScrollPaneTextResultado;
    private javax.swing.JTextArea txaResultado;
    // End of variables declaration//GEN-END:variables
}
