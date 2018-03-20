package softwareag;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.inject.Guice;
import com.google.inject.Injector;

import softwareag.dependencies.TestablePorterModule;

public class App {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new TestablePorterModule());

    int numberOfGreetings = 1000;

    // Create 100 porters greeting concurrently in separate threads
    List<Thread> threads =
      IntStream.range(0, 100).mapToObj((i) -> injector.getInstance(TestablePorter.class)).map((porter) -> {
        return new Thread(() -> {
          Random random = new Random();
          for (int i = 0; i < numberOfGreetings; ++i) {
            porter.greet(args);
            try {
              Thread.sleep(random.nextInt(50));
            } catch (InterruptedException e) {
              // Do nothing
            }
          }
        });
      }).collect(Collectors.toList());

    // Start created threads
    threads.forEach(thread -> thread.start());

    // Wait all threads to complete
    threads.forEach(thread -> {
      try {
        thread.join();
      } catch (InterruptedException e) {
        // Do nothing
      }
    });
    System.exit(0);
  }
}
