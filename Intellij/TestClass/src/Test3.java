/**
 * Created by shutaro on 2017/02/05.
 *
 * オブジェクト変数に代入できるインスタンスを確認するテスト
 *
 * 親クラスのオブジェクト変数に子クラスのインスタンスを代入
 * 子クラスのオブジェクト変数に親クラスのインスタンスを代入
 */
public class Test3 {
    public static void main(String[] args) {
        Test3 obj = new Test3();
        obj.test1();
    }

    void test1() {
        //C3 obj1 = new C1();  エラー  親クラスのオブジェクト変数には代入できない
        //C3 obj2 = new C2();   エラー 親クラスのオブジェクト変数には代入できない
        C3 obj3 = new C3();
        C3 obj4 = new C4();

        obj3.hello();       // C3のhelloが呼ばれる
        obj4.hello();       // C4のhelloが呼ばれる
    }

    class C1 {
        C1() {
            System.out.print("C1 Constructor\n");
        }
        public void hello() {
            System.out.print("C1 hello\n");
        }
    }

    class C2 extends C1 {
        String name;
//        C2() {
//            System.out.print("C2 Constructor\n");
//        }
        C2(String name) {
            this.name = name;
        }
        public void hello() {
            System.out.print("C2 hello\n");
        }
    }

    class C3 extends C2 {
        C3() {
            super("hoge");
            System.out.print("C3 Constructor\n");
        }
        public void hello() {
            System.out.print("C3 hello\n");
        }
    }
    class C4 extends C3 {
        C4() {
            System.out.print("C4 Constructor\n");
        }
        public void hello() {
            System.out.print("C4 hello\n");
        }
    }

}

