package be.bstorm;

import be.bstorm.Repositories.CrudJpaRepository;
import be.bstorm.Repositories.Impl.CrudJpaRepositoryImpl;
import be.bstorm.entities.Adresse;
import be.bstorm.entities.Utilisateur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CrudJpaRepository CrudJPA = new CrudJpaRepositoryImpl();
        String choix;
        int id;
        Utilisateur u = new Utilisateur("Doe", "John", "doejohn@mail.be",
                new Adresse("rue TF TIC", 105, null, 6041,"Gosselies"));
        Utilisateur u2 = new Utilisateur("Doe", "Jane", "doejane@mail.be",
                        new Adresse("rue du cerisier", 4, null, 6000,"Charleroi"));


        do{

            System.out.println("Veuillez faire un choix : \n" +
                    "1. Ajouter un contact \n" +
                    "2. Modifier un contact \n" +
                    "3. Supprimer un contact\n" +
                    "4. Parcourir les contacts \n" +
                    "5. Afficher un contact \n" +
                    "0. Quitter");

            choix = sc.nextLine();

            switch (choix){
                case "1" :
                    CrudJPA.create(u);
                    CrudJPA.create(u2);
                    break;
                case "2" :
                    u.setEmail("doejohn@mail.com");
                    CrudJPA.update(1,u);
                    break;
                case "3" :
                    CrudJPA.delete(1);
                    break;
                case "4" :
                    List<Utilisateur> utilisateurs = CrudJPA.getAll();
                    for(Utilisateur user : utilisateurs){
                        System.out.println(user.getNom()+","+user.getPrenom()+","+ user.getAdresse().getRue());
                    }
                    break;
                case "5" :
                    Utilisateur utilisateur = CrudJPA.getById(2);
                    System.out.println(utilisateur.getNom()+","+utilisateur.getPrenom()+","+ utilisateur.getAdresse().getRue());
                    break;
                case "0" :
                    CrudJPA.close();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }


        }while (!choix.equals("0"));

        System.out.println("Bonne journée.");
    }

}
