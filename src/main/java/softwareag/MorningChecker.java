package softwareag;

import java.time.LocalTime;

public interface MorningChecker {

  /**
   * Decides for a given {@link LocalTime} if it is in the morning
   * @param time The {@link LocalTime} which should be checked if it is in the morning
   * @return <code>true</code> if the provided time is in the morning, <code>false</code> otherwise
   */
  boolean isMorning(LocalTime time);
}
