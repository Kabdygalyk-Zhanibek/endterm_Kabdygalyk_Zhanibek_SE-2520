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

REP I share this code in GitHub and add teg
CCP I grouped class with same task
CRP I don't grouped classes, what are haven't same task or other

U need to divide task of one to many others, they need to connected to other and use for this abstract and interface
I use abstract classes and interfaces abstract method have polymorphism and I connected to classes with using a
getter and setter.

I add Database Schema in docs like photo and text with name "manga_list"

Client give data -> with Service sorted this data -> Repository get data -> BaseEntity displayed data

enter url, username, password in application.properties, next run Application class, next is in Postman
GET http://localhost:8080/...(@RequestMapping)/...(GetMapping) send this and make data

I don't understand why @RestController, @RequestMapping and other is not work may I don't download
some library or other, so this why I con not connect this code to Postman, I and Singleton, Factory and 
Builder is littly create problem, for understand and for write code (Exactly I not sure, I write them correct 
or not).



for bonus task I add new class CacheManager for this class I use solution, so this why we know about 
created only one class CacheManager, I create method for get data (many of them just return data, 
one clear/del data (how min, I think like this))and use him in MangaRepository 
and use all new method in him, for (maybe) get data faster.
In Application, I don't add some new method, I just little "rephrase" him and use MangaService twice for
cache.
