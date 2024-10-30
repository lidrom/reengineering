package example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private static final Movie REMBO = new Movie("Rembo", Movie.MovieType.REGULAR);
    private static final Movie LOTR = new Movie("Lord of the Rings", Movie.MovieType.NEW_RELEASE);
    private static final Movie HARRY_POTTER = new Movie("Harry Potter", Movie.MovieType.CHILDRENS);

    @Test
    public void testStatementWithSingleRentalRegularMovie() {
        List<Rental> rentals = List.of(new Rental(REMBO, 1));
        Customer customer = new Customer("John Doe", rentals);

        String expectedStatement = """
            Rental Record for John Doe
            \tRembo\t2.0
            Amount owed is 2.0
            You earned 1 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithSingleRentalNewReleaseMovie() {
        List<Rental> rentals = List.of(new Rental(LOTR, 4));
        Customer customer = new Customer("John Doe", rentals);

        String expectedStatement = """
            Rental Record for John Doe
            \tLord of the Rings\t12.0
            Amount owed is 12.0
            You earned 2 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithSingleRentalChildrensMovie() {
        List<Rental> rentals = List.of(new Rental(HARRY_POTTER, 5));
        Customer customer = new Customer("John Doe", rentals);

        String expectedStatement = """
            Rental Record for John Doe
            \tHarry Potter\t4.5
            Amount owed is 4.5
            You earned 1 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }

    @Test
    public void testStatementWithMultipleRentals() {
        List<Rental> rentals = List.of(
                new Rental(REMBO, 1),
                new Rental(LOTR, 4),
                new Rental(HARRY_POTTER, 5)
        );
        Customer customer = new Customer("John Doe", rentals);

        String expectedStatement = """
            Rental Record for John Doe
            \tRembo\t2.0
            \tLord of the Rings\t12.0
            \tHarry Potter\t4.5
            Amount owed is 18.5
            You earned 4 frequent renter points""";

        assertEquals(expectedStatement, customer.statement());
    }
}