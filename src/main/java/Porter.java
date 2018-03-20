import java.time.LocalTime;

public class Porter {

	public static final int SUCCESS = 0;
	public static final int FAILURE = 1;

	public static void main(String[] args) {
		Porter aPorter = new Porter();
		aPorter.greet(args);
	}
	
	public void greet(String... names){
		if(names.length == 0){
			System.err.println("There is noone to greet");
			System.exit(FAILURE);
		} else {
			MorningChecker morningChecker = new MorningChecker();
			String greetingPhrase = null;
			if(morningChecker.isMorning(LocalTime.now())){
				greetingPhrase = String.format("Good morning %s!", String.join(" and ", names));
			} else {
				greetingPhrase = String.format("Hello %s", String.join(" and ", names));				
			}
			System.out.println(greetingPhrase);
			System.exit(SUCCESS);
		}
	}
}
