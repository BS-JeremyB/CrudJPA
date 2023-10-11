package be.bstorm.Repositories;

import be.bstorm.entities.Utilisateur;

import java.util.List;

public interface CrudJpaRepository {

    void create(Utilisateur utilisateur);
    List<Utilisateur> getAll();
    Utilisateur getById(long id);
    Utilisateur update(long id,Utilisateur utilisateur);
    void delete(long id);
    void close();

}
