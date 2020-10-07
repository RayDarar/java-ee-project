package practice.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityService {
  private EntityService() {}

  private static EntityManager manager;
  private static EntityManagerFactory factory;

  public static EntityManager getManager() {
    if (manager == null) {
      factory = Persistence.createEntityManagerFactory("default");
      manager = factory.createEntityManager();
    }

    return manager;
  }

  public static void close() {
    if (manager == null) return;

    manager.close();
    factory.close();
  }
}