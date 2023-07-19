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

        /* 
        System.out.println("How many books there are in your list: ");
        int numOfBooks = scanner.nextInt();
        Book[] books = new Book[numOfBooks];

        for (int i = 0; i < numOfBooks; i++) {
            System.out.println("Enter the name of the book: ");
            String name = scanner.next();
            System.out.println("Enter the author of the book: ");
            String author = scanner.next();
            System.out.println("Enter the year of release of the book: ");
            int yrOfRelease = scanner.nextInt();
            
            books[i] = new Book(name, author, yrOfRelease);

            if (i == numOfBooks - 1) {
                System.out.println("Okay, done. ");
            } else {
                System.out.println("Next book: ");
            }
        }
        */