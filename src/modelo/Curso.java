/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import utilidades.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author Pruebas
 */
public class Curso {
    private int id;
    private String nombreProfesor, nombreCurso;

    public Curso(int id, String nombreProfesor, String nombreCurso) {
        this.id = id;
        this.nombreProfesor = nombreProfesor;
        this.nombreCurso = nombreCurso;
    }

    public int getId() {
        return id;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }
    
    public static ArrayList<Curso> getCursos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        
        ConexionBD conexion = new ConexionBD();
        try {
            PreparedStatement ps = conexion.getConnection().prepareStatement("SELECT id_curso, nombre_curso, nombre_profesor FROM curso");
            
            ResultSet resultado = ps.executeQuery();
            
            while (resultado.next()) {
                int idCurso = resultado.getInt("id_curso");
                String nombreCurso = resultado.getString("nombre_curso");
                String nombreProfesor = resultado.getString("nombre_profesor");
                
                Curso c = new Curso(idCurso, nombreProfesor, nombreCurso);
                
                cursos.add(c);
            }
            
        } catch(Exception e) {
            System.out.println("Error al consultar los cursos: " + e.getMessage());
        }
        
        return cursos;
    }
    
    public static Curso getCursoById(int idCurso) {
        ConexionBD conexion = new ConexionBD();
        try {
            PreparedStatement ps = conexion.getConnection().prepareStatement("SELECT id_curso, nombre_curso, nombre_profesor FROM curso WHERE id_curso = ?");
            
            ps.setInt(1, idCurso);
            
            ResultSet resultado = ps.executeQuery();
            
            while (resultado.next()) {
                int id = resultado.getInt("id_curso");
                String nombreCurso = resultado.getString("nombre_curso");
                String nombreProfesor = resultado.getString("nombre_profesor");
                
                Curso c = new Curso(id, nombreProfesor, nombreCurso);
                
                return c;
            }
            
        } catch(Exception e) {
            System.out.println("Error al consultar los cursos: " + e.getMessage());
        }
        return null;
    }
}
