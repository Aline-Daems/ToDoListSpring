package be.technobel.controllers.models.services.impl;

import be.technobel.controllers.models.entities.Categorie;
import be.technobel.controllers.models.entities.Task;
import be.technobel.controllers.models.entities.User;
import be.technobel.controllers.models.repositories.CategoryRepository;
import be.technobel.controllers.models.services.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategoryRepository categoryRepository;

    public CategorieServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Categorie create(Categorie categorie) {

        return categoryRepository.save(categorie) ;
    }

    @Override
    public List<Categorie> getAll() {

        List<Categorie> categories = categoryRepository.findAll();
        return categories;
    }


    @Override
    public Categorie getOne( long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Categorie delete(Long id) {
        Categorie existingCat = getOne(id);

        categoryRepository.delete(existingCat);
        return existingCat;
    }

    @Override
    public Categorie update(Categorie categorie, Long id) {
        Categorie existingCat = getOne(id);

        existingCat.setName(categorie.getName());
        existingCat.setModificationDate(categorie.getModificationDate());
        existingCat.setCreationDate(categorie.getModificationDate());
        existingCat.setTasks(categorie.getTasks());
        existingCat.setUsers(categorie.getUsers());


        return categoryRepository.save(existingCat);
    }

    @Override
    public List<Task> findTasks() {

        return categoryRepository.findByTasks();
    }

    @Override
    public List<User> findUsers() {
        return categoryRepository.findByUsers();
    }


}
