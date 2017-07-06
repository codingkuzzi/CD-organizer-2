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
      model.put("cd", request.session().attribute("cd"));
      model.put("cds", request.session().attribute("cds"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cds", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Cd> cds = request.session().attribute("cds");
      if (cds == null) {
        cds = new ArrayList<Cd>();
        request.session().attribute("cds", cds);
      }

      String artist = request.queryParams("artist");
      String title = request.queryParams("title");
      int year = Integer.parseInt(request.queryParams("year"));
      Cd newCd = new Cd(artist,title,year);
      request.session().attribute("cd", newCd);
      cds.add(newCd);
      model.put("cd", newCd);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
