import java.time.LocalTime;

public class MorningChecker {

	private static final int BREAKFAST_TIME = 8;
	private static final int DINNER_TIME = 12;

	public boolean isMorning(LocalTime time) {
		return time.getHour() >= BREAKFAST_TIME && time.getHour() <= DINNER_TIME;
	}
}
