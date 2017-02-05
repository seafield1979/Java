/**
 * Created by shutaro on 2017/02/04.
 * Javaのコンストラクタのテスト
 */
//import Constructor1;

public class Test1 {

    public static void main(String[] args) {
        System.out.print("Test1:main\n");

        Test1 test = new Test1();

        if (args.length > 0) {
            switch(args[0]) {
                case "test1":
                    test.test1();
                    break;
                case "test2":
                    test.test2();
                    break;
                case "test3":
                    test.test3();
                    break;
            }
        }
    }

    /**
     * Constructor1のテスト
     */
    private void test1() {
        Constructor1 test1 = new Constructor1("hoge", null);
        Constructor1 test2 = new Constructor1("hoge2", test1);

        test1.disp();
        test2.disp();
    }

    /**
     * 初期化ブロックのテスト
     */
    private void test2() {
        InitBlock1 ib1 = new InitBlock1("taro");
        InitBlock1 ib2 = new InitBlock1(null);

        ib1.disp();
        ib2.disp();
    }

    private void test3() {
        Constructor21 const21 = new Constructor21();
        const21.hello();
    }
}

