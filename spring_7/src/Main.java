public class Main {
    public static void main(String[] args) {
//        int i = 1 / 0;
        try {
            test1();
            //test1()抛出异常了，代码执行不到test2()
            test2();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test1() {
        System.out.println("hello");
        throw new RuntimeException("exception");
    }

    public static void test2() {
        System.out.println("hi");
    }
}
