/**
 * Created by shutaro on 2017/02/05.
 *
 * サブクラスで親クラスのコンストラクターが順に呼ばれるテスト
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 obj = new Test2();
        obj.test1();
    }

    void test1() {
        new C4();
    }

    /**
     * インナークラス
     * 名前がかぶるのが嫌なのでインナーにしてみた
     */
    class C1 {
        C1() {
            System.out.print("C1 Constructor\n");
        }
        public void hello() {
            System.out.print("C1 hello\n");
        }
    }

    class C2 extends C1{
        C2() {
            System.out.print("C2 Constructor\n");
        }
        public void hello() {
            System.out.print("C2 hello\n");
        }
    }

    class C3 extends C2 {
        C3() {
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
