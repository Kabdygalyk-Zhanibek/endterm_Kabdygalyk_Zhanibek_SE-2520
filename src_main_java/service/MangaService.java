package service;

import model.Manga;
import model.Review;
import repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MangaService {
    private final CrudRepository<Manga> repository;

    public MangaService(CrudRepository<Manga> repository) {
        this.repository = repository;
    }

    public List<Manga> getSortedManga() {
        List<Manga> mangas = repository.getAll();
        mangas.sort((m1, m2) -> m1.getName().compareToIgnoreCase(m2.getName()));
        return mangas;
    }

    public List<Manga> getFinishedManga() {
        return repository.getAll().stream()
                .filter(m -> m.getIsContinuing() == false)
                .collect(Collectors.toList());
    }
}