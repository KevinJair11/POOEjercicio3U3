/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Chuquitarco.Util;
import beu.Curso;
import beu.Matricula;
import bll.GestionCurso;
import bll.GestionMatricula;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author labctr
 */
public class frmReporteCalificaciones extends javax.swing.JInternalFrame {

    private final  String titulo= "Reporte de Calificaciones";
    private GestionCurso cursosBll = new GestionCurso();
    private GestionMatricula matriculaBll = new GestionMatricula();
    private List<Curso> cursos;
    private List<Matricula> calificaciones;
    private final DefaultTableModel dmtCalificaciones = new DefaultTableModel();
    
    private void configurarModeloTabla(){
        String columnas[] = {"Nombre","Promedio","Estado"};
        this.dmtCalificaciones.setColumnIdentifiers(columnas);
        this.tblReporteCalificaciones.setModel(dmtCalificaciones);
    }
    
    private void leerCurso(){
        try {
            Curso ficticio = new Curso("-Seleccione-",0.0f,"");
            this.cmbCurso.addItem(ficticio);
            cursos = cursosBll.getCursos();
            //Exprecion lambda
            cursos.forEach((c) -> {
                this.cmbCurso.addItem(c);
            });
        } catch (Exception e) {
            Util.imprimir("Error: "+e.toString()+"\n");
            vtnPrincipal.verMensaje("Error al leer cursos", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarMatricula() throws IOException{
        Curso Seleccionado = (Curso)this.cmbCurso.getSelectedItem();
        calificaciones = matriculaBll.reportar(Seleccionado.getTitulo());
        MostarCalificaciones();
    }
    
    private void MostarCalificaciones(){
        DecimalFormat f = new DecimalFormat("##.##"); 
        int lim = this.dmtCalificaciones.getRowCount()-1;
        for (int i = lim; i >= 0; i--) {
            this.dmtCalificaciones.removeRow(i);
        }
        
        for (Matricula m : calificaciones){
            Vector fila = new Vector();
            fila.addElement(m.getEstudiante());
            fila.addElement(f.format(m.getPromedio()));
            fila.addElement(m.getEstado());
            this.dmtCalificaciones.addRow(fila);
        }
        this.tblReporteCalificaciones.setModel(dmtCalificaciones);
    }
    
    public frmReporteCalificaciones() {
        initComponents();
        leerCurso();
        configurarModeloTabla();
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        cmbCurso = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteCalificaciones = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reporte de calificaciones");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel1.setText("Curso:");

        btnBuscar.setIcon(new javax.swing.ImageIcon("/home/labctr/NetBeansProjects/iconos/search.png")); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblReporteCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblReporteCalificaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(cmbCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            buscarMatricula();
        } catch (Exception e) {
            Util.imprimir("\nError"+e.toString()+"\n");
            //vtnPrincipal.verMensaje("Error al buscar Matrícula ",titulo,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<Curso> cmbCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReporteCalificaciones;
    // End of variables declaration//GEN-END:variables
}
