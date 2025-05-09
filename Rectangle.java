//Class Rectangle
//exercice1
class Rectangle {
    private Point pointbasgauche;
    private float largeur;
    private float hauteur;
    private static int nbr;

    public Point getPointbasgauche() {
        return pointbasgauche;
    }

    public void setPointbasgauche(Point pointbasgauche) {
        this.pointbasgauche = pointbasgauche;
    }

    public float getLargeur() {
        return largeur;
    }

    public void setLargeur(float largeur) {
        this.largeur = largeur;
    }

    public float getHauteur() {
        return hauteur;
    }

    public void setHauteur(float hauteur) {
        this.hauteur = hauteur;
    }

    public Rectangle(Point pbg, Point phg) {
        this.pointbasgauche = pbg;
        this.largeur = phg.getX() - pbg.getX();
        this.hauteur = phg.getY() - pbg.getY();
        nbr++;
    }

    public Rectangle(Point pbg, float lar, float haut) {
        this.pointbasgauche = pbg;
        this.largeur = lar;
        this.hauteur = haut;
        nbr++;
    }

    public Rectangle(float x, float y, float lar, float haut) {
        this.pointbasgauche = new Point(x, y);
        this.largeur = lar;
        this.hauteur = haut;
        nbr++;
    }

    // exercice2
    public float surface() {
        return (this.largeur * this.hauteur);

    }

    public void translate(float x, float y) {
        float origine_x = this.pointbasgauche.getX() + x;
        pointbasgauche.setX(origine_x);
        float origine_y = this.pointbasgauche.getY() + y;
        pointbasgauche.setY(origine_y);
    }

    // exercice3
    public boolean contains(Point p1) {
        return ((p1.getX() > this.pointbasgauche.getX()) && (p1.getX() < this.pointbasgauche.getX() + this.largeur)
                && (p1.getY() > pointbasgauche.getY()) && (p1.getY() < pointbasgauche.getY() + this.hauteur));
    }

    public boolean contains(Rectangle r) {
        Point pointbasgauche = r.getPointbasgauche();
        Point pointhautdroit = new Point(pointbasgauche.getX(), pointbasgauche.getY());
        return ((this.contains(pointbasgauche)) && (this.contains(pointhautdroit)));
    }
    // Lorsque plusieurs rectangles partagent le meme point, lorsqu'on va translater
    // le point, cela agira sur tous les rectangles partageant le point la.

    // exercice 4

    public boolean sameAs(Rectangle r) {
        return ((this.hauteur == r.getHauteur()) && (this.largeur == r.getLargeur())
                && (this.pointbasgauche.equals(r.getPointbasgauche())));
    }

    // exercice5
    public static int getNbr() {
        return nbr;
    }

    public static void setNbr(int nbr) {
        Rectangle.nbr = nbr;
    }

    // exercice6
    public static Rectangle hull(Rectangle[] rec) {
        if (rec == null || rec.length == 0)
            return null;

        // On prend les coordonnées du premier rectangle comme base
        float minX = rec[0].getPointbasgauche().getX();
        float minY = rec[0].getPointbasgauche().getY();
        float maxX = minX + rec[0].getLargeur();
        float maxY = minY + rec[0].getHauteur();

        // On parcourt les autres rec pour trouver les extrêmes
        /*
         * for(i=0;i<rec.length;i++){
         * r=rec[i];
         * }
         */
        for (Rectangle r : rec) {
            float x = r.getPointbasgauche().getX();
            float y = r.getPointbasgauche().getY();
            float droite = x + r.getLargeur();
            float haut = y + r.getHauteur();

            if (x < minX)
                minX = x;
            if (y < minY)
                minY = y;
            if (droite > maxX)
                maxX = droite;
            if (haut > maxY)
                maxY = haut;
        }

        // Le rectangle englobant a comme coin bas-gauche (minX, minY)
        // et ses dimensions sont (maxX - minX) et (maxY - minY)
        return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    // Exercice 6 partie heritage, masquage de methode
    @Override
    public String toString() {
        return "Rectangle [pointbasgauche=" + pointbasgauche + ", largeur=" + largeur + ", hauteur=" + hauteur + "]";
    }

    // Exercice 7 partie heritage, masquage de methode
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Rectangle))
            return false;
        Rectangle rectangle = (Rectangle) object;
        return ((this.hauteur == rectangle.getHauteur()) && (this.largeur == rectangle.getLargeur())
                && (this.pointbasgauche.equals(rectangle.getPointbasgauche())));
    }

}