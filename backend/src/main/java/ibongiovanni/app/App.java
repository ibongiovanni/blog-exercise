package ibongiovanni.app;

import static spark.Spark.*;

import org.javalite.activejdbc.Base;
import ibongiovanni.controller.*;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main( String[] args ){

      // Configure Spark
      port(4567);

      enableCORS("*","*","*");

      before((request, response) -> {
        Base.open("org.sqlite.JDBC", "jdbc:sqlite:blog.db", "root", "root");}
      );

      after((request, response) -> {
        Base.close();    
      });

      //Routes
      get("/",  PostController.getAllPosts);
      post("/admin/posts/create", PostController.createPost);


    }

    // This method is an initialization method and should be called once.
    private static void enableCORS(final String origin, final String methods, final String headers) {

      options("/*", (request, response) -> {
      /**/
          String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
          if (accessControlRequestHeaders != null) {
              response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
          }

          String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
          if (accessControlRequestMethod != null) {
              response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
          }

          return "OK";
      });

      before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
            // Note: this may or may not be necessary in your particular application
            response.type("application/json");
      });
    }

}
