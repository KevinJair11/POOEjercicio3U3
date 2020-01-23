
package ui;

import Chuquitarco.Util;
import beu.Curso;
import beu.Estudiante;
import bll.GestionCurso;
import bll.GestionEstudiante;
import bll.GestionMatricula;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class frmRegistroMatricula extends javax.swing.JInternalFrame {

    private final  String titulo= "Registro de matriculas";
    //Servicio / bussines logic layer
    private GestionCurso cursosBll = new GestionCurso();
    private List<Curso> cursos = new ArrayList<>();
    private GestionEstudiante estudiantesBll = new GestionEstudiante();
    private List<Estudiante> estudiantes = new ArrayList<>();
    private GestionMatricula matriculaBll = new GestionMatricula();
    
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
    
    private boolean Validar(){
        Curso cr = (Curso)this.cmbCurso.getSelectedItem();
        Estudiante est = (Estudiante)this.cmbEstudiante.getSelectedItem();
        if(est.getNombre().equals("-Seleccione-")){
            vtnPrincipal.verMensaje("Estudiante no valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (cr.getTitulo().equals("-Seleccione-")){
            vtnPrincipal.verMensaje("Curso no valido", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        
        return true;
        
    }
    
    private void CrearMatricula() throws IOException{
        Curso cr = (Curso)this.cmbCurso.getSelectedItem();
        Estudiante est = (Estudiante)this.cmbEstudiante.getSelectedItem();
        matriculaBll.crear();
        matriculaBll.configurar(cr, est);
        matriculaBll.Archivar();
    }
    
    private void leerEstudiantes(){
        try{
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("-Seleccione-");
            estudiante.setApellido("");
            cmbEstudiante.addItem(estudiante);
            estudiantes = estudiantesBll.leerEstudiantes();
            /*for(Estudiante e : estudiantes){
            this.cmbEstudiante.addItem(e);
            }*/
            estudiantes.forEach((e) -> {
                this.cmbEstudiante.addItem(e);
            });
            
        } catch (Exception e) {
            Util.imprimir("Error: "+e.toString()+"\n");
            vtnPrincipal.verMensaje("Error al leer estudiantes", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public frmRegistroMatricula() {
        initComponents();
        leerCurso();
        leerEstudiantes();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegistro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbEstudiante = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REGISTRO DE MATRÍCULAS");

        lblRegistro.setFont(new java.awt.Font("Ubuntu", 3, 18)); // NOI18N
        lblRegistro.setText("Registro de matrícula");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel1.setText("Estudiante:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 3, 15)); // NOI18N
        jLabel2.setText("Curso:");

        btnGuardar.setIcon(new javax.swing.ImageIcon("/home/labctr/NetBeansProjects/iconos/save.png")); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(50, 50, 50)
                        .addComponent(cmbEstudiante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblRegistro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblRegistro)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if(Validar()){
                CrearMatricula();
                vtnPrincipal.verMensaje("Matrícula agregado correctamente", titulo, JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        } catch (Exception e) {
            Util.imprimir("\nError"+e.toString()+"\n");
            vtnPrincipal.verMensaje("Error al Guardar",titulo,JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Curso> cmbCurso;
    private javax.swing.JComboBox<Estudiante> cmbEstudiante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblRegistro;
    // End of variables declaration//GEN-END:variables
}
