package practicasClase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class ListasYconjuntos {

    public static void main(String[] args) {

        // vamos a crear una lista de Personas
        // la rellenamos con 100 Personas
        // creamos un set de Personas
        // le introducimos los elementos de la lista
        // sacar por pantalla en cada linea : 
        // lista, elem(i): edad// set, elem(i): edad

        List<Persona> listaPersona = new ArrayList<Persona>();
        Persona persona = null;
        
        for (int i = 0; i < 100; i++) {
            persona = new Persona("1", "Alejandro", "Serrano", i);
            listaPersona.add(persona);
        }

        Set<Persona> setPersona = new HashSet<Persona>();

        for (int i = 0; i < 100; i++) {
            persona = new Persona("1", "Alejandro", "Serrano", i);
            setPersona.add(listaPersona.get(i));
        }

        Iterator iteradorSet = setPersona.iterator();
        while (iteradorSet.hasNext()) {
            System.out.println(((Persona) iteradorSet.next()).getEdad());
            
        }


        for (int i = 0; i < listaPersona.size(); i++) {
            System.out.println("LISTA, elem: " + listaPersona.get(i));
            System.out.println(" /// ");
            System.out.println("SET, elem: " + setPersona);
        }

    }

}


class Persona implements Serializable{

    // Atributos

    private String dni;
    private String nombre;
    private String apellidos;
    private int edad = 0;

    // Constructor

    public Persona(String dni, String nombre, String apellidos, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona() {
        dni = null;
        nombre = null;
        apellidos = null;
        edad = -1;
    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return ("[DNI: " + dni + " " + "Nombre: " + nombre + " " + 
        "Apellidos: " + apellidos + " " + "Edad: " + edad +  "]");
    }

    public int compareTo(Object object) {
        if (object.getClass()!=this.getClass()) {
            return 1;
        } else {
            Persona persona = (Persona) object;
            if (this.edad>persona.edad) {
                return 1; // si el objeto es mejor
            } else if (this.edad==persona.edad) {
                return 0; // si el objeto es igual
            } else {
                return -1; //si el objeto es peor
            }
        }
    }

}