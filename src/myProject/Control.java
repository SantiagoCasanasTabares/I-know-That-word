package myProject;

import java.util.ArrayList;


public class Control {
    private Diccionario diccionario;
    private ArrayList<String> words, totalWords;
    private int puntos, palabrasAMemorizar,palabrasDelNivel, nivel;
    private Jugadores jugadores;
    private ArrayList<Boolean> aciertos;


    public Control(String name){
        jugadores = new Jugadores(name);
        diccionario = new Diccionario();
        puntos=0;
        nivel = 0;
        words = new ArrayList<String>();
        totalWords = new ArrayList<String>();
        aciertos = new ArrayList<Boolean>();
    }


    /**
     * compara una palabra de las palabras totales del nivel con alguna de las palabras a recordar, para verificar si acerto o no.
     * @return acierto
     */
    public ArrayList<Boolean> validarPalabra(){
        for (String element: totalWords){
            aciertos.add(words.contains(element));
        }
        return aciertos;
    }


    /**
     * Aumenta el numero de palabras a recordar y el nuemero de palabras del nivel dependiendo en que nivel se encuentre.
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
     *
     */
    public void siguienteNivel(){
        if((nivel==1 || nivel==2) && getPuntos()==(palabrasDelNivel*0.7)){
            nivel++;
        }else if(nivel==3 && getPuntos()==Math.round(palabrasDelNivel*0.75)){
            nivel++;
        }else if((nivel==4 || nivel==5) && getPuntos()==(palabrasDelNivel*0.8)){
            nivel++;
        }else if(nivel==6 && getPuntos()==(palabrasDelNivel*0.85)){
            nivel++;
        }else if((nivel==7 && nivel==8) && getPuntos()==(palabrasDelNivel*0.9)){
            nivel++;
        }else if(nivel==9 && getPuntos()==(palabrasDelNivel*0.95)){
            nivel++;
        }
    }

    public void sumarPuntos(Boolean aciertosDelJugador) {
        if (aciertosDelJugador){
            puntos++;
        } else {
            //puntos +=0;
        }
    }


    /**
     * devuelve la cantidad de puntos dependiendo de los aciertos del jugador
     * @return puntos
     */
    public int getPuntos() {
        return puntos;
    }

    public void setPalabrasInicial() {
        words = diccionario.getPalabrasRecordar(palabrasAMemorizar);
    }

    public void setPalabrasTotales() {
        totalWords = diccionario.getTotalPalabras(palabrasDelNivel);
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public ArrayList<String> getTotalWords() {
        return totalWords;
    }

    public void setNivel() {
        this.nivel = jugadores.getLevel();
    }

    public int getNivel() {
        return nivel;
    }
}
