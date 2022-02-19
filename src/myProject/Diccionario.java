package myProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @autor Santiago Casañas Tabares 2025301 - Jesus Adrian Peña Güetio 2025513
 * santiago.casanas@correounivalle.edu.co - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/02/2022
 */

public class Diccionario {

    private ArrayList<String> diccionario;
    private ArrayList<String> palabrasCorrectas;
    private ArrayList<String> palabrasTotales;

    public Diccionario() {
        palabrasCorrectas = new ArrayList<String>();
        palabrasTotales = new ArrayList<String>();
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
    }

    /**
     * Gets array of random words depending on the user's level of knowledge
     * @return array of random words to remember
     */
    public ArrayList<String> getPalabrasRecordar(int palabrasARecordar) {
        int i = -1;
        //entero en -1 para que al sumar una arranque en la posicion 0 de la lista

        while (i < palabrasARecordar-1) {
            String nuevaPalabra = getFrase();//obtiene una palabra del diccionario
            i++;//suma 1 al i para ahora estar en la posicion a poner el numero
            if (!palabrasCorrectas.contains(nuevaPalabra)) {
                palabrasCorrectas.add(i, nuevaPalabra);//si palabrasCorrectas no contiene la nueva palabra, la añade
            }else{
                i--;//si la contiene, resta el i en uno, para así estar en la posicion anterior y repetir el while;
            }
        }
        return palabrasCorrectas;
    }




    /**
     * Gets array of random words depending on the user's level of knowledge
     * @return array of total words to tell if they were there or not
     */
    public ArrayList<String> getTotalPalabras(int totalPalaNivel) {
        palabrasTotales = new ArrayList<>(palabrasCorrectas);
        int i = palabrasTotales.size()-1;
        //entero en el tamaño de la lis ta-1 para que al sumar una arranque en la posicion que se debe poner la nueva palabra de la lista

        while (i < totalPalaNivel-1) {
            String nuevaPalabra = getFrase();//obtiene nueva palabra
            i++;//suma uno en la posicion
            if (!palabrasTotales.contains(nuevaPalabra)) {
                palabrasTotales.add(i, nuevaPalabra);//si no la contiene, la añade en la posicion i+1;
            }else{
                i--;//si la contiene, vuelve a restar el i en uno y empieza de nuevo;
            }
        }
        Collections.shuffle(palabrasTotales);
        return palabrasTotales;
    }

    /**
     * gets a random word from dictionary.txt
     * @return word
     */
    public String getFrase() {
        Random aleatorio = new Random();
        return diccionario.get(aleatorio.nextInt(diccionario.size()));
    }


}
