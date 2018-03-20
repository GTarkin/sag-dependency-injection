package softwareag;

import java.time.LocalTime;

public interface TimeSource {
	
	LocalTime currentTime();
	
	TimeSource LOCAL_TIME_SOURCE = new TimeSource() {
		
		@Override
		public LocalTime currentTime() {
			return LocalTime.now();
		}
	};
}
