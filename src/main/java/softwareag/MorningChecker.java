package softwareag;
import java.time.LocalTime;
import java.util.Objects;

public class MorningChecker {

	private static final int BREAKFAST_TIME = 8;
	private static final int DINNER_TIME = 12;
  
	private TimeSource timesource;
	
	public MorningChecker(TimeSource ts) {
	  this.timesource = Objects.requireNonNull(ts);
	}

	public boolean isMorning() {
	  LocalTime time = timesource.currentTime();
		return time.getHour() >= BREAKFAST_TIME && time.getHour() <= DINNER_TIME;
	}
}
