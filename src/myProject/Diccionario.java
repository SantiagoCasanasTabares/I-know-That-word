package myProject;

import java.util.ArrayList;
import java.util.Random;

public class Diccionario {

    private ArrayList<String> diccionario;
    private ArrayList<String> palabrasCorrectas;
    private ArrayList<String> palabrasTotales;

    public Diccionario() {
        FileManager fileManager = new FileManager();
        diccionario = fileManager.lecturaFile();
    }

    /**
     * Obtiene array de palabras aleatorias dependiendo el nivel en que vaya el usuario
     * @param  palabrasARecordar
     * @return array de palabras aleatorias a recordar
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
     * Obtiene array de palabras aleatorias dependiendo el nivel en que vaya el usuario
     * @param  totalPalaNivel
     * @return array de palabras totales a decir si estaban o no
     */
    public ArrayList<String> getTotalPalabras(int totalPalaNivel) {
        palabrasTotales = new ArrayList<String>(palabrasCorrectas);
        int i = palabrasTotales.size()-1;
        //entero en el tamaño de la lis ta-1 para que al sumar una arranque en la posicion que se debe poner la nueva palabra de la lista

        while (i < totalPalaNivel) {
            String nuevaPalabra = getFrase();//obtiene nueva palabra
            i++;//suma uno en la posicion
            if (!palabrasTotales.contains(nuevaPalabra)) {
                palabrasTotales.add(i, nuevaPalabra);//si no la contiene, la añade en la posicion i+1;
            }else{
                i--;//si la contiene, vuelve a restar el i en uno y empieza de nuevo;
            }
        }

        return palabrasTotales;
    }

    /**
     * obtiene una palabra aleatoria del diccionario.txt
     * @return palabra
     */
    public String getFrase() {
        Random aleatorio = new Random();
        return diccionario.get(aleatorio.nextInt(diccionario.size()));
    }

    public void setPalabrasCorrectas(ArrayList<String> palabrasCorrectas) {
        this.palabrasCorrectas = palabrasCorrectas;
    }

    public void setPalabrasTotales(ArrayList<String> palabrasTotales) {
        this.palabrasTotales = palabrasTotales;
    }

}
