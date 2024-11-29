/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.MatriculasController;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.Alumno;
import modelo.Curso;

/**
 *
 * @author Pruebas
 */
public class EditarDialog extends javax.swing.JDialog {
    ArrayList<Curso> cursos;
    MatriculasController controller;
    Alumno alumno;
    
    VerAlumnosDialog vad;

    /**
     * Creates new form MatricularDialog
     */
    public EditarDialog(java.awt.Frame parent, boolean modal, Alumno alumno, VerAlumnosDialog vad) {
        super(parent, modal);
        initComponents();
        
        this.alumno = alumno;
        
        this.cursos = new ArrayList<>();
        this.controller = new MatriculasController();
        this.vad = vad;
        
        this.cargarCursos();
        this.cargarAlumno();
    }
    
    private void cargarAlumno() {
        this.txtNombreCompleto.setText(this.alumno.getNombreCompleto());
        this.txtNombreApoderado.setText(this.alumno.getNombreApoderado());
        LocalDate fechaNacimiento = this.alumno.getFechaNacimiento();
        this.txtFechaNacimiento.setText(fechaNacimiento.getDayOfMonth() + "/" + fechaNacimiento.getMonthValue() + "/" + fechaNacimiento.getYear());
        
        Curso curso = this.alumno.getCurso();
        int selectedCursoIndex = -1;
        for (Curso c: this.cursos) {
            if (c.getId() == curso.getId()) {
                selectedCursoIndex = this.cursos.indexOf(c);
            }
        }
        
        this.cboCurso.setSelectedIndex(selectedCursoIndex);
    }

    private void cargarCursos() {
        this.cursos = controller.getCursos();
        
        DefaultComboBoxModel model = (DefaultComboBoxModel)this.cboCurso.getModel();
        
        for (Curso curso: this.cursos) {
            model.addElement(curso.getNombreCurso());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        txtNombreApoderado = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        cboCurso = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnMatricular = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre completo");

        jLabel2.setText("Nombre apoderado");

        jLabel3.setText("Fecha de nacimiento");

        jLabel4.setText("Curso");

        jLabel5.setText("Ej: 31/12/2000");

        btnMatricular.setText("Editar");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreCompleto))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaNacimiento)
                            .addComponent(cboCurso, 0, 97, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreApoderado))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMatricular)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreApoderado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMatricular)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        String nombreCompleto = this.txtNombreCompleto.getText();
        String nombreApoderado = this.txtNombreApoderado.getText();
        String fechaNacimientoStr = this.txtFechaNacimiento.getText();
        
        String[] fechaNacimientoSplitted = fechaNacimientoStr.split("/"); // ["31", "12", "2020"]
        LocalDate fechaNacimiento = LocalDate.of(
                                            Integer.parseInt(fechaNacimientoSplitted[2]), 
                                            Integer.parseInt(fechaNacimientoSplitted[1]), 
                                            Integer.parseInt(fechaNacimientoSplitted[0]));
        
        int selectedCursoIndex = this.cboCurso.getSelectedIndex();
        
        Curso cursor = this.cursos.get(selectedCursoIndex);
        
        this.controller.editarAlumno(this.alumno.getId(), nombreCompleto, nombreApoderado, fechaNacimiento, cursor);
        
        this.vad.cargarAlumnos();
        
        this.setVisible(false);
    }//GEN-LAST:event_btnMatricularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatricular;
    private javax.swing.JComboBox<String> cboCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombreApoderado;
    private javax.swing.JTextField txtNombreCompleto;
    // End of variables declaration//GEN-END:variables
}
