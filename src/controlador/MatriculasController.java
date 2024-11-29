/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Curso;

/**
 *
 * @author Pruebas
 */
public class MatriculasController {
    public ArrayList<Curso> getCursos() {
        return Curso.getCursos();
    }
    
    public void matricularAlumno(String nombreCompleto, String nombreApoderado, LocalDate fechaNacimiento, Curso curso) {
        Alumno nuevoAlumno = new Alumno(nombreCompleto, nombreApoderado, fechaNacimiento, curso);
        nuevoAlumno.agregarAlumno();
    }
    
    public ArrayList<Alumno> getAlumnos() {
        return Alumno.getAlumnos();
    }
    
    public void editarAlumno(int idAlumno, String nombreCompleto, String nombreApoderado, LocalDate fechaNacimiento, Curso curso) {
        Alumno alumnoEditar = new Alumno(idAlumno, nombreCompleto, nombreApoderado, fechaNacimiento, curso);
        alumnoEditar.actualizarAlumno();
    }
    
    public void eliminarAlumno(int idAlumno) {
        Alumno.deleteAlumno(idAlumno);
    }
}
