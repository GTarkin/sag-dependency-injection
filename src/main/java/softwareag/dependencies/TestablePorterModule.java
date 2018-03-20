package softwareag.dependencies;

import java.io.PrintStream;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import softwareag.MorningChecker;
import softwareag.MorningCheckerImpl;
import softwareag.TimeSource;

// In Guice, a module defines a set of dependencies
public class TestablePorterModule extends AbstractModule {

  // Dependencies are configured here
  @Override
  protected void configure() {

    // Binds the MorningChecker-interface to be using the MorningCheckerImpl implementation of said interface
    bind(MorningChecker.class).to(MorningCheckerImpl.class);
    
    // Uses a named binding to bind System.out to a PrintStream named with 'stdout'
    bind(PrintStream.class).annotatedWith(Names.named("stdout")).toInstance(System.out);
    
    // Uses a named binding to bind TimeSource.LOCAL_TIME_SOURCE to a TimeSource named with 'localCurrentTime'
    bind(TimeSource.class).annotatedWith(Names.named("currentLocalTime")).toInstance(TimeSource.LOCAL_TIME_SOURCE);
  }
}
