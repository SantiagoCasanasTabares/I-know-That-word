package myProject;

public class Jugadores extends FileManager {
    private String name;
    private int level;

    public Jugadores(){
        name = "";
        level = 1;

    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
