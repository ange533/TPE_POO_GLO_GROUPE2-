public class Dessin {
    private Rectangle[] rectangles;
    private int count;
    private Rectangle hullRect;

    public Dessin(int tailleMax) {
        rectangles = new Rectangle[tailleMax];
        count = 0;
        hullRect = null;
    }

    // Exercice 7 - Ajouter un rectangle
    public void add(Rectangle r) {
        if (count < rectangles.length) {
            rectangles[count] = r;
            count++;

            // Mise à jour du rectangle englobant
            if (hullRect == null) {
                hullRect = r;
            } else {
                Rectangle[] temp = { hullRect, r };
                hullRect = Rectangle.hull(temp);
            }
        } else {
            System.out.println("Erreur : Dessin plein, impossible d'ajouter plus de rectangles.");
        }
    }

    // Exercice 8 - Calculer la surface totale du dessin
    public float surface() {
        float somme = 0;
        for (int i = 0; i < count; i++) {
            somme += rectangles[i].surface();
        }
        return somme;
    }

    // Exercice 8 - Translation du dessin
    public void translate(float dx, float dy) {
        for (int i = 0; i < count; i++) {
            rectangles[i].translate(dx, dy);
        }

        // On met aussi à jour le rectangle englobant
        if (hullRect != null) {
            hullRect.translate(dx, dy);
        }
    }

    // Exercice 9 - Retourne le rectangle englobant
    public Rectangle hull() {
        return hullRect;
    }

    /*
     * // Pour l'affichage (optionnel)
     * public void afficher() {
     * System.out.println("Dessin avec " + count + " rectangles :");
     * for (int i = 0; i < count; i++) {
     * System.out.println("Rectangle " + (i + 1) + " :");
     * System.out.println("Coin bas gauche : " + rectangles[i].getPointbasgauche());
     * System.out.println("Largeur : " + rectangles[i].getLargeur());
     * System.out.println("Hauteur : " + rectangles[i].getHauteur());
     * }
     * }
     */
}
