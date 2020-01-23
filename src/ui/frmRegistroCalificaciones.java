/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Chuquitarco.Util;
import bll.GestionMatricula;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class frmRegistroCalificaciones extends javax.swing.JInternalFrame {
    

    private final  String titulo= "Registro de Calificaciones";
    private GestionMatricula matriculaBll = new GestionMatricula();
    
    
    private boolean validar(){
        float nota = (float)this.spnValor.getValue();
        if(nota==0f){
            vtnPrincipal.verMensaje("Calificacion no válida", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void consultarMatricula() throws IOException{
        String numero = this.txtNMatricula.getText();
        matriculaBll.consultar(numero);
        this.txtDatosMatricula.setText(matriculaBll.imprimir());
    }
    
    private String Calificar() throws IOException{
        DecimalFormat f = new DecimalFormat("##.##");
        float nota = (float)this.spnValor.getValue();
        f.format(nota);
        String mensaje = matriculaBll.Calificar(nota);
        matriculaBll.Archivar();
        return mensaje;
    }

    
    
    public frmRegistroCalificaciones() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegistro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNMatricula = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlDatosMatricula = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatosMatricula = new javax.swing.JTextArea();
        pnlCalificacion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        spnValor = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REGISTRO DE CALIFICACIONES");

        lblRegistro.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        lblRegistro.setText("Registro de Calificaciones");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel1.setText("N° de Matricula:");

        btnBuscar.setIcon(new javax.swing.ImageIcon("/home/labctr/NetBeansProjects/iconos/search.png")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        pnlDatosMatricula.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de la matricula"));

        txtDatosMatricula.setColumns(20);
        txtDatosMatricula.setRows(5);
        jScrollPane1.setViewportView(txtDatosMatricula);

        javax.swing.GroupLayout pnlDatosMatriculaLayout = new javax.swing.GroupLayout(pnlDatosMatricula);
        pnlDatosMatricula.setLayout(pnlDatosMatriculaLayout);
        pnlDatosMatriculaLayout.setHorizontalGroup(
            pnlDatosMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlDatosMatriculaLayout.setVerticalGroup(
            pnlDatosMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosMatriculaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pnlCalificacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Calificación"));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel2.setText("Valor:");

        spnValor.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(20.0f), Float.valueOf(0.01f)));

        javax.swing.GroupLayout pnlCalificacionLayout = new javax.swing.GroupLayout(pnlCalificacion);
        pnlCalificacion.setLayout(pnlCalificacionLayout);
        pnlCalificacionLayout.setHorizontalGroup(
            pnlCalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalificacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spnValor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        pnlCalificacionLayout.setVerticalGroup(
            pnlCalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalificacionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlCalificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spnValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlDatosMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(txtNMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(lblRegistro)))
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlCalificacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblRegistro)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlDatosMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(validar()){
                String mensaje = this.Calificar();
                vtnPrincipal.verMensaje(mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            Util.imprimir("\nError"+e.toString()+"\n");
            vtnPrincipal.verMensaje("Error al guardar Matícula ",titulo,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            this.consultarMatricula();
            vtnPrincipal.verMensaje("Busqueda correcta ",titulo,JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            Util.imprimir("\nError"+e.toString()+"\n");
            vtnPrincipal.verMensaje("Error al buscar Matrícula ",titulo,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JPanel pnlCalificacion;
    private javax.swing.JPanel pnlDatosMatricula;
    private javax.swing.JSpinner spnValor;
    private javax.swing.JTextArea txtDatosMatricula;
    private javax.swing.JTextField txtNMatricula;
    // End of variables declaration//GEN-END:variables
}
