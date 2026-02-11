package model;

public class Manga extends BaseEntity {
    private int chapters;
    private boolean isContinuing;

    private Manga(Builder builder) {
        super(builder.id, builder.name);
        this.chapters = builder.chapters;
        this.isContinuing = builder.isContinuing;
    }

    public Manga(int id, String name, int chapters, boolean isContinuing) {
        super(id, name);
        this.chapters = chapters;
        this.isContinuing = isContinuing;
    }

    public static class Builder {
        private int id;
        private String name;
        private int chapters;
        private boolean isContinuing;

        public Builder id(int id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder chapters(int chapters) { this.chapters = chapters; return this; }
        public Builder isContinuing(boolean isContinuing) { this.isContinuing = isContinuing; return this; }

        public Manga build() {
            return new Manga(this);
        }
    }

    @Override public void displayDetails() { System.out.println("Manga: " + getName() + " , Chapters: " + chapters); }
    @Override public String getEntityType() { return "MANGA"; }
    public boolean getIsContinuing() { return isContinuing; }
}
