package ejercicio3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio3 {
    //leer numero positivo hasta introducir un negativo
    //almacenar el num en el fichero "tres.dat" OJO
    //usando objects

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        String pathFichero = "src//ejercicio3//tres.dat";
        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new FileOutputStream(pathFichero));
            int num;
            num = teclado.nextInt();
            while (num > -1) {
                escritor.writeObject((Integer) num);
                num = teclado.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (escritor!=null)
                escritor.close();
        }

        ObjectInputStream lector = null;

        try {
            lector = new ObjectInputStream(new FileInputStream(pathFichero));
            int num = (int) lector.readObject();
            while (lector.available()>0) {
                System.out.println(num);
                num = (int) lector.readObject();
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println(e.getMessage());    
        } finally {
            if (lector!=null)
                lector.close();
        }

        teclado.close();
    }

}
