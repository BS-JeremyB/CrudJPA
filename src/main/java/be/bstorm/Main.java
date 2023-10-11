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
        String nom, prenom, email, rue, boite, localite;
        Utilisateur utilisateur = null;
        int id, numero, cp;

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
                    System.out.println("Veuillez entrer un nom :");
                    nom = sc.nextLine();
                    System.out.println("Veuillez entrer un prenom : ");
                    prenom = sc.nextLine();
                    System.out.println("Veuillez entrer un mail :");
                    email = sc.nextLine();
                    System.out.println("Veuillez entrer une rue : ");
                    rue = sc.nextLine();
                    System.out.println("Veuillez entrer un numero :");
                    numero = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Veuillez entrer une boite : ");
                    boite = sc.nextLine();
                    System.out.println("Veuillez entrer un code postal :");
                    cp = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Veuillez entrer une localite : ");
                    localite = sc.nextLine();
                    CrudJPA.create(new Utilisateur(nom,prenom,email,
                                   new Adresse(rue,numero,boite,cp,localite)));
                    break;
                case "2" :
                    System.out.println("Veuillez entrer l'id du contact à modifier :");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Veuillez entrer un nouveau nom ou laisser vide :");
                    nom = sc.nextLine();
                    System.out.println("Veuillez entrer un prenom ou laisser vide : ");
                    prenom = sc.nextLine();
                    System.out.println("Veuillez entrer un mail ou laisser vide :");
                    email = sc.nextLine();
                    utilisateur = CrudJPA.update(id,new Utilisateur(id,nom,prenom,email,
                                                    null));
                    System.out.println(utilisateur.toString());
                    break;
                case "3" :
                    System.out.println("Veuillez entrer l'id du contact à supprimer :");
                    id = sc.nextInt();
                    sc.nextLine();
                    CrudJPA.delete(id);
                    break;
                case "4" :
                    List<Utilisateur> utilisateurs = CrudJPA.getAll();
                    for(Utilisateur user : utilisateurs){
                        System.out.println(user.toString());
                    }
                    break;
                case "5" :
                    System.out.println("Veuillez entrer l'id du contact à afficher :");
                    id = sc.nextInt();
                    sc.nextLine();
                    utilisateur = CrudJPA.getById(id);
                    System.out.println(utilisateur.toString());
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
