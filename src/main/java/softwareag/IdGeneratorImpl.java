package softwareag;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class IdGeneratorImpl implements IdGenerator {

  private long id;
  private Lock lock;


  @Inject
  public IdGeneratorImpl(@Named("idGeneratorStartingId") Long id, Lock lock) {
    this.id = Objects.requireNonNull(id);
    this.lock = Objects.requireNonNull(lock);
  }


  @Override
  public String generateUniqueId() {
    lock.lock();
    try {
      id = id + 1;
    } finally {
      lock.unlock();
    }
    return String.format("[ guid: [%d] ]", id);
  }

}
