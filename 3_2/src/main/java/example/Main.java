package example;

import java.util.List;

import static example.Movie.MovieType.*;

public class Main {
    public static final Movie REMBO = createMovie("Rembo", REGULAR);
    public static final Movie LOTR = createMovie("Lord of the Rings", NEW_RELEASE);
    public static final Movie HARRY_POTTER = createMovie("Harry Potter", CHILDRENS);

    public static void main(String[] args) {
        List<Rental> rentals = initializeRentals();
        Customer customer = new Customer("John Doe", rentals);
        String statement = customer.statement();

        System.out.println(statement);
    }

    private static Movie createMovie(String title, Movie.MovieType type) {
        return new Movie(title, type);
    }

    private static List<Rental> initializeRentals() {
        return List.of(
                new Rental(REMBO, 1),
                new Rental(LOTR, 4),
                new Rental(HARRY_POTTER, 5)
        );
    }
}
