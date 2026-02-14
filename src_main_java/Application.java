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
        try(Connection conn = petterns.DatabaseManager.getInstance().getConnection()) {
            MangaRepository repo = new MangaRepository(conn);
            MangaService service = new MangaService(repo);
            
            List<Manga> firstCall = service.getSortedManga();//need for cache
            List<Manga> secondCall = service.getSortedManga();
            //secondCall = service.getFinishedManga(); for see only ended manga
            /* I start work to this, but I wanted to add him too late
        List<Review> sorted_r = service.getSortedReview();
        sorted_r = service.getFinishedReview();
        sorted_r.forEach(r -> {
            r.logEntity();
            r.displayDetails();
        });*/
            secondCall.forEach(m ->{
                m.logEntity();
                m.displayDetails();
            });
            System.out.println("--- RTTI Demo ---");
            if (!secondCall.isEmpty()) {
                utils.ReflectionUtils.inspect(secondCall.get(0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


           
