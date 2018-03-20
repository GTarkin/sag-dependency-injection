package softwareag;
import java.time.LocalTime;

public class BetterPorter {

	public static final int SUCCESS = 0;
	public static final int FAILURE = 1;

	public static void main(String[] args) {
		BetterPorter aPorter = new BetterPorter();
		int exitCode = aPorter.greet(args);
		System.exit(exitCode);
	}
	
	public int greet(String... names){
		if(names.length == 0){
			System.out.println("There is noone to greet");
			return FAILURE;
		} else {
			MorningChecker morningChecker = new MorningChecker();
			String greetingPhrase = null;
			if(morningChecker.isMorning(LocalTime.now())){
				greetingPhrase = String.format("Good morning %s", String.join(" and ", names));
			} else {
				greetingPhrase = String.format("Hello %s", String.join(" and ", names));				
			}
			System.out.println(greetingPhrase);
			return SUCCESS;
		}
	}
}
