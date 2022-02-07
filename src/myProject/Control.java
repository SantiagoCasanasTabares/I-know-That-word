package myProject;

public class Control {
    private Diccionario palabras;
    private int puntos, palabrasAMemorizar,palabrasDelNivel, nivel;
    private String palabra;
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
    public String obtenerPalabra(){
        for(int i=0; i<palabras.getPalabrasRecordar(palabrasAMemorizar).size(); i++){
            palabra= palabras.getPalabrasRecordar(palabrasAMemorizar).get(i);
        }
        return palabra;
    }

    /**
     * compara una palabra de las palabras totales del nivel con alguna de las palabras a recordar, para verificar si acerto o no.
     * @return acierto
     */
    public boolean validarPalabra(){
        for (int i=0; i<palabras.getTotalPalabras(palabrasDelNivel).size();i++){
            if( palabras.getTotalPalabras(palabrasDelNivel).get(i) == obtenerPalabra()){
                acierto=true;
            }else{
                acierto=false;
            }
        }
        return acierto;
    }

    /**
     *
     */
    public void siguienteNivel(){

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
     * devuelve la cantidad de puntos dependiendo de los aciertos del jugador
     * @return puntos
     */
    public int getPuntos() {
        if (validarPalabra()){
            puntos++;
        }
        return puntos;
    }
}
