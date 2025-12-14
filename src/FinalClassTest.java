public final class FinalClassTest {

    public  void test(String s){
        System.out.println("test");
    }

    public static void main(String[] args) {
        FinalClassTest test = new FinalClassTest();
        test.test("Hello");
    }

}
