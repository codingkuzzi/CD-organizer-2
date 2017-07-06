import org.junit.*;
import static org.junit.Assert.*;

public class CdTest {
  @Test
  public void Cd_instantiatesCorrectly_true() {
    Cd myCd = new Cd("Pink","True About Love",1991);
    assertEquals(true, myCd instanceof Cd);
  }

  @Test
  public void Cd_instantiatesWithGetArtist_Pink() {
    Cd myCd = new Cd("Pink","True About Love",1991);
    assertEquals("Pink", myCd.getArtist());
  }

  @Test
  public void Cd_instantiatesWithGetTitle_TrueAboutLove() {
    Cd myCd = new Cd("Pink","True About Love",1991);
    assertEquals("True About Love", myCd.getTitle());
  }

  @Test
  public void Cd_instantiatesWithGetYear_1991() {
    Cd myCd = new Cd("Pink","True About Love",1991);
    assertEquals(1991, myCd.getYear());
  }

}
