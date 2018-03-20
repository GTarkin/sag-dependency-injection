package softwareag;

import java.time.Clock;
import java.time.LocalTime;

/*
 * This is an example of an class which was intentionally closed of against normal construction by the designer. The only way to
 * get an instance is via the static "UTC_Clock" method
 */
public final class ClosedOffUTCTimeSource implements TimeSource {

  // Private as per design
  private ClosedOffUTCTimeSource() {
  }


  @Override
  public LocalTime currentTime() {
    return LocalTime.now(Clock.systemUTC());
  }


  // Get a new UTC_Time_Source
  public static ClosedOffUTCTimeSource UTC_Clock() {
    return new ClosedOffUTCTimeSource();
  }
}
