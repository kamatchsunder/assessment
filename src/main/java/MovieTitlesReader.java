import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


public class MovieTitlesReader implements MovieTitles{


    private HttpClient client;
    private HttpGet reader;

    MovieHelper helper;

    public MovieTitlesReader(){

        client = HttpClientBuilder.create().build();

        helper = new MovieHelper();
    }

    public MovieTitleModel readMovieTitle(String url) throws IOException {

        reader = new HttpGet(url);
        HttpResponse response = client.execute(reader);
        HttpEntity entity = response.getEntity();

        String json = EntityUtils.toString(entity);

        return helper.getMovieTitle(json);
    }


}
