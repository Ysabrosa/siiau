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
public class Profesor {
    
    
    private String codigo;
    private String nombre;
    private int antiguedad;
    private String fechaDeNacimiento;
    private boolean puesto;
    private String pass;

    public Profesor(String codigo, String nombre, int antiguedad, String fechaDeNacimiento, boolean puesto,String pass) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.puesto = puesto;
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

    public boolean isPuesto() {
        return puesto;
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

    
    public void setPuesto(boolean puesto) {
        this.puesto = puesto;
    }
    
    
    public void mostrarDatos(){
    
        System.out.println("Código: "+getCodigo());
        System.out.println("Nombre: "+getNombre());
        System.out.println("Antigüedad: "+getAntiguedad());
        System.out.println("Fecha de Nacimiento: "+getFechaDeNacimiento());
        System.out.println("Departamento            Materia ");
        
        if(puesto){
            System.out.println("Es administrativo");
        }
        
        
    
    }
    
}
