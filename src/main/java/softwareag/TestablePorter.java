package softwareag;

import java.io.PrintStream;
import java.util.Objects;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class TestablePorter implements Porter {

  private MorningChecker morningChecker;
  private PrintStream out;
  private TimeSource timeSource;
  private IdGenerator idGenerator;

  public static final int SUCCESS = 0;
  public static final int FAILURE = 1;


  @Inject
  public TestablePorter(IdGenerator idGenerator, MorningChecker mc, @Named("stdout") PrintStream out,
    @Named("currentLocalTime") TimeSource ts) {
    this.idGenerator = Objects.requireNonNull(idGenerator);
    this.morningChecker = Objects.requireNonNull(mc);
    this.out = Objects.requireNonNull(out);
    this.timeSource = Objects.requireNonNull(ts);
  }


  public int greet(String... names) {
    String greetingId = idGenerator.generateUniqueId();
    if (names.length == 0) {
      out.println(String.format("%s There is noone to greet", greetingId));
      return FAILURE;
    } else {
      String greetingPhrase = null;
      if (morningChecker.isMorning(timeSource.currentTime())) {
        greetingPhrase = String.format("%s Good morning %s", greetingId, String.join(" and ", names));
      } else {
        greetingPhrase = String.format("%s Hello %s", greetingId, String.join(" and ", names));
      }
      out.println(greetingPhrase);
      return SUCCESS;
    }
  }
}
