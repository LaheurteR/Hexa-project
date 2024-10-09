package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Reponse
{
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot)
    {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position)
    {
        return this.resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai)
    {
        char[] tabC = essai.toCharArray();
        char cCourant;
        for (int i = 0; i < tabC.length; i++)
        {
            position = i;
            cCourant = tabC[i];
            if (estPlace(cCourant)) resultat.add(Lettre.PLACEE);
            else if (estPresent(cCourant)) resultat.add(Lettre.NON_PLACEE);
            else resultat.add(Lettre.INCORRECTE);
        }
    }

    // si toutes les lettres sont placées
    public boolean lettresToutesPlacees()
    {
        for (Lettre lettre : resultat)
        {
            if (!lettre.equals(Lettre.PLACEE)) return false;
        }
        return true;
    }

    public List<Lettre> lettresResultat()
    {
        return unmodifiableList(resultat);
    }

    // renvoie le statut du caractère
    private Lettre evaluationCaractere(char carCourant)
    {
        return null;
    }

    // le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant)
    {
        char[] tabC = motSecret.toCharArray();
        for (char c : tabC)
        {
            if (c == carCourant) return true;
        }
        return false;
    }

    // le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant)
    {
        return motSecret.charAt(position) == carCourant;
    }
}
