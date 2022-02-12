package myProject;

import java.util.ArrayList;
import java.util.Collections;

public class Control {
    private Diccionario diccionario;
    private ArrayList<String> words, totalWords;
    private int puntos, palabrasAMemorizar,palabrasDelNivel, nivel;
    private String palabraARecordar, palabraFinal;
    private boolean acierto;

    public Control(){
        diccionario = new Diccionario();
        puntos=0;
        nivel=1;
        words = new ArrayList<String>();
        totalWords = new ArrayList<String>();
    }

    /**
     * nos devuelve una palabra de las palabras a recordar
     * @return palabra
     */
    public String palabraArecordar(){
        for(int i=0; i < words.size(); i++){
            palabraARecordar = words.get(i);
        }
        return palabraARecordar;
    }

    /**
     *
     *
     */
    public String palabrasTotales(){
        for (int i=0; i < totalWords.size();i++){
            palabraFinal = totalWords.get(i);
        }
        return palabraFinal;
    }

    /**
     * compara una palabra de las palabras totales del nivel con alguna de las palabras a recordar, para verificar si acerto o no.
     * @return acierto
     */
    public boolean validarPalabra(Boolean clicked, Boolean pertenece){
        if(clicked==true){
            if(pertenece==true){
                for (int i=0; i < totalWords.size();i++){
                    if( words.contains(totalWords.get(i))){
                        acierto=true;
                    }else{
                        acierto=false;
                    }
                }
            }else{
                acierto=true;
            }
        }
        return acierto;
    }

    /**
     * Aumenta el numero de palabras a recordar y el nuemero de palabras del nivel dependiendo en que nivel se encuentre.
     */
    public void aumentarPalabras(){
        switch (nivel){
            case 1: palabrasAMemorizar=10;
                palabrasDelNivel=20;
                break;
            case 2: palabrasAMemorizar=20;
                palabrasDelNivel=40;
                break;
            case 3: palabrasAMemorizar=25;
                palabrasDelNivel=50;
                break;
            case 4: palabrasAMemorizar=30;
                palabrasDelNivel=60;
                break;
            case 5: palabrasAMemorizar=35;
                palabrasDelNivel=70;
                break;
            case 6: palabrasAMemorizar=40;
                palabrasDelNivel=80;
                break;
            case 7: palabrasAMemorizar=50;
                palabrasDelNivel=100;
                break;
            case 8: palabrasAMemorizar=60;
                palabrasDelNivel=120;
                break;
            case 9: palabrasAMemorizar=70;
                palabrasDelNivel=140;
                break;
            case 10: palabrasAMemorizar=100;
                palabrasDelNivel=200;
                break;
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

    /**
     * devuelve la cantidad de puntos dependiendo de los aciertos del jugador
     * @return puntos
     */
    public int getPuntos() {
        if (acierto==true){
            puntos++;
        }
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

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
