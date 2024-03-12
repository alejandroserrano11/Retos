package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {

        // apartado A

        System.out.println();
        puntoA();

        // apartado B y C

        System.out.println();
        puntoBC();

    }

    public static void puntoA() throws IOException {
        // metodo apartado a
        // mostrar directorio actual

        System.out.println(System.getProperty("user.dir"));

        // crear directorio dirEjer2 (comprobar antes que existe)
        File directorio = new File("dirEjer2");
        if (directorio.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            directorio.mkdir();
        }

        // crear dos ficheros uno.txt y dos.txt comprobar que existe

        File fileUno = new File("dirEjer2//uno.txt");
        File fileDos = new File("dirEjer2//dos.txt");

        if (fileUno.exists()) {
            System.out.println("El fichero: " + fileUno.getName() + " ya existe");
        } else {
            fileUno.createNewFile();
        }

        if (fileDos.exists()) {
            System.out.println("El fichero: " + fileDos.getName() + " ya existe");
        } else {
            fileDos.createNewFile();
        }

    }

    public static void puntoBC() throws IOException {
        // apartado B y C

        // abrir el fichero uno para escritura, usar bufferedwriter y filewriter y 
        // pedir al usuario un nombre hasta que el introducido sea solo: "-"

        BufferedWriter escritor = null;
        String nombre;
        Scanner teclado = new Scanner(System.in);

        try {
            escritor = new BufferedWriter(new FileWriter(new File("dirEjer2//uno.txt")));
            do{
                System.out.println("Introduce nombre por pantalla: ");
                System.out.println("Introduce - para finalizar");
                nombre = teclado.nextLine();
                if (!nombre.equals("-")){
                    escritor.write(nombre + "\n");
                }
            } while (!nombre.equals("-"));
                    teclado.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor != null) {
                escritor.close();
            }
        }

    }

    
    
    
}


