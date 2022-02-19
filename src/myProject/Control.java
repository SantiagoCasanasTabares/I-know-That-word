package myProject;

import java.util.ArrayList;

/**
 * Esta clase es usada para manejar toda la logica del juego
 * @author Santiago Casañas - santiago.casanas@correounivalle.edu.co
 * @author Jesus Adrian Peña - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/02/2022
 */
public class Control {
    private Diccionario diccionario;
    private ArrayList<String> words, totalWords;
    private int puntos, palabrasAMemorizar,palabrasDelNivel, nivel;
    private Jugadores jugadores;
    private ArrayList<Boolean> aciertos;
    private boolean nextLevel;


    /**
     * class constructor
     * @param name
     */
    public Control(String name){
        jugadores = new Jugadores(name);
        diccionario = new Diccionario();
        puntos=0;
        nivel = 0;
        words = new ArrayList<String>();
        totalWords = new ArrayList<String>();
        aciertos = new ArrayList<Boolean>();
        nextLevel = false;
    }


    /**
     * Compares the words to be memorized by the user with the total words of the level,
     * and stores in a list the resulting Booleans
     * @return hits
     */
    public ArrayList<Boolean> validarPalabra(){
        aciertos.clear();
        for (String element: totalWords){
            aciertos.add(words.contains(element));
        }
        return aciertos;
    }


    /**
     * Increases the number of words to remember and the total number of words in the level depending on which level you are in.
     */
    public void aumentarPalabras(){
        switch (nivel) {
            case 1 -> {
                palabrasAMemorizar = 10;
                palabrasDelNivel = 20;
            }
            case 2 -> {
                palabrasAMemorizar = 20;
                palabrasDelNivel = 40;
            }
            case 3 -> {
                palabrasAMemorizar = 25;
                palabrasDelNivel = 50;
            }
            case 4 -> {
                palabrasAMemorizar = 30;
                palabrasDelNivel = 60;
            }
            case 5 -> {
                palabrasAMemorizar = 35;
                palabrasDelNivel = 70;
            }
            case 6 -> {
                palabrasAMemorizar = 40;
                palabrasDelNivel = 80;
            }
            case 7 -> {
                palabrasAMemorizar = 50;
                palabrasDelNivel = 100;
            }
            case 8 -> {
                palabrasAMemorizar = 60;
                palabrasDelNivel = 120;
            }
            case 9 -> {
                palabrasAMemorizar = 70;
                palabrasDelNivel = 140;
            }
            case 10 -> {
                palabrasAMemorizar = 100;
                palabrasDelNivel = 200;
            }
        }
    }

    /**
     * Increases the player's level depending on the number of hits he/she had
     * @param aciertosDeLaRonda
     */

    public void siguienteNivel(int aciertosDeLaRonda){
        if((nivel==1 || nivel==2) && aciertosDeLaRonda>=(palabrasDelNivel*0.7)){
            nivel++;
            puntos=0;
            nextLevel = true;
        }else if(nivel==3 && aciertosDeLaRonda>=Math.round(palabrasDelNivel*0.75)){
            nivel++;
            puntos=0;
            nextLevel = true;
        }else if((nivel==4 || nivel==5) && aciertosDeLaRonda>=(palabrasDelNivel*0.8)){
            nivel++;
            puntos=0;
            nextLevel = true;
        }else if(nivel==6 && aciertosDeLaRonda>=(palabrasDelNivel*0.85)){
            nivel++;
            puntos=0;
            nextLevel = true;
        }else if((nivel==7 && nivel==8) && aciertosDeLaRonda>=(palabrasDelNivel*0.9)){
            nivel++;
            puntos=0;
            nextLevel = true;
        }else if(nivel==9 && aciertosDeLaRonda>=(palabrasDelNivel*0.95)){
            nivel++;
            puntos=0;
            nextLevel = true;
        }else if(nivel==10 && aciertosDeLaRonda>=(palabrasDelNivel*1)){
            nextLevel = true;
        }
    }

    /**
     * returns a boolean to know if the player passed a level.
     * @return nextLevel
     */
    public boolean isNextLevel() {
        return nextLevel;
    }

    /**
     * establece un valor a nextLevel
     * @param nextLevel
     */
    public void setNextLevel(boolean nextLevel) {
        this.nextLevel = nextLevel;
    }

    /**
     * sets a value to nextLevel
     * @param aciertosDelJugador
     */
    public void sumarPuntos(Boolean aciertosDelJugador) {
        if (aciertosDelJugador){
            puntos++;
        }
    }


    /**
     * returns the number of hits of the player
     * @return points
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Sets the initial words to remember
     */
    public void setPalabrasInicial() {
        words.clear();
        words = diccionario.getPalabrasRecordar(palabrasAMemorizar);
    }

    /**
     * Sets the total words
     */
    public void setPalabrasTotales() {
        totalWords.clear();
        totalWords = diccionario.getTotalPalabras(palabrasDelNivel);
    }

    /**
     * returns a list of words to be remembered
     * @return words
     */
    public ArrayList<String> getWords() {
        return words;
    }

    /**
     * Returns a list with the total word list
     * @return
     */
    public ArrayList<String> getTotalWords() {
        return totalWords;
    }

    /**
     * sets the player's level
     */
    public void setNivel() {
        this.nivel = jugadores.getLevel();
    }

    /**
     * Returns the player's level
     * @return nivel
     */
    public int getNivel() {
        return nivel;
    }
}
