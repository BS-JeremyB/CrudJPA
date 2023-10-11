package be.bstorm.Repositories.Impl;

import be.bstorm.Repositories.CrudJpaRepository;
import be.bstorm.entities.Utilisateur;
import jakarta.persistence.*;

import java.util.List;

public class CrudJpaRepositoryImpl implements CrudJpaRepository {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRUDJPA");
    private static final EntityManager em = emf.createEntityManager();

    @Override
    public void create(Utilisateur utilisateur) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(utilisateur);
        et.commit();

    }

    @Override
    public List<Utilisateur> getAll() {
        TypedQuery<Utilisateur> query = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
        List<Utilisateur> utilisateurs = query.getResultList();


        return utilisateurs;
    }

    @Override
    public Utilisateur getById(long id) {
        Utilisateur utilisateur = em.find(Utilisateur.class, id);


        return utilisateur;
    }

    @Override
    public Utilisateur update(long id, Utilisateur utilisateur) {
        EntityTransaction et = em.getTransaction();

        Utilisateur utilisateurAModifier = getById(id);

        if (utilisateurAModifier != null) {

            if(
               !utilisateur.getNom().equals("") &&
               !utilisateurAModifier.getNom().equals(utilisateur.getNom())
              )
            {
                utilisateurAModifier.setNom(utilisateurAModifier.getNom());
            }
            if(
                    !utilisateur.getPrenom().equals("") &&
                    !utilisateurAModifier.getPrenom().equals(utilisateur.getPrenom())
            )
            {
                utilisateurAModifier.setPrenom(utilisateur.getPrenom());
            }
            if(
                    !utilisateur.getEmail().equals("") &&
                    !utilisateurAModifier.getEmail().equals(utilisateur.getEmail())
            )
            {
                utilisateurAModifier.setEmail(utilisateur.getEmail());
            }

            et.begin();
            em.merge(utilisateurAModifier);
            et.commit();

            return utilisateurAModifier;

        } else {

            return null;
        }
    }

    @Override
    public void delete(long id) {

        EntityTransaction et = em.getTransaction();
        Utilisateur utilisateurASupprimer = getById(id);
        et.begin();
        em.remove(utilisateurASupprimer);
        et.commit();

    }

    public void close(){
        em.close();
        emf.close();
    }
}
