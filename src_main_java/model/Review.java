package model;

public class Review extends BaseEntity {
    private double score;

    public Review(int id, String name, double score) {
        super(id, name);
        this.score = score;
    }

    @Override
    public void displayDetails() {
        System.out.println("Review for: " + getName() + ", Score: " + score);
    }

    @Override
    public String getEntityType() { return "REVIEW"; }
}
