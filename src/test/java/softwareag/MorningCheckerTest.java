package softwareag;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MorningCheckerTest {

  @Mock
  TimeSource clock;
  
  MorningChecker morningChecker;


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    
    morningChecker = new MorningChecker(clock);
  }


  @Test
  public void itsMorningAtEight() {
    int hourOfDay = 8;
    int minuteOfHour = 0;
    when(clock.currentTime()).thenReturn(LocalTime.of(hourOfDay, minuteOfHour));   

    assertThat(morningChecker.isMorning(), equalTo(true));
  }


  @Test
  public void itsMorningAtTwelve() {
    int hourOfDay = 12;
    int minuteOfHour = 0;
    when(clock.currentTime()).thenReturn(LocalTime.of(hourOfDay, minuteOfHour));

    assertThat(morningChecker.isMorning(), equalTo(true));
  }


  @Test
  public void itsNotMorningAtMidnight() {
    int hourOfDay = 0;
    int minuteOfHour = 0;
    when(clock.currentTime()).thenReturn(LocalTime.of(hourOfDay, minuteOfHour));

    assertThat(morningChecker.isMorning(), equalTo(false));
  }
}
