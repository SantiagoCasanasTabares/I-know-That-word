package myProject;

import java.io.*;
import java.util.ArrayList;

/**
 * @autor Santiago Casañas Tabares 2025301 - Jesus Adrian Peña Güetio 2025513
 * santiago.casanas@correounivalle.edu.co - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/02/2022
 */

public class FileManager {
    public static final String PATHPALABRAS = "src/myProject/files/diccionario.txt";
    public static final String PATHJUGADORES = "src/myProject/files/jugadores.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;


    /**
     * reads the text file of words and group them into an array
     * @return array of the words in the text file
     */
    public ArrayList<String> lecturaFile() {
        ArrayList<String> frases = new ArrayList<String>();

        try {
            fileReader = new FileReader(PATHPALABRAS);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                frases.add(line);
                line=input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return frases;
    }


    /**
     * Write the name players in the text file
     * @param linea
     */
    public void escribirTexto(String linea){
        try {
            fileWriter = new FileWriter(PATHJUGADORES,true);
            output = new BufferedWriter(fileWriter);
            output.write(linea);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * reads the text file of players and group them into an array
     * @return array of the words in the text file
     */
    public ArrayList<String> jugadoreslecturaFile() {
        ArrayList<String> jugadores = new ArrayList<String>();

        try {
            fileReader = new FileReader(PATHJUGADORES);
            input = new BufferedReader(fileReader);
            String line = input.readLine();
            while(line!=null){
                jugadores.add(line);
                line=input.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jugadores;
    }

    /**
     * modify array of players to set the new level to a given user
     * @param nivel
     * @param posicion
     */
    public void actualizarNivel( int nivel, int posicion){
        try {
            ArrayList<String> jugadoresActulizar = jugadoreslecturaFile();
            String usuarioAntiguo = jugadoresActulizar.get(posicion);
            String usuarioActualizado = usuarioAntiguo.substring(0, usuarioAntiguo.lastIndexOf(":")+1) +  nivel;
            jugadoresActulizar.remove(posicion);
            jugadoresActulizar.add(posicion,usuarioActualizado);
            fileWriter = new FileWriter(PATHJUGADORES,false);
            output = new BufferedWriter(fileWriter);
            for (int i=0;i<jugadoresActulizar.size();i++){
                output.write(jugadoresActulizar.get(i));
                output.newLine();

            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




