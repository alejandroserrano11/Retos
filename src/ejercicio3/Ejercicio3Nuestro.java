package ejercicio3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Ejercicio3Nuestro {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[3];
        String[] asig = new String[3];
        String nombre;
        for (int al = 0; al < 3; al++) {
            System.out.println("CREACION ALUMNO " + al);
            System.out.println("nombre: ");
            nombre = teclado.nextLine();
            for (int j = 0; j < 3; j++) {
                System.out.println("Asignatura " + j + ": ");
                asig[j] = teclado.nextLine();
            }
            alumnos[al] = new Alumno(nombre, asig);
        }
        teclado.close();
        for (int cont = 0; cont < 3; cont++) {
            System.out.println(alumnos[cont].getId());
        }
        System.out.println(Alumno.getIdActual());

        // almacenar el objeto creado en un fichero
        
        ObjectOutputStream escritor = null;
        String pathFichero = "src//ejercicio3//tresNuestro.dat";

        try {
            escritor = new ObjectOutputStream(new FileOutputStream(pathFichero));
            escritor.writeObject(alumnos[0]);
            escritor.writeObject(alumnos[1]);
            escritor.writeObject(alumnos[2]);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        } finally {
            if (escritor != null)
                escritor.close();
        }

        alumnos[0] = null;
        alumnos[1] = null;
        alumnos[2] = null;

        ObjectInputStream lector = null;
        try {
            lector = new ObjectInputStream(new FileInputStream(pathFichero));
            int cont=0;
            while (lector.available() > 0) {
                alumnos[cont] = (Alumno) lector.readObject();
                System.out.println(alumnos[cont].getNombre());
                cont++;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lector != null)
                lector.close();            
        }

        System.out.println("*** TERMINANDO PROGRAMA ***");

    } // fin del main

} // fin Ejercicio3

// clase para trabajar con ella
class Alumno implements Serializable {
    // atributos

    private static int idActual = 0;
    private int id;
    private String nombre;
    private String[] asignaturas = new String[3];

    // constructor

    public Alumno(String nombre, String[] asignaturas) {
        idActual++;
        this.id = idActual;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    // getter y setter

    public static int getIdActual() {
        return idActual;
    }

    public static void setIdActual(int idActual) {
        Alumno.idActual = idActual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(String[] asignaturas) {
        this.asignaturas = asignaturas;
    }

} // fin Alumno
