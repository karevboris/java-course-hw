package Task1_1;

import Task1_1.MyPoint;

/**
 * Created by Boris on 10.10.2017.
 */
public class MyTriangle {

    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    @Override
    public String toString() {
        return "Task1_1.MyTriangle[" +
                "v1=(" + v1.toString() +
                ", v2=" + v2.toString() +
                ", v3=" + v3.toString() +
                ']';
    }

    public double getPerimeter(){
        return v1.distance(v2)+v2.distance(v3)+v3.distance(v1);
    }

    public String getType(){
        String res = "Scalene";
        double a = v1.distance(v2), b = v2.distance(v3), c = v3.distance(v1);
        if ((a==b)||(b==c)||(c==a)) res = "Isosceles";
        if ((a==b)&&(b==c)) res="Equilateral";
        return res;
    }
}
