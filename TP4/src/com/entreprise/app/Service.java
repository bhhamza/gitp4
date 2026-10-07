package com.entreprise.app;

import java.util.Arrays;

import com.entreprise.exceptions.EquipeCompleteException;
import com.entreprise.rh.Employe;

public class Service {

    private Employe[] employes;
    private int nb;

    // Constructeur
    public Service(int capacite) {
        employes = new Employe[capacite];
        nb = 0;
    }

    // Ajouter un employé
    public void ajouter(Employe e) {
        if (nb >= employes.length) {
            throw new EquipeCompleteException(employes.length);
        }

        employes[nb] = e;
        nb++;
    }

    // Récupérer un employé
    public Employe getEmploye(int i) {
        if (i < 0 || i >= nb) {
            throw new IllegalArgumentException("indice invalide : " + i);
        }

        return employes[i];
    }

    // Nombre d'employés présents
    public int getNb() {
        return nb;
    }

    // Masse salariale
    public double getMasseSalariale() {
        double total = 0;

        for (int i = 0; i < nb; i++) {
            total += employes[i].getSalaire();
        }

        return total;
    }

    // Trier les employés par salaire
    public void trier() {
        Arrays.sort(employes, 0, nb);
    }

    // Afficher les employés
    public void afficher() {
        for (int i = 0; i < nb; i++) {
            System.out.println(i + " : " + employes[i]);
        }
    }
}