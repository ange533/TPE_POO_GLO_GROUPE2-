//Exercice1

public class SlantedRectangle extends Rectangle {
    // Angle d'inclinaison en radians (0 = rectangle standard)
    private float angle;

    public SlantedRectangle(Point pbg, Point phd, float angle) {
        super(pbg, phd); // Appel au constructeur de la classe parente
        this.angle = angle;
    }

    public SlantedRectangle(Point pbg, float largeur, float hauteur, float angle) {
        super(pbg, largeur, hauteur); // Appel au constructeur de la classe parente
        this.angle = angle;
    }

    public SlantedRectangle(float x, float y, float largeur, float hauteur, float angle) {
        super(x, y, largeur, hauteur); // Appel au constructeur de la classe parente
        this.angle = angle;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    // Exercice2

    public void rotate(float deltaAngle) {
        this.angle += deltaAngle;
        // On normalise l'angle entre 0 et 2π si nécessaire
        while (this.angle >= 2 * Math.PI) {
            this.angle -= 2 * Math.PI;
        }
        while (this.angle < 0) {
            this.angle += 2 * Math.PI;
        }
    }

    // Exercice 3

    @Override
    public boolean contains(Point p) {
        // Pour vérifier si un point est dans un rectangle incliné,
        // on effectue une transformation inverse pour "redresser" le rectangle
        // et utiliser la méthode de test du rectangle standard

        // On obtient les coordonnées du point à tester
        float px = p.getX();
        float py = p.getY();

        // Coordonnées du centre du rectangle
        float centerX = getPointbasgauche().getX() + getLargeur() / 2;
        float centerY = getPointbasgauche().getY() + getHauteur() / 2;

        // On translate le point pour que le centre du rectangle soit à l'origine
        float translatedX = px - centerX;
        float translatedY = py - centerY;

        // On effectue une rotation inverse du point
        float cosAngle = (float) Math.cos(-angle);
        float sinAngle = (float) Math.sin(-angle);

        float rotatedX = translatedX * cosAngle - translatedY * sinAngle;
        float rotatedY = translatedX * sinAngle + translatedY * cosAngle;

        // On retranslate le point pour retrouver les coordonnées dans le repère du
        // rectangle non incliné
        float finalX = rotatedX + centerX;
        float finalY = rotatedY + centerY;

        // On crée un point "redressé" et on utilise la méthode contains du rectangle
        // parent
        Point redressedPoint = new Point(finalX, finalY);

        // On utilise la méthode de la classe parente sur ce point transformé
        return super.contains(redressedPoint);
    }

    @Override
    public boolean contains(Rectangle r) {
        // Un rectangle est contenu dans un autre si ses quatre coins sont contenus
        Point coinBasGauche = r.getPointbasgauche();
        Point coinBasDroit = new Point(coinBasGauche.getX() + r.getLargeur(), coinBasGauche.getY());
        Point coinHautGauche = new Point(coinBasGauche.getX(), coinBasGauche.getY() + r.getHauteur());
        Point coinHautDroit = new Point(coinBasGauche.getX() + r.getLargeur(), coinBasGauche.getY() + r.getHauteur());

        // On vérifie que les quatre coins sont contenus
        return contains(coinBasGauche) && contains(coinBasDroit)
                && contains(coinHautGauche) && contains(coinHautDroit);
    }

    

    // exercice6
    // Représentation textuelle du rectangle incliné
    @Override
    public String toString() {
        return super.toString() + " avec un angle de " + angle + " radians";
    }
  
    //exercice 7
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        SlantedRectangle other = (SlantedRectangle) obj;
        return Float.compare(this.angle, other.angle) == 0;
    }
}