package softwareag;


public interface IdGenerator {

  /**
   * Generates a application-wide globally unique id
   * @return A application-wide globally unique id
   */
  String generateUniqueId();
}
