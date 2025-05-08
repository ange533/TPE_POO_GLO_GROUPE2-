public class MainExercice8_9_10_11_13 {
    public static void main(String[] args) {
        //exercice 8,9,10
        A a = new A();
        A ab = new B();
        B b = new B();
        a.f(a);
        a.f(ab);
        a.f(b);
        ab.f(a);
        ab.f(ab);
        ab.f(b);
        b.f(a);
        b.f(ab);
        b.f(b);

        //exercice 11
        System.out.println(a instanceof A);
        System.out.println(ab instanceof A);
        System.out.println(b instanceof A);
        System.out.println(a instanceof B);
        System.out.println(ab instanceof B);
        System.out.println(b instanceof B);

        //exercice 13
        C c = new C();
        C cd = new D();
        D d = new D();
        System.out.println(c.ch);
        System.out.println(c.getCh());
        System.out.println(cd.ch);
        System.out.println(cd.getCh());
        System.out.println(d.ch);
        System.out.println(d.getCh());
    }
}