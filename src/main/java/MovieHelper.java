import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class MovieHelper {

    private ObjectMapper mapper;

    public MovieHelper(){
        mapper = new ObjectMapper();
    }


    public  MovieTitleModel getMovieTitle(String movieInformation) throws IOException {

        JsonNode node = mapper.readTree(movieInformation);

        if (node != null) {

            JsonNode dataNode = node.get("data");

            List<JsonNode> jsonNodeList = dataNode.findValues("Title");

            MovieTitleModel movieTitleModel = new MovieTitleModel();
            movieTitleModel.titles = jsonNodeList.stream().map(JsonNode::textValue)
                    .collect(Collectors.toList());

            movieTitleModel.totalPages = node.get("total_pages").asInt();

            return movieTitleModel;
        }
        return null;
    }

}
