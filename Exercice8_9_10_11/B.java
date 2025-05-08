public class B extends A {
    void f(A o){
        System.out.println("void f(A o) dans B");
    }
    void f(B o){
        System.out.println("void f(B o) dans B");
    }
}
