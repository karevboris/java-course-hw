package Task1_2;

/**
 * Created by Boris on 11.10.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyComplex mc = new MyComplex();
        System.out.println(mc.argument());

        Ball ball = new Ball (0,1,1,1,0);
        Container container = new Container(0,0,2,2);
        System.out.println(ball);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(container.collides(ball));
        System.out.println(ball);
        System.out.println(container);
    }
}
