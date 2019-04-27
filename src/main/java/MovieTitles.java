import java.io.IOException;


public interface MovieTitles {

    MovieTitleModel readMovieTitle(String url) throws IOException;
}
