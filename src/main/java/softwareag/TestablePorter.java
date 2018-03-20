package softwareag;
import java.io.PrintStream;
import java.util.Objects;

public class TestablePorter {
	
	private MorningChecker morningChecker;
	private PrintStream out;

	public TestablePorter(MorningChecker mc, PrintStream out){
		this.morningChecker = Objects.requireNonNull(mc);
		this.out = Objects.requireNonNull(out);
	}

	public static final int SUCCESS = 0;
	public static final int FAILURE = 1;

	public static void main(String[] args) {
		TestablePorter aPorter = new TestablePorter(new MorningChecker(TimeSource.LOCAL_TIME_SOURCE), System.out);
		int exitCode = aPorter.greet(args);
		System.exit(exitCode);
	}
	
	public int greet(String... names){
		if(names.length == 0){
			out.println("There is noone to greet");
			return FAILURE;
		} else {
			String greetingPhrase = null;
			if(morningChecker.isMorning()){
				greetingPhrase = String.format("Good morning %s", String.join(" and ", names));
			} else {
				greetingPhrase = String.format("Hello %s", String.join(" and ", names));				
			}
			out.println(greetingPhrase);
			return SUCCESS;
		}
	}
}
