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
    public boolean sameAs(Rectangle r) {
        if (r instanceof SlantedRectangle) {
            SlantedRectangle sr = (SlantedRectangle) r;
            return super.sameAs(r) && this.angle == sr.getAngle();
        }
        return false; // Un rectangle incliné ne peut pas être identique à un rectangle normal
    }

    @Override
    public boolean contains(Point p) {
        // Convertir les coordonnées du point par rapport au centre du rectangle
        Point center = new Point(
                getPointbasgauche().getX() + getLargeur() / 2,
                getPointbasgauche().getY() + getHauteur() / 2);

        // Coordonnées du point p relatives au centre du rectangle
        float dx = p.getX() - center.getX();
        float dy = p.getY() - center.getY();

        // Rotation inverse pour ramener le point dans le système de coordonnées du
        // rectangle
        float cosAngle = (float) Math.cos(-angle);
        float sinAngle = (float) Math.sin(-angle);

        float rotatedX = dx * cosAngle - dy * sinAngle;
        float rotatedY = dx * sinAngle + dy * cosAngle;

        // Vérifier si le point est dans le rectangle
        return (Math.abs(rotatedX) <= getLargeur() / 2 &&
                Math.abs(rotatedY) <= getHauteur() / 2);
    }

    @Override
    public boolean contains(Rectangle r) {
        // Un rectangle incliné contient un autre rectangle si tous ses coins sont à
        // l'intérieur
        if (r instanceof SlantedRectangle) {
            SlantedRectangle sr = (SlantedRectangle) r;

            // Pour simplifier, on vérifie les 4 coins du rectangle
            Point p1 = sr.getPointbasgauche();
            Point p2 = new Point(p1.getX() + sr.getLargeur(), p1.getY());
            Point p3 = new Point(p1.getX() + sr.getLargeur(), p1.getY() + sr.getHauteur());
            Point p4 = new Point(p1.getX(), p1.getY() + sr.getHauteur());

            // Rotation des points en fonction de l'angle du rectangle sr
            // Cette partie est simplifiée et pourrait être plus complexe

            return contains(p1) && contains(p2) && contains(p3) && contains(p4);
        } else {
            // Pour un rectangle normal, vérifier ses 4 coins
            Point p1 = r.getPointbasgauche();
            Point p2 = new Point(p1.getX() + r.getLargeur(), p1.getY());
            Point p3 = new Point(p1.getX() + r.getLargeur(), p1.getY() + r.getHauteur());
            Point p4 = new Point(p1.getX(), p1.getY() + r.getHauteur());

            return contains(p1) && contains(p2) && contains(p3) && contains(p4);
        }
    }

    // Méthode pour tester si un SlantedRectangle contient un autre SlantedRectangle
    public boolean contains(SlantedRectangle sr) {
        // Vérifier les 4 coins du rectangle incliné
        Point p1 = sr.getPointbasgauche();

        // Calculer les coordonnées des 4 coins après rotation
        float cos = (float) Math.cos(sr.getAngle());
        float sin = (float) Math.sin(sr.getAngle());

        Point center = new Point(
                p1.getX() + sr.getLargeur() / 2,
                p1.getY() + sr.getHauteur() / 2);

        // Coins du rectangle avant rotation autour du centre
        Point[] corners = new Point[4];
        corners[0] = new Point(center.getX() - sr.getLargeur() / 2, center.getY() - sr.getHauteur() / 2);
        corners[1] = new Point(center.getX() + sr.getLargeur() / 2, center.getY() - sr.getHauteur() / 2);
        corners[2] = new Point(center.getX() + sr.getLargeur() / 2, center.getY() + sr.getHauteur() / 2);
        corners[3] = new Point(center.getX() - sr.getLargeur() / 2, center.getY() + sr.getHauteur() / 2);

        // Rotation des coins
        for (int i = 0; i < 4; i++) {
            float dx = corners[i].getX() - center.getX();
            float dy = corners[i].getY() - center.getY();

            corners[i].setX(center.getX() + dx * cos - dy * sin);
            corners[i].setY(center.getY() + dx * sin + dy * cos);
        }

        // Vérifier si tous les coins sont contenus
        return contains(corners[0]) && contains(corners[1]) &&
                contains(corners[2]) && contains(corners[3]);
    }

    // Redéfinition de la méthode hull pour prendre en compte les rectangles
    // inclinés
    public static Rectangle hull(Rectangle[] rec) {
        if (rec == null || rec.length == 0)
            return null;

        // On initialise avec des valeurs extrêmes
        float minX = Float.MAX_VALUE;
        float minY = Float.MAX_VALUE;
        float maxX = Float.MIN_VALUE;
        float maxY = Float.MIN_VALUE;

        // Pour chaque rectangle, on calcule les coordonnées des 4 coins après rotation
        for (Rectangle r : rec) {
            Point[] corners = new Point[4];

            if (r instanceof SlantedRectangle) {
                SlantedRectangle sr = (SlantedRectangle) r;
                Point p = sr.getPointbasgauche();
                float largeur = sr.getLargeur();
                float hauteur = sr.getHauteur();
                float angle = sr.getAngle();

                // Calcul du centre du rectangle
                Point center = new Point(p.getX() + largeur / 2, p.getY() + hauteur / 2);

                // Coins avant rotation (par rapport au centre)
                corners[0] = new Point(center.getX() - largeur / 2, center.getY() - hauteur / 2); // bas gauche
                corners[1] = new Point(center.getX() + largeur / 2, center.getY() - hauteur / 2); // bas droite
                corners[2] = new Point(center.getX() + largeur / 2, center.getY() + hauteur / 2); // haut droite
                corners[3] = new Point(center.getX() - largeur / 2, center.getY() + hauteur / 2); // haut gauche

                // Rotation des coins
                float cos = (float) Math.cos(angle);
                float sin = (float) Math.sin(angle);

                for (int i = 0; i < 4; i++) {
                    float dx = corners[i].getX() - center.getX();
                    float dy = corners[i].getY() - center.getY();
                    corners[i].setX(center.getX() + dx * cos - dy * sin);
                    corners[i].setY(center.getY() + dx * sin + dy * cos);
                }
            } else {
                // Rectangle normal
                Point p = r.getPointbasgauche();
                corners[0] = new Point(p.getX(), p.getY()); // bas gauche
                corners[1] = new Point(p.getX() + r.getLargeur(), p.getY()); // bas droite
                corners[2] = new Point(p.getX() + r.getLargeur(), p.getY() + r.getHauteur()); // haut droite
                corners[3] = new Point(p.getX(), p.getY() + r.getHauteur()); // haut gauche
            }

            // Mise à jour des valeurs min et max
            for (Point corner : corners) {
                minX = Math.min(minX, corner.getX());
                minY = Math.min(minY, corner.getY());
                maxX = Math.max(maxX, corner.getX());
                maxY = Math.max(maxY, corner.getY());
            }
        }

        // Création du rectangle englobant
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    // exercice6
    // Représentation textuelle du rectangle incliné
    @Override
    public String toString() {
        return super.toString() + " avec un angle de " + angle + " radians";
    }

    // exercice 7

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