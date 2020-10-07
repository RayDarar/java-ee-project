package practice.services;

import java.util.List;

import javax.persistence.EntityManager;

import practice.entities.User;

public class UsersService {
  public static List<User> getUsers() {
    EntityManager db = EntityService.getManager();
    return db.createQuery("select * from users").getResultList();
  }
}
