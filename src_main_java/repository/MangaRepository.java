package repository;

import model.Manga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MangaRepository implements CrudRepository<Manga> {
    private final Connection connection;

    public MangaRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Manga> getAll() {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override public void create(Manga entity) {}
    @Override public Manga getById(int id) { return null; }
    @Override public void update(Manga entity) {}
    @Override public void delete(int id) {}
}