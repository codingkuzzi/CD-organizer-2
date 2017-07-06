import java.util.List;
import java.util.ArrayList;

public class Genre {
  private String mName;
  private static List<Genre> instances = new ArrayList<Genre>();
  private int mId;
  private List<Cd> mCds;

  public Genre (String name){
    mName = name;
    instances.add(this);
    mId = instances.size();
    mCds = new ArrayList<Cd>();
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public static List<Genre> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Genre find(int id) {
    return instances.get(id-1);
  }

  public List<Cd> getCds() {
    return mCds;
  }

  public void addCd (Cd cd) {
    mCds.add(cd);
  }
}
