package model;

public abstract class BaseEntity {
    private int id;
    private String name;

    public BaseEntity(int id, String name) {
        setId(id);
        setName(name);
        //Yes, I know I can do this without set...(), but maybe I will be use this for INSERT INTO
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public abstract void displayDetails();
    public abstract String getEntityType();

    public void logEntity() {
        System.out.println("Entity [" + getEntityType() + "]: " + name);
    }
}