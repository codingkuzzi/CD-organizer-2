public class Cd {

  private String mArtist;
  private String mTitle;
  private int mYear;

  public Cd(String artist, String title, int year) {
    mArtist = artist;
    mTitle = title;
    mYear = year;
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
}
