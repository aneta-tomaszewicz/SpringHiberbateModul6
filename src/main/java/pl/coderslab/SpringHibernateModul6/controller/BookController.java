package pl.coderslab.SpringHibernateModul6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringHibernateModul6.dao.AuthorDao;
import pl.coderslab.SpringHibernateModul6.dao.BookDao;
import pl.coderslab.SpringHibernateModul6.dao.PublisherDao;
import pl.coderslab.SpringHibernateModul6.entity.Author;
import pl.coderslab.SpringHibernateModul6.entity.Book;
import pl.coderslab.SpringHibernateModul6.entity.Category;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;
import pl.coderslab.SpringHibernateModul6.repository.BookRepository;
import pl.coderslab.SpringHibernateModul6.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping ("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/byTitle/{title}")
    @ResponseBody
    public String findByTitleRepository(@PathVariable("title") String title) {
        return bookRepository.findFirstByTitle(title)
                .map(Book::toString)
                .orElse("Ksiazki nie znaleizono o zadanym tytule");
    }

    @GetMapping("/byCat/{idCategory}")
    @ResponseBody
    public String findByCatObject(@PathVariable("idCategory") long idCategory) {
        Category cat = categoryRepository.getById(idCategory);
        return bookRepository.findAllByCategory(cat)
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("<br />"));
    }

    @GetMapping("/byCategoryId/{idCategory}")
    @ResponseBody
    public String findByCatId(@PathVariable("idCategory") long idCategory) {
        return bookRepository.findAllByCategory_Id(idCategory)
                .stream()
                .map(Book::toString)
                .collect(Collectors.joining("<br />"));
    }



    @RequestMapping("/add")
    @ResponseBody
    public String addBook() {
        Publisher publisher = new Publisher();
        publisher.setName("LubimyCzytać.pl");
        publisherDao.persist(publisher);
        Book book = new Book();
        book.setTitle("Dym");
        book.setDescription("W noweli ukazana została wzajemna, bezinteresowna miłość matki i syna. ");
        book.setRating(4);
        book.setPublisher(publisher);
        bookDao.persist(book);
        return "Id dodanej książki " + book.getTitle() + " to: " + book.getId();
    }

    @RequestMapping("/addWithExist")
    @ResponseBody
    public String addWithExist() {
        Publisher publisher = publisherDao.findById(3);
        Author firstAuthor = authorDao.findById(5);
        Author secondAuthor = authorDao.findById(6);
        Book book = new Book();
        book.setTitle("Władcy samotności");
        book.setDescription("Akcja rozgrywa się w bliżej nieokreślonej przyszłości po jakimś kataklizmie, który całkowicie zmienił obraz cywilizacji.");
        book.setRating(5);
        book.setPublisher(publisher);
        book.getAuthors().add(firstAuthor);
        book.getAuthors().add(secondAuthor);
        firstAuthor.getBooks().add(book);
        secondAuthor.getBooks().add(book);
        bookDao.persist(book);
        return book.toString();
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String findBookById(@PathVariable long id) {
        Book book = bookDao.findById(id);
        return book.toString();
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String title) {
        Book book = bookDao.findById(id);
        book.setTitle("Dym1");
        bookDao.update(book);
        return book.toString();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable long id) {
        bookDao.remove(id);
        return "Książka usunięta";
    }

    @RequestMapping("/all")
    @ResponseBody
    public String findAll(){
        List<Book>allBooks = bookDao.findAll();
        return allBooks.stream()
                .map(book -> book.getId()+ ": " + book.getTitle())
                .collect(Collectors.joining("<br />"));
    }

    @RequestMapping("/rating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating){
        List<Book>allBooksByRating = bookDao.findAllByRating(rating);
        return allBooksByRating.stream()
                .map(book-> book.getId() +" Title: "+book.getTitle()+ " Rating: "+ book.getRating())
                .collect(Collectors.joining("<br/>"));
    }

    @RequestMapping("/publisher/any")
    @ResponseBody
    public String findWithAnyPublisher(){
        List<Book>allBooksWithAnyPublisher = bookDao.findWithAnyPublisher();
        return allBooksWithAnyPublisher.stream()
                .map(book -> book.getId() + " Tytuł:"+ book.getTitle()+ " Publisher: "+book.getPublisher())
                .collect(Collectors.joining("<br/>"));

    }

    @RequestMapping("/publisher/{publisherId}")
    @ResponseBody
    public String findAllWithPublisher(@PathVariable long publisherId){
        Publisher publisher = publisherDao.findById(publisherId);
        List<Book>allBooksWithPublisher = bookDao.findAllWithPublisher(publisher);
        return  allBooksWithPublisher.stream()
                .map(book -> book.getId() + " Tytuł: " + book.getTitle())
                .collect(Collectors.joining("<br/>"));
    }
    @RequestMapping("/author/{authorId}")
    @ResponseBody
    public String findAllWithAuthor(@PathVariable long authorId){
        Author author = authorDao.findById(authorId);
        List<Book>allWithAuthors = bookDao.findAllWithAuthor(author);
        return allWithAuthors.stream()
                .map(book -> book.getId() + " Tytuł: "+ book.getTitle())
                .collect(Collectors.joining("<br/>"));
    }
}
