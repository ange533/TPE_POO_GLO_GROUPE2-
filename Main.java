public class Main {
    public static void main(String[] args) {
       // Test de la classe Rectangle
        System.out.println("=== TEST Rectangle ===");
       

        // Création de points
        Point p1 = new Point(2, 3);

        // Test constructeur avec 2 points (Exercice 1)
        Rectangle r1 = new Rectangle(p1, 6, 4);
        System.out.println("Surface de r1 : " + r1.surface());
        // Rectangle r2= new Rectangle(2, 3, 4, 5);
        Rectangle r2 = new Rectangle(p1, 4, 5);
        // Test translation (Exercice 2)
        System.out.println("\nAvant translation de r1 : " +
                r2.getPointbasgauche().toString());
        System.out.println("Avant translation de r2 : " + r2.getLargeur());
        System.out.println("Avant translation de r2 : " + r2.getHauteur());
        r2.translate(2, 2);
        System.out.println("Après translation de r2 : " +
                r2.getPointbasgauche().toString());
        System.out.println("Après translation de r2 : " + r2.getLargeur());
        System.out.println("Après translation de r2 : " + r2.getHauteur());

        System.out.println("\nAvant translation de r1 : " +
                r1.getPointbasgauche().toString());
        System.out.println("Avant translation de r1 : " + r1.getLargeur());
        System.out.println("Avant translation de r1 : " + r1.getHauteur());
        // r1.translate(2, 2);
        System.out.println("Après translation de R1 : " +
                r1.getPointbasgauche().toString());
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
        System.out.println("\nNombre total de rectangles créés : " +
                Rectangle.getNbr());

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

        
        
        // Test de la classe SlantedRectangle
        
        
        
        System.out.println("=== TEST SlantedRectangle ===");

        // Création de points
        Point p3 = new Point(0, 0);
        Point p2 = new Point(2, 3);

        // Constructeurs
        SlantedRectangle sr1 = new SlantedRectangle(p3, 4, 2, (float) Math.PI / 6);
        SlantedRectangle sr2 = new SlantedRectangle(1, 1, 4, 2, (float) Math.PI / 6);
        SlantedRectangle sr3 = new SlantedRectangle(p3, p2, 0f); // angle = 0

        System.out.println("sr1: " + sr1);
        System.out.println("sr2: " + sr2);
        System.out.println("sr3: " + sr3);

        // Test getters / setters
        System.out.println("Angle sr1: " + sr1.getAngle());
        sr1.setAngle((float) Math.PI / 4);
        System.out.println("Nouveau angle sr1: " + sr1.getAngle());

        // Test rotate()
        sr1.rotate((float) Math.PI / 4);
        System.out.println("Après rotation sr1: " + sr1.getAngle());

        // Test sameAs()
        SlantedRectangle sr4 = new SlantedRectangle(1, 1, 4, 2, (float) (Math.PI / 2));
        sr4.setAngle(sr1.getAngle());
        System.out.println("sr1 sameAs sr4: " + sr1.sameAs(sr4));

        // Test contains(Point)
        Point inside = new Point(2, 1.5f);
        Point outside = new Point(10, 10);
        System.out.println("sr2 contient " + inside + "? " + sr2.contains(inside));
        System.out.println("sr2 contient " + outside + "? " + sr2.contains(outside));

        // Test contains(Rectangle)
        Rectangle rectInside = new Rectangle(new Point(1.5f, 1.2f), 1, 0.5f);
        Rectangle rectOutside = new Rectangle(new Point(100, 100), 2, 2);
        System.out.println("sr2 contient rectInside? " + sr2.contains(rectInside));
        System.out.println("sr2 contient rectOutside? " + sr2.contains(rectOutside));

        // Test contains(SlantedRectangle)
        SlantedRectangle srContained = new SlantedRectangle(1.2f, 1.2f, 1, 0.5f, (float) Math.PI / 6);
        SlantedRectangle srFar = new SlantedRectangle(100, 100, 1, 1, 0f);
        System.out.println("sr2 contient srContained? " + sr2.contains(srContained));
        System.out.println("sr2 contient srFar? " + sr2.contains(srFar));

        // Test hull()
        Rectangle[] rects = { sr1, sr2, sr3, sr4 };
        Rectangle enveloppe = SlantedRectangle.hull(rects);
        System.out.println("Rectangle englobant: " + enveloppe);

        // Test toString() et equals()
        System.out.println("sr1 toString(): " + sr1);
        System.out.println("sr1 equals sr4? " + sr1.equals(sr4));

        SlantedRectangle srClone = new SlantedRectangle(sr1.getPointbasgauche(), sr1.getLargeur(), sr1.getHauteur(),
                sr1.getAngle());
        System.out.println("sr1 equals srClone? " + sr1.equals(srClone));

    }
}
