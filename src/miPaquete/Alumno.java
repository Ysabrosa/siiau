/*
 * Clase Alumno
 * Clase con los atributos más importantes para representar computacionalmente
 * Un objeto de tipo Alumno con atributos como nombre, código, carrera, promedio, 
 *situación, nivel, cliclo de admisión, ultimo ciclo, Centro Universitario y créditos
 */
package miPaquete;

/**
 *
 * @author leox01
 */
public class Alumno {
    
    
    private String nombre;
    private String codigo;
    private String carrera;
    private double promedio;
    private String situacion;
    private String nivel;
    private String admision;
    private String ultimoCiclo;
    private String centro;
    private int creditos;
    private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
   

    public String getNombre() {
        return nombre;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setAdmision(String admision) {
        this.admision = admision;
    }

    public void setUltimoCiclo(String ultimoCiclo) {
        this.ultimoCiclo = ultimoCiclo;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getSituacion() {
        return situacion;
    }

    public String getNivel() {
        return nivel;
    }

    public String getAdmision() {
        return admision;
    }

    public String getUltimoCiclo() {
        return ultimoCiclo;
    }

    public String getCentro() {
        return centro;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        
        
        return promedio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

   

    public Alumno(String nombre, String codigo, String carrera, double promedio, String situacion, String nivel, String admision, String ultimoCiclo, String centro, int creditos,String pass) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.carrera = carrera;
        this.promedio = promedio;
        this.situacion = situacion;
        this.nivel = nivel;
        this.admision = admision;
        this.ultimoCiclo = ultimoCiclo;
        this.centro = centro;
        this.creditos = creditos;
        this.pass = pass;
    }
    
    
    
    public void mostrarDatos(){
    
        System.out.println("Nombre: "+getNombre());
        System.out.println("Código: "+getCodigo());
        System.out.println("Carrera: "+getCarrera());
        System.out.println("Promedio: "+getPromedio());
        System.out.println("Situación: "+getSituacion());
        System.out.println("Nivel: "+getNivel());
        System.out.println("Admisión: "+getAdmision());
        System.out.println("Ultimo ciclo: "+getUltimoCiclo());
        System.out.println("Centro Universitario: "+getCentro());
        System.out.println("Créditos: "+getCreditos());
    
    
    }
    
    
    
}
