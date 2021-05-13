import behaviours.IPlay;

public class Player {


    private String name;
    private int health;
    private IPlay character;

    public Player(String name, int health, IPlay character){
        this.name = name;
        this.health = health;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public IPlay getCharacter() {
        return character;
    }

    public void setCharacter(IPlay character) {
        this.character = character;
    }
}
