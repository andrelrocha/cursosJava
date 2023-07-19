import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Movie[] movies = new Movie[3];
        
        
        Movie movieBatman = new Movie("Batman Begins", 2005);
        movieBatman.setDirector("Christopher Nolan");
        movieBatman.setGenre("Action");
        movieBatman.setCast(new String[] {"Christian Bale", "Michael Caine", "Liam Neeson", "Katie Holmes", "Gary Oldman", "Cillian Murphy", "Morgan Freeman", "Tom Wilkinson"});
        movieBatman.setRating(8.2);
        movieBatman.setDuration(140);
        movies[0] = movieBatman;

        Movie movieAvengers = new Movie("Avengers: Endgame", 2019);
        movieAvengers.setDirector("Anthony Russo");
        movieAvengers.setGenre("Action");
        movieAvengers.setCast(new String[] {"Robert Downey Jr.", "Chris Evans", "Mark Ruffalo", "Chris Hemsworth", "Scarlett Johansson", "Jeremy Renner", "Don Cheadle", "Paul Rudd", "Brie Larson", "Karen Gillan", "Danai Gurira", "Benedict Wong", "Jon Favreau", "Bradley Cooper", "Gwyneth Paltrow", "Josh Brolin"});
        movieAvengers.setRating(8.4);
        movieAvengers.setDuration(181);
        movieAvengers.setIsAvailabe(true);
        movies[1] = movieAvengers;


        Movie movieInception = new Movie("Inception", 2010);
        movieInception.setDirector("Christopher Nolan");    
        movieInception.setGenre("Action");
        movieInception.setCast(new String[] {"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page", "Tom Hardy", "Ken Watanabe", "Dileep Rao", "Cillian Murphy", "Tom Berenger", "Marion Cotillard", "Pete Postlethwaite", "Michael Caine"});
        movieInception.setRating(8.8);
        movieInception.setDuration(148);
        movieInception.setIsAvailabe(true);
        movies[2] = movieInception;



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

    }
}