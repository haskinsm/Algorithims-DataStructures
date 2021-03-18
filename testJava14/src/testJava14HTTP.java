import java.util.*;
import java.util.function.Function;

	//import com.fasterxml.jackson.core.JsonProcessingException;
	//import com.fasterxml.jackson.core.type.TypeReference;
	//import com.fasterxml.jackson.databind.ObjectMapper;

	import java.io.IOException;
	import java.net.URI;
	import java.net.http.HttpClient;
	import java.net.http.HttpRequest;
	import java.net.http.HttpResponse;
	import java.util.List;
	
	import com.fasterxml.jackson.databind.ObjectMapper;

	public class testJava14HTTP {

	    public static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";

	    public static void main(String[] args) throws IOException, InterruptedException {
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .GET()
	                .header("accept", "application/json")
	                .uri(URI.create(POSTS_API_URL))
	                .build();
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	        System.out.println(response.body());
	        // parse JSON
	        ObjectMapper mapper = new ObjectMapper();
	       // List<Post> posts = mapper.readValue(response.body(), new TypeReference<List<Post>>() {});

	        // posts.forEach(post -> {
	        //     System.out.println(post.toString());
	        // });
		       // posts.forEach(System.out::println);
		  }
}


	