public class Book {
    private String name;
    private int yrOfRelease;
    private String genre;
    private String author;
    private int pages;

    public Book(String name, String author, int yrOfRelease) {
        this.name = name;
        this.author = author;
        this.yrOfRelease = yrOfRelease;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return this.name;
    }
}
