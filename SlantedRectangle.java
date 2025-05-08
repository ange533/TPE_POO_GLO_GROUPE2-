//Exercice 1
public class SlantedRectangle extends Rectangle {
 private double angle;
 public SlantedRectangle(double x, double y, double width, double height, double angle) {
 super(x, y, width, height);
 this.angle = angle;
 }
 public double getAngle() {
 return angle;
 }
 public void setAngle(double angle) {
 this.angle = angle;
 }
}
//Exercice 2
public void rotate(double deltaAngle) {
 this.angle += deltaAngle;
}
//Exercice 3
@Override
public String toString() {
 return "SlantedRectangle[x=" + getX() + ", y=" + getY() + 
 ", width=" + getWidth() + ", height=" + getHeight() + 
 ", angle=" + angle + "]";
}
