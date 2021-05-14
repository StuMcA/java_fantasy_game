package items;

public class Treasure extends Item  {

    private String type;
    private int value;

    public Treasure(String type, int value) {
        super(value);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
