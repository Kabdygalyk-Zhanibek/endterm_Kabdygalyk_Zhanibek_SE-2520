import model.Manga;
import repository.MangaRepository;
import service.MangaService;
import utils.ReflectionUtils;

import java.sql.*;
import java.util.List;

/*
@RestController
@RequestMapping("/api")
*/
public class Application {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/manga_list";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "Janibek590!")) {
            MangaRepository repo = new MangaRepository(conn);
            MangaService service = new MangaService(repo);

            List<Manga> sorted = service.getSortedManga();
            //sorted = service.getFinishedManga();//You can delete this for make all manga
            sorted.forEach(m -> {
                m.logEntity();
                m.displayDetails();
            });

        /* I start work to this, but I wanted to add him too late
        List<Review> sorted_r = service.getSortedReview();
        sorted_r = service.getFinishedReview();
        sorted_r.forEach(r -> {
            r.logEntity();
            r.displayDetails();
        });*/

            System.out.println("--- RTTI Demo ---");
            if (!sorted.isEmpty()) {
                ReflectionUtils.inspect(sorted.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
