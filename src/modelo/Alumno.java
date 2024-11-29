/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import utilidades.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pruebas
 */
public class Alumno {
    private int id;
    private String nombreCompleto, nombreApoderado;
    private LocalDate fechaNacimiento;
    private Curso curso;
    
    private ConexionBD conexion;

    public Alumno(String nombreCompleto, String nombreApoderado, LocalDate fechaNacimiento, Curso curso) {
        this.nombreCompleto = nombreCompleto;
        this.nombreApoderado = nombreApoderado;
        this.fechaNacimiento = fechaNacimiento;
        this.curso = curso;
        
        this.conexion = new ConexionBD();
    }

    public Alumno(int id, String nombreCompleto, String nombreApoderado, LocalDate fechaNacimiento, Curso curso) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreApoderado = nombreApoderado;
        this.fechaNacimiento = fechaNacimiento;
        this.curso = curso;
        
        this.conexion = new ConexionBD();
    }
    
    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNombreApoderado() {
        return nombreApoderado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Curso getCurso() {
        return curso;
    }
    
    public static ArrayList<Alumno> getAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        ConexionBD conexion = new ConexionBD();
        try {
            PreparedStatement ps = conexion.getConnection().prepareStatement("SELECT id_alumno, nombre_completo, nombre_apoderado, fecha_nacimiento, id_curso FROM alumno");
            
            ResultSet resultado = ps.executeQuery();
            
            while (resultado.next()) {
                int idAlumno = resultado.getInt("id_alumno");
                String nombreCompleto = resultado.getString("nombre_completo");
                String nombreApoderado = resultado.getString("nombre_apoderado");
                LocalDate fechaNacimiento = resultado.getObject("fecha_nacimiento", LocalDate.class);
                int idCurso = resultado.getInt("id_curso");
                
                Curso c = Curso.getCursoById(idCurso);
                
                Alumno a = new Alumno(idAlumno, nombreCompleto, nombreApoderado, fechaNacimiento, c);
                
                alumnos.add(a);
            }
            
        } catch(Exception e) {
            System.out.println("Error al consultar los cursos: " + e.getMessage());
        }
        
        return alumnos;
    }
    
    public static void deleteAlumno(int id) {
        try {
            PreparedStatement ps = new ConexionBD().getConnection().prepareStatement("DELETE FROM alumno where id_alumno = ?");
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        } catch(Exception e) {
            System.out.println("Error al borrar alumno: " + e.getMessage());
        }
    }
    
    public void actualizarAlumno() {
        try {
            PreparedStatement ps = this.conexion.getConnection().prepareStatement("UPDATE alumno SET nombre_completo = ?, nombre_apoderado = ?, fecha_nacimiento = ?, id_curso = ? WHERE id_alumno = ?");
            
            ps.setString(1, this.nombreCompleto);
            ps.setString(2, this.nombreApoderado);
            ps.setObject(3, this.fechaNacimiento);
            ps.setInt(4, this.curso.getId());
            ps.setInt(5, this.id);
            
            ps.executeUpdate();
            
        } catch(Exception e) {
            System.out.println("Error al actualizar alumno: " + e.getMessage());
        }
    }
    
    public void agregarAlumno() {
        try {
            PreparedStatement ps = this.conexion.getConnection().prepareStatement("INSERT INTO alumno(nombre_completo, nombre_apoderado, fecha_nacimiento, id_curso) VALUES(?, ?, ?, ?)");
            
            ps.setString(1, this.nombreCompleto);
            ps.setString(2, this.nombreApoderado);
            ps.setObject(3, this.fechaNacimiento);
            ps.setInt(4, this.curso.getId());
            
            ps.executeUpdate();
            
        } catch(Exception e) {
            System.out.println("Error al agregar alumno: " + e.getMessage());
        }
    }
}
