package Task1_1;

/**
 * Created by Boris on 10.10.2017.
 */
public class MyPoint {

    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY(){
        int [] xy = {x, y};
        return xy;
    }

    public void setXY (int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "(" + x + ", "+ y + ')';
    }

    public double distance(int x, int y){
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }

    public double distance(MyPoint mp){
        return distance(mp.getX(), mp.getY());
    }

    public double distance(){
        return distance(0,0);
    }
}
