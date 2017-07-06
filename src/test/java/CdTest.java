import org.junit.*;
import static org.junit.Assert.*;

public class CdTest {
  @Before
  public void tearDown() {
    Cd.clear();
  }

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

  @Test
  public void Cd_instantiatesWithGetGenre_Rock() {
    Cd myCd = new Cd("Pink","True About Love",1991);
    assertEquals(1991, myCd.getYear());
  }

  @Test
  public void all_returnsAllInstancesOfCd_true() {
    Cd firstCd = new Cd("Pink", "Truth About Love", 1991);
    Cd secondCd = new Cd("Pinchas Zuckerman", "Paganini Etudes", 1981);
    assertEquals(true, Cd.all().contains(firstCd));
    assertEquals(true, Cd.all().contains(secondCd));
  }

  @Test
  public void clear_emptiesAllCdsFromArrayList_0() {
    Cd myCd = new Cd("Pink", "Truth About Love", 1991);
    Cd.clear();
    assertEquals(0, Cd.all().size());
  }

  @Test
  public void getId_cdsInstantiateWithAnID_1() {

    Cd myCd = new Cd("Pink", "Truth About Love", 1991);
    assertEquals(1, myCd.getId());
  }

  @Test
  public void find_returnsCdWithSameId_secondTask() {
    Cd firstCd = new Cd("Pink", "Truth About Love", 1991);
    Cd secondCd = new Cd("Pinchas Zuckerman", "Paganini Etudes", 1981);
    assertEquals(Cd.find(secondCd.getId()), secondCd);
  }

  @Test
  public void find_setCdWithGenre_Rock() {
    Cd testCd = new Cd("Pink", "Truth About Love", 1991);
    testCd.setGenre("Rock");
    assertEquals("Rock", testCd.getGenre());
  }

}
