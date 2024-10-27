package example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void testGetDaysRented() {
        Rental rental = new Rental(new Movie("Avatar", Movie.MovieType.NEW_RELEASE), 3);
        assertEquals(3, rental.getDaysRented());
    }

    @Test
    public void testGetMovie() {
        Movie movie = new Movie("Titanic", Movie.MovieType.REGULAR);
        Rental rental = new Rental(movie, 2);
        assertEquals(movie, rental.getMovie());
    }
}