package myProject;

public class Jugadores extends FileManager {
    String name;
    private int level;
    private FileManager fileManager;

    public Jugadores(String name){
        fileManager = new FileManager();
        this.name = name;
        level = 1;

    }

    //Retorna la posicion del usuario en el array de usuarios
    public int buscarUsuario(){
        int posicion = 0;
        System.out.println("busca el usuario");
        for (int i = 0; i < fileManager.jugadoreslecturaFile().size()&&fileManager.jugadoreslecturaFile().get(i).length()!=0; i++) {
            System.out.println("busca la "+i);
            String usuario = fileManager.jugadoreslecturaFile().get(i).substring(0, fileManager.jugadoreslecturaFile().get(i).lastIndexOf(":"));
            if (usuario.equals(name)){
                posicion=i;
                break;
            }

        }
        return posicion;
    }


    public String getName() {
        return name;
    }

    public int getLevel(){
        String usuario = fileManager.jugadoreslecturaFile().get(buscarUsuario());
        String nivel = usuario.substring(usuario.lastIndexOf(":")+1);
        return Integer.valueOf (nivel);
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public void setLevel() {
        this.level = getLevel();
    }
}
