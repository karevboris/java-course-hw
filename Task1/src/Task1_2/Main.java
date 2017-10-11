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

        MyPolynomial mp = new MyPolynomial(1, 2, 3, 4, 5 );
        MyPolynomial mp2 = new MyPolynomial(5, 6, 7, 8 );
        MyPolynomial mp3 = mp.add(mp2);
        MyComplex mc2 = new MyComplex(2,5);
        MyComplex mc3 = new MyComplex(1,1);
        MyComplex mc4 = mc3.addNew(mc3);
        mc2.add(mc3);

        System.out.println(mp);
        System.out.println(mp2);
        System.out.println(mp3);
        System.out.println(mc2);
        System.out.println(mc3);
        System.out.println(mc4);

    }
}
