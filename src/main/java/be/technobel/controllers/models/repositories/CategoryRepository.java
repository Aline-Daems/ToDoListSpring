package be.technobel.controllers.models.repositories;

import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categorie, Long> {

    @Query("SELECT t FROM Task t WHERE t.categorie = :category")
      List<Task> findByTasks( );

    @Query("SELECT u FROM User u WHERE u.categorie = :category")
    List<User> findByUsers();


}
