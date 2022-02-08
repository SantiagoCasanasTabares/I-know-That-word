package myProject;

import java.util.Collections;

public class Control {
    private Diccionario palabras;
    private int puntos, palabrasAMemorizar,palabrasDelNivel, nivel;
    private String palabraARecordar, palabraFinal;
    private boolean acierto;

    public Control(){
        palabras = new Diccionario();
        puntos=0;
        nivel=1;
    }

    /**
     * nos devuelve una palabra de las palabras a recordar
     * @return palabra
     */
    public String palabraArecordar(){
        for(int i=0; i<palabras.getPalabrasRecordar(palabrasAMemorizar).size(); i++){
            palabraARecordar= palabras.getPalabrasRecordar(palabrasAMemorizar).get(i);
        }
        return palabraARecordar;
    }

    /**
     *
     *
     */
    public String palabrasTotales(){
        Collections.shuffle(palabras.getTotalPalabras(palabrasDelNivel));
        for (int i=0; i<palabras.getTotalPalabras(palabrasDelNivel).size();i++){
            palabraFinal = palabras.getTotalPalabras(palabrasDelNivel).get(i);
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
                for (int i=0; i<palabras.getTotalPalabras(palabrasDelNivel).size();i++){
                    if( palabras.getTotalPalabras(palabrasDelNivel).get(i) == palabraArecordar()){
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
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=20;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 2: palabrasAMemorizar=20;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=40;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 3: palabrasAMemorizar=25;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=50;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 4: palabrasAMemorizar=30;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=60;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 5: palabrasAMemorizar=35;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=70;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 6: palabrasAMemorizar=40;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=80;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 7: palabrasAMemorizar=50;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=100;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 8: palabrasAMemorizar=60;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=120;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 9: palabrasAMemorizar=70;
                    palabras.getPalabrasRecordar(palabrasAMemorizar);
                    palabrasDelNivel=140;
                    palabras.getTotalPalabras(palabrasDelNivel);
                    break;
            case 10: palabrasAMemorizar=100;
                     palabras.getPalabrasRecordar(palabrasAMemorizar);
                     palabrasDelNivel=200;
                     palabras.getTotalPalabras(palabrasDelNivel);
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
}
