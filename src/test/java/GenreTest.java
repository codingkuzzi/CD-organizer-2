import org.junit.*;
import static org.junit.Assert.*;

public class GenreTest {

  @Before
  public void tearDown(){
    Genre.clear();
  }

  @Test
  public void genre_instantiatesCorrectly_true() {
    Genre testGenre = new Genre("Rock");
    assertEquals(true, testGenre instanceof Genre);
  }

  @Test
  public void getName_genreInstantiatesWithName_Rock() {
    Genre testGenre = new Genre("Rock");
    assertEquals("Rock", testGenre.getName());
  }

  @Test
  public void all_returnsAllInstancesOfGenre_true() {
    Genre firstGenre = new Genre("Rock");
    Genre secondGenre = new Genre("Classical");
    assertEquals(true, Genre.all().contains(firstGenre));
    assertEquals(true, Genre.all().contains(secondGenre));
  }

  @Test
  public void clear_emptiesAllGenresFromList_0() {
    Genre testGenre = new Genre("Rock");
    Genre.clear();
    assertEquals(0, Genre.all().size());
  }

  @Test
  public void getId_genresInstantiateWithAnId_1() {
    Genre testGenre = new Genre("Rock");
    assertEquals(1, testGenre.getId());
  }

  @Test
  public void find_returnsGenreWithSameId_secondGenre() {
    Genre.clear();
    Genre firstGenre = new Genre("Rock");
    Genre secondGenre = new Genre("Classical");
    assertEquals(Genre.find(secondGenre.getId()), secondGenre);
  }

  @Test
  public void getCds_initiallyReturnsEmptyList_ArrayList() {
    Genre.clear();
    Genre testGenre = new Genre("Rock");
    assertEquals(0, testGenre.getCds().size());
  }

  @Test
  public void addCd_addsCdToList_true() {
    Genre testGenre = new Genre("Rock");
    Cd testCd = new Cd("Pink", "True About Love", 1991);
    testGenre.addCd(testCd);
    assertTrue(testGenre.getCds().contains(testCd));
  }
}
