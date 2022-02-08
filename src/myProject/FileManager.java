package myProject;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static final String PATHPALABRAS = "src/myProject/files/diccionario.txt";
    public static final String PATHJUGADORES = "src/myProject/files/jugadores.txt";
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;



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


    //
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



}
