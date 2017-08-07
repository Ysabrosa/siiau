/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miPaquete;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author leox01
 */
public class ControladoraSiiau {

    Scanner tecladoString = new Scanner(System.in);
    Scanner tecladoInt = new Scanner(System.in);
    private final String  codigoAdmin = "admin";
    private final String passWordAdmin = "admin";   
    
    public boolean periodoRegistro = false;
    public boolean periodoSubirCalificaciones = false;
    
    ArrayList<Alumno> alumnos = new ArrayList<>();
    ArrayList<Profesor> profesores = new ArrayList<>();
    ArrayList<Administrativo> administrativos = new ArrayList<>();
    ArrayList<Materia> materias = new ArrayList<>();
    
    
    
    
    public static void main(String[] args) {
        
        ControladoraSiiau siauu = new ControladoraSiiau();
        siauu.login();
       
    }
    
    
    public void login(){
        String codigo,pass;
        int fallosLogin=0;
        do{
            System.out.println("Codigo");
            codigo = tecladoString.nextLine();
            System.out.println("Contraseña");
            pass = tecladoString.nextLine();

            if (codigo.equals(codigoAdmin)&&pass.equals(passWordAdmin)) {
                menuRoot();
                fallosLogin=0;
            }else if(verificarDatosProfesor(codigo,pass)){
                menuProfesor(codigo);
                fallosLogin=0;
            }else if(verificarDatosAlumno(codigo,pass)){
                menuAlumno(codigo);
                fallosLogin=0;
            }else if(verificarDatosAdministravo(codigo,pass)){
                menuAdministrativo(codigo);
                fallosLogin=0;
            }else{
                System.out.println("Código o contraseña incorrectos");
                fallosLogin++;
            }
        }while(fallosLogin<3);
        
    
    }

    private void menuRoot() {
        int opcion=0;
        boolean repetir;
        boolean repetirMenu=true;
        do{
            do{
                System.out.println("Menu Root Principal");
                System.out.println("1.-Alumnos");
                System.out.println("2.-Profesores");
                System.out.println("3.-Administrativo");
                System.out.println("4.-Asignar Periodos");
                System.out.println("5.-Materias");
                System.out.println("6.-Salir");
                try {
                    opcion = tecladoInt.nextInt();
                    if (opcion>6||opcion<1) {
                        System.out.println("Opción no válida");
                        repetir=true;
                    }else
                        repetir=false;
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Opción no válida");
                    repetir = true;
                    tecladoInt.nextLine(); //limpiardor de buffer
                }
            }while(repetir);
        
            switch(opcion){
                case 1:
                    menuAlumnosRoot();
                    break;
                case 2:
                    menuProfesoresRoot();
                    break;
                case 3:
                    menuAdministrativoRoot();
                    break;
                case 4:
                    menuAsignarPeriodos();
                    break;
                case 5:
                    menuMateriasRoot();
                    break;
                case 6: 
                    System.out.println("Cerrando Sesión");
                    repetirMenu=false;
                    break;
            }
        
        }while(repetirMenu);
    
    }

    private void menuProfesor(String codigo) {
        System.out.println("Menu Profesor Principal");
        int opcion=0;
        boolean repetir;
        boolean repetirMenuProfesor=true;
        
        
            
            do {                
                
           
                do{

                    System.out.println("Menu Profesor ");
                    System.out.println("1.-Ver Datos");
                    System.out.println("2.-Cambiar contraseña");
                    System.out.println("3.-Ver Carga Horaria");
                    System.out.println("4.-Ver lista de asistencia");
                    System.out.println("5.-Subir calificaciones");
                    System.out.println("6.-Salir");

                    try {
                            opcion=tecladoInt.nextInt();
                            if(opcion<1||opcion>6){
                                System.out.println("No es una opción válida");
                                repetir=true;
                            }else
                                repetir=false;
                    }catch (Exception e) {
                            System.out.println("No es una opción válida");
                            repetir=true;
                     }

                }while(repetir);


                switch(opcion){

                    case 1:
                        buscarUsuario(1, codigo);
                        break;
                    case 2: 
                        cambiarPasswordUsuario(1,codigo);
                        break;
                    case 3: 
                        verCargaHoraria(codigo);
                        break;
                    case 4:
                        verListaDeAsistencia(codigo);
                        break;
                    case 5:
                        subirCalificaciones(codigo); 
                        break;
                    case 6: 
                        System.out.println("Saliendo del programa");
                        repetirMenuProfesor=false;
                        break;

                }
            
             }while (repetirMenuProfesor);
        
    }

    private void menuAlumno(String codigo) {
        
        boolean repetirMenu;
        int opcion=-1;
        
        do {    
            repetirMenu=true;
            
       
            System.out.println("Menu Alumno Principal");
            System.out.println("1.-Ver Datos");
            System.out.println("2.-Cambiar Contraseña");
            System.out.println("3.-Registrar Materias");
            System.out.println("4.-Revisar horario");
            System.out.println("5.-Ver Calificaciones");
            System.out.println("6.-Salir");
            try {
                opcion=tecladoInt.nextInt();
                
            } catch (Exception e) {
                System.out.println("Opción no válida");
            }
            
            switch(opcion){
                
                case 1:
                    buscarUsuario(0, codigo);
                    break;
                case 2:
                    cambiarPasswordUsuario(0,codigo);
                    break;
                case 3:
                    registrarMateriasAlumno(codigo);
                    break;
                case 4:
                    revisarHorarioAlumno(codigo);
                    break;
                case 5:
                    verCalificaciones(codigo);
                    break;
                case 6:
                    System.out.println("Saliendo");
                    repetirMenu=false;
                    break;
                default: 
                    System.out.println("opción no válida");
            
            }
        
         } while (repetirMenu);
        
    }

    private void menuAdministrativo(String codigo) {
        System.out.println("Menu Administrativos Principal");
        
        boolean repetirMenu=true;
        boolean repetirDatos;
        int opcion=0;
        do {   
            do{
                System.out.println("1.-Registrar Materias Profesor");
                System.out.println("2.-Ver datos Alumnos");
                System.out.println("3.-Ver datos Profesores");
                System.out.println("4.-Cambiar Contraseña");
                System.out.println("5.-Cerrar Sesión");

                try {
                    opcion = tecladoInt.nextInt();
                    if (opcion<1||opcion>5) {
                        repetirDatos=true;
                        System.out.println("Opcion No valida");

                    }else
                        repetirDatos=false;

                } catch (Exception e) {
                    repetirDatos=true;
                    System.out.println("Opcion No valida");
                }


            }while(repetirDatos);
            
            switch(opcion){
            
                case 1:
                    registrarMateriasProfesores();
                    break;
                case 2:
                    verDatosAlumno();
                    break;
                case 3:
                    verDatosProfesores();
                    break;
                case 4:
                    cambiarPasswordUsuario(3,"*");
                case 5:
                    System.out.println("Saliendo");
                    repetirMenu=false;
                    break;
            
            }
            
            
        } while (repetirMenu);
        
        
        
    }

    private boolean verificarDatosProfesor(String codigo, String pass) {
    
        if(!profesores.isEmpty()){
            
            if (profesores.stream().anyMatch((profesor) -> (profesor.getCodigo().equals(codigo)&&profesor.getPass().equals(pass)))) {
                return true;
            }
            
        }
        return false;
    }

    private boolean verificarDatosAlumno(String codigo, String pass) {
    
         if(!alumnos.isEmpty()){
            
             if (alumnos.stream().anyMatch((alumno) -> (alumno.getCodigo().equals(codigo)&&alumno.getPass().equals(pass)))) {
                 return true;
             }
            
        }
        return false;
    }

    private boolean verificarDatosAdministravo(String codigo, String pass) {
        if(!administrativos.isEmpty()){
            
            if (administrativos.stream().anyMatch((administrativo) -> (administrativo.getCodigo().equals(codigo)&&administrativo.getPass().equals(pass)))) {
                return true;
            }
            
        }
        return false;
    }

    private void menuAlumnosRoot() {
    
        boolean repetirMenuAlumnosRoot=true;
        boolean repetirPedirDatos;
        int opcion=0;
        do{
            do{
                System.out.println("Menu Alumnos Root");
                System.out.println("1.-Alta");
                System.out.println("2.-Baja");
                System.out.println("3.-Cambios");
                System.out.println("4.-Buscar");
                System.out.println("5.-Mostrar Todos Registros");
                System.out.println("6.-Regresar");
                try {
                    opcion = tecladoInt.nextInt();
                    if (opcion>6||opcion<1) {
                        System.out.println("Opción no válida");
                        repetirPedirDatos=true;
                    }else{
                       repetirPedirDatos=false;
                    }


                } catch (Exception e) {
                    System.out.println("Opción no válida");
                    repetirPedirDatos=true;
                }
            
            }while(repetirPedirDatos);
            
            switch(opcion){
                
                case 1:
                    altaDeUsuario(0);
                    break;
                case 2:
                    bajaDeUsuario(0);
                    break;
                case 3:
                    cambiosDeUsuario(0);
                    break;
                case 4:
                    buscarUsuario(0,"*");
                    break;
                case 5:
                    mostrarUsuario(0);
                    break;
                case 6:
                    System.out.println("Regresando al menú anterior...");
                    repetirMenuAlumnosRoot = false;
                    break;
            
            }
            
        
        }while (repetirMenuAlumnosRoot);  
    }

    private void menuProfesoresRoot() {
    
        boolean repetirMenuProfesoresRoot=true;
        boolean repetirPedirDatos;
        int opcion=0;
        do{
            do{
                System.out.println("Menu Profesores Root");
                System.out.println("1.-Alta");
                System.out.println("2.-Baja");
                System.out.println("3.-Cambios");
                System.out.println("4.-Buscar");
                System.out.println("5.-Mostrar Todos Registros");
                System.out.println("6.-Regresar");
                try {
                    opcion = tecladoInt.nextInt();
                    if (opcion>6||opcion<1) {
                        System.out.println("Opción no válida");
                        repetirPedirDatos=true;
                    }else{
                       repetirPedirDatos=false;
                    }


                } catch (Exception e) {
                    System.out.println("Opción no válida");
                    repetirPedirDatos=true;
                }
            
            }while(repetirPedirDatos);
            
            switch(opcion){
                
                case 1:
                    altaDeUsuario(1);
                    break;
                case 2:
                    bajaDeUsuario(1);
                    break;
                case 3:
                    cambiosDeUsuario(1);
                    break;
                case 4:
                    buscarUsuario(1,"*");
                    break;
                case 5:
                    mostrarUsuario(1);
                    break;
                case 6:
                    System.out.println("Regresando al menú anterior...");
                    repetirMenuProfesoresRoot = false;
                    break;
            
            }
            
        
        }while (repetirMenuProfesoresRoot);  
    }

    private void menuAdministrativoRoot() {
    
        boolean repetirMenuAdministrativosRoot=true;
        boolean repetirPedirDatos;
        int opcion=0;
        do{
            do{
                System.out.println("Menu Administrativos Root");
                System.out.println("1.-Alta");
                System.out.println("2.-Baja");
                System.out.println("3.-Cambios");
                System.out.println("4.-Buscar");
                System.out.println("5.-Mostrar Todos Registros");
                System.out.println("6.-Regresar");
                try {
                    opcion = tecladoInt.nextInt();
                    if (opcion>6||opcion<1) {
                        System.out.println("Opción no válida");
                        repetirPedirDatos=true;
                    }else{
                       repetirPedirDatos=false;
                    }


                } catch (Exception e) {
                    System.out.println("Opción no válida");
                    repetirPedirDatos=true;
                }
            
            }while(repetirPedirDatos);
            
            switch(opcion){
                
                case 1:
                    altaDeUsuario(2);
                    break;
                case 2:
                    bajaDeUsuario(2);
                    break;
                case 3:
                    cambiosDeUsuario(2);
                    break;
                case 4:
                    buscarUsuario(2,"*");
                    break;
                case 5:
                    mostrarUsuario(2);
                    break;
                case 6:
                    System.out.println("Regresando al menú anterior...");
                    repetirMenuAdministrativosRoot = false;
                    break;
            
            }
            
        
        }while (repetirMenuAdministrativosRoot);
    }

    private void menuAsignarPeriodos() {
    
        int opcion=0;
        boolean repetirMenu = true;
        boolean repetirIngresarDatos;
        do{
            do { 
                System.out.println("Menú Asignar Periodos");
                System.out.println("1.-Periodo de registro");
                System.out.println("2.-Periodo de calificaciones");
                System.out.println("3.-Regresar");

                try {

                    opcion = tecladoInt.nextInt();
                    if (opcion<1||opcion>3) {
                        System.out.println("Opción no valida");
                        repetirIngresarDatos=true;
                    }else
                        repetirIngresarDatos = false;

                } catch (Exception e) {
                    System.out.println("Opción no valida");
                    repetirIngresarDatos = true;
                }

                }while (repetirIngresarDatos);


            if (opcion==1) {

                if (periodoRegistro) {
                    System.out.println("El periodo de registro está actividado");
                    System.out.println("¿Quieres desactivar el periodo de registro? SI o NO");
                    String desactivar = tecladoString.nextLine().toLowerCase();

                    switch (desactivar) {
                        case "si":
                            periodoRegistro = false;
                            System.out.println("Periodo de registro desactivado exitosamente");
                            break;
                        case "no":
                            System.out.println("No se hicieron cambios en el periodo de registro");
                            break;
                        default:
                            System.out.println("respuesta incorrecta");
                            break;
                    }

                }else{
                    System.out.println("El periodo de registro está desactivado");
                    System.out.println("¿Quieres ACTIVAR el periodo de registro? SI o NO");
                    String desactivar = tecladoString.nextLine().toLowerCase();

                    switch (desactivar) {
                        case "si":
                            periodoRegistro = true;
                            System.out.println("Periodo de registro se ACTIVÓ exitosamente");
                            break;
                        case "no":
                            System.out.println("No se hicieron cambios en el periodo de registro");
                            break;
                        default:
                            System.out.println("respuesta incorrecta");
                            break;
                    }
                
                }

            }else if(opcion==2){
                
                if (periodoSubirCalificaciones) {
                    System.out.println("El periodo de calificaciones está actividado");
                    System.out.println("¿Quieres DESACTIVAR el periodo de calificaciones? SI o NO");
                    String desactivar = tecladoString.nextLine().toLowerCase();

                    switch (desactivar) {
                        case "si":
                            periodoSubirCalificaciones = false;
                            System.out.println("Periodo de calificaciones desactivado exitosamente");
                            break;
                        case "no":
                            System.out.println("No se hicieron cambios en el periodo de calificaciones");
                            break;
                        default:
                            System.out.println("respuesta incorrecta");
                            break;
                    }

                }else{
                    System.out.println("El periodo de calificaciones está desactivado");
                    System.out.println("¿Quieres ACTIVAR el periodo de calificaciones? SI o NO");
                    String desactivar = tecladoString.nextLine().toLowerCase();

                    switch (desactivar) {
                        case "si":
                            periodoSubirCalificaciones = true;
                            System.out.println("Periodo de calificaciones se ACTIVÓ exitosamente");
                            break;
                        case "no":
                            System.out.println("No se hicieron cambios en el periodo de calificaciones");
                            break;
                        default:
                            System.out.println("respuesta incorrecta");
                            break;
                    }
                
                }
                

            }else{
                System.out.println("Regresando...");
                repetirMenu = false;
            }
        
            
        
        }while(repetirMenu);
        
    
    }
    
    /*
     * Ti pode de usuario es 0 = Alunos, 1= profesores, 2=Administrativos
     */
    private void altaDeUsuario(int tipoDeUsuario) {
        
        
        String codigo;
        
        if (tipoDeUsuario==0) {
            
            //Hace falta programar las validaciones de tipos de datos
            System.out.println("Dame el nombre del alumno");
            String nombre = tecladoString.nextLine();
            
            //verificar que no se repita ningún código
            do{
               
                System.out.println("Dame el código del Alumno");
                codigo = tecladoString.nextLine();
                
            }while(validarCodigo(codigo));
            
            System.out.println("Dame la carrera del alumno");
            String carrera = tecladoString.nextLine();
            System.out.println("Promedio del alumno");
            double promedio = tecladoInt.nextDouble();
            System.out.println("Situación:");
            String situacion = tecladoString.nextLine();
            System.out.println("Nivel");
            String nivel = tecladoString.nextLine();
            System.out.println("Cliclo de Admisión");
            String admision = tecladoString.nextLine();
            System.out.println("Ultimo ciclo");
            String ultimoCiclo = tecladoString.nextLine();
            System.out.println("Centro Unviersitario:");
            String centro = tecladoString.nextLine();
            System.out.println("Creditos:");
            int creditos = tecladoInt.nextInt();
            System.out.println("Password");
            String pass =tecladoString.nextLine();

            alumnos.add(new Alumno(nombre, codigo, carrera, promedio, situacion, nivel, admision, ultimoCiclo, centro, creditos, pass));
          
        }else if (tipoDeUsuario==1) {
            
            //Hace falta programar las validaciones de tipos de datos
            System.out.println("Dame el nombre del Profesor");
            String nombre = tecladoString.nextLine();
            do{
               
                System.out.println("Dame el código del Profesor");
                codigo = tecladoString.nextLine();
                
            }while(validarCodigo(codigo));
            
            
            System.out.println("Antiguedad del Profesor");
            int antiguedad = tecladoInt.nextInt();
            System.out.println("Fecha de nacimiento:");
            String fecha = tecladoString.nextLine();
            System.out.println("Tiene algún puesto administrativo SI o NO");
            String respuesta = tecladoString.nextLine().toLowerCase();
            boolean puesto;
            
            puesto = respuesta.equals("si");
            
            System.out.println("Password");
            String pass = tecladoString.nextLine();
            
        
            profesores.add(new Profesor(codigo, nombre, antiguedad, fecha, puesto, pass));
        
        }else{
            
            
            //Hace falta programar las validaciones de tipos de datos
            System.out.println("Dame el nombre del Administrativo");
            String nombre = tecladoString.nextLine();
            
            do{
               
                System.out.println("Dame el código del Administrativo");
                codigo = tecladoString.nextLine();
                
            }while(validarCodigo(codigo));
            
            System.out.println("Antiguedad del Administrativo");
            int antiguedad = tecladoInt.nextInt();
            System.out.println("Fecha de nacimiento:");
            String fecha = tecladoString.nextLine();
            System.out.println("Cargo:");
            String cargo = tecladoString.nextLine();
            System.out.println("Grado Académico:");
            String gradoAcademico = tecladoString.nextLine();
            System.out.println("Password");
            String pass = tecladoString.nextLine();
            
            administrativos.add(new Administrativo(codigo, nombre, antiguedad, gradoAcademico, cargo, gradoAcademico, pass));
        }
        
    }

    private void bajaDeUsuario(int tipo) {
        
        
        if (tipo==0) {
            
            int index = buscarUsuario(0,"*");
            if(index!=-1){

              
                System.out.println("¿Seguro que quieres eliminar al alumno?");
                System.out.println("1.-Si\n2.-No");
                int opcion = tecladoInt.nextInt();
                if (opcion==1) {
                    alumnos.remove(index);
                    System.out.println("Alumno Eliminado");

               }else if(opcion==2)
                        System.out.println("No se ha eliminado el alumno");


            }
            
        }else if(tipo ==1){
            
            
            int index = buscarUsuario(1,"*");
            if(index!=-1){

              

                System.out.println("¿Seguro que quieres eliminar al Profesor?");
                System.out.println("1.-Si\n2.-No");
                int opcion = tecladoInt.nextInt();
                if (opcion==1) {
                    profesores.remove(index);
                    System.out.println("Profesor Eliminado");

               }else if(opcion==2)
                        System.out.println("No se ha eliminado el Profesor");


            }
        
        
        }else{
            
            int index = buscarUsuario(2,"*");
            if(index!=-1){

             

                System.out.println("¿Seguro que quieres eliminar al Administrativo?");
                System.out.println("1.-Si\n2.-No");
                int opcion = tecladoInt.nextInt();
                if (opcion==1) {
                    administrativos.remove(index);
                    System.out.println("Administrativo Eliminado");

               }else if(opcion==2)
                        System.out.println("No se ha eliminado el Administrativo");


            }
        
       
        }
        
        
    }

    private int buscarUsuario(int tipo, String codigoRecibido) {
        if(codigoRecibido.equals("*")){
            if(tipo == 0){
                System.out.println("Dame el codigo");
                String codigo = tecladoString.nextLine();
                int index=0;
                for (Alumno alumno : alumnos) {
                    if(alumno.getCodigo().equals(codigo)){

                        System.out.println("Alumno encontrado");
                        alumno.mostrarDatos();
                        return index;

                    }

                    index++;
                }
                System.out.println("No se contró al alumno");

            }else if(tipo == 1){
                System.out.println("Dame el codigo");
                String codigo = tecladoString.nextLine();
                int index=0;
                for (Profesor profesor : profesores) {
                    if(profesor.getCodigo().equals(codigo)){

                        System.out.println("Profesor encontrado");
                        profesor.mostrarDatos();
                        return index;

                    }

                    index++;
                }
                System.out.println("No se contró al Profesor");

            }else{

                System.out.println("Dame el codigo");
                String codigo = tecladoString.nextLine();
                int index=0;
                for (Administrativo administrativo : administrativos) {
                    if(administrativo.getCodigo().equals(codigo)){

                        System.out.println("Administrativo encontrado");
                        administrativo.mostrarDatos();
                        return index;

                    }

                    index++;
                }

         }
        }else{
            
            if(tipo == 0){
                
                int index=0;
                for (Alumno alumno : alumnos) {
                    if(alumno.getCodigo().equals(codigoRecibido)){

                        System.out.println("Alumno encontrado");
                        alumno.mostrarDatos();
                        return index;

                    }

                    index++;
                }
                System.out.println("No se contró al alumno");

            }else if(tipo == 1){
              
                int index=0;
                for (Profesor profesor : profesores) {
                    if(profesor.getCodigo().equals(codigoRecibido)){

                        System.out.println("Profesor encontrado");
                        profesor.mostrarDatos();
                        return index;

                    }

                    index++;
                }
                System.out.println("No se contró al Profesor");

            }else{

                
                int index=0;
                for (Administrativo administrativo : administrativos) {
                    if(administrativo.getCodigo().equals(codigoRecibido)){

                        System.out.println("Administrativo encontrado");
                        administrativo.mostrarDatos();
                        return index;

                    }

                    index++;
                }

            }
        
        }
        
        return -1; //no se contró ese código
         
    }

    private void cambiosDeUsuario(int tipo) {
        
        
        if (tipo==0) {
            
        
            boolean repetirOpciones,repetirCambiarEstudiante=true;
            int opcion=0;
            do{

                do{
                    System.out.println("1.-Código");
                    System.out.println("2.-Nombre");
                    System.out.println("3.-Carrera");
                    System.out.println("4.-Promedio");
                    System.out.println("5.-Situación");
                    System.out.println("6.-Nivel");
                    System.out.println("7.-Admision");
                    System.out.println("8.-Ultimo Clico");
                    System.out.println("9.-Cetro Universitario");
                    System.out.println("10.-Créditos");
                    System.out.println("11.-Password");
                    System.out.println("12.-Regresar");
                    
                    try {

                        opcion = tecladoInt.nextInt();
                        if (opcion<1||opcion>12) {
                            System.out.println("opción no válida");
                            repetirOpciones = true;
                        }else
                            repetirOpciones = false;
                    } catch (Exception e) {

                        System.out.println("opción no válida");
                        repetirOpciones = true;
                    }

                }while(repetirOpciones);

                switch(opcion){

                    case 1:
                        cambiarCogioUsuario(0);
                        break;
                    case 2:
                        cambiarNombreUsuario(0);
                        break;
                    case 3:
                        cambiarCarrera();
                        break;
                    case 4:
                        cambiarPromedioAlumno();
                        break;
                    case 5:
                        cambiarSituacionAlumno();
                        break;
                    case 6:
                        cambiarNivelAlumno();
                        break;
                    case 7:
                        cambiarAdmisionAlumno();
                        break;
                    case 8:
                        cambiarUltimoCicloAlumno();
                        break;
                    case 9:
                        cambiarCentroUniversitarioAlumno();
                        break;
                    case 10:
                        cambiarCreditosAlumno();
                        break;
                    case 11:
                        cambiarPasswordUsuario(0,"*");
                        break;
                    case 12:
                        System.out.println("Regresando...");
                        repetirCambiarEstudiante=false;
                        break;

                }
            }while(repetirCambiarEstudiante);
            
            
        }else if (tipo==1) {
            
            boolean repetirOpciones,repetirCambiarProfesor=true;
            int opcion=0;
            do{

                do{
                    System.out.println("1.-Código");
                    System.out.println("2.-Nombre");
                    System.out.println("3.-Antigüedad");
                    System.out.println("4.-Fecha de Nacimiento");
                    System.out.println("5.-Password");
                    System.out.println("6.-Cambiar puesto");
                    System.out.println("7.-Regresar");
                    try {

                        opcion = tecladoInt.nextInt();
                        if (opcion<1||opcion>8) {
                            System.out.println("opción no válida");
                            repetirOpciones = true;
                        }else
                            repetirOpciones = false;
                    } catch (Exception e) {

                        System.out.println("opción no válida");
                        repetirOpciones = true;
                    }

                }while(repetirOpciones);

                switch(opcion){
                    case 1:
                        cambiarCogioUsuario(1);
                        break;
                    case 2:
                        cambiarNombreUsuario(1);
                        break;
                    case 3:
                        cambiarAntiguedad(1);
                        break;
                    case 4:
                        cambiarFechaDeNacimiento(1);
                        break;
                    case 5:
                        cambiarPuesto();
                        break;
                    case 6:
                        cambiarPasswordUsuario(1,"*");
                        break;
                    case 7:
                        System.out.println("Regresando...");
                        repetirCambiarProfesor=false;
                        break;

                }
            }while(repetirCambiarProfesor);
            
            
            
        }else{
            
            
            boolean repetirOpciones,repetirCambiarAdministrativo=true;
            int opcion=0;
            do{

                do{
                    System.out.println("1.-Código");
                    System.out.println("2.-Nombre");
                    System.out.println("3.-Antigüedad");
                    System.out.println("4.-Fecha de Nacimiento");
                    System.out.println("5.-Password");
                    System.out.println("6.-Cambiar Cargo");
                    System.out.println("7.-Grado academico");
                    System.out.println("8.-Regresar");
                    try {

                        opcion = tecladoInt.nextInt();
                        if (opcion<1||opcion>9) {
                            System.out.println("opción no válida");
                            repetirOpciones = true;
                        }else
                            repetirOpciones = false;
                    } catch (Exception e) {

                        System.out.println("opción no válida");
                        repetirOpciones = true;
                    }

                }while(repetirOpciones);

                switch(opcion){
                    case 1:
                        cambiarCogioUsuario(2);
                        break;
                    case 2:
                        cambiarNombreUsuario(2);
                        break;
                    case 3:
                        cambiarAntiguedad(2);
                        break;
                    case 4:
                        cambiarFechaDeNacimiento(2);
                        break;
                    case 5:
                        cambiarPasswordUsuario(2,"*");
                        break;
                    case 6:
                        cambiarCargo();
                        break;
                    case 7: 
                        cambiarGradoAcademico();
                        break;
                    case 8:
                        System.out.println("Regresando...");
                        repetirCambiarAdministrativo=false;
                        break;

                }
            }while(repetirCambiarAdministrativo);
        
        
        }
    
    }

    private void mostrarUsuario(int tipo) {
        
        if(tipo==0){
            
            int contador=0;
            for (Alumno alumno : alumnos) {
                System.out.println(contador++);
                alumno.mostrarDatos();
                System.out.println("");
            }
        
        
        }else if (tipo==1) {
            
            int contador=0;
            for (Profesor profesor : profesores) {
                System.out.println(contador++);
                profesor.mostrarDatos();
                System.out.println("");
            }
            
        }else{
            
            int contador=0;
            for (Administrativo administrativo : administrativos) {
                System.out.println(contador++);
                administrativo.mostrarDatos();
                System.out.println("");
            }
        
        }
    
    }

    private void cambiarCogioUsuario(int tipo) {
        
        //tipo 0 = alumno
        if (tipo==0) {
            
            int index = buscarUsuario(0,"*");
        
            if (index!=-1) {

                System.out.println("¿Estás seguro que quieres cambiar el código del alumno? SI o NO ");
                String respuesta = tecladoString.nextLine().toUpperCase();
                String nuevoCodigo;
                if(respuesta.equals("SI")){
                    
                    do{
                        System.out.println("Dame el nuevo código de alumno");
                        nuevoCodigo = tecladoString.nextLine();
                        
                    }while(validarCodigo(nuevoCodigo));
                    
                    Alumno alumno = alumnos.get(index);
                    alumno.setCodigo(nuevoCodigo);
                    System.out.println("Se cambió el código de forma exitosa");

                }else
                    System.out.println("No se hicieron los cambios");

            }

            //tipo 2 == profesor
        }else if (tipo==1) {
            
                int index = buscarUsuario(1,"*");

                if (index!=-1) {

                    System.out.println("¿Estás seguro que quieres cambiar el código del Profesor? SI o NO ");
                    String respuesta = tecladoString.nextLine().toUpperCase();
                    String nuevoCodigo;
                    if(respuesta.equals("SI")){
                        
                        do{
                        System.out.println("Dame el nuevo código de alumno");
                        nuevoCodigo = tecladoString.nextLine();
                        
                        }while(validarCodigo(nuevoCodigo));
                        
                        Profesor profesor = profesores.get(index);
                        profesor.setCodigo(nuevoCodigo);
                        System.out.println("Se cambió el código de forma exitosa");

                    }else
                        System.out.println("No se hicieron los cambios");

                }

                //tipo 3 = administrativo
        }else if(tipo==3){
                
                int index = buscarUsuario(2,"*");

                if (index!=-1) {

                    System.out.println("¿Estás seguro que quieres cambiar el código del Administrativo? SI o NO ");
                    String respuesta = tecladoString.nextLine().toUpperCase();
                    String nuevoCodigo;
                    if(respuesta.equals("SI")){
                       
                        do{
                            System.out.println("Dame el nuevo código del Administrativo");
                            nuevoCodigo = tecladoString.nextLine();
                        }while(validarCodigo(nuevoCodigo));
                        
                        Administrativo administrativo = administrativos.get(index);
                        administrativo.setCodigo(nuevoCodigo);
                        System.out.println("Se cambió el código de forma exitosa");

                    }else
                        System.out.println("No se hicieron los cambios");

                }
        
        }
    
    }

    private void cambiarNombreUsuario(int tipo) {
        
        
        if (tipo==1) {
            
            int index = buscarUsuario(0,"*");
            if (index!=-1) {

                System.out.println("¿Estás seguro que quieres cambiar el nombre del alumno? SI o NO ");
                String respuesta = tecladoString.nextLine().toUpperCase();

                if(respuesta.equals("SI")){
                    System.out.println("Dame el nuevo Nombre de alumno");
                    String nuevoNombre = tecladoString.nextLine();

                    Alumno alumno = alumnos.get(index);
                    alumno.setNombre(nuevoNombre);
                    System.out.println("Se cambió el nombre de forma exitosa");

                }else
                    System.out.println("No se hicieron los cambios");

            }
            
        }else if (tipo==2) {
            int index = buscarUsuario(1,"*");
            if (index!=-1) {

                System.out.println("¿Estás seguro que quieres cambiar el nombre del Profesor? SI o NO ");
                String respuesta = tecladoString.nextLine().toUpperCase();

                if(respuesta.equals("SI")){
                    System.out.println("Dame el nuevo Nombre del Profesor");
                    String nuevoNombre = tecladoString.nextLine();

                    Profesor profesor = profesores.get(index);
                    profesor.setNombre(nuevoNombre);
                    System.out.println("Se cambió el nombre de forma exitosa");

                }else
                    System.out.println("No se hicieron los cambios");

            }
            
        }else{
            int index = buscarUsuario(2,"*");
            if (index!=-1) {

                System.out.println("¿Estás seguro que quieres cambiar el nombre del Administrativo? SI o NO ");
                String respuesta = tecladoString.nextLine().toUpperCase();

                if(respuesta.equals("SI")){
                    System.out.println("Dame el nuevo Nombre de Administrativo");
                    String nuevoNombre = tecladoString.nextLine();

                    Administrativo administrativo = administrativos.get(index);
                    administrativo.setNombre(nuevoNombre);
                    System.out.println("Se cambió el nombre de forma exitosa");

                }else
                    System.out.println("No se hicieron los cambios");

            }
        
        }
        
    }

    private void cambiarCarrera() {
        
        
        
        int index = buscarUsuario(0,"*");
        
        if (index!=-1) {
            
            System.out.println("¿Estás seguro que quieres cambiar la carrera del alumno? SI o NO ");
            String respuesta = tecladoString.nextLine().toUpperCase();
            
            if(respuesta.equals("SI")){
                System.out.println("Dame la nueva carrera del alumno");
                String nuevaCarrera = tecladoString.nextLine();
                
                Alumno alumno = alumnos.get(index);
                alumno.setCarrera(nuevaCarrera);
                System.out.println("Se cambió la carrera de forma exitosa");
            }else
                System.out.println("No se hicieron los cambios");
            
        }
        
        
    
    
    }

   

    

    private void menuMateriasRoot() {
        boolean repetirPedirDatos=false;
        boolean repetirMenuMaterias = true;
        int opcion=0;
        do{
            do{
                System.out.println("Menú Materias Root");
                System.out.println("1.-Alta");
                System.out.println("2.-Eliminar");
                System.out.println("3.-Modificar");
                System.out.println("4.-Buscar");
                System.out.println("5.-Mostrar Todo");
                System.out.println("6.-Regresar");
                try {
                    opcion=tecladoInt.nextInt();
                    if (opcion<1||opcion>6) {
                        System.out.println("opcion No válida");
                        repetirPedirDatos=true;
                    }
                    
                } catch (Exception e) {
                    System.out.println("Opción no válida");
                    repetirPedirDatos=true;
                }

            }while(repetirPedirDatos);
            
            switch(opcion){
                case 1:
                    altaDeMateria();
                    break;
                case 2:
                    eliminarMateria();
                    break;
                case 3:
                    modificarMateria();
                    break;
                case 4:
                    buscarMateria();
                    break;
                case 5:
                    mostrarMaterias();
                    break;
                case 6:
                    System.out.println("Regresando....");
                    repetirMenuMaterias=false;
                    break;
            
            }
        
        
        }while(repetirMenuMaterias);
    
    
    }

   

    private void cambiarPasswordUsuario(int tipo,String codigoActivo) {
        if (codigoActivo.equals("*")) {
            
                if (tipo==0) {

                int index = buscarUsuario(0,"*");

                if (index!=-1) {
                    System.out.println("Dame la nueva contraseña");
                    String newPassword = tecladoString.nextLine();
                    Alumno alumno = alumnos.get(index);
                    alumno.setCodigo(newPassword);
                    System.out.println("El password se cambió correctamente...");
                }

            }else if(tipo==1){

                int index = buscarUsuario(1,"*");

                if (index!=-1) {
                    System.out.println("Dame la nueva contraseña");
                    String newPassword = tecladoString.nextLine();
                    Profesor profesor = profesores.get(index);
                    profesor.setCodigo(newPassword);
                    System.out.println("El password se cambió correctamente...");
                }

            }else{
                int index = buscarUsuario(2,"*");

                if (index!=-1) {
                    System.out.println("Dame la nueva contraseña");
                    String newPassword = tecladoString.nextLine();
                    Administrativo administrativo = administrativos.get(index);
                    administrativo.setCodigo(newPassword);
                    System.out.println("El password se cambió correctamente...");
                }

            }
            
        }else{
            
             if (tipo==0) {

                int index = buscarUsuario(0,codigoActivo);

                if (index!=-1) {
                    System.out.println("Dame la nueva contraseña");
                    String newPassword = tecladoString.nextLine();
                    Alumno alumno = alumnos.get(index);
                    alumno.setCodigo(newPassword);
                    System.out.println("El password se cambió correctamente...");
                }

            }else if(tipo==1){

                int index = buscarUsuario(1,codigoActivo);

                if (index!=-1) {
                    System.out.println("Dame la nueva contraseña");
                    String newPassword = tecladoString.nextLine();
                    Profesor profesor = profesores.get(index);
                    profesor.setCodigo(newPassword);
                    System.out.println("El password se cambió correctamente...");
                }

            }else{
                int index = buscarUsuario(2,codigoActivo);

                if (index!=-1) {
                    System.out.println("Dame la nueva contraseña");
                    String newPassword = tecladoString.nextLine();
                    Administrativo administrativo = administrativos.get(index);
                    administrativo.setCodigo(newPassword);
                    System.out.println("El password se cambió correctamente...");
                }
        
        
        
            }
        
    
        }
        
    }

    

    private void altaDeMateria() {
        
        
        String nrc;
        System.out.println("Clave: ");
        String clave = tecladoString.nextLine();
        do {   
            
            System.out.println("NRC ");
            nrc = tecladoString.nextLine();
         
        } while (verificarNRC(nrc));
        
        System.out.println("Nombre:");
        String nombre = tecladoString.nextLine();
        System.out.println("Departamento");
        String departamento = tecladoString.nextLine();
        System.out.println("Horario");
        String horario = tecladoString.nextLine();
        System.out.println("Horas:");
        int horas = tecladoInt.nextInt();
        System.out.println("Salón");
        String salon = tecladoString.nextLine();
        System.out.println("Cupo");
        int cupo = tecladoInt.nextInt();
        
        materias.add(new Materia(clave, nrc, nombre, "", departamento, horario, horas, salon, cupo));
        
    
    
    }

    private void eliminarMateria() {
    
        
        
        int index=buscarMateria();
        
        
        if (index!=-1) {
            System.out.println("¿Estas seguro de que quieres eliminar la materia? Si o No ");
            String respuesta = tecladoString.nextLine().toLowerCase();
            
            switch (respuesta) {
                case "si":
                    materias.remove(index);
                    System.out.println("La materia se eliminó exitosamente");
                    break;
                case "no":
                    System.out.println("No se hicieron cambios");
                    break;
                default:
                    System.out.println("opción no válida.... no se hicieron cambios");
                    break;
            }
            
        }
        
    
    
    
    }

    private void modificarMateria() {
       
    
        int opcion=0;
        int index = buscarMateria();
        boolean repetir;
        boolean repetirMenu;
        
        if (index!=-1) {
            
            do { 
                repetirMenu=true;
                do {   
                    repetir=false;
                    System.out.println("¿Que quieres modificar de la materia?");
                    System.out.println("1.-Clave");
                    System.out.println("2.-NRC");
                    System.out.println("3.-Nombre");
                    System.out.println("4-Codigo del Maestro");
                    System.out.println("5.-Departamento");
                    System.out.println("6.-Horario");
                    System.out.println("7.-Horas");
                    System.out.println("8.-Salon");
                    System.out.println("9.-Cupo");
                    System.out.println("10.-Regresar");

                    try {

                        opcion=tecladoInt.nextInt();
                        if (opcion<1||opcion>10) {
                            System.out.println("Opción no válida");
                            repetir=true;
                        }


                    } catch (Exception e) {
                        System.out.println("Opción no válida");
                        repetir=true;

                    }

                }while (repetir);


                switch(opcion){


                    case 1:
                        cambiarClaveDeMateria(index);
                        break;
                    case 2:
                        cambiarNRCDeMateria(index);
                        break;
                    case 3:
                        cambiarNombreMateria(index);
                        break;
                    case 4:
                        cambiarCodigoDelMaestroMateria(index);
                        break;
                    case 5:
                        cambiarDepartamentoMateria(index);
                        break;
                    case 6:
                        cambiarHorarioMateria(index);
                        break;
                    case 7:
                        cambiarHorasMateria(index);
                        break;
                    case 8:
                        cambiarSalonMateria(index);
                        break;
                    case 9:
                        cambiarCupoMateria(index);
                        break;
                    case 10:
                        repetirMenu=false;
                        break;


                }
            
            } while (repetirMenu);
        }
    
    
    
    }

    private int buscarMateria() {
    
        System.out.println("Dame el NRC de la materia");
        int nrc = tecladoInt.nextInt();
        int index=0;
        for (Materia materia : materias) {
            
            if (materia.getNRC().equals(nrc)) {
                
                System.out.println("Materia encontrada ");
                materia.mostrarDatos();
                return index;
            }
            index++;
        }
        
        System.out.println("Materia no encontrada");
        return -1;
        
    }

    private boolean mostrarMaterias() {
        
        
        if (!materias.isEmpty()) {
            
            for (Materia materia : materias) 
                materia.mostrarDatos();
        
            return true;
        }else{
            System.out.println("No hay materias registradas");
            return false;
        }
         
    
        
        
    
    }

    private boolean validarCodigo(String codigo) {
        
        for (Alumno alumno : alumnos) 
             if(alumno.getCodigo().equals(codigo)){
                System.out.println("El código está repetido, intenta de nuevo");
                return true;
             }
               
        for (Profesor profesor : profesores) 
            if(profesor.getCodigo().equals(codigo)){
                System.out.println("El código está repetido, intenta de nuevo");
                return true;
             }
            
       for (Administrativo administrativo : administrativos) 
            if(administrativo.getCodigo().equals(codigo)){
                System.out.println("El código está repetido, intenta de nuevo");
                return true;
             }
            
    return false;
        
    }

    private void verCargaHoraria(String codigo) {
        
        
        for (Materia materia : materias) {
              if (materia.getCodigoMaestro().equals(codigo)) {
                materia.mostrarDatos();
                
            }
        }
    
    
    }

    private void verListaDeAsistencia(String codigo) {
        
       
        ArrayList<String> nrc = new ArrayList <>();
        
        for (Materia materia : materias) {
              if (materia.getCodigoMaestro().equals(codigo)) {
                  System.out.println(materia.getNombre());
                  System.out.println(materia.getNRC());
                  nrc.add(materia.getNRC());
               
            }
              
        }
        boolean noEncontrado;
        do {  
            noEncontrado=false;
            System.out.println("Escribe el NRC de la materia que quieres imprimir la lista");
            String respuesta = tecladoString.nextLine();
            
            for (String n : nrc) 
                if (n.equals(respuesta)){
                   for (Materia materia : materias) 
                        if (materia.getNRC().equals(respuesta)) 
                             materia.imprimirLista();
                noEncontrado=true;
                }

            if(!noEncontrado){
                System.out.println("No se encontró el NRC");
            }
        
        } while (!noEncontrado);
        
          
     
    }

    private void subirCalificaciones(String codigo) {
        
        if (periodoSubirCalificaciones) {
        
            ArrayList<String> nrc = new ArrayList <>();
            for (Materia materia : materias) {
                  if (materia.getCodigoMaestro().equals(codigo)) {
                      System.out.println(materia.getNombre());
                      System.out.println(materia.getNRC());
                      nrc.add(materia.getNRC());

                }

            }
            boolean noEncontrado;
            do {  
                noEncontrado=false;
                System.out.println("Escribe el NRC de la materia que quieres subir calificaciones");
                String respuesta = tecladoString.nextLine();

                for (String n : nrc) 
                    if (n.equals(respuesta)){
                       for (Materia materia : materias) 
                            if (materia.getNRC().equals(respuesta)){
                                for (int i = 0; i < materia.getContadorDeAlumnosRegistrados(); i++) {
                                    System.out.println("Dame la calificación de "+materia.getAlumnos(i));
                                    double calificacion = tecladoInt.nextDouble();
                                    materia.setCalificacion(calificacion, i);
                                
                                }  
                            }
                    noEncontrado=false;
                    }

                if(noEncontrado){
                    System.out.println("No se encontró el NRC");
                    noEncontrado=true;
                }

        } while (noEncontrado);
        
        } else
            System.out.println("No es periodo de registro de calificaciones");
    
    }

    private void registrarMateriasProfesores() {
        
        if (!materias.isEmpty()) {
            
            int opcion;
            int index = buscarUsuario(1, "*");
            boolean repetirMenuRegistroMaterias=true;

            if (index!=-1) {
                    do {                

                        System.out.println("1.-Imprimir Todas las materias disponibles");
                        System.out.println("2.-Ingresar el NRC de la materia");
                        try {
                            opcion=tecladoInt.nextInt();
                            if (opcion==1) {
                                mostrarMaterias();

                                Profesor profesor = profesores.get(index);
                                boolean repetirNRC;
                                boolean nrcCorrecto=false;
                                do{
                                    repetirNRC=false;
                                    System.out.println("Dame el NRC de la materia que quieres registrarle al profesor "+profesor.getNombre());

                                    try {
                                        String nrc = tecladoString.nextLine();

                                        for (Materia materia : materias) {
                                            if (materia.getNRC().equals(nrc)) {
                                                materia.setCodigoMaestro(profesor.getCodigo());
                                                System.out.println("La materia se asignó correctamente");
                                                nrcCorrecto =true;
                                            }
                                        }

                                        if (!nrcCorrecto) {
                                            System.out.println("No se encontró el NRC");
                                            repetirNRC=true;
                                        }



                                    } catch (Exception e) {
                                        System.out.println("Error");
                                        repetirNRC=true;
                                    }
                                }while(repetirNRC);




                                repetirMenuRegistroMaterias=false;

                            }else if(opcion==2){


                                 boolean nrcCorrecto = false;

                                 System.out.println("Ingresa el NRC de la materia");
                                 String respuesta = tecladoString.nextLine();
                                 Profesor profesor = profesores.get(index);

                                for (Materia materia : materias) 
                                    if (materia.getNRC().equals(respuesta)){
                                       for (Materia materia1 : materias) 
                                            if (materia1.getNRC().equals(respuesta)){
                                                  materia1.setCodigoMaestro(profesor.getCodigo());
                                                  System.out.println("La materia se asignó exitosamente");
                                                  nrcCorrecto =true;
                                            }

                                    }

                                if(!nrcCorrecto){
                                    System.out.println("No se encontró el NRC");
                                }


                                repetirMenuRegistroMaterias=false;
                            }else
                                System.out.println("Opción no válida");
                        } catch (Exception e) {
                            System.out.println("Opción no válida");
                        }

                    } while (repetirMenuRegistroMaterias);

            }
            
        }else
            System.out.println("No hay materias registradas");
        
        
    
    
    }

    private void verDatosAlumno() {
        
        
        boolean repetir;
        int opcion=-1;
        
        do{
            repetir=false;
        
            System.out.println("Ver datos de alumnos");
            System.out.println("1.-Buscar Alumno");
            System.out.println("2.-Mostrar todos los alumnos");
            System.out.println("3.-Regresar");


            try {

                   opcion= tecladoInt.nextInt();

            } catch (Exception e) {

                System.out.println("opción no válida");

            }
            switch(opcion){

                case 1:
                    buscarUsuario(0, "*");
                    break;

                case 2:
                    mostrarUsuario(0);
                    break;

                case 3:
                    System.out.println("Regresando");
                    break;

                default :  
                    System.out.println("opción no válida");
                    repetir=true;
              
            }

                
        }while(repetir);
        
    }

    private void verDatosProfesores() {
        
        boolean repetir;
        int opcion=-1;
        
        do{
            repetir=false;
        
            System.out.println("Ver datos de Profesores");
            System.out.println("1.-Buscar Profesor");
            System.out.println("2.-Mostrar todos los Profesores");
            System.out.println("3.-Regresar");


            try {

                   opcion= tecladoInt.nextInt();

            } catch (Exception e) {

                System.out.println("opción no válida");

            }
            switch(opcion){

                case 1:
                    buscarUsuario(1, "*");
                    break;

                case 2:
                    mostrarUsuario(1);
                    break;

                case 3:
                    System.out.println("Regresando");
                    break;

                default :  
                    System.out.println("opción no válida");
                    repetir=true;
              
            }

                
        }while(repetir);
    
    }

    private void cambiarClaveDeMateria(int index) {
    
    
        Materia materia = materias.get(index);
        boolean repetirClave;
        String nuevaClave;
        
        do {            
            repetirClave=false;
            System.out.println("Dame la nueva clave de la materia");
            nuevaClave = tecladoString.nextLine();
            
            for (Materia materia1 : materias) {
                if (materia1.getClave().equals(nuevaClave)) {
                    
                    System.out.println("Clave repetida, intenta de nuevo");
                    repetirClave=true;
                            
                }
            }
            
            
        } while (repetirClave);
        
        
        materia.setClave(nuevaClave);
        System.out.println("La clave se cambió exitosamente.");
        
        
    }

    private void cambiarNRCDeMateria(int index) {
    
        Materia materia = materias.get(index);
        boolean repetirClave;
        String nuevoNRC;
        
        do {            
            repetirClave=false;
            System.out.println("Dame el  nuevo NRC de la materia");
            nuevoNRC = tecladoString.nextLine();
            
            for (Materia materia1 : materias) {
                if (materia1.getNRC().equals(nuevoNRC)) {
                    
                    System.out.println("NRC repetido, intenta de nuevo");
                    repetirClave=true;
                            
                }
            }
            
            
        } while (repetirClave);
        
        
        materia.setNRC(nuevoNRC);
        System.out.println("El nuevo NRC se cambió exitosamente.");
    
    
    }

    private void cambiarNombreMateria(int index) {
        
        
        Materia materia = materias.get(index);
        boolean repetirClave;
        String respuesta;
        
        do {            
            repetirClave=false;
            System.out.println("Dame el nuevo Nombre de la materia");
            respuesta = tecladoString.nextLine();
            
            for (Materia materia1 : materias) {
                if (materia1.getNombre().equals(respuesta)) {
                    
                    System.out.println("Nombre repetido, intenta de nuevo");
                    repetirClave=true;
                            
                }
            }
            
            
        } while (repetirClave);
        
        
        materia.setNombre(respuesta);
        System.out.println("El nuevo nombre se cambió exitosamente.");
    
    
    }

    private void cambiarCodigoDelMaestroMateria(int index) {
        
        Materia materia = materias.get(index);
        boolean repetirClave;
        String respuesta;
        
        do {            
            repetirClave=false;
            System.out.println("Dame el nuevo codigo del profesor que imparte la materia");
            respuesta = tecladoString.nextLine();
            
            for (Profesor profesor : profesores) {
                if (profesor.getCodigo().equals(respuesta)) {
                    repetirClave=false;
                    break;
                }
            }
            
            
        } while (repetirClave);
        
        
        materia.setCodigoMaestro(respuesta);
        System.out.println("El nuevo codigo del profesor se cambió exitosamente.");
    }

    private void cambiarDepartamentoMateria(int index) {
        
        Materia materia = materias.get(index);
        
        String respuesta;
        System.out.println("Dame el nuevo Nombre de la materia");
        respuesta = tecladoString.nextLine();
        materia.setDepartamento(respuesta);
        System.out.println("El nuevo nombre se cambió exitosamente.");
    
    
    }

    private void cambiarHorarioMateria(int index) {
        
        Materia materia = materias.get(index);
        String respuesta;
        System.out.println("Dame el nuevo Horario de la materia");
        respuesta = tecladoString.nextLine();
        materia.setHorario(respuesta);
        System.out.println("El nuevo nombre se cambió exitosamente.");
    
    }

    private void cambiarHorasMateria(int index) {
        
        Materia materia = materias.get(index);
        int respuesta;
        System.out.println("Dame las nuevas horas de la materia");
        respuesta = tecladoInt.nextInt();
        materia.setHoras(respuesta);
        System.out.println("El nuevo nombre se cambió exitosamente.");
        
        
    
    
    }

    private void cambiarSalonMateria(int index) {
        Materia materia = materias.get(index);
        String respuesta;
        System.out.println("Dame el nuevo Nombre de la materia");
        respuesta = tecladoString.nextLine();
        
        materia.setSalon(respuesta);
        System.out.println("El nuevo nombre se cambió exitosamente.");
    
    }

    private void cambiarCupoMateria(int index) {
        Materia materia = materias.get(index);
       
        int respuesta;
        System.out.println("Dame el nuevo Nombre de la materia");
        respuesta = tecladoInt.nextInt();
        
        materia.setCupo(respuesta);
        System.out.println("El nuevo nombre se cambió exitosamente.");
    
    
    }
    
    private void cambiarCargo() {
        
        String respuesta;
        int index = buscarUsuario(2, "*");
        if (index!=-1) {
            System.out.println("¿Estas seguro de que quieres cambiar el cargo? SI o NO");
            respuesta = tecladoString.nextLine().toLowerCase();
            
            switch (respuesta) {
                case "si":
                    System.out.println("Dame el nuevo cargo ");
                    String cargoNuevo = tecladoString.nextLine();
                    Administrativo administrativo = administrativos.get(index);
                    administrativo.setCargo(cargoNuevo);
                    break;
                case "no":
                    System.out.println("No se hicieron cambios");
                    break;
                default:
                    System.out.println("Respuesta incorrecta, no se hicieron cambios.");
                    break;
            }
            
        }
        
       
       
    }

    private void cambiarGradoAcademico() {
        
        
        String respuesta;
        int index = buscarUsuario(2, "*");
        if (index!=-1) {
            System.out.println("¿Estas seguro de que quieres cambiar el grado académico? SI o NO");
            respuesta = tecladoString.nextLine().toLowerCase();
            
            switch (respuesta) {
                case "si":
                    System.out.println("Dame el nuevo grado académico ");
                    String gradoAcademicoNuevo = tecladoString.nextLine();
                    Administrativo administrativo = administrativos.get(index);
                    administrativo.setGradoAcademico(gradoAcademicoNuevo);
                    break;
                case "no":
                    System.out.println("No se hicieron cambios");
                    break;
                default:
                    System.out.println("Respuesta incorrecta, no se hicieron cambios.");
                    break;
            }
            
        }
        
        
        
    
    
    }
    
     private void cambiarAntiguedad(int tipo) {
         
         if (tipo==2) {
             
            String respuesta;
            int index = buscarUsuario(2, "*");
            if (index!=-1) {
            System.out.println("¿Estas seguro de que quieres cambiar la antigüedad? SI o NO");
            respuesta = tecladoString.nextLine().toLowerCase();
            
            switch (respuesta) {
                case "si":
                    System.out.println("Dame la nueva antigüedad ");
                    int antiguedad = tecladoInt.nextInt();
                    Administrativo administrativo = administrativos.get(index);
                    administrativo.setAntiguedad(antiguedad);
                    break;
                case "no":
                    System.out.println("No se hicieron cambios");
                    break;
                default:
                    System.out.println("Respuesta incorrecta, no se hicieron cambios.");
                    break;
            }
            
        }
             
             
             
         }else if(tipo==1){
             String respuesta;
             int index = buscarUsuario(1, "*");
             if (index!=-1) {
                  System.out.println("¿Estas seguro de que quieres cambiar la antigüedad? SI o NO");
                  respuesta = tecladoString.nextLine().toLowerCase();

                  switch (respuesta) {
                      case "si":
                          System.out.println("Dame la nueva antigüedad ");
                          int antiguedad = tecladoInt.nextInt();
                          Profesor profesor = profesores.get(index);
                          profesor.setAntiguedad(antiguedad);
                          break;
                      case "no":
                          System.out.println("No se hicieron cambios");
                          break;
                      default:
                          System.out.println("Respuesta incorrecta, no se hicieron cambios.");
                          break;
                  }

              }
         
         
         
         }
         
    }

    private void cambiarFechaDeNacimiento(int tipo) {
        if (tipo==2) {
             
            String respuesta;
            int index = buscarUsuario(2, "*");
            if (index!=-1) {
            System.out.println("¿Estas seguro de que quieres cambiar la fecha de nacimiento? SI o NO");
            respuesta = tecladoString.nextLine().toLowerCase();
            
            switch (respuesta) {
                case "si":
                    System.out.println("Dame la nueva fecha de nacimiento ");
                    String fechaDeNacimiento = tecladoString.nextLine();
                    Administrativo administrativo = administrativos.get(index);
                    administrativo.setFechaDeNacimiento(fechaDeNacimiento);
                    break;
                case "no":
                    System.out.println("No se hicieron cambios");
                    break;
                default:
                    System.out.println("Respuesta incorrecta, no se hicieron cambios.");
                    break;
            }
            
        }
             
             
             
         }else if(tipo==1){
             String respuesta;
             int index = buscarUsuario(1, "*");
             if (index!=-1) {
                  System.out.println("¿Estas seguro de que quieres cambiar la fecha de nacimiento? SI o NO");
                  respuesta = tecladoString.nextLine().toLowerCase();

                  switch (respuesta) {
                      case "si":
                          System.out.println("Dame la nueva fecha de nacimiento ");
                          String fechaDeNacimiento = tecladoString.nextLine();
                          Profesor profesor = profesores.get(index);
                          profesor.setFechaDeNacimiento(fechaDeNacimiento);
                          break;
                      case "no":
                          System.out.println("No se hicieron cambios");
                          break;
                      default:
                          System.out.println("Respuesta incorrecta, no se hicieron cambios.");
                          break;
                  }

              }
         }
        
    }

    private void cambiarPuesto() {
        
         int index = buscarUsuario(0,"*");
        
         if (index!=-1) {

                System.out.println("¿Estás seguro que quieres cambiar el puesto del profesor? SI o NO ");
                String respuesta = tecladoString.nextLine().toUpperCase();
                String puestoAdministrativo;
                if(respuesta.equals("SI")){
                    
                   
                    System.out.println("¿El profesor tiene puesto administrativo? SI o NO");
                    puestoAdministrativo = tecladoString.nextLine().toLowerCase();
                    if (puestoAdministrativo.equals("si")) {
                        
                        Profesor profesor = profesores.get(index);
                        profesor.setPuesto(true);
                        System.out.println("Se cambió el código de forma exitosa");
                        
                    }else if (puestoAdministrativo.equals("no")) {
                        
                        Profesor profesor = profesores.get(index);
                        profesor.setPuesto(false);
                        System.out.println("Se cambió el código de forma exitosa");
                        
                    }
                    

                }else
                    System.out.println("No se hicieron los cambios");

        }
        
        
        
    }
    
    private void cambiarPromedioAlumno() {
        
        
        
    }

    private void cambiarSituacionAlumno() {
    
    }

    private void cambiarNivelAlumno() {
    
    }

    private void cambiarAdmisionAlumno() {
    }

    private void cambiarUltimoCicloAlumno() {
    }

    private void cambiarCentroUniversitarioAlumno() {
    }

    private void cambiarCreditosAlumno() {
       
    }

    private void verCalificaciones(String codigo) {
        
        
        int index =0;
        boolean registrado = false;
        for (Materia materia : materias) {
            if (materia.getAlumnos(index).equals(codigo)) {
                
                System.out.println("La calificación del alumno en la materia "+materia.getNombre()+" Es:"+materia.getCalificacion(index));
                
                registrado=true;
            }
            index++;
        }
        
        
        if (!registrado) {
            System.out.println("NO Tienes materias registradas");
        }
        
        
        
       
    
    }

    private void registrarMateriasAlumno(String codigo) {
        
        
        if (periodoRegistro) {
            String nrc;
            boolean repetirPedirNRC;
            if(mostrarMaterias()){

                do {      
                    repetirPedirNRC=true;
                    System.out.println("Dame el NRC de la materia que queires registrar o presiona 0 para cancelar");
                    nrc = tecladoString.nextLine();

                    for (Materia materia : materias) {
                        if(materia.getNRC().equals(nrc)){
                            repetirPedirNRC=false;
                            System.out.println("NRC válido");
                            if (materia.revisarAlumnoRegistrado(codigo).equals("encontrado")) {
                                System.out.println("Ya estás registrado en la materia");
                                break;
                            }else{
                                if(materia.registrarAlumnos(materia.getContadorDeAlumnosRegistrados(), codigo)){
                                    System.out.println("Te haz registrado exitosamente!!!");
                                }
                                
                                break;
                            }
                        }
                    }

                    if (repetirPedirNRC) {
                        System.out.println("No se encontró el NRC, intenta de nuevo");
                    }

                    if (nrc.equals("0")) {
                        repetirPedirNRC=false;
                    }


                 } while (repetirPedirNRC);
            }
            
        }else
            System.out.println("No es periodo de registro de materias");
        
        
    
    }

    private void revisarHorarioAlumno(String codigo) {
        
        
        
        for (Materia materia : materias) {
            if (materia.revisarAlumnoRegistrado(codigo).equals("encontrado")){
                materia.mostrarDatos();
                break;
            }
        }
        
        System.out.println("No tienes materias registradas");
        
       
    
    }

    private boolean verificarNRC(String nrc) {
    
        for (Materia materia : materias) {
            if (materia.getNRC().equals(nrc)) {
                System.out.println("el NRC ya existe, intenta de nuevo");
                return true;
            }
        }
        
        return false;
    
    
    }
    
    
    
    
}
