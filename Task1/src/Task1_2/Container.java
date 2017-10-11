package Task1_2;

/**
 * Created by Boris on 11.10.2017.
 */
public class Container {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = width - x;
        this.y2 = height - y;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth(){
        return x2-x1;
    }

    public int getHeight(){
        return y2-y1;
    }

    public boolean collides(Ball ball){
        return ((ball.getX()+ball.getRadius()<=x2)&&(ball.getX()-ball.getRadius()>=x1)&&(ball.getY()+ball.getRadius()<=y2)&&(ball.getY()-ball.getRadius()>=y1));
    }

    @Override
    public String toString() {
        return "Container[" +
                "(" + x1 +
                ", " + y1 +
                "), (" + x2 +
                ", " + y2 +
                ")]";
    }
}
