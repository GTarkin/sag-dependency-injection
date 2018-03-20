# Dependency Injection with Google Guice

This is tutorial for showing dependency injection with Google Guice.

Check out in local directory with:
```sh
$ git clone https://github.com/GTarkin/sag-dependency-injection-with-guice
```

Navigate into the directory:
```
$ cd sag-dependency-injection-with-guice
```

Built with:
```
$ ./gradlew installDist
```

Execute with:
```
$ ./build/install/sag-dependency-injection-with-guice/bin/sag-dependency-injection-with-guice Han Leia Luke
```
# Tags
Following tags are defined for this repository and reflect different stages of development and refactoring

| Tag                         | Description                                                                                                 |
| --------------------------- |:------------------------------------------------------------------------------------------------------------|
| original                    | Original unrefactored version of the greeting porter                                                        |
| betterPorter_v1             | Introduced a better Porter with unit tested exit codes                                                      | 
| testablePorter_v1           | First version of the TestablePorter. Knowledge of time directly resides within the Porter in form of a clock |
| testablePorter_v2           | Dependency on TimeSource.java moved from TestablePorter.java to MorningChecker.java                         |
| testablePorter_guice_v1     | Application code and unit testing code now uses guice for dependency injection                              |
| testablePorter_guice_v2     | Shows different types of bindings                                                                           |

You may checkout any tag with
```
$ git checkout <tag>
```
where <tag> is the name of the tag.
