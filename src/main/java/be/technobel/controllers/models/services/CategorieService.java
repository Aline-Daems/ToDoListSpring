package be.technobel.controllers.models.services;

import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.entities.User;

import java.util.List;

public interface CategorieService {

    Categorie create (Categorie categorie);

    List<Categorie> getAll();

    Categorie getOne( long id);
    Categorie delete(Long id);

    Categorie update (Categorie categorie, Long id);

      List<Task> findTasks();
      List<User> findUsers();


}
