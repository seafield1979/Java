/**
 * Created by shutaro on 2017/02/04.
 *
 * クラスのテスト
 */
// Math.exp を exp だけで呼び出せるようにするおまじない
import java.util.Random;

import static java.lang.Math.exp;

public class Test1 {
    enum Mode {
        InnerClass,     // インナークラスのテスト
        Overload,       // オーバーロードのテスト
        Override        // オバーライドのテスト
    }

    private static Mode mMode = Mode.Override;
    public static void main(String[] args) {
        switch(mMode) {
            case InnerClass:
                testInnerClass();
                break;
            case Overload:
                testOverload();
                break;
            case Override:
                testOverride();
        }
    }
    private void test1() {

    }

    private static void testInnerClass() {
        // インナークラスのテスト
        TestInnerClass test1 = new TestInnerClass();
        test1.test1();

        // staticないなークラスのテスト
        TestInnerClass.Test2.hello();
    }

    private static void testOverload() {
        // オーバーロードクラスのテスト
        TestOverload test1 = new TestOverload();
        test1.test1();
        test1.test1("hoge");
        test1.test1(100);
        test1.test1("hoge", 100);

        test1.disp();
    }

    /**
     * オーバーライドのテスト
     */
    private static void testOverride() {
//        TestOverride2 override = new TestOverride2();
//        override.hello();

        TestOverride override2 = new TestOverride2();
        TestOverride override3 = new TestOverride();
        override2.hello();
        override3.hello();
    }
}


/**
 * インナークラスのテスト
 *
 * Javaではクラスの中でクラスを定義できる
 *  staticでないインナークラスは主に内包する親のクラス内でしか使われない
 *  staticのインナークラスは内包する親クラス以外から使われる
 */
class TestInnerClass{
    /**
     * インナークラス1
     * 普通のインナークラスは通常
     */
    class Test1 {
        public void hello() {
            System.out.print("hello from TestInnerClass\n");
        }
    }

    /**
     * Staticなインナークラス
     * 親クラス名.インナークラス名 のように呼び出す
     */
    static class Test2 {
        static public void hello() {
            System.out.print("hello Test2\n");
        }
    }

    Test1 mInner1;
    TestInnerClass() {
        mInner1 = new Test1();
    }

    public void test1() {
        // インナークラスのインスタンスを作成する
        mInner1.hello();
    }

    // Math.expの短縮表示のテスト
    public double testExp(double x) {

        return (exp(x) - exp(-x)) / (exp(x) + exp(-x));
    }
}

/**
 * オーバーロードのテストクラス
 * オーバーロードは同じメソッドでも引数の数、引数の型が異なれば別メソッドとして定義できる仕組みのことです。
 */
class TestOverload {
    private String name;
    private int id;

    void test1() {
        System.out.print("test1()\n");
    }
    void test1(String name) {
        this.name = name;
        System.out.print("test1(String name)\n");
    }

    void test1(int id) {

        this.id = id;
        System.out.print("test1(int id)\n");
    }

    void test1(String name, int id) {
        this.name = name;
        this.id = id;
        System.out.print("test1(String name, int id)\n");
    }

    // 引数の型の違いではオーバーロードできない
//    String test1() {
//        return "hoge";
//    }

    void disp() {
        System.out.printf("name:%s id:%d\n", name, id);
    }
}

