package softwareag;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BetterPorterTest {

  BetterPorter porter;


  @Before
  public void setup() {
    porter = new BetterPorter();
  }


  @Test
  public void existsWithSuccessWhenThereArePeopleToGreet() {

    assertThat(porter.greet("person1"), equalTo(BetterPorter.SUCCESS));
  }


  @Test
  public void existsWithFailureWhenThereNoPeopleToGreet() {

    String[] NOONE = {};
    assertThat(porter.greet(NOONE), equalTo(BetterPorter.FAILURE));
  }

}
