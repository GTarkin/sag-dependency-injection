package softwareag;
import java.io.PrintStream;
import java.util.Objects;

public class TestablePorter {
	
	private MorningChecker morningChecker;
	private PrintStream out;
	private TimeSource timeSource;

	public TestablePorter(MorningChecker mc, PrintStream out, TimeSource ts){
		this.morningChecker = Objects.requireNonNull(mc);
		this.out = Objects.requireNonNull(out);
		this.timeSource = Objects.requireNonNull(ts);
	}

	public static final int SUCCESS = 0;
	public static final int FAILURE = 1;

	public static void main(String[] args) {
		TestablePorter aPorter = new TestablePorter(new MorningChecker(), System.out, TimeSource.LOCAL_TIME_SOURCE);
		int exitCode = aPorter.greet(args);
		System.exit(exitCode);
	}
	
	public int greet(String... names){
		if(names.length == 0){
			out.println("There is noone to greet");
			return FAILURE;
		} else {
			String greetingPhrase = null;
			if(morningChecker.isMorning(timeSource.currentTime())){
				greetingPhrase = String.format("Good morning %s", String.join(" and ", names));
			} else {
				greetingPhrase = String.format("Hello %s", String.join(" and ", names));				
			}
			out.println(greetingPhrase);
			return SUCCESS;
		}
	}
}
