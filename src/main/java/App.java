import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      if (Cd.all().isEmpty()) {
        Genre rockGenre = new Genre ("Rock");
        Genre classicalGenre = new Genre ("Classical");
        Cd firstCd = new Cd("Pink", "Truth About Love", 1991);
        Cd secondCd = new Cd("Pinchas Zuckerman", "Paganini Etudes", 1981);
        Cd thirdCd = new Cd("Maria Callas", "Verdi Arias", 1951);
        rockGenre.addCd(firstCd);
        classicalGenre.addCd(secondCd);
        classicalGenre.addCd(thirdCd);
      }

      model.put("cd", request.session().attribute("cd"));
      model.put("cds", request.session().attribute("cds"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/cd-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cds", Cd.all());
      model.put("template", "templates/cds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cds", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Cd> cds = request.session().attribute("cds");
      if (cds == null) {
        cds = new ArrayList<Cd>();
        request.session().attribute("cds", cds);
      }

      Genre genre =Genre.find(Integer.parseInt(request.queryParams("genreId")));
      String genreName = request.queryParams("genreName");

      String artist = request.queryParams("artist");
      String title = request.queryParams("title");
      int year = Integer.parseInt(request.queryParams("year"));
      Cd newCd = new Cd(artist,title,year);
      newCd.setGenre(genreName);
      request.session().attribute("cd", newCd);
      genre.addCd(newCd);
      model.put("genre", genre);
      model.put("template", "templates/genre-cds-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cds/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Cd cd = Cd.find(Integer.parseInt(request.params(":id")));
      model.put("cd", cd);
      model.put("template", "templates/cd.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/genre-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/genres", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Genre newGenre = new Genre(name);
      model.put("genre", newGenre);
      model.put("template", "templates/genre-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("genres", Genre.all());
      model.put("template", "templates/genres.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      model.put("genre", genre);
      model.put("template", "templates/genre.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("genres/:id/cds/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      model.put("genre", genre);
      model.put("template", "templates/genre-cds-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
