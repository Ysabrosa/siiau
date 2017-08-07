/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miPaquete;

/**
 *
 * @author leox01
 */
public class Administrativo {
    
    private String codigo;
    private String nombre;
private int antiguedad;
    private String fechaDeNacimiento;
    private String cargo;
    private String gradoAcademico;
    private String pass;
    
    public Administrativo(String codigo, String nombre, int antiguedad, String fechaDeNaciemiento, String cargo, String gradoAcademico,String pass){
    
        this.codigo = codigo;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.fechaDeNacimiento = fechaDeNaciemiento;
        this.cargo = cargo;
        this.gradoAcademico = gradoAcademico;
        this.pass = pass;
        
    
    }
    
    public void setPass(String pass){
        this.pass=pass;
    }
    
    public String getPass(){
        return pass;
    }
    
    public void setCodigo(String codigo){
    
        this.codigo = codigo;
    
    }
    
    public String getCodigo(){
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    
    
    
    public void mostrarDatos(){
    
    
        System.out.println("Código: "+getCodigo());
        System.out.println("Nombre: "+getNombre());
        System.out.println("Antigüedad: "+getAntiguedad());
        System.out.println("Fecha de Nacimiento: "+getFechaDeNacimiento());
        System.out.println("Cargo: "+getCargo());
        System.out.println("Grado Academico "+getGradoAcademico());
    
    }
    
    
}
