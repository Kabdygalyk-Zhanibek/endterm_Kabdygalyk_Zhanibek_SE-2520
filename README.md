I use Singleton Pattern(BaseEntity with him subclasses), Factory Pattern(Service, Repository, etc.), 
Builder Pattern(when sorted and maybe BaseEntity(or other new class) if I add method for add new manga) and
REP, CCP, CRP
And display mangas, chapters and can display only what of them are ended, also display, and what the entity displayed and 
what the date from him and name of fields and methods

how I understand if I add this
@GetMapping // GET http://localhost:8080/api/manga
public List<Manga> getAllManga() {
return mangaService.getSortedManga();
}
In some class then I may display all data in list of Manga. 

Singleton in DatabaseManager() is need for connect to database and from hir make all info, before this do Application
, Factory in MangaFactory() is need for create a new data in some class just with adding some data
, Builder in Manga() is need for create new Manga 

