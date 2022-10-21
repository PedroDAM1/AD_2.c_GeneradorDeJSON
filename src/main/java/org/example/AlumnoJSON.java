package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author jmfdiaz
 */

public class AlumnoJSON {

    public static void main(String[] args) {

        Alumno a1 = new Alumno(1000L, "Jose Andres Perez", 22, false, new String[]{"222333444", "555666777", "888999000"});
        Alumno a2 = new Alumno(1001L, "Ana Sanchis Cabanilles", 21, false, new String[]{"222333444", "555666777", "888999000", "333421039"});
        Alumno a3 = new Alumno(1002L, "Aina Gomes Pons", 23, true, new String[]{});
        Alumno a4 = new Alumno(1003L, "Ainara Gabaldón Estruch", 24, false, new String[]{"222111214", "515626677"});

        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(a1);
        listaAlumnos.add(a2);
        listaAlumnos.add(a3);
        listaAlumnos.add(a4);


        JSONObject clase = new JSONObject();

        JSONArray alumnos = new JSONArray();
        clase.append("alumnos",  alumnos);

        for(Alumno a : listaAlumnos){
            alumnos.put(a.asJSON());
        }


        FileWriter fw;
        try {
            fw = new FileWriter("alumnos.json");
            fw.write(clase.toString(4));
            fw.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }



}

class Alumno {

    private Long idAlumno;
    private String nombre;
    private int edad;
    private boolean repetidor;
    private String[] telefonos;

    // TO-DO


    public Alumno(Long idAlumno, String nombre, int edad, boolean repetidor, String[] telefonos) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.edad = edad;
        this.repetidor = repetidor;
        this.telefonos = telefonos;
    }

    public  JSONObject asJSON(){
        JSONObject alumno = new JSONObject();
        alumno.put("idAlumno", this.idAlumno);
        alumno.put("nombre", this.nombre);
        alumno.put("edad", this.edad);
        alumno.put("repetidor", this.repetidor);
        JSONArray telefonos = new JSONArray();
        for (String telefono : this.telefonos){
            telefonos.put(telefono);
        }
        alumno.put("telefonos", telefonos);
        return alumno;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    public String[] getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String[] telefonos) {
        this.telefonos = telefonos;
    }
}


