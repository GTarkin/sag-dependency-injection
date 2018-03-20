package softwareag;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestablePorterTest {

  @Mock
  TimeSource clock;

  @Mock
  PrintStream out;

  TestablePorter porter;


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);

    when(clock.currentTime()).thenReturn(LocalTime.of(0, 0));

    porter = new TestablePorter(new MorningChecker(), out, clock);
  }


  @Test
  public void existsWithSuccessWhenThereArePeopleToGreet() {

    assertThat(porter.greet("person1"), equalTo(TestablePorter.SUCCESS));
  }


  @Test
  public void existsWithFailureWhenThereNoPeopleToGreet() {
    String[] NOONE = {};
    
    int exitCode = porter.greet(NOONE);
    
    assertThat(exitCode, equalTo(TestablePorter.FAILURE));
    verify(out).println("There is noone to greet");
  }


  @Test
  public void greetsWithGoodMorningInTheMorning() {
    int hour = 8;
    int minute = 0;
    when(clock.currentTime()).thenReturn(LocalTime.of(hour, minute));

    int exitCode = porter.greet("person1", "person2");

    assertThat(exitCode, equalTo(TestablePorter.SUCCESS));
    verify(out).println("Good morning person1 and person2");
  }


  @Test
  public void greetsWithHelloInTheRestOfTheDay() {
    int hour = 14;
    int minute = 0;
    when(clock.currentTime()).thenReturn(LocalTime.of(hour, minute));

    int exitCode = porter.greet("person1", "person2");

    assertThat(exitCode, equalTo(TestablePorter.SUCCESS));
    verify(out).println("Hello person1 and person2");
  }
}
