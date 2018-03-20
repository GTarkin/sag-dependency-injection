package softwareag;

import java.io.PrintStream;
import java.util.Objects;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

import softwareag.dependencies.TestablePorterModule;

public class TestablePorter {

  private MorningChecker morningChecker;
  private PrintStream out;
  private TimeSource timeSource;

  public static final int SUCCESS = 0;
  public static final int FAILURE = 1;


  @Inject
  public TestablePorter(MorningChecker mc, @Named("stdout") PrintStream out, @Named("currentLocalTime") TimeSource ts) {
    this.morningChecker = Objects.requireNonNull(mc);
    this.out = Objects.requireNonNull(out);
    this.timeSource = Objects.requireNonNull(ts);
  }


  public static void main(String[] args) {
    //TestablePorter aPorter = new TestablePorter(new MorningCheckerImpl(), System.out, TimeSource.LOCAL_TIME_SOURCE);

    Injector injector = Guice.createInjector(new TestablePorterModule());
    TestablePorter aPorter = injector.getInstance(TestablePorter.class);

    int exitCode = aPorter.greet(args);
    System.exit(exitCode);
  }


  public int greet(String... names) {
    if (names.length == 0) {
      out.println("There is noone to greet");
      return FAILURE;
    } else {
      String greetingPhrase = null;
      if (morningChecker.isMorning(timeSource.currentTime())) {
        greetingPhrase = String.format("Good morning %s", String.join(" and ", names));
      } else {
        greetingPhrase = String.format("Hello %s", String.join(" and ", names));
      }
      out.println(greetingPhrase);
      return SUCCESS;
    }
  }
}
