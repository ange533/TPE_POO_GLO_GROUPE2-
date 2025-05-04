public class Point {
   private float x;
   private float  y;

    public Point(float x, float y){
        this.x=x;
        this.y=y;
    }
  public float getX(){
    return this.x;
  }
  public float getY(){
    return this.y;
  }
  public void setX(float x){
    this.x=x;
  }
  public void setY(float y){
    this.y=y;
  }
  public boolean equals(Point p){
    return((this.x==p.getX())&&(this.y==p.getY()));
  }
  @Override
  public String toString() {
    return "Point [x=" + x + ", y=" + y + "]";
  }
 

}
