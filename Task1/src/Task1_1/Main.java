package Task1_1;

import Task1_1.*;

/**
 * Created by Boris on 10.10.2017.
 */
public class Main {
    public static void main(String[] args) {

        Author[] author = new Author [1];
        Book book = new Book("book1", author, 50, 100);
        Circle c = new Circle();
        Employee e = new Employee(50, "fname", "lname",111);
        MyTriangle mt = new MyTriangle(0,0,0,1,1,0);
        Rectangle r = new Rectangle(5,6);

        System.out.println(book);
        System.out.println(c);
        System.out.println(e);
        System.out.println(mt);
        System.out.println(r);
    }
}
