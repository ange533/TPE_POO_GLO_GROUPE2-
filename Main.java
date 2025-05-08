public class Main {
    public static void main(String[] args) {
    /*     // Test de la classe Rectangle

        // Création de points
        Point p1 = new Point(2, 3);

        // Test constructeur avec 2 points (Exercice 1)
        Rectangle r1 = new Rectangle(p1, 6, 4);
        System.out.println("Surface de r1 : " + r1.surface());
        // Rectangle r2= new Rectangle(2, 3, 4, 5);
        Rectangle r2 = new Rectangle(p1, 4, 5);
        // Test translation (Exercice 2)
        System.out.println("\nAvant translation de r1 : " + r2.getPointbasgauche().toString());
        System.out.println("Avant translation de r2 : " + r2.getLargeur());
        System.out.println("Avant translation de r2 : " + r2.getHauteur());
        r2.translate(2, 2);
        System.out.println("Après translation de r2 : " + r2.getPointbasgauche().toString());
        System.out.println("Après translation de r2 : " + r2.getLargeur());
        System.out.println("Après translation de r2 : " + r2.getHauteur());

        System.out.println("\nAvant translation de r1 : " + r1.getPointbasgauche().toString());
        System.out.println("Avant translation de r1 : " + r1.getLargeur());
        System.out.println("Avant translation de r1 : " + r1.getHauteur());
        // r1.translate(2, 2);
        System.out.println("Après translation de R1 : " + r1.getPointbasgauche().toString());
        System.out.println("Après translation de R1 : " + r1.getLargeur());
        System.out.println("Après translation de R1 : " + r1.getHauteur());

        // Test contains (Exercice 3)
        Point pTest = new Point(3, 4);
        System.out.println("\nr1 contient le point (3,4) ? " + r1.contains(pTest));

        // Test contains avec un rectangle
        Rectangle rInside = new Rectangle(new Point(3, 4), 1, 1);
        System.out.println("r1 contient rInside ? " + r1.contains(rInside));

        // Test equals (Exercice 4)
        Rectangle r4 = new Rectangle(new Point(2, 3), 4, 4);
        System.out.println("\nr1 est égal à r4 ? " + r1.equals(r4));

        // Test nombre de rectangles (Exercice 5)
        System.out.println("\nNombre total de rectangles créés : " + Rectangle.getNbr());

        // Test méthode hull (Exercice 6)
        Rectangle[] tab = {
                new Rectangle(2, 1, 2, 2),
                new Rectangle(5, 2, 1, 2)
        };
        Rectangle englobant = Rectangle.hull(tab);
        System.out.println("\nRectangle englobant (hull) :");
        System.out.println("Coin bas gauche : " + englobant.getPointbasgauche());
        System.out.println("Largeur : " + englobant.getLargeur());
        System.out.println("Hauteur : " + englobant.getHauteur());
*/



        // Test de la classe SlantedRectangle
        System.out.println("=== Test de SlantedRectangle ===");

        // Création d'un rectangle incliné
        Point p3 = new Point(2, 3);
        SlantedRectangle sr1 = new SlantedRectangle(p3, 6, 4, (float) (Math.PI / 4)); // 45 degrés

        System.out.println("Rectangle incliné créé : " + sr1);
        System.out.println("Surface : " + sr1.surface());

        // Test de la méthode rotate
        System.out.println("\n--- Test de la rotation ---");
        System.out.println("Angle initial : " + sr1.getAngle() + " radians");
        sr1.rotate((float) (Math.PI / 2)); // Rotation de 90 degrés
        System.out.println("Après rotation de π/2 : " + sr1.getAngle() + " radians");

        // Test de la méthode contains pour un point
        System.out.println("\n--- Test de contains pour un point ---");
        Point pt = new Point(5, 5); // Point qui devrait être dans le rectangle
        System.out.println("Le point " + pt + " est dans le rectangle ? " + sr1.contains(pt));

        // Test de la méthode contains pour un rectangle
        System.out.println("\n--- Test de contains pour un rectangle ---");
        Rectangle rTest = new Rectangle(new Point(3, 4), 2, 1);
        System.out.println("Le rectangle " + rTest + " est dans le rectangle incliné ? " + sr1.contains(rTest));

        // Test de la méthode equals
        System.out.println("\n--- Test de equals ---");
        SlantedRectangle sr2 = new SlantedRectangle(p3, 6, 4, (float) (Math.PI / 4));
        System.out.println("sr1 est égal à sr2 ? " + sr1.equals(sr2));

        // Après changement d'angle
        sr2.setAngle((float) (Math.PI / 2));
        System.out.println("sr1 est égal à sr2 après changement d'angle ? " + sr1.equals(sr2));

        // Test de la méthode translate
        System.out.println("\n--- Test de translate ---");
        System.out.println("Avant translation : " + sr1);
        sr1.translate(2, 2);
        System.out.println("Après translation : " + sr1);

    }
}
