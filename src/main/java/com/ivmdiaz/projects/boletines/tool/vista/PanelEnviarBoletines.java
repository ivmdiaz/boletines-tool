/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.ivmdiaz.projects.boletines.tool.vista;

import com.ivmdiaz.projects.boletines.tool.Principal;
import com.ivmdiaz.projects.boletines.tool.modelo.Boletin;
import com.ivmdiaz.projects.boletines.tool.modelo.ConfiguracionCorreo;
import com.ivmdiaz.projects.boletines.tool.modelo.CorreoBoletinEstudiante;
import com.ivmdiaz.projects.boletines.tool.modelo.Directorio;
import com.ivmdiaz.projects.boletines.tool.negocio.EnvioCorreo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idiaz@cx.local
 */
public class PanelEnviarBoletines extends javax.swing.JPanel {

    private File carpetaBoletines;
    private final List<Directorio> directorioList;
    private final ConfiguracionCorreo configuracionCorreo;
    private List<Boletin> boletinesParaEnviar = new ArrayList<>();
    private List<Boletin> boletinesPendientesEnviar = new ArrayList<>();


    /**
     * Creates new form Directorio
     */
    public PanelEnviarBoletines(final List<Directorio> directorioList,
            final ConfiguracionCorreo configuracionCorreo) {
        initComponents();
        this.directorioList = directorioList;
        this.configuracionCorreo = configuracionCorreo;
        this.actualizarTablaParaEnviar();
        this.actualizarTablaPendientesEnviar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        btnCargarCarpeta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListosEnviar = new javax.swing.JTable();
        btnEnviarCorreos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePendientesEnviar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 600));

        title.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        title.setText("Enviar boletines");

        btnCargarCarpeta.setText("Cargar carpeta");
        btnCargarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarCarpetaActionPerformed(evt);
            }
        });

        tableListosEnviar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Niup", "Correo personal", "Correo alternativo", "Archivo"
            }
        ));
        jScrollPane1.setViewportView(tableListosEnviar);

        btnEnviarCorreos.setText("Enviar correos");
        btnEnviarCorreos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreosActionPerformed(evt);
            }
        });

        tablePendientesEnviar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Niup", "Correo personal", "Correo alternativo", "Archivo"
            }
        ));
        jScrollPane2.setViewportView(tablePendientesEnviar);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Listos para enviar");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Pendientes por correo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(title)
                                .addComponent(btnCargarCarpeta)
                                .addComponent(jLabel1)
                                .addComponent(btnEnviarCorreos))
                            .addGap(0, 764, Short.MAX_VALUE))))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(title)
                .addGap(47, 47, 47)
                .addComponent(btnCargarCarpeta)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnviarCorreos)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarCarpetaActionPerformed
        final JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        final int result = fileChooser.showOpenDialog(this);
        if (result == 0) {
            try {
                final File selectedFolder = fileChooser.getSelectedFile();
                System.out.println("Selected folder: " + selectedFolder.getAbsolutePath());
                this.carpetaBoletines = selectedFolder;
                this.procesarCarpetaBoletines();
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Error no se pudo cargar el archivo", "Error", 0);
            }
        }
    }//GEN-LAST:event_btnCargarCarpetaActionPerformed

    private void btnEnviarCorreosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreosActionPerformed

        enviarCorreos();
        actualizarTablaParaEnviar();
        
        JOptionPane.showMessageDialog(this, "Se ha enviado los boletines correctamente.", "Directorio correo", 1);

    }//GEN-LAST:event_btnEnviarCorreosActionPerformed

    public void enviarCorreos() {
        
        final EnvioCorreo envioCorreo = new EnvioCorreo();

        final Iterator<Boletin> iterator = boletinesParaEnviar.listIterator();

        while (iterator.hasNext()) {
            final Boletin boletin = iterator.next();

            System.out.println("Procesando envio de boletín");

            try {
                final CorreoBoletinEstudiante plantilla = new CorreoBoletinEstudiante(boletin);
                envioCorreo.sendEmail(configuracionCorreo, plantilla);

                final String origin = boletin.getArchivo().getAbsolutePath();
                final String destDir = carpetaBoletines.getAbsolutePath() + "/enviados";
                final String destination = destDir + "/" + boletin.getArchivo().getName();
                moveFileDirectory(origin, destDir, destination);

                System.out.println("Boletín Procesado");
                iterator.remove();

            } catch (final MessagingException ex) {
                System.err.println("Error procesando envio de boletín 1");
                Logger.getLogger(PanelEnviarBoletines.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.err.println("Error procesando envio de boletín 2");
                Logger.getLogger(PanelEnviarBoletines.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void moveFileDirectory(String origin, String destDir, String destination) throws IOException {

        Path FROM = Paths.get(origin);
        Path TO = Paths.get(destination);
        File directory = new File(String.valueOf(destDir));

        if (!directory.exists()) {
            directory.mkdir();
        }
        //overwrite the destination file if it exists, and copy
        // the file attributes, including the rwx permissions
        CopyOption[] options = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES

        };
        Files.copy(FROM, TO, options);
        Files.delete(FROM);

    }

    public void procesarCarpetaBoletines() throws FileNotFoundException, IOException {

        if (this.carpetaBoletines.exists()) {

            this.boletinesParaEnviar = new ArrayList<>();
            this.boletinesPendientesEnviar = new ArrayList<>();

            final File[] boletines = this.carpetaBoletines.listFiles();
            for (final File boletinFile : boletines) {

                if (boletinFile.getName().endsWith(".pdf")) {

                    final String niup = boletinFile.getName().split("-")[0].trim().replaceFirst("^0+(?!$)", "");
                    final String nombre = boletinFile.getName().split("-")[1].replaceAll(".pdf", "").trim();

                    final Boletin boletin = new Boletin();
                    boletin.setArchivo(boletinFile);
                    boletin.setNiup(niup);
                    boletin.setNombre(nombre);

                    final Optional<Directorio> optDirectorio = this.directorioList.stream()
                            .filter(directorio -> directorio.getNiup().equals(niup))
                            .findFirst();

                    if (optDirectorio.isPresent()) {
                        boletin.setDirectorio(optDirectorio.get());
                        this.boletinesParaEnviar.add(boletin);
                    } else {
                        this.boletinesPendientesEnviar.add(boletin);
                    }
                }

            }

            this.actualizarTablaParaEnviar();
            this.actualizarTablaPendientesEnviar();

        }
    }

    private void actualizarTablaParaEnviar() {

        final DefaultTableModel tableModel = new DefaultTableModel();
        this.tableListosEnviar = new JTable(tableModel);

        tableModel.addColumn("Niup");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Correo personal");
        tableModel.addColumn("Correo alternativo");

        this.boletinesParaEnviar.forEach(boletin -> {

            String correoPersonal = null;
            String correoAlternativo = null;

            if (boletin.getDirectorio() != null) {
                correoPersonal = boletin.getDirectorio().getCorreoPersonal();
                correoAlternativo = boletin.getDirectorio().getCorreoAlternativo();
            }

            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                boletin.getNiup(),
                boletin.getNombre(),
                correoPersonal,
                correoAlternativo
            });

        });

        jScrollPane1.setViewportView(tableListosEnviar);
    }

    private void actualizarTablaPendientesEnviar() {

        final DefaultTableModel tableModel = new DefaultTableModel();
        this.tablePendientesEnviar = new JTable(tableModel);

        tableModel.addColumn("Niup");
        tableModel.addColumn("Nombre");

        this.boletinesPendientesEnviar.forEach(boletin -> {
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{
                boletin.getNiup(),
                boletin.getNombre()
            });

        });

        jScrollPane2.setViewportView(tablePendientesEnviar);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarCarpeta;
    private javax.swing.JButton btnEnviarCorreos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableListosEnviar;
    private javax.swing.JTable tablePendientesEnviar;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
