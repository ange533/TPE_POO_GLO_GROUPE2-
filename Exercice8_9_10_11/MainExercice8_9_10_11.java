public class MainExercice8_9_10_11 {
    public static void main(String[] args) {
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
        System.out.println(a instanceof A);
        System.out.println(ab instanceof A);
        System.out.println(b instanceof A);
        System.out.println(a instanceof B);
        System.out.println(ab instanceof B);
        System.out.println(b instanceof B);
    }
}