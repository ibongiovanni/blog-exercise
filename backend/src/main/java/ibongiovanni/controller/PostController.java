package ibongiovanni.controller;

import ibongiovanni.model.*;
import com.google.gson.Gson;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import spark.*;
import org.javalite.activejdbc.*;



public class PostController {

  public static Route getAllPosts = (Request request, Response response) -> {
    Map<String,Object> m = new HashMap<>();
    List<Map<String,Object>> posts = Post.findAll().toMaps();
    m.put("posts",posts);
    return new Gson().toJson(m);
  };


  public static Route createPost = (Request request, Response response) -> {
    Map<String,Object> m = new HashMap<>();
    Properties properties = new Gson().fromJson(request.body(), Properties.class);
        String title = properties.getProperty("title");
        String body = properties.getProperty("body");
    if (title==null || body == null) {
      response.status(400);
      m.put("error","Incorrect parameters");
    }
    else {
      Post.createIt("title",title,"body",body);
      response.status(201);
    }
    return new Gson().toJson(m);
  };
  
}