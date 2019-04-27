import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class MovieTitleReaderTest {

    private MovieTitlesReader reader;

    @Test
    public void testGetMovieTitles() throws IOException {

        reader = new MovieTitlesReader();
        String subString = "spiderman";
        int page = 1;
        int limit=10;
        String url = "https://jsonmock.hackerrank.com/api/movies/search/"; //?Title="+subString+"&page="+page+"&limit="+limit;

        MovieTitleModel titles = reader.readMovieTitle(url);

        System.out.println(titles.titles);

    }

    @Test
    public void testGetMovieApp() throws IOException {

        List<String> titles = MovieApp.getMovietitles("spiderman");

        System.out.println(titles);

    }

}
