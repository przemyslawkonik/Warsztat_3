package pl.coderslab.model;

public class Group extends Model {
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
