public class A {
    void f(A o){
        System.out.println("void f(A o) dans A");
    }
    void f(B o){
        System.out.println("void f(B o) dans A");
    }
}
