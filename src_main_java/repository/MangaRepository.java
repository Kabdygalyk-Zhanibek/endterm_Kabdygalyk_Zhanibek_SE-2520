package repository;

import model.Manga;
import petterns.CacheManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangaRepository implements CrudRepository<Manga> {
    private final Connection connection;
    private final CacheManager cache = CacheManager.getInstance();

    public MangaRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Manga> getAll() {
        String cacheKey = "manga";//change
        if (cache.contains(cacheKey)) {
            System.out.println("--- Returning data from CACHE ---");
            return (List<Manga>) cache.get(cacheKey);
        }

        System.out.println("--- Querying DATABASE ---");
        List<Manga> list = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM manga")) {
            while (rs.next()) {
                list.add(new Manga(
                        rs.getInt("manga_id"),
                        rs.getString("manga_name"),
                        rs.getInt("num_chapters"),
                        rs.getBoolean("continue")
                ));
            }
            cache.put(cacheKey, list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override public void create(Manga entity) { cache.clear(); }
    @Override public Manga getById(int id) { return null; }
    @Override public void update(Manga entity) { cache.clear(); }
    @Override public void delete(int id) { cache.clear(); }
}
