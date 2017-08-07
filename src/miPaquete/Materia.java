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
public class Materia {
    
    private String clave;
    private String nrc;
    private String nombre; 
    private String codigoMaestro;
    private String departamento;
    private String horario;
    private int horas; 
    private String salon;
    private int cupo;
    private String[] alumnos = new String[30];
    private double[] calificacionAlumnos = new double[30];
    private int contadorDeAlumnosRegistrados = 0;
    
    public void setContadorDeAlumnosRegistrados(int contadorDeAlumnosRegistrados){
        this.contadorDeAlumnosRegistrados = contadorDeAlumnosRegistrados;
    }
    
    public int getContadorDeAlumnosRegistrados(){
        return contadorDeAlumnosRegistrados;
    }
    

    public Materia(String clave, String nrc, String nombre, String codigoMaestro, String departamento, String horario, int horas, String salon, int cupo) {
        this.clave = clave;
        this.nrc = nrc;
        this.nombre = nombre;
        this.codigoMaestro = codigoMaestro;
        this.departamento = departamento;
        this.horario = horario;
        this.horas = horas;
        this.salon = salon;
        this.cupo = cupo;
    }
    
    
    public void setCalificacionAlumnos(double[] calificacionAlumnos) {
        this.calificacionAlumnos = calificacionAlumnos;
    }

    public double[] getCalificacionAlumnos() {
        return calificacionAlumnos;
    }
    
    public String[] getAlumnos() {
        return alumnos;
    }
    
    public String revisarAlumnoRegistrado(String codigo){
        
        for (int i = 0; i < contadorDeAlumnosRegistrados; i++) {
            if (alumnos[i].equals(codigo)) {
                return "encontrado";
            }
        }
        return "No encontrado";
    
    }
    
    public String getAlumnos(int index){
        return alumnos[index];
    }

    public void setAlumnos(String[] alumnos) {
        this.alumnos = alumnos;
    }
    
    public boolean registrarAlumnos(int index, String codigo) {
        if (getContadorDeAlumnosRegistrados()<getCupo()) {
            this.alumnos[index]= codigo;
            contadorDeAlumnosRegistrados++;
            return true;
        }else{
            System.out.println("Ya no hay cupos en esa materia");
            return false;
        }
        
    }
    
    public void setCalificacion(double calificacion,int index){
        this.calificacionAlumnos[index]= calificacion;
    }
    
    public double getCalificacion(int index){
        return calificacionAlumnos[index];
    }
    
    public String getClave() {
        return clave;
    }

    public String getNRC() {
        return nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoMaestro() {
        return codigoMaestro;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getHorario() {
        return horario;
    }

    public int getHoras() {
        return horas;
    }

    public String getSalon() {
        return salon;
    }

    public int getCupo() {
        return cupo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNRC(String nrc) {
        this.nrc = nrc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoMaestro(String codigoMaestro) {
        this.codigoMaestro = codigoMaestro;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    
    
    public void mostrarDatos(){
        
    
        System.out.println("Clave: "+getClave());
        System.out.println("nrc: "+getNRC());
        System.out.println("Nombre: "+getNombre());
        System.out.println("Maestro: "+getCodigoMaestro());
        System.out.println("Departamento: "+getDepartamento());
        System.out.println("Horario: "+getHorario());
        System.out.println("Horas: "+getHoras());
        System.out.println("Salón: "+getSalon());
        System.out.println("Cupo: "+getCupo());
        
    }
    
    public void imprimirLista(){
    
        for(int x=0;x<contadorDeAlumnosRegistrados;x++)
            System.out.println("Codigo: "+alumnos[x]);
    
    }
    
}
