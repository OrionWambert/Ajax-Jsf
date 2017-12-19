/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.lab.beans;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author HP Notebook
 */
@Named
@RequestScoped
public class UserBean implements Serializable {

    private String nom;
    private String prenom;
    private String age;
    private String sexe;
    private String textSubmit="s'enregistre";

    public UserBean() {
    }

    public UserBean(String nom, String prenom, String age, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.sexe = sexe;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        setPrenom(isUppercase(nom));

        this.nom = nom;
    }

    public SelectItem[] selectitem() {
        ArrayList array = new ArrayList();
        array.add(new SelectItem("M", "M"));
        array.add(new SelectItem("F", "F"));
        SelectItem[] tabs = new SelectItem[array.size()];

        array.toArray(tabs);
        return tabs;

    }

    //Methode de conversion des chaines
    public String isUppercase(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                r += String.valueOf(c).toLowerCase();
            } else {
                r += String.valueOf(c).toUpperCase();
            }
        }
        return r;
    }

    public String getPrenom() {

        return prenom;
    }

    public void setPrenom(String prenom) {

        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {

        this.sexe = sexe;
       /* if (sexe.equalsIgnoreCase("M")) {
            setAge("20");
        } else if (sexe.equalsIgnoreCase("F")) {
            setAge("17");
        } else {
            setAge("");
        }*/
    }

    public String getTextSubmit() {
        return textSubmit;
    }

    public void setTextSubmit(String textSubmit) {
        this.textSubmit = textSubmit;
    }
    
    //Methode appelée lors de la soumission du formulaire
    public void actionListener(AjaxBehaviorEvent actionEvent) {
        System.out.println("Nom :" + nom);
        System.out.println("Prenom :" + prenom);
        System.out.println("Sexe :" + sexe);
        System.out.println("Age :" + age);

    }

    public void listener(AjaxBehaviorEvent event) {
        if (sexe.equalsIgnoreCase("M")) {
            setAge("20");
        } else if (sexe.equalsIgnoreCase("F")) {
            setAge("17");
        } else {
            setAge("");
        }
    }
    
    public void listenerBlur(AjaxBehaviorEvent event){
        System.out.println("Methode Hover");
        setTextSubmit("Connectez vous !!!");
    }

}
