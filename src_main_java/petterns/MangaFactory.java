package petterns;

import model.BaseEntity;
import model.Manga;
import model.Review;

public class MangaFactory {
    public static BaseEntity createEntity(String type, int id, String name, int param, boolean isContinuing) {
        if (type.equalsIgnoreCase("MANGA")) {
            return new Manga(id, name, param, isContinuing);
        } else if (type.equalsIgnoreCase("REVIEW")) {
            return new Review(id, name, (double) param);
        }
        throw new IllegalArgumentException("Unknown type: " + type);
    }
}