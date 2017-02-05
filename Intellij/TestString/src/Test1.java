import java.util.Date;

/**
 * Created by shutaro on 2017/02/04.
 * Stringクラスのテスト
 */

/**
 * パラメータ用のクラス
 */
class Values {
    public String name;
    public int value;

    public void disp() {
        System.out.printf("name:%s value:%d\n", name, value);
    }
}

public class Test1 {
    // 戻り値返却用のパラメータクラス
    class Params {
        public String name;
        public int value;
        public Date time;

        public void disp() {
            System.out.printf("name:%s value:%d time:%s\n", name, value, time);
        }
    }

    public static void main(String[] args) {
        test1();

        // test1
        String[] names = {"hoge", "hoge2", "hoge3"};

        // test2
        test2(names);

        // test3
        Test1 test = new Test1();
        Params ret = test.test3();
        ret.disp();

        // test5
        Values vals = new Values();
        test.test5(vals);
    }

    /**
     * toCharArrayのテスト
     */
    static void test1() {
        char[] chars = "今日の晩御飯".toCharArray();

        for (char c : chars) {
            System.out.print(c + "\n");
        }
    }

    /**
     * 可変引数のテスト
     * 可変引数は 型 ... 変数名  のように定義する。
     * 可変引数は配列に変換されて渡ってくる。
     */
    static void test2(String ... strs) {
        for (String str : strs) {
            System.out.print(str + "\n");
        }
    }

    /**
     * 複数のパラメータを返す関数のテスト
     * @return Paramsクラスのオブジェクト
     */
    Params test3() {
        Params param = new Params();
        param.name = "hoge";
        param.value = 100;
        param.time = new Date();

        return param;
    }

    /**
     * 引数にfinalをつけて変更不可にする
     */
    void test4(final int value) {
        //value += 100;  エラー
    }

    /**
     * 参照渡しされたパラメータを書き換える
     */
     void test5(Values vals) {
         vals.name = "new " + vals.name;
     }
}
