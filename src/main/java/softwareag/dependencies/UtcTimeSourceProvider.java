package softwareag.dependencies;

import com.google.inject.Provider;

import softwareag.ClosedOffUTCTimeSource;


public class UtcTimeSourceProvider implements Provider<ClosedOffUTCTimeSource> {

  @Override
  public ClosedOffUTCTimeSource get() {
    return ClosedOffUTCTimeSource.UTC_Clock();
  }

}
