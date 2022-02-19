package myProject;

/**
 * @autor Santiago Casañas Tabares 2025301 - Jesus Adrian Peña Güetio 2025513
 * santiago.casanas@correounivalle.edu.co - jesus.guetio@correounivalle.edu.co
 * @version v.1.0.0 date:18/02/2022
 */

public class Jugadores extends FileManager {
    String name;
    private int level;
    private FileManager fileManager;


    public Jugadores(String name){
        fileManager = new FileManager();
        this.name = name;
        level = 1;

    }


    /**
     * Search for the name of a user in an array of users.
     * @return user's position in user array
     */
    public int buscarUsuario(){
        int posicion = 0;
        //System.out.println("busca el usuario");
        for (int i = 0; i < fileManager.jugadoreslecturaFile().size()&&fileManager.jugadoreslecturaFile().get(i).length()!=0; i++) {
            //System.out.println("busca en "+i);
            String usuario = fileManager.jugadoreslecturaFile().get(i).substring(0, fileManager.jugadoreslecturaFile().get(i).lastIndexOf(":"));
            if (usuario.equals(name)){
                //System.out.println(i);
                posicion=i;
                break;
            }
        }
        return posicion;

    }


    /**
     * Get the user name
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the user level
     * @return user level
     */
    public int getLevel(){
        String usuario = fileManager.jugadoreslecturaFile().get(buscarUsuario());
        String nivel = usuario.substring(usuario.lastIndexOf(":")+1);
        return Integer.valueOf (nivel);
    }

    /**
     * set the user's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the user's level
     */
    public void setLevel() {
        this.level = getLevel();
    }
}