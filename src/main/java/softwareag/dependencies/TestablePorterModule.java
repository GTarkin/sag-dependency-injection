package softwareag.dependencies;

import java.io.PrintStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

import softwareag.IdGenerator;
import softwareag.IdGeneratorImpl;
import softwareag.MorningChecker;
import softwareag.MorningCheckerImpl;
import softwareag.Porter;
import softwareag.TestablePorter;
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

    // Uses a named binding to bind a named TimeSource to a provider that is providing a clock giving time in UTC
    bind(TimeSource.class).annotatedWith(Names.named("currentLocalTime")).toProvider(UtcTimeSourceProvider.class);

    // Bind Lock to ReentrantLock
    bind(Lock.class).to(ReentrantLock.class);

    // Bind IdGenerator to IdGeneratorImpl
    bind(IdGenerator.class).to(IdGeneratorImpl.class).in(Scopes.SINGLETON);

    // Bind Porter to TestablePorter
    bind(Porter.class).to(TestablePorter.class);

    // Initialize the starting id for the id generator
    bind(Long.class).annotatedWith(Names.named("idGeneratorStartingId")).toInstance(Long.valueOf(0));
  }
}
