package example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testGetTitle() {
        Movie movie = new Movie("Inception", Movie.MovieType.NEW_RELEASE);
        assertEquals("Inception", movie.getTitle());
    }

    @Test
    public void testGetPriceCode() {
        Movie movie = new Movie("Toy Story", Movie.MovieType.CHILDRENS);
        assertEquals(Movie.MovieType.CHILDRENS, movie.getPriceCode());
    }
}