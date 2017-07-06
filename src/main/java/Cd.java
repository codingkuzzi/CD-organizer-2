import java.util.ArrayList;
import java.util.List;

public class Cd {

  private String mArtist;
  private String mTitle;
  private int mYear;
  private String mGenre;
  private static List<Cd> instances = new ArrayList<Cd>();
  private int mId;

  public Cd(String artist, String title, int year) {
    mArtist = artist;
    mTitle = title;
    mYear = year;
    instances.add(this);
    mId = instances.size();
  }

  public String getArtist() {
    return mArtist;
  }

  public String getTitle() {
    return mTitle;
  }

  public int getYear() {
    return mYear;
  }

  public String getGenre() {
    return mGenre;
  }

  public int getId() {
    return mId;
  }

  public void setGenre(String genre) {
       this.mGenre = genre;
  }

  public static List<Cd> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Cd find(int id) {
    return instances.get(id-1);
  }
}
