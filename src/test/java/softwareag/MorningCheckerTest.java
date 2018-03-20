package softwareag;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class MorningCheckerTest {

  MorningCheckerImpl morningChecker;


  @Before
  public void setup() {
    morningChecker = new MorningCheckerImpl();
  }


  @Test
  public void itsMorningAtEight() {
    int hourOfDay = 8;
    int minuteOfHour = 0;

    assertThat(morningChecker.isMorning(LocalTime.of(hourOfDay, minuteOfHour)), equalTo(true));
  }


  @Test
  public void itsMorningAtTwelve() {
    int hourOfDay = 12;
    int minuteOfHour = 0;

    assertThat(morningChecker.isMorning(LocalTime.of(hourOfDay, minuteOfHour)), equalTo(true));
  }


  @Test
  public void itsNotMorningAtMidnight() {
    int hourOfDay = 0;
    int minuteOfHour = 0;

    assertThat(morningChecker.isMorning(LocalTime.of(hourOfDay, minuteOfHour)), equalTo(false));
  }
}
