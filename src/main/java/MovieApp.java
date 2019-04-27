import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class MovieApp {


    private static String URL = "https://jsonmock.hackerrank.com/api/movies/search";

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String subStr = scanner.nextLine();

        if(subStr.isEmpty()){
            throw new RuntimeException("Invalid title input");
        }

        try {
            System.out.println(getMovietitles(subStr));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<String> getMovietitles(String subString) throws IOException {


        String url = URL+"?Title="+subString+"&page=1";

        MovieTitles movieTitles = new MovieTitlesReader();

        MovieTitleModel movieTitleModel = movieTitles.readMovieTitle(url);

        List<String> titles = new ArrayList<>(movieTitleModel.titles);

        int NoPages = movieTitleModel.totalPages;

        for (int i = 2; i <= NoPages; i++) {
            movieTitleModel = movieTitles.readMovieTitle(URL+"?Title="+subString+"&page="+i);
            titles.addAll(movieTitleModel.titles);
        }

        Collections.sort(titles);

        return titles;
    }
}
